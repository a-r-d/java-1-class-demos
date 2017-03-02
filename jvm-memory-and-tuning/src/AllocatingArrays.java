import java.util.Scanner;

public class AllocatingArrays {

	public static void main(String[] args) throws InterruptedException {

		Scanner s = new Scanner(System.in);
		System.out.println("Type something to continue...");
		s.nextLine();
		
		System.out.println("Allocating...");
		
		// giga is 10^9
		// an int is 32 bits, which is 4 bytes.
		// 10^9 / 4 is about how many gigs it will take up.
		int toAlloc = (int)Math.pow(10, 9) / 4;
		int [] ints = new int [toAlloc];
		
		System.out.println("Sleeping");
		
		// what happens when we null the ref?
		ints = null;
		
		Thread.sleep(60000);
		
		System.out.println("Done...");
	}

}
