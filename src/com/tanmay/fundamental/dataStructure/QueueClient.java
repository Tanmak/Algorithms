package com.tanmay.fundamental.dataStructure;

import edu.princeton.cs.algs4.StdIn;

public class QueueClient {
	
	public static void main(String[] args) {

		Queue<String> queue = new Queue<String>();
		
		while(!StdIn.isEmpty()){
			String str = StdIn.readString();
			if(!str.equals("-")){
				queue.enqueue(str);
			}else if(!queue.isEmpty()){
				String s = queue.dequeue();
				System.out.println("Popped Item : " + s);
			}
		}
		
	
	}

}
