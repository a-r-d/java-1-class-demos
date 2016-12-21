import java.util.Scanner;

public class DescTria {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("enter a char => ");
		String myLine = scanner.nextLine();
		char upperCaseLtr = myLine.charAt(0);
		
		if((int)upperCaseLtr < (int)'A' && 
				(int)upperCaseLtr > (int)'Z') {
			System.out.println("Invalid entry");
			System.exit(1);
		}
		
		int distanceFromA = (int)upperCaseLtr - (int)'A';
		
		for(int i = 0; i < distanceFromA + 1; i++) {
			
			for(int j = 0; j < distanceFromA - i; j++) {
				System.out.print(" ");
			}
			
			for(int j = 0; j < i + 1; j++) {
				System.out.print((char)('A' + j));
			}
			
			for(int j = 0; j < i; j++) {
				System.out.print((char)('A' + i - 1 - j ));
			}
			System.out.println();
			
		}
		
		
	}

}
















