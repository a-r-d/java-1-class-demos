package week8;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class CheckIfFileExists {

	public static void main(String[] args) {

		FileSystem fs = FileSystems.getDefault();
		
		Path aPath = fs.getPath(System.getProperty("user.dir"));
		
		System.out.println("What is the user dir: " + aPath);
		
		boolean exists = Files.exists(aPath);
		
		System.out.println("Does it exist: " + exists);
		
	}

}
