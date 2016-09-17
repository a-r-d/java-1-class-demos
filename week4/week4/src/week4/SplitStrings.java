package week4;

import java.util.Arrays;

public class SplitStrings {

	public static void main(String[] args) {

		
		String someInput = "799, 3990, 3882, 238, 23894, 1983, 34893, 48393, 4894";
		String [] arr = someInput.split(",");
		
		System.out.println(Arrays.toString(arr));
		
		// oh wow, look at those extra spaces???
		
		for(int i = 0; i < arr.length; i++) {
			// trim the spaces, remember strings are immutable.
			arr[i] = arr[i].trim();
		}
		
		System.out.println(Arrays.toString(arr));
		// that looks better.
		
		
	}

}
