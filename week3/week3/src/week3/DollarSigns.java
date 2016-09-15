package week3;

public class DollarSigns {

	public static void main(String[] args) {
		
		int sizeLoop = 10;
		
		for(int i = 0; i < sizeLoop; i++) {
			for(int j = 0; j < i + 1; j++) {
				System.out.print("$");
			}
			System.out.print("\n");
		}
		
	}

}
