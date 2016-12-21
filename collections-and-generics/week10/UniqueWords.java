package week10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UniqueWords {

	public static void main(String[] args) {

		// read in a line
		Scanner scanner = new Scanner(System.in);
		System.out.println("give me a line of text: ");
		String text = scanner.nextLine();
		
		// split the line
		String [] words = text.split(" ");
		
		// convert to List
		List<String> wordList = Arrays.asList(words);
		System.out.println(wordList);
		
		// convert to Set
		Set<String> uniqueWords = new HashSet<>(wordList);
		System.out.println("Unique word count: " + uniqueWords.size());
		
		// frequency of each word.
		Map<String, Integer> frequencyCounter = new HashMap<>();
		
		for(String word : wordList) {
			// have we encountered the word before?
			if(frequencyCounter.containsKey(word)) {
				// if you PUT on something that already exists,
				// it will simply replace it.
				frequencyCounter.put(word, frequencyCounter.get(word) + 1);
			} else {
				// otherwise, record the initial count as 1
				frequencyCounter.put(word, 1);
			}
		}
		
		// print the frequency of each word
		for(String word : frequencyCounter.keySet()) {
			System.out.printf("%s: %d \n", word, frequencyCounter.get(word));
		}
		
		
	}

}
