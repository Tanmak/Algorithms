package com.tanmay.tracking;

/**
 * This class is used to find algorthimic efficiency by track how much time is taken. 
 *  
 * @author Tanmay
 *
 */
public class Stopwatch {
	
	private final long start;
	
	public Stopwatch(){
		start = System.currentTimeMillis();
	}
	
	public double elapsedTime(){
		long now = System.currentTimeMillis();
		return (now - start)/1000;
	}

}
