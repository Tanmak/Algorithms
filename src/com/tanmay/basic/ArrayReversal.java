package com.tanmay.basic;

public class ArrayReversal {
	
	private static int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	
	public static void main(String[] args) {
		int size = a.length;
		
		for (int i = 0; i < size/2 ; i++){
			int item = a[i];
			a[i] = a[size - 1 - i];
			a[size - 1 - i] = item; 
		}
		
		for(int i : a)
		System.out.println(" The reversed array : " + i);
	}

}
