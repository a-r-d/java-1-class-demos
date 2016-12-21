package week2;

public class ForLoops {

	public static void main(String[] args) {
		
		System.out.println("We will begin a loop");
		for(int i = 0; i < 5; i++) {
			System.out.println("The value of i is: " + i);
		}
		
		System.out.println("\nOkay, let's define this loop a bit differently");
		for(int i = 1; i <= 5; i++) {
			System.out.println("The value of i is=" + i);
		}
		
		System.out.println("\nGreat, let's try another variation. Reverse it!");
		// check it out, we can go in reverse
		for(int i = 5; i > 0; i--) {
			System.out.println("The value of i is=" + i);
		}
		
		System.out.println("\nOkay, lets change the structure because Java is zero-indexed!");
		for(int i = 4; i >= 0; i--) {
			System.out.println("The value of i is=" + i);
		}
		
	}

}
