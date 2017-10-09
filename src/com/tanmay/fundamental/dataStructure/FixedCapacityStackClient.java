package com.tanmay.fundamental.dataStructure;

import edu.princeton.cs.algs4.StdIn;

public class FixedCapacityStackClient {
	
	public static void main(String[] args) {
		
		FixedCapacityStack<String> stack = new FixedCapacityStack<String>(100);
		while(!StdIn.isEmpty()){
			String s = StdIn.readString();
			if(!s.equals("-")){
				stack.push(s);
			}else if(!stack.ismpty()){
				String s1 = stack.pop();
				System.out.println(s1);
			}
		}
		
		System.out.println(stack.size() + " items left");
		
	}

}
