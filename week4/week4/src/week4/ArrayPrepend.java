import java.util.Arrays;

public class ArrayPrepend {

	public static void main(String[] args) {

		String [] originalArray = new String [] {"AAPL", "MSFT", "NFLX", "GOOG", "ORCL"};
		
		String [] stockList = arrayPrepend(originalArray, "AMZN");
		
		System.out.println(Arrays.toString(stockList));
	}
	
	public static String [] arrayPrepend(String [] original, String item) {
		String [] prependedArray = new String [original.length + 1];
		
		prependedArray[0] = item;
		
		for(int i = 0; i < original.length; i++) {
			prependedArray[i + 1] = original[i];
		}
		
		return prependedArray;
	}

}
