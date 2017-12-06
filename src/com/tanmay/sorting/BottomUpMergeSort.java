package com.tanmay.sorting;

import java.util.Arrays;

/**
 * Another way to implement Merge Sort is to organize the merges so that we do all
 * the merges of tiny sub-arrays on one pass, then do a a second pass to merge  
 * those sub-arrays in pairs , and so forth, continuing until we do a merge that
 * encompasses the whole array. We start doing a pass of 1-by-1 merges (considering 
 * individual items as sub-arrays of length 1), then a pass of 2-by-2 merges (merge 
 * sub-arrays of length 2 to make sub-arrays of length 4), then 4-by-4 merges, and
 * so forth. The second sub-array may be smaller than the first in the last merge 
 * on each pass, but otherwise all merges involve sub-arrays of equal length , 
 * doubling the sorted sub-array length for next pass.
 */
public class BottomUpMergeSort {

	private static Comparable[] aux;
	
	public static void sort(Comparable[] a){
		int n = a.length;
		aux = new Comparable[n];
		
		for(int len = 1 ; len < n ; len*=2){
			for(int lo = 0 ; lo < n-len ; lo += len+len){
				merge(a, lo, lo+len-1, Math.min(lo+len+len-1, n-1));
			}
		}
	}
	
	private static void merge(Comparable[] a, int lo, int mid, int hi){
		for(int k = lo ; k <= hi ; k++){
			aux[k] = a[k];
		}
		
		int i = lo;
		int j = mid+1;
		
		for(int k = lo ; k <= hi ; k++){
			if(i > mid){
				a[k] = aux[j];
				j++;
			}else if(j > hi){
				a[k] = aux[i];
				i++;
			}else if(less(aux[i], aux[j])){
				a[k] = aux[i];
				i++;
			}else{
				a[k] = aux[j];
				j++;
			}
		}
	}
	
	private static boolean less(Comparable u, Comparable v){
		return u.compareTo(v) < 0;
	}

}
