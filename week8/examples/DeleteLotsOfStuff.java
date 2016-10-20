package week8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteLotsOfStuff {

	public static void main(String[] args) {
		
		Path path = Paths.get(
				System.getProperty("user.home"), 
				"tmp-dir",
				"another-dir");
		
		try {
			Files.delete(path);
			Files.delete(path.getParent());
			System.out.println("Success!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
