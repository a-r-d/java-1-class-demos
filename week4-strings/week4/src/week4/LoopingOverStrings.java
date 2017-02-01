package week4;

public class LoopingOverStrings {

	public static void main(String[] args) {
		
		String hello = "hello world";
		
		for(int i = 0; i < hello.length(); i++) {
			char c = hello.charAt(i);
			System.out.println(c);
		}
		
		
		char [] chars = hello.toCharArray();
		for(char c : chars) {
			System.out.println(c);
		}
		
		
		
	}

}
