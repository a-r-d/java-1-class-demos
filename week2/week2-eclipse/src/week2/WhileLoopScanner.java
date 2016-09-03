package week2;

import java.util.Scanner;

public class WhileLoopScanner {

	public static void main(String[] args) {
		
		Scanner s = new Scanner	(System.in);
		
		System.out.println("Enter a line: => ");
		while(s.hasNext()) {
			String line = s.nextLine();
			if(line.trim().equals("end")) {
				System.out.println("Ending this infinte loop");
				break;
			}
			System.out.println(line);
			System.out.println("Enter a line: => ");
		}
		
	}

}
