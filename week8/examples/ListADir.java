package week8;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class ListADir {

	public static void main(String[] args) {

		Path currentPath = Paths.get(System.getProperty("user.dir"));
		DirectoryStream<Path> paths = null;
		
		try {
			
			// this gets all the paths in a dir.
			paths = Files.newDirectoryStream(currentPath);
			
			// this prints info for each path.
			for (Path path : paths) {
				System.out.println(path.getFileName());
				BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
				System.out.println("  -> " + (attr.size() / (1000)) + " kb");
				System.out.println("  -> is directory: " + attr.isDirectory());
				System.out.println("  -> is file: " + attr.isRegularFile());
				System.out.println("  -> is symlink + " + attr.isSymbolicLink());
				System.out.println("  -> created " + attr.creationTime());
				System.out.println("  -> modified " + attr.lastModifiedTime());
				System.out.println();
			}
		} catch (Exception e) {
			System.err.println(e);
		}

		
	}

}
