package com.tanmay.sorting;

import java.util.Arrays;

/**
 * Shell Sort works as follows:
 * The idea is to rearrange the array to give it the property that taking every 'h' th entry
 * yields a sorted subsequence. Such an array is said to be h-sorted. Put another way, an h sorted array
 * is h independent sorted subsequence, interleaved together. By h-sorting for some large values of h, 
 * we can move items in the array long distances and thus make it easier to h-sort for smaller values 
 * of h. Using such a procedure for any sequence of values of h that ends in 1 will produce a 
 * sorted array. 
 * 
 * h=4
 * L E E A M H L E P S O L T S X R
 * L-------M-------P-------T
 *   E-------H-------S-------S
 *     E-------L-------O-------X
 *       A-------E-------L--------R
 *       
 */
public class ShellSort {
	
	public static void sort(Comparable[] a) {
		int n = a.length;
		int h = 1;
		
		while(h <= n/3){
			h = 3*h + 1;
		}
		
		while(h >= 1){
			for(int i = h ; i < n ; i++){
				for(int j = i ; j >= h ; j-=h){
					if(less(a[j],a[j-h])){
						exchange(a, j, j-h);
					}
				}
			}
			h = h/3;
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
