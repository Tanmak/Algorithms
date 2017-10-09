package com.tanmay.fundamental.dataStructure;

import java.util.Iterator;

/**
 * Linked List implementation of Stack
 * @author Tanmay
 *
 */
public class Stack<Item> implements Iterable<Item>{
	
	Node first;
	int N;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public void push(Item item){
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	
	public Item pop(){
		Item item = first.item;
		first = first.next;
		N--;
		return item;
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
