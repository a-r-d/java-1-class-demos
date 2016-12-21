package week8;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateADir {

	public static void main(String[] args) {

		// user.dir is this current directory of executing program
		Path file = Paths.get(System.getProperty("user.dir")).resolve("tmp-dir").resolve("another-dir");
		
		// the user.home dir the home dir of the logged in user
		//Path file = Paths.get(System.getProperty("user.home")).resolve("tmp-dir").resolve("another-dir");
	
		System.out.println(file);
		
		try {
			Files.createDirectories(file);
			
			// run "refresh" on the project to see the new file.
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		
		
		
	}

}
