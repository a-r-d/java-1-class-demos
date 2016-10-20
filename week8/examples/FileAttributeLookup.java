package week8;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class FileAttributeLookup{

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Give me an absolute filename: ");
		String fname = scanner.nextLine();
		
		FileSystem fs = FileSystems.getDefault();
		Path filepath = fs.getPath(fname);
		
		if(Files.exists(filepath) == false) {
			System.out.println("Hey that file doesn't exist!");
			System.exit(1);
		} else {
			System.out.println("We resolved the path: " + filepath);
			System.out.println("The filepath does exist.\n");
		}
		
		BasicFileAttributes attr = Files.readAttributes(
				filepath, BasicFileAttributes.class);

		System.out.println("  -> isDir: " + attr.isDirectory());
		System.out.println("  -> isFile" + attr.isRegularFile());
		System.out.println("  -> is symlink + " + attr.isSymbolicLink());
		System.out.println("  -> created " + attr.creationTime());
		System.out.println("  -> modified " + attr.lastModifiedTime());
	
		scanner.close();
	}

}
