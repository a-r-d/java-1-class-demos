package week3;

import java.util.Arrays;

public class MaxValue {

	public static void main(String[] args) {

		int [] nums = new int [] {1,2,3,4,5,6,7,8,10,20,50,-50,-20,-3};

		// slow way:
		Arrays.sort(nums);
		int max = nums[nums.length - 1];
		
		// why? Because sorting is slow. Sorting is slower exponentially for each item 
		// in the array being sorted.
		System.out.println("Max: " + max);
		
		// faster way than sorting: 
		int highest = nums[0];
		for(int i : nums) {
			if(i > highest) {
				highest = i;
			}
		}
		System.out.println("Max via a loop: " + highest);
		
		
	}

}
