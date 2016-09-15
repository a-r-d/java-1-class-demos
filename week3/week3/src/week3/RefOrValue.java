package week3;

import java.util.Arrays;

public class RefOrValue {

	public static void main(String[] args) {
		int myInt  = 100;
		addToMyInt(myInt);

		System.out.println("myInt in main " + myInt);
	
		int arr [] = new int [] {9,8,4,3,1,2,4,5,6,7};
		System.out.println(Arrays.toString(arr));
		doASort(arr);
		System.out.println(Arrays.toString(arr));
	}

	// by value, because it is primitive
	private static void addToMyInt(int myInt) {
		myInt += 100;
		System.out.println("myint in the function: " + myInt);
	}
	
	// by ref, because it is not (an array is not primitive)
	private static void doASort(int [] arr) {
		Arrays.sort(arr);
	}
	
}
