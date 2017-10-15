package com.tanmay.fundamentalExercises;

import com.tanmay.fundamental.dataStructure.Queue;
import com.tanmay.tracking.Stopwatch;

import edu.princeton.cs.algs4.StdIn;

/**
 * In the Josephus problem from antiquity, n people are in dire straits and agree to the following
 * strategy to reduce the population. They arrange themselves in a cicle(at positions numbered from 
 * 0 to n-1) and proceed around the circle, eliminating every mth person until only one person is left.
 * Legend has it that Josephus figured out where to sit to avoid being eliminated. Write a Queue client 
 * Josephus that takes m and n from the command line and prints out the order in which people are eliminated
 * (ans thus would show Josephus where to sit in the circle.)
 * 
 * % java Josephus 2 7
 *	1 3 5 0 4 2 6
 *    
 * @author Tanmay
 *
 */

public class Josephus {
	
	private static Queue<Integer> queue = new Queue<Integer>();

	public static void main(String[] args) {
		int order = StdIn.readInt();
		int noOfPeople = StdIn.readInt();
		
		
		for(int i = 0 ; i < noOfPeople ; i++){
			queue.enqueue(i);
		}
		System.out.println(order + " " + noOfPeople);
		
		Stopwatch timer = new Stopwatch();
		printOrder(order);
		System.out.println("Elapsed Time : " + timer.elapsedTime());
	}
	
	private static void printOrder(int order){
		int n = 0;
		int size = queue.size();
		
		while(!(size == 0)){
			n++;
			if(n%order == 0){
				int item = queue.dequeue();
				size--;
				System.out.println(item);
			}else{
				int item = queue.dequeue();
				queue.enqueue(item);
			}
		}
	}
}
