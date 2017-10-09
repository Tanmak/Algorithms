package com.tanmay.fundamental.dataStructure;

import edu.princeton.cs.algs4.StdIn;

public class StackClient {
	
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		
		while(!StdIn.isEmpty()){
			String str = StdIn.readString();
			if(!str.equals("-")){
				stack.push(str);
			}else if(!stack.isEmpty()){
				String s = stack.pop();
				System.out.println("Popped Item : " + s);
			}
		}
		
	}

}
