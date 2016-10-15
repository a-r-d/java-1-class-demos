package week9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadAndWriteStreamsAndTransform {

	public static void main(String[] args) throws Exception {

		// this is from the datasets that I provided on github
		Path file = Paths.get(System.getProperty("user.dir")).resolve("datasets").resolve("Average_Daily_Traffic_Counts.csv");
		
		// this resolves a file next to the original one, in the same dir.
		Path writeToFile = file.resolveSibling("copy_of_traffic_counts.csv");
		
		if(!Files.exists(file)) {
			throw new FileNotFoundException(file.toAbsolutePath().toString());
		}
		
		System.out.println("Copy from: " + file);
		System.out.println("Copy to: " + writeToFile);
		
		// prepare our streams
		BufferedReader reader = new BufferedReader(new FileReader(file.toFile()));
		BufferedWriter writer = new BufferedWriter(new FileWriter(writeToFile.toFile()));
		
		// reads + writes the file a line at a time.
		int count = 0;
		String line = reader.readLine();
		while(line != null) {
			count++;
			
			// do some transformation
			// this is just an example.
			line = line.toUpperCase();
			
			// write the file.
			writer.write(line + "\n");
			writer.flush();
			
			// get the next line
			line = reader.readLine();
		}
		
		// close up all of the resources.
		reader.close();
		writer.close();
		
		
		// What happened? We copied + transformed the text without reading the entire file into memory at once!
		// Sometimes you MUST use streams. What happens if you are manipulating a file that is 5 gigabytes???
		// YOu have to use streams for things of that size. Same with massive DB operations, you can stream records.
		System.out.printf("Read and wrote %d lines", count);
		
	}

}
