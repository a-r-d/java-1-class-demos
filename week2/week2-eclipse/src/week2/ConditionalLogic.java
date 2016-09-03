package week2;

public class ConditionalLogic {

	public static void main(String[] args) {

		// if
		boolean areWeLearningJava = true;
		if(areWeLearningJava) {
			System.out.println("we are learning java!");
		}
		
		// if with a not in the expression
		boolean weAreInTexas = false;
		if(!weAreInTexas) {
			System.out.println("We are NOT in texas");
		}
		
		// if / else
		if(1 != 1) {
			System.out.println("Oh no, math is not working today!");
		} else {
			System.out.println("Okay, looks like math is working normally today.");
		}
		
		
		// if / else if / else
		if(1 != 1) {
			// we know this will never ever ever execute
			System.out.println("I will never execute");
		} else if(1 == 1) {
			// but then we fall through to this block
			System.out.println("Yep, im in that middle \"else if\" block");
		} else {
			System.out.println("I will never execute");
		}
		
		
		// nesting, it is ugly and hard to read, but sure you can do it
		if(1 == 1) {
			if(2 == 2) {
				if(3 == 3) {
					int i = 123;
					System.out.println("Look im way down in some if blocks: " + 123);
				}
			}
		}
		
		
		System.out.println("Is i in scope here anymore?");
		
		
	}

}
