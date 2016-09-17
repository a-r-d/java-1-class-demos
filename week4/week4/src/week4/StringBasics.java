package week4;

public class StringBasics {

	public static void main(String[] args) {

		// commonly done
		String literal = "I am a string literal";
		
		// a little pointless
		String obj = new String("i am a string object");
		
		// strings are really char arrays!
		char [] chars = new char [] {'s', 't', 'r', 'i', 'n', 'g'};
		// this is where you want to use the constructor
		String fromCharArray = new String(chars);
		
		System.out.println(literal);
		System.out.println(obj);
		System.out.println(fromCharArray);
		
		
		final String iAmAConstant = "normally you want to make your string a final unless you plan to redifine it";
		
		// I will not compile:
		// iAmAConstant = "something else";
		
		String reassingable = "I am a literal";
		reassingable = "I am another literal";
		
	}

}
