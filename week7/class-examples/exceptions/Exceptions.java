package exceptions;

public class Exceptions {

	public static void main(String[] args) throws Exception {

		Exception example = new Exception("an example");
		//throw example;
		
		try {
			boolean inATry = true;
			System.out.println("In a try block");
			someFunction();
			someOtherFunction();
		} catch (CStateException e) {
			System.out.println("In the CSTate exception block");
			System.out.println("Data: " + e.someExtraData);
		} catch (Exception e) {
			System.out.println("In the general exception block");
			CUtilities.WriteLog(e);
		} finally {
			System.out.println("Look, I'm in a finally block");
		}
		
		boolean inATry;
		
	}
	
	
	public static void someOtherFunction() throws CStateException {
		throw new CStateException(
				"Original message here",
				"important additional data"
		);
	}
	
	public static void someFunction() throws Exception {
		throw new Exception("coming from someFunction");
	}

}
