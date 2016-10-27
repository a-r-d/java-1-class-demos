package week8;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class WhileCheckPath {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Path path = null;
		boolean isValid = false;
		
		while(isValid == false) {
			// do stuff and try to get a valid path
			// when the path is valid, it willl break loop
			System.out.println("Please enter a path: ");
			String tempPath = scanner.nextLine();
			
			System.out.println("You typed: " + tempPath);
			try {
				path = Paths.get(tempPath);
				System.out.println("Testing if this path exists: " + 
						path.toAbsolutePath());
				
				if(Files.exists(path)) {
					isValid = true;
					System.out.println("Awesome, it does exist");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		// valid....
		
		System.out.println("Done, File path: " + path.toAbsolutePath());
		
	}

}
