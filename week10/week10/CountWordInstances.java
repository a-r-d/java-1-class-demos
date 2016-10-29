package week10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class CountWordInstances {

	public static void main(String[] args) throws Exception {

		Path path = Paths.get(System.getProperty("user.dir"))
				.resolve("article.txt");
		
		BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));
		
		Map<String, Integer> frequency = new HashMap<>();
	
		String line = reader.readLine();
		while(line != null) {
			//System.out.println("Processing line: " + line);
			
			if(!line.trim().equals("")) {
				String [] words = line.split(" ");
				
				for(String word : words) {
					if(word == null || word.trim().equals("")) {
						continue;
					}
					String processed = word.toLowerCase();
					processed = processed.replace(",", "");
					
					if(frequency.containsKey(processed)) {
						frequency.put(processed, 
								frequency.get(processed) + 1);
					} else {
						frequency.put(processed, 1);
					}
				}
			}
			
			line = reader.readLine();
		}
		
		
		System.out.println(frequency);
		
		int mostFrequentlyUsed = 0;
		String theWord = null;
		
		for(String word : frequency.keySet()) {
			Integer theVal = frequency.get(word);
			if(theVal > mostFrequentlyUsed) {
				mostFrequentlyUsed = theVal;
				theWord = word;
			}
		}
		System.out.println();
		System.out.printf("the most frequently used word is '%s', %d times", 
				theWord, mostFrequentlyUsed);
		
	}

}
