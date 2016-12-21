import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringsExamples {

	public static void main(String[] args) {
		int vowels = countVowels("this is a huge STRING");
		System.out.println("How many vowels: " + vowels);
		
		String headline = "Hackers are 'poking around' voter systems, " +
				" FBI director says";
		
		int position = firstAppearance(headline, 'z');
		if(position >= 0) {
			System.out.println("Found char at: " + position);
		} else {
			System.out.println("Char not found ¯\\_(ツ)_/¯");
		}
		
		int [] positions = findAllAppearances(headline, 's');
		System.out.println(Arrays.toString(positions));
		
		
		//String subbed = headline.substring(55, 65);
		String subbed = ourSubstring(headline, 10, 15);
		System.out.println("My custom substring: " + subbed);
		
		
		System.out.println(compareStrings("hello", "hello"));
		System.out.println("hello".equals("hello"));
		
	}
	
	public static boolean compareStrings(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false;
		}
		
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public static String ourSubstring(String toSub, int start, int end) {
		char subStr [] = new char [ end - start ];
		
		for(int i = 0; i < subStr.length; i++) {
			subStr[ i ] = toSub.charAt(i + start);
		}
		
		return new String(subStr);
	}
	
	public static int [] findAllAppearances(String input, char toFind) {
		int timesSeen = 0;
		for(int i = 0; i < input.length(); i++) {
			char thisChar = input.charAt(i);
			if(thisChar == toFind) {
				timesSeen++;
			}
		}
		
		int positions [] = new int[timesSeen];
		timesSeen = 0;
		for(int i = 0; i < input.length(); i++) {
			char thisChar = input.charAt(i);
			if(thisChar == toFind) {
				positions[timesSeen] = i;
				timesSeen++;
			}
		}
		return positions;
	}
	
	
	public static int firstAppearance(String input, char toFind) {
		for(int i = 0; i < input.length(); i++) {
			char thisChar = input.charAt(i);
			if(thisChar == toFind) {
				return i;
			}
		}
		return -1;
	}
	
		
	public static int countVowels(String input) {
		char [] arr = input.toLowerCase().toCharArray();
		int vowels = 0;
		
		char [] allVowels = new char [] {'a', 'e', 'i', 'o', 'u'};
		
		// below we will use the for loop shorthand for collections
		// this is the equivalent long version
		/*  (ctrl+shft+/)		
		for(int i = 0; i < arr.length; i++) {
			char toCheck = arr[i];
			
		}*/
		
		for(char toCheck : arr) {
			for(char vowel: allVowels) {
				if(toCheck == vowel) {
					vowels++;
				}
			}
		}
		
		return vowels;
	}

}
