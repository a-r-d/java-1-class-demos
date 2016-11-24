
import java.util.HashSet;
import java.util.Set;

public class PangramsSet {

	public static void main(String[] args) throws Exception {

		// String [] pangrams = new String [] {
		// "The quick brown fox jumps over the lazy dog",
		// "Pack my box with five dozen liquor jugs",
		// "The five boxing wizards jump quickly"
		// };

		String pangram = "The five boxing wizards jump quickly!";
		
		Set<Character> chars = new HashSet<>();
		pangram = pangram.replaceAll("[ \\.,!]", "");
		pangram = pangram.toLowerCase();
		
		for(char c : pangram.toCharArray()) {
			chars.add(c);
		}
		if(chars.size() == 26) {
			System.out.println("Is a pangram");
		} else {
			System.out.println("Is not a pangram");
		}
    
	}

}
