package week8;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class VideoWhilePathCheck {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Path userPath = null;
		boolean isValid = false;
		
		while(isValid == false) {
			try {
		
				System.out.println("Please enter a filepath: ");
				
				String filePath = scanner.nextLine();
				
				userPath = Paths.get(filePath);
				
				if(filePath.trim() == "") {
					System.out.println("Sorry, that file path was empty!");
					continue;
				}
				
				if(Files.exists(userPath)) {
					isValid = true;
				} else {
					System.out.println("Sorry, that file did not exist");
				}
				
				System.out.println();
				
			} catch (InvalidPathException ex) {
				System.out.println("Path was not valid");
			}
		}
		
		
		// we have valid input.
		
		System.out.println("user's path: " + userPath.toAbsolutePath());
		System.out.println("Done!");
		
	}

}
