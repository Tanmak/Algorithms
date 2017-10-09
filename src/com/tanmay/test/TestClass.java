package com.tanmay.test;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;

public class TestClass {
	
	public static void main(String[] args) {
		System.out.println("start");
		In in = new In(args[0]);
		int[] a = in.readAllInts();
		System.out.println(Arrays.toString(a));
		System.out.println("End");
	}

}
