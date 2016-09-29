
public class MethodsExamples {

	public static void main(String[] args) {
		// a function with no arguments and no return value
		helloWorld();
		
		// a function with one String argument and no return value
		helloWhat("mars");
		
		// this has a return value and an argument
		String result = hello("venus");
		System.out.println(result);
		
		// this returns a value and takes multiple arguments
		String res2 = hello("hello", "robots");
		System.out.println(res2);
		
	}
	
	public static String hello(String say, String what) {
		return String.format("%S %s", say, what);
	}
	
	public static String hello(String what) {
		return "Hello " + what;
	}
	
	public static void helloWhat(String what) {
		System.out.println("Hello " + what);
	}
	
	public static void helloWorld() {
		System.out.println("Hello world");
	}

}
