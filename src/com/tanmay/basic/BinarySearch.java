package com.tanmay.basic;

import java.util.Arrays;

public class BinarySearch {
	
	int[] data = {1,4,6,3,8,12,67,77};
	
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		Arrays.sort(bs.data);
		int index = bs.indexOf(bs.data, 4);
		System.out.println("the index is " + index);
	}
	
	private int indexOf(int[] data, int key){
		System.out.println(Arrays.toString(data));
		int hi = data.length - 1;
		int lo = 0;
		
		while(lo <= hi){
			int mid = lo+(hi-lo)/2;
			if(data[mid] < key)
				lo = mid+1;
			else if(data[mid] > key)
				hi = mid-1;
			else{
				return mid;
			}
		}
		return -1;
	}

}
