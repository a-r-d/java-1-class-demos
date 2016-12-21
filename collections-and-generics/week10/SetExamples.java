package week10;

import java.util.HashSet;
import java.util.Set;

public class SetExamples {

	public static void main(String[] args) {

		Set<String> strings = new HashSet<>();
		
		String test = "test";
		String test2 = "test2";
		String test3 = "test";
		
		strings.add(test);
		strings.add(test2);
		
		System.out.println("Size: " + strings.size());
		
		strings.add(test3);
		
		System.out.println("Size: " + strings.size());
		
		
		
	}

}
