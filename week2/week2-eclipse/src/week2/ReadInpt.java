package week2;

import java.util.Scanner;

public class ReadInpt {
	
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Please enter an integer => ");
		int i = s.nextInt();
		
		System.out.println("int: " + i);
		System.out.println("Done!");
	}
}
