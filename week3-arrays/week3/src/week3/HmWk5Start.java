package week3;

import java.util.Arrays;
import java.util.Scanner;

public class HmWk5Start {

	public static void main(String[] args) {

		
		int myInts [] = new int [10];
		
		Scanner s = new Scanner(System.in);
		System.out.print("How large is the array => ");
		int size = s.nextInt();
		
		if(size > 100 || size < 0) {
			System.out.println("Whoa that number is not right!");
		}
		
		String arr [] = new String [size];
		arr[0] = "Always";
		arr[1] = "Be";
		arr[2] = "coding";
		
		System.out.println(Arrays.toString(arr));
		
		
	}

}
