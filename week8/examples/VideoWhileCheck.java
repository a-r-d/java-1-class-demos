package week8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VideoWhileCheck {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		boolean isValid = false;
		
		int userVal = -1;
		
		while(isValid == false) {
			
			// collect valid input
			try {
				
				System.out.println("Please enter a positive integer: ");
				userVal = scanner.nextInt();
					
				if(userVal > 0) {
					isValid = true;
				}
				
			} catch (InputMismatchException e) {
				//System.err.println(e);
				scanner.next();
			}
		}
		
		// go on with valid input
		System.out.println("What did the user enter?: " + userVal);
		System.out.println("Done!");
		
	}

}
