package com.tanmay.fundamental.dataStructure;

import java.util.Iterator;


public class Queue<Item> implements Iterable<Item>{

	Node first;
	Node last;
	int N;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public void enqueue(Item item){
		Node oldLast = last;
		last = new Node();
		last.item = item;
		if(isEmpty()){
			first = last;
		}else{
			oldLast.next = last;
		}
		N++;
	}
	
	public Item dequeue(){
		Node oldFirst = first;
		first = first.next;
		N--;
		if(isEmpty())
			last = null;
		return oldFirst.item;
	}
	
	public int size(){
		return N;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{

		private Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item  = current.item;
			current = current.next;
			return item;
		}
		
	}
}
