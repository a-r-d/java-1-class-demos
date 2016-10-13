import java.util.Scanner;

public class DemosInClass1 {

	public static void main(String[] args) {

		/*
		for(int i = 0; i < 100; i++) {
			System.out.println(i);
		}
		*/
		/*
		int sum = 0;
		for(int i = 1; i <= 1000; i++) {
			sum += i;
		}
		System.out.println(sum);
		*/
		
/*
		int sum = 0;
		for(int i = 1; i <= 300; i++) {
			if(i %
			 2 != 0) {
				sum += i;
			}
		}
		System.out.println(sum);
*/		
		
		/*
		int sum = 0;
		for(int i = 2000; i >= 6; i--) {
			if(i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
		
		*/
		
		// Read in an integer value from the user and print out if 
		// the number is even or odd.
		
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("type something => ");
		//int myInt = s.nextInt();
		//boolean bool = s.nextBoolean()
		
		String aLineAUserEntered = s.nextLine();
		Integer myInt = null;
		
		try {
			myInt = Integer.parseInt(aLineAUserEntered);
		} catch (Exception e) {
			System.out.println("Oh No! " + e.toString() + e.getMessage());
		}
		
		System.out.println("My Int: " + myInt);
		
		if(myInt % 2 == 0) {
			System.out.println("yay, it was even");
		} else {
			System.out.println("nope, that was odd");
		}
		
		s.close();
		
		
		
		
		
		
	}

}
























