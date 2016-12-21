package week2;

public class LogicalOperators {

	public static void main(String[] args) {

		boolean exp1 = true == true;
		boolean exp2 = 1 == 2;
		
		boolean exp3 = exp1 && exp2;
		System.out.println("Are both expressions true? - " + exp3);
		
		boolean exp4 = exp1 || exp2;
		System.out.println("Is one or the other true?  - " + exp4);
		
		boolean allInline = "yes".equals("no") || 2 > 3;
		System.out.println("Is one or the other true? " + allInline);
		
		
		boolean allInline2 = "yes".equals("no") || 2 > 3 || 10 / 5 == 20 / 10;
		System.out.println("Is one or the other or the other true? " + allInline2);
		
		
	}

}
