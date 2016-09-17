package week4;

import java.util.Arrays;

public class ArrayInsert {

	public static void main(String[] args) {

		
		String [] arr = new String [] {"always", "be", "coding"};
		
		// create a new array with an extra length
		String [] arrLonger = insertInArray(arr, "seriously", 2);
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arrLonger));
			
	}
	
	
	public static String [] insertInArray(String [] arr, String item, int index ) {
		
		// create a new array with length + 1
		String [] arrLonger = new String [arr.length + 1]; 
		
		for(int i = 0; i < arrLonger.length; i++) {
			
			// this is the case when we are at the insert position
			if(i == index) {
				arrLonger[i] = item;
				
			// this is the case when we are before the insert position
			} else if(i < index) {
				arrLonger[i] = arr[i];
				
			// this is the case when we are after the insert position.
		    // notice that i - 1 in the original array???
			} else {
				arrLonger[i] = arr[i - 1];
			}
		}
		
		return arrLonger;
	}
	
	

}
