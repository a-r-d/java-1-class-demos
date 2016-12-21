package exceptions;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadingIntegers {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int i;
		try {
			System.out.print("enter an int => ");
			i = s.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Error! " + e);
			i = -1;
		} finally {
			s.close();
			System.out.println("we're done");
		}
		
		
		System.out.println("What is the value of i: " + i);
	}

}
