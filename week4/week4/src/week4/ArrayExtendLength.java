package week4;

import java.util.Arrays;

public class ArrayExtendLength {

	public static void main(String[] args) {

		String [] arr = new String [] {"always", "be", "coding"};
		
		// double the length.
		String [] arrLonger = new String [arr.length + arr.length]; 
		
		for(int i = 0; i < arr.length; i++) {
			arrLonger[i] = arr[i];
		}
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arrLonger));
		
		
	}

}
