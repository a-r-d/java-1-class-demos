package week2;

public class Expressions {

	public static void main(String[] args) {

		boolean amITrue = 1 == 1;
		System.out.println("Is 1 equal to 1? " + amITrue);
		
		boolean amIFalse = 2 + 2 == 5;
		System.out.println("does 2 + 2 = 5? " + amIFalse);
		
		String cat = "cat";
		String dog = "dog";
		
		boolean catDog = cat.equals(dog);
		System.out.println("Is a cat the same as a dog: " + catDog);
		
		// NOT operator (!)
		boolean shortcut = !amITrue;
		System.out.println("If I am NOT true, I am: " + shortcut);

		// the expressions:
		// ==
		// !=
		// >=
		// <=
		// >
		// <
		
		// Java has another one:
		// .equals() for objects.
		
		// Why? 
		// because objects are complicated, what field do you compare on ? Is there a way to default this?
		// Turns out that you need to override .equals when you make objects if you want to compare them.
		
		
	}

}
