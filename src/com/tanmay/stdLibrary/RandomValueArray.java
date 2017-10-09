package com.tanmay.stdLibrary;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomValueArray {

	public static void main(String[] args) {
		int n = 50;
		double[] data = new double[n];
		for(int i = 0 ; i < n ; i++)
		 data[i] = StdRandom.uniform();
		
		for(int i = 0 ; i < n ; i++){
			double x = 1.0*i%n;
			System.out.println(x);
			double y = data[i]/2.0;
			double hight = data[i]/2.0;
			double width = .5/n;
			StdDraw.filledRectangle(x, y, width, hight);
		}
		
	}
}
