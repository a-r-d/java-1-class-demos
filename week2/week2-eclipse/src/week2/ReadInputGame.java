package week2;

import java.util.Scanner;

public class ReadInputGame {

	
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Please enter a number => ");
		int i = s.nextInt();
		
		if(i % 2 == 0) {
			System.out.println("You Win!");
		} else {
			System.out.println("You Lose!");
		}
	}
	
}
