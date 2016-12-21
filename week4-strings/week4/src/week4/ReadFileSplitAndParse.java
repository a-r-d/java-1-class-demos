package week4;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFileSplitAndParse {

	public static void main(String[] args) throws Exception {

		// this gets the file path for a file in the root of the project:
		String fileLoc = new File("./data.txt").getAbsolutePath();
		Path path = Paths.get(fileLoc);
		
		// list is like an array, we'll go into it eventually. It is part of the collections system.
		List<String> lines = Files.readAllLines(path);
		
		// this is my RE for an IP address. It is not as good as it could be. We can actually validate number ranges with RE
		// and IPs must be 0-255
		Pattern ipAddress = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
		
		int i = 1;
		String [] allIps = new String[ lines.size() ];
		
		for(String line : lines) {
			String[] splits = line.split(" ");
			//System.out.println(Arrays.toString(splits));
			Matcher m = ipAddress.matcher(line);
			while(m.find()) {
				String ip = m.group();
		        System.out.println(String.format("line: %s, IP on line: %s", i, ip));
		        
		        // what would happen if it matched more than one IP on the same line?
		        // what if we don't find any?
		        // can we make this better?
		        allIps[i - 1] = ip;
		    }
			i++;
		}
		
		
		// What else can we do?
		System.out.println(Arrays.toString(allIps));
		
		// how many are in the 207 block?
		
		// how many end in 104 ?
		
		// how many errors were there in the log file?
		
	}

}
