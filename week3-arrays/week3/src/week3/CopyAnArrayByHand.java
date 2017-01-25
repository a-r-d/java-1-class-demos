package week3;

import java.util.Arrays;

public class CopyAnArrayByHand {

	public static void main(String[] args) {
		
		int [] arr1 = new int [] {1,2,3,4,5};
		
		int [] arr2 = new int [arr1.length + 1];
		
		int lastValue = 9000;
		
		for(int i = 0; i < arr1.length; i++) {
			arr2[ i ] = arr1[ i ];
		}
		
		arr2[arr2.length - 1] = lastValue;
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		

	}

}
