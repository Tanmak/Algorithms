package com.tanmay.sorting;

/**
 * Selection Sort works as follow: 
 * First find the smallest item in the array and exchange it with the 
 * first entry. Then find the next smallest item and exchange it with 
 * the second entry. Continue with this way until the entire array is sorted.
 * This method is called Selection Sort because it works by repeatedly 
 *selecting the smallest remaining item.
 */

public class SelectionSort {

	public static void sort(Comparable[] a){
		int size = a.length;
		
		for(int i=0 ; i<size ; i++){
			int min = i;
			for(int j=i+1 ; j<size ; j++){
				if(less(a[j],a[i])){
					min = j;
				}
			}
			
			exchange(a, min, i);
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
