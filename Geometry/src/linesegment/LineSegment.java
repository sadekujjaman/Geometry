package linesegment;
import java.io.*;
import java.util.*;

/**
 * 
 * @author Saju
 *
 */

public class LineSegment {

	public static void main(String[] args) {

		InputReader in = new InputReader(System.in);
		int test = in.nextInt();

		for (int t = 1; t <= test; t++) {
			Point[] points = new Point[4];
			for (int i = 0; i < 4; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				points[i] = new Point(x, y);
			}

			boolean ans = doIntersect(points[0], points[1], points[2], points[3]);
			if (ans) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}

		}

		System.exit(0);

	}

	static boolean doIntersect(Point p1, Point q1, Point p2, Point q2) {
		// Find the four orientations needed for general and
		// special cases
		int o1 = orientation(p1, q1, p2);
		int o2 = orientation(p1, q1, q2);
		int o3 = orientation(p2, q2, p1);
		int o4 = orientation(p2, q2, q1);

		// General case
		if (o1 != o2 && o3 != o4)
			return true;

		// Special Cases
		// p1, q1 and p2 are colinear and p2 lies on segment p1q1
		if (o1 == 0 && onSegment(p1, p2, q1))
			return true;

		// p1, q1 and q2 are colinear and q2 lies on segment p1q1
		if (o2 == 0 && onSegment(p1, q2, q1))
			return true;

		// p2, q2 and p1 are colinear and p1 lies on segment p2q2
		if (o3 == 0 && onSegment(p2, p1, q2))
			return true;

		// p2, q2 and q1 are colinear and q1 lies on segment p2q2
		if (o4 == 0 && onSegment(p2, q1, q2))
			return true;

		return false; // Doesn't fall in any of the above cases
	}
//	int o1 = getOrientation(points[0], points[1], points[2]);
//    int o2 = getOrientation(points[0], points[1], points[3]);
//    int o3 = getOrientation(points[2], points[3], points[0]);
//    int o4 = getOrientation(points[2], points[3], points[1]);
//    
//    if(o1 != o2 && o3 != o4){
//        System.out.println("YES");
//    }
//    else if(o1 == 0 && onSegment(points[0], points[1], points[2]) == 1){
//        System.out.println("YES");
//    }
//    else if(o2 == 0 && onSegment(points[0], points[1], points[3]) == 1){
//        System.out.println("YES");
//    }
//    else if(o3 == 0 && onSegment(points[2], points[3], points[0]) == 1){
//        System.out.println("YES");
//    }
//    else if(o4 == 0 && onSegment(points[2], points[3], points[1]) == 1){
//        System.out.println("YES");
//    }
//    else{
//        System.out.println("NO");
//    }
//    

	private static int orientation(Point p1, Point p2, Point p3) {

		long val = (long) (((p2.y - p1.y) * (p3.x - p2.x)) - ((p3.y - p2.y) * (p2.x - p1.x)));
		if (val > 0) {
			return 1;
		} else if (val < 0) {
			return 2;
		}

		return 0;
	}

	private static boolean onSegment(Point p1, Point p2, Point p3) {
		//
//		 if(p1.x < p3.x && p2.x > p3.x){
//		 return true;
//		 }
//		 else if(p1.x > p3.x && p2.x < p3.x){
//		 return true;
//		 }
//		 return false;

//		if (p2.x <= Math.max(p1.x, p3.x) && p2.x >= Math.min(p1.x, p3.x) && p2.y <= Math.max(p1.y, p3.y)
//				&& p2.y >= Math.min(p1.y, p3.y))
//			return true;
//
//		return false;
		
		return Math.min(p1.x, p3.x) <= p2.x && Math.max(p1.x, p3.x) >= p2.x;
	}

	private static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public String next() {
			try {
				while (tokenizer == null || !tokenizer.hasMoreTokens()) {
					tokenizer = new StringTokenizer(reader.readLine());

				}
			} catch (IOException e) {
				return null;
			}
			return tokenizer.nextToken();
		}

		public String nextLine() {
			String line = null;
			try {
				tokenizer = null;
				line = reader.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return line;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public boolean hasNext() {
			try {
				while (tokenizer == null || !tokenizer.hasMoreTokens()) {
					tokenizer = new StringTokenizer(reader.readLine());
				}
			} catch (Exception e) {
				return false;
			}
			return true;
		}
	}
}
