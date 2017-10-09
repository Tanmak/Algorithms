package com.tanmay.fundamental;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdIn;

public class IntersectingLines {
	
	static int n = 0;
	
	public static void main(String[] args) {
		System.out.println("How many lines you want?");
		n = StdIn.readInt();
		double[][] arr = new double[n][2];
		for(int i = 0 ; i < n ; i++){
			System.out.println("provide x and y values:");
			System.out.println("x value : ");
			double x = StdIn.readDouble();
			System.out.println("y value : ");
			double y = StdIn.readDouble();
			arr[i][0] = x;
			arr[i][1] = y;
		}
		
		for(int i = 0 ; i < n ; i++){
			Interval1D line = new Interval1D(arr[i][0], arr[i][1]);
			Interval1D line1 = new Interval1D(arr[i][0], arr[i][1]);
			
			Interval2D box = new Interval2D(line, line1);
			box.draw();
		}
	}

}
