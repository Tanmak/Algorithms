package com.tanmay.fundamental.dataStructure;

public class FixedCapacityStack<Item> {

	Item[] stack;
	int n;
	
	public FixedCapacityStack(int capacity){
		stack = (Item[]) new Object[capacity];
	}
	
	public boolean ismpty(){
		return n == 0;
	}
	
	public int size(){
		return n;
	}
	
	public void push(Item item){
		stack[n++] = item;
	}
	
	public Item pop(){
		return stack[--n];
	}
	
}
