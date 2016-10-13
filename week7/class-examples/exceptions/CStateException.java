package exceptions;

public class CStateException extends Exception {

	public String someExtraData;
	
	public CStateException(String message, String someExtraData) {
		super(message);
		this.someExtraData = someExtraData;
	}
	
}
