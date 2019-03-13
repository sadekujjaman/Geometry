package convexhull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ConvexHullJavisMarch {

	public static void main(String[] args) {
		
		int n = 6;
	     Point[] points = new Point[n];
	     points[0] = new Point(1, 1);
	     points[1] = new Point(2, 2);
	     points[2] = new Point(2, 0);
	     points[3] = new Point(2, 4);
	     points[4] = new Point(3, 3);
	     points[5] = new Point(4, 2);
	     
	     List<Point> ansPoint = findConvexHull(points);
	     System.out.println(ansPoint.size());
	     for(int i = 0; i < ansPoint.size(); i++){
	    	 Point p = ansPoint.get(i);
	    	 System.out.print("[" + p.x + "," + p.y + "], ");
	     }
		
	}
	
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	
	public static List<Point> findConvexHull(Point[] points){
		
		// Step -> 1:
		// Find the leftmost point
		Point start = points[0];
		for(int i = 1; i < points.length; i++){
			if(points[i].x < start.x){
				start = points[i];
			}
		}
		
		// Step -> 2
		// Use HashSet since user can try to input duplicate points
		Point current = start;
		HashSet<Point> result = new HashSet<>();
		result.add(start);
		List<Point> colinearPoints = new ArrayList<>();
		
		while(true){
			Point nextTarget = points[0];
			
			for(int i = 0; i < points.length; i++){
				if(points[i] == current)
					continue;
				
				int val = crossProduct(current, nextTarget, points[i]);
				
				// do with leftmost point
				if(val > 0){
					nextTarget = points[i];
					// initialize colinearPoints list since we have now new Target
					colinearPoints = new ArrayList<>();
				}
				else if(val == 0){
					if(distance(current, nextTarget, points[i]) < 0){
						colinearPoints.add(nextTarget);
						nextTarget = points[i];
					}
					else{
						colinearPoints.add(points[i]);
					}
				}
				// else nothing to do... ignore rightmost point
				
			}
			
			// add all colinear points to the result
			for(Point p : colinearPoints){
				result.add(p);
			}
			
			if(nextTarget == start)
				break;
			
			
			// add nextTarget to result
			result.add(nextTarget);
		   current = nextTarget;
		   
		}
		
		return new ArrayList<>(result);
	}


	private static int distance(Point current, Point nextTarget, Point point) {
		int x1 = current.x - nextTarget.x;
		int x2 = current.x - point.x;
		int y1 = current.y - nextTarget.y;
		int y2 = current.y - point.y;
		
		return Integer.compare(y1 * y1 + x1 * x1, y2 * y2 + x2 * x2);
	}


	private static int crossProduct(Point current, Point nextTarget, Point point) {
		
		int x1 = current.x - nextTarget.x;
		int x2 = current.x - point.x;
		int y1 = current.y - nextTarget.y;
		int y2 = current.y - point.y;
		
		
		return (y2 * x1) - (y1 * x2);
	}

}
