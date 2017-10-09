package com.tanmay.basic;

public class IdentifyPrimeNumber {

	private static int number = 19;

	public static void main(String[] args) {
		boolean isPrime = false;

		if (number < 2)
			isPrime = true;
		else {
			isPrime = true;
			for (int i = 2; i*i < number; i++) {
				if (number % i == 0)
					isPrime = false;
			}
		}
		
		System.out.println("Is the number : " + number + " prime? : " + isPrime);
		
	}
}
