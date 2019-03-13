package linesegment;

import java.util.Scanner;


/**
 *
 * @author Saju
 */
public class LineSegment {
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Point points[] = new Point[4];
        
        // line 1
        // points[0] - > p1
        // points[1] - > p2
        
        // line 2
        // points[2] - > p3
        // points[3] - > p4
        
          for(int i = 0; i < 4; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x, y);
        }
        
        int o1 = getOrientation(points[0], points[1], points[2]);
        int o2 = getOrientation(points[0], points[1], points[3]);
        int o3 = getOrientation(points[2], points[3], points[0]);
        int o4 = getOrientation(points[2], points[3], points[1]);
        
        if(o1 != o2 && o3 != o4){
            System.out.println("YES");
        }
        else if(o1 == 0 && onSegment(points[0], points[1], points[2]) == 1){
            System.out.println("YES");
        }
        else if(o2 == 0 && onSegment(points[0], points[1], points[3]) == 1){
            System.out.println("YES");
        }
        else if(o3 == 0 && onSegment(points[2], points[3], points[0]) == 1){
            System.out.println("YES");
        }
        else if(o4 == 0 && onSegment(points[2], points[3], points[1]) == 1){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
        
        sc.close();
        
    }
    
    private static int getOrientation(Point p1, Point p2, Point p3){
        
        int val = ((p2.y - p1.y) * (p3.x - p2.x)) - ((p3.y - p2.y) * (p2.x - p1.x));
        if( val > 0){
            return 1;
        }
        else if(val < 0){
            return 2;
        }
        
        return 0;
    }
    
    private static int onSegment(Point p1, Point p2, Point p3){
        
        if(p1.x < p3.x & p2.x > p3.x){
            return 1;
        }
        else if(p1.x > p3.x && p2.x < p3.x){
            return 1;
        }
        return 0;
    }
    
    private static class Point{
        int x;
        int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
