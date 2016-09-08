package week3;

public class ScrambleNumbers {

	public static void main(String[] args) {
		
		int nums [] = new int [] { 1,2,3,4,5,6,7,8,9,10 };
		
		for(int i = 0; i < nums.length; i++) {
			int randPos = (int)Math.floor((Math.random() * nums.length));
			int randPos2 = (int)Math.floor((Math.random() * nums.length));
			
			int tmp = nums[randPos];
			nums[randPos] = nums[randPos2];
			nums[randPos2] = tmp;
		}
		
		
		for(int i : nums) {
			System.out.println(i);
		}
		
		
	}

}
