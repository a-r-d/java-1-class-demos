package week8;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class ResolvePaths {

	public static void main(String[] args) {

		FileSystem fs = FileSystems.getDefault();
		
		String linuxPath = "/home/ard/Documents/tmp-pdf.txt";			// this is a linux filesytem path.
		String windowsPath = "C:\\Users\\aaron.decker\\Documents"; 		// in java you must escape backslashes
		
		Path testPath = fs.getPath(linuxPath);
		System.out.println(testPath);
		
		Path testPath2 = fs.getPath(windowsPath, "tmp.txt");
		System.out.println(testPath2);
		
		try {
			// null char is not allowed on linux "\0"
			// on windows ? is not allowed.
			Path testPath3 = fs.getPath("\0");  // special NULL char.
			System.out.println(testPath3);
		} catch (InvalidPathException e ) {
			System.out.println(e);
		}
		
	}

}
