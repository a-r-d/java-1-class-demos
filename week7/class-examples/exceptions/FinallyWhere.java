package exceptions;

public class FinallyWhere {

	public static void main(String[] args) {
		boolean res = retInTry();
		System.out.println("What happened? -> " + res);
	}
	
	public static boolean retInTry() {
		try {
			System.out.println("In a try block");
			return false;
		} catch (Exception e) {
			System.out.println("In exception");
		} finally {
			System.out.println("In the finally block");
			return true;
		}
		//return true;
	}

}
