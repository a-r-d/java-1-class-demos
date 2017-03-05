import java.util.HashSet;
import java.util.Set;

public class AllUniqueChars {

	public static void main(String[] args) {
		
		// "Implement and algorithm to determine if a String has all unique characters"

		// should pass
		String test = "abcdef89372";
		
		// should fail, many dupes
		String test2 = "abcbca2892";
		
		// should fail only one dupe
		String test3 = "nhtfcswqoljh";
		
		// should pass?
		String test4 = null;
		
		System.out.println(hasUniqueChars(test));
		System.out.println(hasUniqueChars(test2));
		System.out.println(hasUniqueChars(test3));
		System.out.println(hasUniqueChars(test4));
		
	}
	
	public static boolean hasUniqueChars(String toTest) {
		Set<Character> set = new HashSet<>();
		for(char c : toTest.toCharArray()) {
			if(set.contains(c)) {
				return false;
			}
			set.add(c);
		}
		return true;
	}

}
