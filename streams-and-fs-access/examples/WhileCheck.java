package week8;

import java.nio.file.Path;
import java.util.Scanner;

public class WhileCheck {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Path path = null;
		boolean isValid = false;
		
		while(isValid == false) {
			// do stuff and try to get a valid path
			
			// when the path is valid, it willl break loop
		
			try {
				//path = Paths.get("stuff")

				isValid = true;
			} catch (Exception e) {
				
			}
		}
		
	}

}
