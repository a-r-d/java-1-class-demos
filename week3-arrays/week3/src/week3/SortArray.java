package week3;

import java.util.Arrays;
import java.util.Comparator;

public class SortArray {

	public static void main(String[] args) {

		Integer [] nums = new Integer [] {2,5,342,54,2,1,0,-50};
		
		Arrays.sort(nums);
		
		for(int i : nums) {
			System.out.println(i);
		}
		
		System.out.println("");
		
		Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        });
		
		for(int i : nums) {
			System.out.println(i);
		}
		
		
	}
	

}
