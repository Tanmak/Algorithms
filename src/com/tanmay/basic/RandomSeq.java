package com.tanmay.basic;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomSeq {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		
		double low = Double.parseDouble(args[1]);
		double high = Double.parseDouble(args[2]);
		
		for(int i = 0 ; i < n ; i++){
			double d = StdRandom.uniform(low, high);
			StdOut.printf("%.2f\n", d);
		}
	}
	
}
