import java.util.Arrays;
import java.util.Scanner;

public class ArrayAnxietyExamples {
	
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int [] ourArray;
		ourArray = makeArray();
		System.out.println("User entered: " + ourArray.length);
				
		populateArray(ourArray);
		System.out.println(Arrays.toString(ourArray));
		
		float average = getAverage(ourArray);
		System.out.println("Array average: " + average);
		
		// append to an array
		ourArray = appendToArray(ourArray, 59);
		System.out.println("appended: " + Arrays.toString(ourArray));
		
	}
	
	public static int [] appendToArray(int [] originalArr, int val) {
		int [] ourNewArray = new int [originalArr.length + 1];
		for(int index = 0; index < originalArr.length; index++) {
			ourNewArray[ index ] = originalArr[ index ];
		}
		ourNewArray[ ourNewArray.length - 1 ] = val;
		
		return ourNewArray;
	}
	
	
	public static float getAverage(int [] ourArray) {
		int sum = 0;
		for(int arrVal : ourArray) {
			sum += arrVal;
		}
		System.out.println("Array Sum: " + sum);
		
		float avg = (float)sum / (float)ourArray.length;
		return avg;
	}
	
	public static void populateArray(int [] ourArray) {
		for(int index = 0; index < ourArray.length; index++) {
			System.out.println("Please enter val for position #" + index);
			int nextVal = scanner.nextInt();
			ourArray[ index ] = nextVal;
		}
	}
	
	
	public static int [] makeArray() {
		System.out.println("give me an int => ");
		int valueFromUser = -1;
		
		while(!isValid(valueFromUser)) {
			valueFromUser = scanner.nextInt();
			if(!isValid(valueFromUser)) {
				System.out.println("Sorry, this was not valid: " + valueFromUser);
				System.out.println("give me an int => ");
			}
		}
		
		int [] arr = new int [valueFromUser];
		return arr;
	}
	
	public static boolean isValid(int test) {
		boolean testResult = test >= 0 && test <= 100;
		return testResult;
	}

}
