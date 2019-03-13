package closestpair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ClosestPairDistance {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Point points[] = new Point[n];
		for(int i = 0; i < n; i++){
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			
			points[i] = new Point(x, y);
		}
		
		double result = getClosestPairDistance(n, points);
		
		sc.close();
		
	}
	private static double getClosestPairDistance(int n, Point[] points) {
		
//		for(int i = 0; i < n; i++){
//			System.out.println(points[i]);
//		}
//		
//		System.out.println("X");
//		Arrays.sort(points, new SortByXCord());
//		for(int i = 0; i < n; i++){
//			System.out.println(points[i]);
//		}
//		
//		System.out.println("Y");
//		
//		Arrays.sort(points, new SortByYCord());
//		for(int i = 0; i < n; i++){
//			System.out.println(points[i]);
//		}
		
		Point[] px = new Point[n];
		Point[] py = new Point[n];
		
		for(int i = 0; i < n; i++){
			px[i] = points[i];
			py[i] = points[i];
		}
		Arrays.sort(px, new SortByXCord());
//		Arrays.sort(py, new SortByYCord());
		
		Point[] aux = new Point[n];

        closest(px, py, aux, 0, n-1);
		double ans = closestPairUtil(px, py, n);
		return 0;
	}
	static double bestDistance;
	static Point best1;
	static Point best2;
	
	private static void closest(Point[] px, Point[] py, Point[] aux, int i, int j) {
		
	}
	private static double closestPairUtil(Point[] px, Point[] py, int n) {
		
		return 0;
	}
	private static double closestPairUtil(int low, int high, Point[] points) {
	
		
		
		return 0;
	}
	
	private static double bruteForce(int n, Point[] points) {
		
		double minDistance = Double.MAX_VALUE;
		for(int i = 0; i < n; i++){
			for(int j = i + 1; j < n; j++){
				double dist = distance(points[i], points[j]);
				if( dist < minDistance){
					minDistance = dist;
				}
			}
		}
		return minDistance;
	}

	private static double distance(Point point1, Point point2) {
		
		return ((point1.x - point2.x) * (point1.x - point2.x)) + ((point1.y - point2.y) * (point1.y - point2.y));
	}

	private static class SortByXCord implements Comparator<Point>{

		@Override
		public int compare(Point o1, Point o2) {
		
			return (int) (o1.x - o2.x);
		}
		
	}
	
	private static class SortByYCord implements Comparator<Point>{

		@Override
		public int compare(Point o1, Point o2) {
			
			return (int) (o1.y - o2.y);
		}
		
	}
	
	private static class Point{
		double x;
		double y;
		
		public Point(double x, double y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			
			return "" + this.x + " " + this.y + "";
		}
	}

}
