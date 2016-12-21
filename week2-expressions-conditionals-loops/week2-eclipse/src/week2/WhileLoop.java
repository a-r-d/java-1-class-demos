package week2;

public class WhileLoop {

	public static void main(String[] args) {
		
		int start = 0;
		int end = 7;
		while(start < end) {
			System.out.println("Start variable: " + start);
			start++;
		}
		
		
		System.out.println("\nHere is a loop that breaks early:\n");
		
		start = 0;
		end = 1000;
		while(start < end) {
			if(start > 5) {
				System.out.println("Okay that's enough!");
				break;
			}
			System.out.println("start: " + start);
			start++;
		}
		
	}

}
