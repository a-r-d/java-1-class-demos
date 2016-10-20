package week8;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class ListTree {

	public static void main(String[] args) {

		//Path currentPath = Paths.get(System.getProperty("user.dir"));
		Path currentPath = Paths.get(
				System.getProperty("user.home"), 
				"projects");
		
		try {
			// this gets all the paths in a dir.
			listDirAndFollow(currentPath, 0);
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	
	public static void listDirAndFollow(Path path, int depth) throws Exception{
		BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
		if(path.endsWith(".git")) {
			return;
		}
		// case for directory
		if(attributes.isDirectory()) {
			depth++;
			
			// print for each directory
			System.out.println(getSpacesForDepth(depth) + ">" + path.getFileName());
			
			// now call for each child:
			DirectoryStream<Path> paths = Files.newDirectoryStream(path);
			for(Path tmpPath: paths) {
				listDirAndFollow(tmpPath, depth);
			}
		} else {
			
			// Case for a file
			System.out.println(getSpacesForDepth(depth) + " -->" + path.getFileName());
		}
	}
	
	public static String getSpacesForDepth(int depth) {
		StringBuilder spaces = new StringBuilder();
		for(int i = 0; i < depth; i++) {
			spaces.append("    ");
		}
		return spaces.toString();
	}
	

}
