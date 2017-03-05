import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsOneStringAPermutationOfAnother {

	public static void main(String[] args) {
		
		// Given two strings, write a method to decide if one is a permutation
		// of another. 

		// what is a permutation?
		// well, since these are strings, you could just consider
		// this to be an anagram test...
		
		// they contain the same chars in the same quantities
		String a1 = "abcdef";
		String b1 = "bcafed";
		
		String a2 = "abcdef";
		String b2 = "acbddf";
		
		// what about case sensitivity? 
		// what about whitespace? 
		
		System.out.println(isPerm(a1, b1));
		
		System.out.println(isPerm(a2, b2));
		
	}
	
	
	
	public static boolean isPerm(String a, String b) {
		// quick short-circuit check.
		if(a.length() != b.length()) {
			return false;
		}
		
		// n * log(n) soln
//		char [] arr1 = a.toCharArray();
//		Arrays.sort(arr1);
//		char [] arr2 = b.toCharArray();
//		Arrays.sort(arr2);
//		
//		return (new String(arr1)).equals(new String(arr2));
		
		
		// linear soln (n)
		Map<Character, Integer> charMap = new HashMap<>();
		for(char c : a.toCharArray()) {
			if(charMap.containsKey(c)) {
				charMap.put(c, charMap.get(c) + 1);
			} else {
				charMap.put(c, 1);
			}
		}
		
		for(char c : b.toCharArray()) {
			if(charMap.containsKey(c)) {
				charMap.put(c, charMap.get(c) - 1);
			} else {
				// if we are missing something in the 2nd string
				// that we had in the first.
				return false;
			}
		}
		
		//
		for(int i : charMap.values()) {
			if(i != 0) {
				return false;
			}
		}
		
		// 3 * n --> n 
		
		return true;
	}

	
	
	
	
}
