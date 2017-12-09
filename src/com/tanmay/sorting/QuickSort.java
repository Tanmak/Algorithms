package com.tanmay.sorting;

import java.util.Arrays;

/**
 * QuickSort is a divide-and-conquer method for sorting. It works by partitioning an array into two sub-arrays,
 * then sorting the sub-arrays independently. QuickSort is complementary to MergeSort: for MergeSort,
 * we break the array into two sub-arrays to be sorted and then combine the ordered sub-arrays
 * to make the whole ordered array; for QuickSort, we rearrange the array such that, when the two sub-arrays
 * are sorted, the whole array is ordered. For MergeSort, the array is divided in half, for QuickSort 
 * the position of the partition depends on the contents of the array. 
 */
public class QuickSort {
	
	public static void sort(Comparable[] a){
		sort(a, 0, a.length-1);
	}

	private static void sort(Comparable[] a, int lo, int hi){
		if(lo >= hi){
			return;
		}
		
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
	private static int partition(Comparable[] a, int lo, int hi){
		
		Comparable v = a[lo];
		int i = lo;
		int j = hi+1;
		
		while(true){
			while(less(a[++i], v)){
				if(i == hi){
					break;
				}
			}
			
			while(less(v, a[--j])){
				if(j == lo){
					break;
				}
			}
			
			if(i >= j){
				break;
			}
			
			exchange(a, i, j);
		}
		
		exchange(a, lo, j);
		return j;
	}
	
	private static boolean less(Comparable u, Comparable v){
		return u.compareTo(v) < 0;
	}
	
	private static void exchange(Comparable[] a, int i, int j){
		Comparable dummy = a[i];
		a[i] = a[j];
		a[j] = dummy;
	}
	
	public static void main(String[] args) {
		String[] s = {"T", "A", "N", "M", "A", "Y"};
		sort(s);
		System.out.println(Arrays.toString(s));
	}
}
 