package com.tanmay.sorting;

import java.util.Arrays;

/**
 * Merging is a process of combining two ordered arrays to make one large ordered array. This operation 
 * immediately leads to a simple recursive sort method known as Merge Sort: to sort an array, divide it 
 * into two halves, sort the two halves(recursively), and then merge the results.
 */
public class TopDownMergeSort {

	private static Comparable[] aux;
	
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length-1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi){
		if(hi <= lo){
			return;
		}
		
		int mid = lo + (hi - lo)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a, lo, mid, hi);
	}
	
	private static void merge(Comparable[] a, int lo, int mid, int hi){
		
		int i = lo;
		int j = mid + 1;
		
		for(int k = lo ; k <= hi ; k++){
			aux[k] = a[k];
		}
		
		for(int k = lo ; k <= hi ; k++){
			if(i > mid){
				a[k] = aux[j];
				j++;
			}else if(j > hi){
				a[k] = aux[i];
				i++;
			}else if(less(aux[j],aux[i])){
				a[k] = aux[j];
				j++;
			} else {
				a[k] = aux[i];
				i++;
			}
		}
	}
	
	private static boolean less(Comparable u, Comparable v){
		return u.compareTo(v) < 0;
	}
	
	public static void main(String[] args) {
		String[] a = {"T", "A", "N", "M", "A", "Y"};
		sort(a);
		System.out.println(Arrays.toString(a));
	}
}
