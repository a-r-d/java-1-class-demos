import java.util.Arrays;

public class ArrayExamples {

	public static void main(String[] args) {

		String [] strArr;
		strArr = new String [10];
		System.out.println(Arrays.toString(strArr));
		
		String [] arrLit = new String [] {"i", "am", "an array", "of", "strings"};
		System.out.println(Arrays.toString(arrLit));
		
		
		for(int index = 0; index < strArr.length; index++) {
			strArr[index] = "position " + index;
		}
		
		System.out.println(Arrays.toString(strArr));
		
	}

}
