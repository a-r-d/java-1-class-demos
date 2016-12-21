package week11;

import java.util.Arrays;

public class ArraysSearchExample {

	public static void main(String[] args) {

		int [] nums = new int [] {54, 2, 6, 99, 390, 290, 3, 1, 0, -59, 392, 60};
	
		int numToFind = 1;
		
		for(int i = 0; i < nums.length; i++) {
			int val = nums[i];
			if(val == numToFind) {
				System.out.println("we found it at position " + i);
			}
		}

		Arrays.sort(nums);
		
		System.out.println(Arrays.toString(nums));
		
		int position = Arrays.binarySearch(nums, numToFind);
		
		System.out.println("Binary search found it at: " + position);
		
	}

}
