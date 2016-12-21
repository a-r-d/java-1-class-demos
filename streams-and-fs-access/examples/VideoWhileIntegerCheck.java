package week8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VideoWhileIntegerCheck {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		int userVal = -1;
		
		while(userVal < 0) {
			try {
				
				System.out.println("Please enter a positive integer: ");
				
				userVal = scanner.nextInt();
				
			} catch (InputMismatchException ex) {
				//System.out.println(ex);
				scanner.next();
			}
		}
		
		// user entered a valid value.
		
		System.out.println("user entered: " + userVal);
		System.out.println("Done!");
		
		scanner.close();
	}

}
