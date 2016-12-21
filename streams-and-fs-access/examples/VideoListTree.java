package week8;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class VideoListTree {

	public static void main(String[] args) throws Exception {
		Path currentPath = Paths.get(System.getProperty("user.dir"));
		listDir(currentPath, 0);
	}
	
	public static void listDir(Path path, int depth) throws Exception {
	
		BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
		
		// if directory, list the files, and traverse down iside each of those
		if(attr.isDirectory()) {
			
			DirectoryStream<Path> paths = Files.newDirectoryStream(path);
			System.out.println(spacesForDepth(depth) + " > " + path.getFileName());
			
			for(Path tempPath: paths) {
				listDir(tempPath, depth + 1);
			}
			
		} else {
			System.out.println(spacesForDepth(depth) + " -- " + path.getFileName());
		}
	}
	
	public static String spacesForDepth(int depth) {
		StringBuilder builder = new StringBuilder();
		for(int i =0; i < depth; i++) {
			builder.append("    ");
		}
		return builder.toString();
	}
	
	
	
	

}
