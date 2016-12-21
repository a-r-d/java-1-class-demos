package week3;

public class MultiDim {
	public static void main(String[] args) {
		
		int nums [][];
		
		nums = new int [10][10];
		
		for(int i =0; i < nums.length; i++) {
			for(int j = 0; j < nums[i].length; j++) {
				nums[i][j] = randRng(100);
			}
		}
		
		for(int i =0; i < nums.length; i++) {
			for(int j = 0; j < nums[i].length; j++) {
				System.out.print(nums[i][j] + ",");
			}
			System.out.println();
		}
		
	}
	
	
	public static int randRng(int max) {
		return (int)Math.floor(Math.random() * max);
	}
}
