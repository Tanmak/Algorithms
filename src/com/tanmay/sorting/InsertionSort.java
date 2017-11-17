package com.tanmay.sorting;

import java.util.Arrays;

/**
 * The algorithm that people often use to sort bridge hands is to consider the cards one at a time,
 * inserting each into its proper place among those already considered(keeping them sorted). In a computer 
 * implementation, we need to make space to insert the current item by moving larger items one position 
 * to the right, before inserting the current item into the vacated position.
 */
public class InsertionSort {

	public static void sort(Comparable[] a) {
		
		int length = a.length;
		for(int i = 1 ; i < length ; i++){
			for(int j = i ; j > 0 ; j--){
				if(less(a[j], a[j-1])){
					exchange(a, j, j-1);
				}
			}
		}
	}
	
	private static boolean less(Comparable u, Comparable v){
		return u.compareTo(v) < 0;
	}
	
	private static void exchange(Comparable[] a, int i, int j){
		Comparable dummy = a[i];
		a[i] = a[j];
		a[j] = dummy;
	}
}
