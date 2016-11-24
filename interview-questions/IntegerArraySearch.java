
import java.util.Arrays;
import java.util.Scanner;

public class IntegerArraySearch {

	public static void main(String[] args) {
		int [] arr = new int[]{
			4, 6, 7, 9, 2, 5, 1, 10, 20	
		};
		Arrays.sort(arr);
		
		System.out.print(">");
		Scanner s = new Scanner(System.in);
		int find = s.nextInt();
		
		//int res = findInt(arr, find);
		int res = bSearchRecursive(arr, find, arr.length - 1, 0);
		
		for(int i : arr) System.out.print(i + " ");
		System.out.println();
		System.out.println(res);
	}
	
	
	private static int bSearchRecursive(int [] arr, int target, int high, int low) {
		if(high < low) {
			return -1;
		}
		int mid = low + ((high - low) / 2);
		// if the array position is higher than the target
		// then we need to look lower in the array
		if(arr[mid] > target) {
			// so we drop the high end to the midpoint
			return bSearchRecursive(arr, target, mid - 1, low);
		
		// if the array position is lower than the target
		// then we look up higher in the array
		} else if(arr[mid] < target) {
			return bSearchRecursive(arr, target, high, mid + 1);
		} else {
			return mid;
		}
	}
	
	private static int findInt(int [] arr, int target) {
		int low = 0;
		int high = arr.length - 1;
		int midpoint;
		
		while(low <= high) {
			// This is the crux
			// midpoint is the low # + the high end. 
			// first pass is halfway up array
			// 2nd pass may be  farther up or down depending on the stuff below
			midpoint = low + ((high - low) / 2);
			
			// if the array position is higher than target, lower the high point 
			// i.e. we look toward the beginning of the array
			if (arr[midpoint] > target){
				high = midpoint - 1;
			
			// if the array is position is lower, raise up low point
			// i.e. we look toward the end of the array
			} else if (arr[midpoint] < target){
				low = midpoint + 1;
			} else {
				return midpoint;
			}
		}
		
		return -1;
	}
	
	

}
