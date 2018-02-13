package com.tanmay.searching;

/**
 * The implementation SeparateChainingHash Symbol Table maintains as array of SequentialSearchST
 * objects and implements get() and put() by computing a hash function to choose which SequentialSearchST
 * object can obtain the key and then using get() and put() from SequentialSearchST to complete the job.
 *
 * @param <Key>
 * @param <Value>
 */
public class SeparateChainingHashST<Key, Value> {

	private int m;
	private SequentialSearchST<Key, Value>[] st;
	
	public SeparateChainingHashST(){
		this(997);
	}
	
	public SeparateChainingHashST(int m){
		this.m = m;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
		
		for(int i = 0 ; i < m ; i++){
			st[i] = new SequentialSearchST();
		}
	}
	
	private int hash(Key key){
		return (key.hashCode() & 0x7fffffff) % m; 
	}
	
	public Value get(Key key){
		return (Value) st[hash(key)].get(key);
	}
	
	public void put(Key key, Value value){
		st[hash(key)].put(key, value);
	}
}
