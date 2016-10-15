package week9;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.LongBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class WriteToBufferedOutputStream {

	public static void main(String[] args) {

		// user.dir is this current directory of executing program
		Path file = Paths.get(System.getProperty("user.dir")).resolve("tmp-dir").resolve("data.txt");
		
		// the user.home dir the home dir of the logged in user
		//Path file = Paths.get(System.getProperty("user.home")).resolve("tmp-dir").resolve("data.txt");
	
		System.out.println(file);
		
		try {
			// probably, the "tmp-dir" part does not exist.
			Files.createDirectories(file.getParent());
			
			// what happens if you don't call "getParent()" ???
			
			// run "refresh" on the project to see the new file.
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		String helloWorld = "Hello World! This is going to be AWESOME!";
		// int bufferSize = Character.BYTES * helloWorld.length();
		// System.out.println("Allocating a buffer of size: " + bufferSize);
	    
		try {
			BufferedWriter fileOut = Files.newBufferedWriter(
					file, Charset.forName("UTF-16"), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
			
			System.out.println("Writing to buffer: " + helloWorld); 
			fileOut.write(helloWorld);
			fileOut.flush();
			fileOut.close();
				
		} catch (IOException e) {
			System.err.println(e);
		}
		
	}

}
