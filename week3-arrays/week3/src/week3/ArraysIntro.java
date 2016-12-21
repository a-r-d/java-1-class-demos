package week3;

public class ArraysIntro {

	public static void main(String[] args) {

		int evens [];
		int [] odds;
		
		evens = new int [5];
		
		System.out.println("Len evens: " + evens.length);
		
		evens[0] = 2;
		evens[1] = 4;
		evens[2] = 8;
		
		System.out.println("2nd position evens: " + evens[1]);
		
		
		for(int i =0; i < evens.length; i++) {
			System.out.println("Evens: " + i + "=" + evens[i]);
		}
		
		
		// literals: 
		odds = new int [] {1, 3, 5, 7, 9};
		
		// what is in it?
		for(int i =0; i < odds.length; i++) {
			System.out.println("Odds: " + i + "=" + odds[i]);
		}
		
		// this is a bad thing in Java language. Array has a terrible toString()....
		System.out.println("odds to string: " + odds.toString());
		
	
		
	}

}
