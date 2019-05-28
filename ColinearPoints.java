package algorithmsCourse;

import java.util.Comparator;
import edu.princeton.cs.algs4.*;
import java.lang.Math;

public class ColinearPoints {
	public class Point implements Comparable<Point>{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public void draw() {
			StdDraw.point(x, y);
		}
		public void drawTo(Point that) {
	        StdDraw.line(this.x, this.y, that.x, that.y);
		}
		
		public String toString() {
	        return "(" + x + ", " + y + ")";
	    }
		
		public int compareTo(Point that) {
			if (this.y > that.y) {
				return 1;
			}
			if (this.y < that.y) {
				return -1;
			}
			if (this.y == that.y) {
				if (this.x > that.x) {
					return 1;
				}
				else {return -1;}
			}
			return 0;
			}
		
		public double slopeTo(Point that) {
			if (this.x != that.x) { 
			return (this.y - that.y)/(this.x - that.x);
			}
			if ((this.x == that.x) && (this.y == that.y)){
				return Double.NEGATIVE_INFINITY;
			}
			if ((this.x == that.x) && (this.y != that.y)) {
				return Double.POSITIVE_INFINITY;
			}
			return -1;
		}
		private class PointSlopeComparator implements Comparator<Point>{

			public int compare(Point firstPoint, Point secondPoint) {
				Double ret = slopeTo(firstPoint) - slopeTo(secondPoint);
				return (int) Math.floor(ret); 
			}
			
		}
		public Comparator<Point> slopeOrder(){
			return new PointSlopeComparator();		
			
		}
	}
	
	
	public static class LineSegment {
	    private final Point p;  
	    private final Point q;   

	
	    public LineSegment(Point p, Point q) {
	        if (p == null || q == null) {
	            throw new NullPointerException("argument is null");
	        }
	        this.p = p;
	        this.q = q;
	    }

	    public void draw() {
	        p.drawTo(q);
	    }

	    public String toString() {
	        return p + " -> " + q;
	    }

	    public int hashCode() {
	        throw new UnsupportedOperationException();
	    }

	}
	
	public static class FastColinearPoints{
		LineSegment[] segments;
		public FastColinearPoints(Point[] input) {
			int num = input.length;
			Point[] inputCopy = new Point[input.length];
			inputCopy = input;
			segments = new LineSegment[num];
			int repet = 1;
			int segmentsNumber = 0;
			for (int i = 0; i < num; i++) {
				Point cur1 = input[i];
				MergeX.sort(inputCopy, cur1.slopeOrder());	
				for (int k = 0; k < num; k++) {
					if ((k > 0) && (inputCopy[k] == inputCopy[k - 1])) {
						repet++;
					}
					if (repet >= 4 && (inputCopy[k] != inputCopy[k - 1])) {
						LineSegment cur = new LineSegment(inputCopy[k - 1], inputCopy[k - repet - 1]);
						segments[segmentsNumber++] = cur;
					}
					if (k > 0 && inputCopy[k] == inputCopy[k - 1]) {
						repet++;
					}
					if (k > 0 && inputCopy[k] != inputCopy[k - 1]) {
						repet = 1;
					}
				}
			}
				
			
		}
	}
	public static void main(String[] args) {
		
	}

}


