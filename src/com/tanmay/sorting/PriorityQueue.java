package com.tanmay.sorting;

public class PriorityQueue <Key extends Comparable<Key>>{

	private Key[] arr;
	private int count = 0;
	
	PriorityQueue(int size){
		arr = (Key[]) new Comparable[size+1];
	}
	
	public void insert(Key key){
		arr[++count] = key;
		swim(count);
	}
	
	public Key delMax(){
		Key key = arr[1];
		exchange(1, count--);
		arr[count+1] = null;//avoid loitering
		sink(1);
		return key;
	}
	
	public boolean isEmpty(){
		return count == 0;
	}
	
	public int size(){
		return count;
	}
	
	private void swim(int k){
		while(k>1 && less(k/2, k)){
			exchange(k, k/2);
			k = k/2;
		}
	}
	
	private void sink(int k){
		while(2*k <= count){
			int j = 2*k;
			if(j < count && less(j, j+1)){
				j++;
			}
			
			if(!less(k, j)){
				break;
			}
			exchange(k, j);
			k = j;
		}
	}
	
	private boolean less(int u, int v){
		return arr[u].compareTo(arr[v]) < 0;
	}
	
	private void exchange(int u, int v){
		Key dummy = arr[u];
		arr[u] = arr[v];
		arr[v] = dummy;
	}
	
}
