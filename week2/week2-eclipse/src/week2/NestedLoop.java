package week2;

public class NestedLoop {

	public static void main(String[] args) {
		
		for(int i = 1 ; i <= 10; ++i) {
			for(int j = 1; j <= 10; j++) {
//				/*for(int k = 1; k <= 10; k++) {
//					System.out.print(i*j*k+",");
//				}*/
				System.out.print(i*j+",");
			}
			System.out.println();
		}
		
		
	}

}
