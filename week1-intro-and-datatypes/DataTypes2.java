package edu.cincinnatistate;

public class DataTypes2 {
	
	static final int test = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// comments
		
		/***
		 * long comment
		 * 
		 * 
		 * 
		 */
		
		final String str = "test"
				+ ""
				+ ""
				+ "";
				
		
		// explicit cast
		int a = 5;
		final long b = 10L;
		int c = a + (int)b;
		
		// constants
		final int x = 1;
		
		
		// order of operations
		int y = 1 + 2 * 3;
		System.out.println("y:" + y);
		
		// += operator
		int z = 0;
		z += y;
		//z = z + y;
		
		// ++ operator
		int i = 0;
		i++;
		++i;
		i++;
		
		System.out.println(i);
		
		// -- operator
		i--;
		--i;
		i--;
		
		System.out.println("i now equals: " + i);
		
		
		// Math utils.
		System.out.println("random:" + Math.random());
		
		if(Math.random() > 0.5) {
			System.out.println("Yay!");
		}
		
		System.out.print("i will not return\n");
		System.out.println(Math.floor(50.000143893));
		System.out.println(Math.ceil(50.999));
		
		System.out.println(Math.abs(-50));
		
		
		
		//int Long = 5;
		//int class = 5;
		
		

	}

}
