package convexhull;

import java.util.Arrays;

import convexhull.GrahamMe.Point;

public class Test {

	public static void main(String[] args) {
		
//		Point p = new Point(1, 2);
//		Point q = new Point(2, 4);
//		Point r = new Point(3, 1);
		
		
//		int val = orientation(r, q, p);
//		System.out.println(val);
//		
//		if(val == 0)
//			System.out.println("Colinear");
//		else if(val > 0)
//			System.out.println("Clockwise");
//		else if(val < 0)
//			System.out.println("Counter Clockwise");
//		
//		System.out.println(dist(p, q));
		
//		Point[] points = new Point[5];
//		points[0] = new Point(1, 2);
//		points[1] = new Point(2, 4);
//		points[2] = new Point(3, 1);
//		points[3] = new Point(4, 5);
//		points[4] = new Point(5, 3);
//		
//		Arrays.sort(points, new Point());
//		for(Point p : points){
//			System.out.println(p.x + " " + p.y);
//		}
//		
		
	}
	public static double dist(Point p1, Point p2){
		double dx =  p2.x - p1.x;
		double dy = p2.y - p1.y;
		return Math.sqrt((dx * dx) + (dy * dy));
	}
	
	public static int orientation(Point p, Point q, Point r){
		
		double val = ((q.y - p.y) * (r.x - q.x)) -((q.x - p.x) * (r.y - q.y)) ;
		
		int v = (int)val;
	    if(v > 0)
	    	return 1; // right
	    else if(v < 0)
	    	return -1; //left
	    
	    return 0;
		
	}
}
