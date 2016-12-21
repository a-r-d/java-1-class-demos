package week2;

import java.util.Scanner;

public class ReadPrimeGame {

	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Please enter a number => ");
		int i = s.nextInt();
		
		// we will call another method
		if (isPrime(i)) {
			System.out.println("You Win!");
		} else {
			System.out.println("You Lose!");
		}
	}
	
	// this will be slow for large numbers.
	public static boolean isPrime(int n) {
		
		// start counting at 2, because we know 1 and 2 are prime!
	    for (int i = 2; i < n; i++) {
	        if (n % i == 0) {
	        	// welp, it was divisible by something!
	            return false;
	        }
	    }
	    return true;
	}
		
}
