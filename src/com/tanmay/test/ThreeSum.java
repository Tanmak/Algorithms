package com.tanmay.test;

import com.tanmay.tracking.Stopwatch;

/**
 * This class counts the number of "triples" in a file of n integers that sum to 0.
 * This class is written just to check whether Data from resources are fetched properly 
 * not concerning the algorithmic efficiency.
 * 
 * RUN : java ThreeSum Resource\1Kints.txt 
 */
import edu.princeton.cs.algs4.In;

public class ThreeSum {
	
	private static int count(int[] intData){
		
		int n = intData.length;
		int count = 0;
		
		for(int i = 0 ; i < n ; i++){
			for(int j = i+1 ; j < n ; j++){
				for(int k = j+1 ; k < n ; k++){
					if(intData[i] + intData[j] + intData[k] == 0)
						count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		In in = new In(args[0]);
		int[] intData = in.readAllInts();
		Stopwatch timer = new Stopwatch();
		System.out.println(count(intData));
		System.out.println(timer.elapsedTime());
	}

}
