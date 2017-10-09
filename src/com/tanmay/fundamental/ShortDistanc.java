package com.tanmay.fundamental;
//1.2.1
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class ShortDistanc {
	
	static int n = 30;
	
	public static void main(String[] args) {
		
		Point2D[] pointArray = new Point2D[n];
		double dist = 1.0;
		
		StdDraw.setPenRadius(.015);
		StdDraw.setPenColor(StdDraw.BOOK_RED);
		for(int i = 0 ; i < n ; i++){
			double x = StdRandom.uniform(0.0, 1.0);
			double y = StdRandom.uniform(0.0, 1.0);
			
			Point2D p = new Point2D(x, y);
			pointArray[i] = p;
			p.draw();
		}
		
		Point2D shortestX = null;
		Point2D shortestY = null;
		StdDraw.setPenRadius(.0001);
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n ; j++){
				if(pointArray[i] != pointArray[j]){
					double dist1 = pointArray[i].distanceTo(pointArray[j]);
					
					System.out.println(dist1);
					
					Point2D allX = pointArray[i];
					Point2D allY = pointArray[j];
					StdDraw.line(allX.x(), allX.y(), allY.x(), allY.y());
					
					if(dist1 < dist){
						shortestX = pointArray[i];
						shortestY = pointArray[j];
						dist = dist1;
					}
				}
			}
		}
		
		StdDraw.setPenRadius(.005);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.line(shortestX.x(), shortestX.y(), shortestY.x(), shortestY.y());
		System.out.println("--------------------");
		System.out.println("Least distance : " + dist);
	}

}
