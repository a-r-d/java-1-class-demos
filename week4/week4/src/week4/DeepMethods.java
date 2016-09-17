package week4;

import javax.swing.plaf.SliderUI;

public class DeepMethods {

	public static void main(String[] args) throws Exception{

		// Let's see what the stack is.
		f1();
		
		Thread.sleep(100l);
		System.out.println("OK we are back in the main function");
		
		System.out.println("Now, what does the stack look like???");
		new Exception().printStackTrace();
		
	}
	
	public static void f1() {
		System.out.println("Inside f1");
		f2();
	}
	
	public static void f2() {
		System.out.println("Inside f2");
		f3();
	}
	
	public static void f3() {
		System.out.println("Inside f3");
		f4();
	}
	
	public static void f4() {
		System.out.println("Inside f4");
		f5();
	}
	
	public static void f5() {
		System.out.println("Inside f5");
		new Exception().printStackTrace();
	}

}
