
public class NextPermutationString {

	public static void main(String[] args) {

		// https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
		// 
		// http://rumkin.com/tools/cipher/numbers.php
		// 
		// "h e f g"
		// "8-5-6-7"
		// next highest?
		// we want the next permutation, but only the next. 
		//
		// this is correct:
		// "h e g f"
		// "8-5-7-6"
		//	
		// this is wrong (highest possible)!
		// "h g f e"
		// "8-7-6-5"
		
		// for the purposes of this we can just let the chars cast to numerics
		// because they are in the right order.
		System.out.println((int)'e');
		System.out.println((int)'f');
		
		//System.out.println(getNextPermutation("hefg"));
		
		
		//System.out.println(getNextPermutation("abcdefgh"));
		// "qrstuvwxyz"
		//System.out.println(getNextPermutation("zyxwvut"));
		
		// u is greater than t, so the next permutation will be flipped.
		System.out.println(getNextPermutation("zyxwvtu"));
		
		
		
		// "d k  h c"
		// "4-11-8-3"
		// 
		// "h c d k  "
		//  8-3-4-11
		
		System.out.println(getNextPermutation("dkhc")); // should be "hcdk"
	
		
		
		// more complex example:
		// 
		// 
		String orig =     "biehzcmjckznhwrfgglverxsezxuqpj";
		String shouldBe = "biehzcmjckznhwrfgglverxsjepquxz";
		System.out.println(getNextPermutation(orig));
	}

	

	public static String getNextPermutation(String text) {
		// next permutation
		char [] letters = text.toCharArray();

		// find the largest decreasing sequence.
		int startLongestNonInc = text.length() - 1;
		
		// loop back from the end of the char array, until you find
		// a spot where the preceeding char is greater than the next.
		while (startLongestNonInc > 0 && 
				text.charAt(startLongestNonInc - 1) >= text.charAt(startLongestNonInc)) {
	        startLongestNonInc--;
		}
			

		if (startLongestNonInc <= 0) {
			// then you must be at the last permutation.
			// e.g. "54321" is the last permutation of that sequence.
			// "cba", "321"
			return null;
		}

		// next we need to find a "pivot point".
		// this is a following element (to the right) that is 
		// greater than the start of the largest decreasing sequence.
		int pivotSwapWith = text.length() - 1;
	    while (text.charAt(pivotSwapWith) <= text.charAt(startLongestNonInc - 1)) {
	        pivotSwapWith--;
	    }
	
	    // Swap the pivot with the higher element to the right
	    char temp = letters[startLongestNonInc - 1];
	    letters[startLongestNonInc - 1] = letters[pivotSwapWith];
	    letters[pivotSwapWith] = temp;
	    
	    // Reverse the suffix sequence
	    pivotSwapWith = text.length()  - 1;
	    while (startLongestNonInc < pivotSwapWith) {
	    	// another bit of swapping code.
	    	// pull out original
	        temp = letters[startLongestNonInc];
	        // assign the end to the beginning.
	        letters[startLongestNonInc] = letters[pivotSwapWith];
	        // assign the temp back to the other spot.
	        letters[pivotSwapWith] = temp;
	        startLongestNonInc++;
	        pivotSwapWith--;
	    }
	    

	    // remember, strings are immutable, so we need to pass 
	    // back a new string from the char array.
	    return new String(letters);
	}

	
}
