package week5;

import java.util.Scanner;

public class IsAVowel {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("give me a letter: ");
		String line = scanner.nextLine();
		char first = line.charAt(0);
		first = Character.toUpperCase(first);
		
		System.out.println("Entered: " + first);
		
		System.out.println(isVowel(first));
		
		System.out.println(isASmallPositiveNumber(50));
		System.out.println(isASmallPositiveNumber(-69));
	}
	
	private static boolean test1(int i) {
		System.out.println("Running test 1");
		return i > 0;
	}
	
	private static boolean test2(int i) {
		System.out.println("Running test 2");
		return i < 100;
	}
	
	private static boolean isASmallPositiveNumber(int i) {
		return test1(i) && test2(i);
	}
	
	private static boolean isVowel(char c) {
		return c == 'A' ||
				c == 'E' ||
				c == 'I' ||
				c == 'O' ||
				c == 'U';
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
