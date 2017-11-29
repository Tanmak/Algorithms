package com.tanmay.sorting;

import com.tanmay.tracking.Stopwatch;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class SortCompare {
	
	private static double time(String algorithm, Comparable[] a){
		Stopwatch timer = new Stopwatch();
		
		if(algorithm.equals("Selection")){
			SelectionSort.sort(a);
		}if(algorithm.equals("Insertion")){
			InsertionSort.sort(a);
		}
		
		return timer.elapsedTime();
	}
	
	private static double timeRandomInput(String algorithm, int n, int trial){
		double total = 0.0;
		
		Double[] a = new Double[n];
		for(int i = 0 ; i < trial ; i++){
			for(int j = 0 ; j < n ; j++){
				a[i] = StdRandom.uniform(0.0, 1.0);
			}
			
			total += time(algorithm, a);
		}
		return total;
	}
	
	public static void main(String[] args) {
		String alg1 = args[0];
		String alg2 = args[1];
		int dataSize = Integer.parseInt(args[2]);
		int trial = Integer.parseInt(args[3]);
		
		double time1 = timeRandomInput(alg1, dataSize, trial);
		double time2 = timeRandomInput(alg2, dataSize, trial);
		
		double ratio = time2/time1;
		StdOut.printf("For %d random Doubles\n %s is", dataSize, alg1);
		StdOut.printf(" %.1f times faster than %s\n", ratio, alg2);
	}

}
