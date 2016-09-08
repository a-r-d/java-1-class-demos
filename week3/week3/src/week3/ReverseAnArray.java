package week3;

public class ReverseAnArray {

	public static void main(String[] args) {

		
		int [] nums = new int [] {1,2,3,4,5};
		
		for(int i : nums) {
			System.out.println(i);
		}
		
		
		System.out.println("reversing...");
		// what happens when you don't divide by two here?
		
		for(int i = 0; i < nums.length / 2; i++) {
			int tmp = nums[i];
			nums[i] = nums[nums.length - i - 1];
			nums[nums.length - i - 1] = tmp;
			
			for(int j: nums) {
				System.out.print(j + ",");
			}
			System.out.println();;
			
		}
		
		System.out.println("done reversing...");
		for(int i : nums) {
			System.out.println(i);
		}
		
	}

}
