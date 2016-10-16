package week9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadInTrafficCountsNoBuffer {

	public static void main(String[] args) throws Exception {
		
		Path file = Paths.get(System.getProperty("user.dir")).resolve("datasets").resolve("Average_Daily_Traffic_Counts.csv");
		
		if(!Files.exists(file)) {
			throw new FileNotFoundException(file.toAbsolutePath().toString());
		}
		
		System.out.println("reading file: " + file);
		
		// prepare our stream
		FileReader reader = new FileReader(file.toFile());
		
		// alteratively you can use a buffered reader, which is more efficient:
		// BufferedReader reader = new BufferedReader(new FileReader(file.toFile()));
		// then you can read the data in line by line.
		
		// just like an array you dont size, we will go over collections next week.
		StringBuilder builder = new StringBuilder();
		
		// prime the data stream
		int data = reader.read();
		
		// data will be -1 when end of stream is reached
		while(data != -1) {
			char convertedToChar = (char)data;
			builder.append(convertedToChar);
			
			// read the next char
			// reading one char at a time is slow !
			data = reader.read();
		}
		
		// what did this do? We read the entire file into memory and stored it into a list.
		reader.close();
		
		String theData = builder.toString();
		String [] theLines = theData.split("\n");
		
		System.out.println("How many lines: " + theLines.length);
		System.out.println();
		System.out.println(theLines[0]);
		System.out.println(theLines[1]);

		
	}

}
