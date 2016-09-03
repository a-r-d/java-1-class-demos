package week2;

import java.util.Scanner;

public class SwitchCase {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		System.out.println("enter an integer => ");
		int yourNum = s.nextInt();
		
		switch(yourNum) {
			case 1: 
				System.out.println("you had a 1");
				break;
			case 0: 
				System.out.println("you has a zero");
				break;
			default:
				System.out.println("You has something other than a zero or a one");
		}
		
		
	}

}
