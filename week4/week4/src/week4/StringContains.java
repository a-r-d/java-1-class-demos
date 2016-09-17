package week4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringContains {

	public static void main(String[] args) {

		// what about validating an email?
		
		String arr [] = new String [] {"test@test.com", "lol@lo.what", "i am not an email", "root@localhost", "53393002"};
		
		// how to check if they are emails?
		// what about @ sign?
		
		for(String s : arr){
			if(s.contains("@")) {
				System.out.println(String.format("VALID: %s", s));
			} else {
				System.out.println(String.format("INVALID: %s", s));
			}
		}
		
		System.out.println();
		
		// -----> https://regex101.com/#javascript 
		// any char, followed by an @ followed by any char, followed by period
		String rePattern = ".+@.+\\.";
		Pattern p = Pattern.compile(rePattern);
		
		for(String s : arr){
			// create a matcher to check the string.
			Matcher m = p.matcher(s);
			if(m.find()) {
				System.out.println(String.format("RE VALID: %s", s));
			} else {
				System.out.println(String.format("RE INVALID: %s", s));
			}
		}
		
		// Wow, look that was much more restrictive and caught the bad @localhost email.
		
	}

}
