package com.tanmay.searching;

import java.util.NoSuchElementException;

import com.tanmay.fundamental.dataStructure.Queue;

public class BinarySearchTreeST <Key extends Comparable<Key>, Value>{
	
	private Node root;
	
	private class Node{
		private Key key;
		private Value value;
		private Node left;
		private Node right;
		private int n;
		
		public Node(Key key, Value value, int n){
			this.key = key;
			this.value = value;
			this.n = n;
		}
	}
	
	public int size(){
		return size(root);
	}
	
	private int size(Node node){
		if(node == null){
			return 0;
		}else{
			return node.n;
		}
	}
	
	public Value get(Key key){
		return get(root, key);
	}
	
	private Value get(Node node, Key key){
		if(node == null){
			return null;
		}
		int cmp = key.compareTo(node.key);
		if(cmp < 0){
			return get(node.left, key);
		}else if(cmp > 0){
			return get(node.right, key);
		}else{
			return node.value;
		}
	}
	
	public void put(Key key, Value value){
		root = put(root, key, value);
	}
	
	private Node put(Node node, Key key, Value value){
		if(node == null){
			return new Node(key, value, 1);
		}
		int cmp = key.compareTo(node.key);
		if(cmp < 0){
			node.left = put(node.left, key, value);
		}else if(cmp > 0){
			node.right = put(node.right, key, value);
		}else{
			node.value = value;
		}
		node.n = size(node.left) + size(node.right) + 1;
		
		return node;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public Key min(){
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		Node x = min(root);
		return x.key;
	}
	
	private Node min(Node x){
		if(x.left == null){
			return x;
		}
		return min(x.left);
	}
	
	public Key max(){
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		Node x = max(root);
		return x.key;
	}

	private Node max(Node x){
		if(x.right == null){
			return x;
		}
		return max(x.right);
	}
	
	public Key select(int rank){
		if(rank < 0 || rank >= size(root)){
			throw new IllegalArgumentException();
		}
		Node x = select(root, rank);
		return x.key;
	}
	
	private Node select(Node x, int rank){
		if(x == null){
			return null;
		}
		int t = size(x.left);
		if(t > rank){
			return select(x.left, rank);
		}else if(t < rank){
			return select(x.right, (rank - t - 1));
		}else{
			return x;
		}
	}
	
	public int rank(Key key){
		return rank(root, key);
	}
	
	private int rank(Node x, Key key){
		if(x == null){
			return 0;
		}
		int cmp = key.compareTo(x.key);
		if(cmp < 0){
			return rank(x.left, key);
		}else if (cmp > 0){
			return 1 + size(x.left) + rank(x.right, key);
		}else{
			return size(x.left);
		}
	}
	
	public void deleteMin(){
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node x){
		if(x.left == null){
			return x.right;
		}
		x.left = deleteMin(x.left);
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public void deleteMax(){
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		root = deleteMax(root);
	}
	
	private Node deleteMax(Node x){
		if(x.right == null){
			return x.left;
		}
		x.right = deleteMax(x.right);
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public void delete(Key key){
		root = delete(root, key);
	}
	
	private Node delete(Node x, Key key){
		if(x == null){
			return null;
		}
		int cmp = key.compareTo(x.key);
		if(cmp < 0){
			x.left = delete(x.left, key);
		}else if(cmp > 0){
			x.right = delete(x.right, key);
		}else{
			if(x.left == null){
				return x.right;
			}
			if(x.right == null){
				return x.left;
			}
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.n = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public Iterable<Key> keys(){
		return keys(min(), max());
	}
	
	public Iterable<Key> keys(Key lo, Key hi){
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue, lo, hi);
		return queue;
	}
	
	private void keys(Node x, Queue<Key> queue, Key lo, Key hi){
		if(x == null){
			return;
		}
		int cmpLo = lo.compareTo(x.key);
		int cmpHi = hi.compareTo(x.key);
		
		if(cmpLo < 0){
			keys(x.left, queue, lo, hi);
		}
		if(cmpLo <= 0 && cmpHi >= 0){
			queue.enqueue(x.key);
		}
		if(cmpHi > 0){
			keys(x.right, queue, lo, hi);
		}
	}
	
	public void print(){
		print(root);
	}
	
	private void print(Node x){
		if(x == null){
			return;
		}
		print(x.left);
		System.out.print(" " + x.key);
		print(x.right);
	}
}
