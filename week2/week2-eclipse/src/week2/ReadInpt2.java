package week2;

import java.util.Scanner;

public class ReadInpt2 {
	
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Please enter a line of text => ");
		String txt = s.nextLine();
		
		System.out.println("your line: " + txt);
		System.out.println("Done!");
	}
}
