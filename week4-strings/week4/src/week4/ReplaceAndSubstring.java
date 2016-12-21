package week4;

public class ReplaceAndSubstring {

	public static void main(String[] args) {

		String hello = "Hello good world";
		System.out.println(hello);
		
		hello = hello.replace("good", "cruel");
		System.out.println(hello);
		
		hello = hello.replace("Hello", "Goodbye");
		System.out.println(hello);
		
		// ?? why did I re-assign this?
		// Strings are immutable
		
		// immutable means you cannot change it.
		// so we take the result of the transform and re-assign it.
		
		
		// where is "world" ??
		int index = hello.indexOf("world");
		
		// I get a copy of the substring that I sliced out.
		String world = hello.substring(index, index + 5);
		
		System.out.println("Did I get world? " + world);
		

		
		
		
	}

}
