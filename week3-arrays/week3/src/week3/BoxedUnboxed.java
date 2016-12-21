package week3;

public class BoxedUnboxed {

	public static void main(String[] args) {
		
		int i = 1;
		Integer i2 = 2;
		
		if(i + 1 == i2) {
			System.out.println("The integer values are equal");
		}
		
		boolean b = true;
		Boolean b2 = true;
	
		if(b == b2) {
			System.out.println("The boolena values are equal");
		}
		
		
		Long l1 = 123l;
		Long l2 = 123l;
		if(l1 == l2) {
			System.out.println("The long values are equal");
		}
		if(l1.equals(l2)) {
			System.out.println("the long values are equal by .equals");
		}
		
		
		Long parsedLong = Long.parseLong("5489424");
		System.out.println("Look, I parsed a long: " + parsedLong);
		
		

	}

}
