package week2;

import java.util.Scanner;

public class HomeWorkStart {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter an uppercase letter:");
		String fromUser = scan.nextLine();
		
		char userChar = fromUser.charAt(0);
		
		System.out.println("User typed: " + userChar);
		
		int length = userChar - 'A';
		
		System.out.println("Distance from A: " + length);
		
		
	
	}

}
