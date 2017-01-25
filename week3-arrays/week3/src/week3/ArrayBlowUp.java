package week3;

import java.util.Arrays;

public class ArrayBlowUp {

	public static void main(String[] args) {
		
		int nums [] = new int [] {5,6,7};
		
		System.out.println(nums.length);
		
		nums[2] = 100;
		
		System.out.println(Arrays.toString(nums));
		
		nums[3] = 200;

	}

}
