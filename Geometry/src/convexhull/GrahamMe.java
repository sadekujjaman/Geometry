package convexhull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class GrahamMe {

	static class Point implements Comparator<Point> {
		double x;
		double y;

		public Point() {
			// TODO Auto-generated constructor stub
		}

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compare(Point p1, Point p2) {

			int ori = orientation(p0, p1, p2);

			if (ori == 0) {
				return dist(p0, p2) >= dist(p0, p1) ? -1 : 1;
			}

			return ori;
		}
	}
	static Point p0;// = new Point(3, 1);

	public static double dist(Point p1, Point p2) {
		double dx = p2.x - p1.x;
		double dy = p2.y - p1.y;
		return Math.sqrt((dx * dx) + (dy * dy));
	}

	public static int orientation(Point p, Point q, Point r) {

		double val = ((q.y - p.y) * (r.x - q.x)) - ((q.x - p.x) * (r.y - q.y));

		int v = (int) val;
		if (v > 0)
			return 1; // right clock
		else if (v < 0)
			return -1; // left counter

		return 0;

	}

	public static List<Point> getConvexHull(Point[] points) {

		Point minPoint = points[0];
		int min = 0;
		for (int i = 1; i < points.length; i++) {
			Point p = points[i];

			if ((p.y < minPoint.y) || (p.y == minPoint.y && p.x < minPoint.x)) {
				minPoint = p;
				min = i;
			}
		}

		System.out.println("Min: " + minPoint.x + " " + minPoint.y);
		
		Point temp = points[0];
		points[0] = points[min];
		points[min] = temp;

		p0 = points[0];

		Arrays.sort(points, 1, points.length, new Point());

		for(Point p : points){
			System.out.println(p.x + " " + p.y);
		}
		
		Stack<Point> stack = new Stack<>();
		if (points.length < 3) {
			for (int i = 0; i < points.length; i++) {
				stack.push(points[i]);
			}
		} else {
			stack.push(points[0]);
			stack.push(points[1]);
			stack.push(points[2]);

			for (int i = 3; i < points.length; i++) {

				int ori = orientation(nextToTop(stack), stack.peek(), points[i]);

				while (true) {
					if (ori == -1 || ori == 0)
						break;
					stack.pop();
					ori = orientation(nextToTop(stack), stack.peek(), points[i]);
				}
				stack.push(points[i]);
			}

		}
		//
		// System.out.println(stack.size());
		// for(Point p : stack){
		// System.out.println(p.x + " " + p.y);
		// }

		// Point[] arr = (Point[]) stack.toArray();
		return new ArrayList<>(stack);
	}

	private static Point nextToTop(Stack<Point> stack) {
		Point p = stack.peek();
		stack.pop();
		Point res = stack.peek();
		stack.push(p);
		return res;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			Point[] points = new Point[n];
			for (int i = 0; i < n; i++) {
				long x = sc.nextLong();
				long y = sc.nextLong();
				points[i] = new Point(x, y);

			}

			List<Point> ans = getConvexHull(points);

			double result = 0;

			for (int i = 0; i < ans.size() - 1; i++) {
				Point p1 = ans.get(i);
				Point p2 = ans.get(i + 1);
				double len = dist(p1, p2);
				result += len;
			}

			double len = dist(ans.get(ans.size() - 1), ans.get(0));

			result += len;

			result += (2 * Math.PI * d);
			System.out.printf("Case %d: %.10f\n", t, result);

		}

		sc.close();

	}

}
