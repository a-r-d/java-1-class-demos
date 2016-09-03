package week2;

public class BlockScope {
	public static void main(String[] args) {

		// if blocks
		int i = 123;
		boolean areWeLearningJava = true;
		if(areWeLearningJava) {
			System.out.println("we are learning java! - " + i);
		}
		
		if(1 == 1) {
			// what if I want to use i again?
			// int i = 0;  // compile error, duplicate variable
			int x = 54321;
			System.out.println("Defining variables in an if block scope: " + x);
		}
		
		int x = 890;
		System.out.println("Wait what, I redefined this same variable??? - " + x);
		
		
		if(1 == 1) {
			if(2 == 2) {
				int y = 123;
			}
			int y = 234;
		}
		int y = 345;
		System.out.println("So you mean I can define the same variable at different scopes? " + y);
		System.out.println("Yes, you can, it just depends on if how the scopes overlap!");
		
		
	}
}
