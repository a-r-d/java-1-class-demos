package week3;

import java.util.Arrays;

public class SomeFunctions {

	public static void main(String[] args) {

		int [] myArr = getMyArr();
		
		System.out.println(Arrays.toString(myArr));
		
		iAmAVoidFunc();
		
		int myNum = getANum();
		System.out.println(myNum);
		
		String hello = "Hello";
		saySomething(hello);
		
		String world = "World";
		saySomethingMore(hello, world);
		
		
		String greeting = addStringsTogether(hello, world);
		System.out.println("our greeting: " + greeting);
	}
	
	private static String addStringsTogether(String hello, String world) {
		String greeting =  hello + world;
		return greeting;
	}

	private static void saySomethingMore(String hello, String world) {
		System.out.println(hello + " " + world);
	}

	public static int [] getMyArr() {
		return new int [] {1,2,3};
	}
	
	public static void iAmAVoidFunc() {
		System.out.println("Hello void");
		return;
	}
	
	public static int getANum() {
		return 3;
	}
	
	public static void saySomething(String whatever) {
		System.out.println(whatever);
	}
	
	
	
}
