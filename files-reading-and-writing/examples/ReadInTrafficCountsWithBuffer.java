package week9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadInTrafficCountsWithBuffer {

	public static void main(String[] args) throws Exception {
		
		Path file = Paths.get(System.getProperty("user.dir")).resolve("datasets").resolve("Average_Daily_Traffic_Counts.csv");
		
		if(!Files.exists(file)) {
			throw new FileNotFoundException(file.toAbsolutePath().toString());
		}
		
		System.out.println("reading file: " + file);
		
		// prepare our stream
		BufferedReader reader = new BufferedReader(new FileReader(file.toFile()));
		
		// prime the data stream
		String line = reader.readLine();
		List<String> lines = new ArrayList<>();
		
		// data will be -1 when end of stream is reached
		while(line != null) {
			lines.add(line);
			
			line = reader.readLine();
		}
		
		// what did this do? We read the entire file into memory and stored it into a list.
		reader.close();
		
		System.out.println("How many lines: " + lines.size());
		System.out.println();
		System.out.println(lines.get(0));
		System.out.println(lines.get(1));	

		
	}

}
