
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayWithNIntegers {

	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<Integer>();
		for(int i = 0; i < 50; i++) {
			ints.add(i);
		}
		ints.add(30);
		
		for(int i : ints) System.out.print(i + " ");
		
		findByHashMap(ints);
		findByArr(ints);
		cleverWay(ints);
	}
	
	private static void cleverWay(List<Integer> ints) {
		int sumExpected = 0;
		int sumActual = 0;
		for(int i = 0; i < 50; i++) {
			sumExpected += i;
			sumActual += ints.get(i);
		}
		sumActual += ints.get(50); // there are 51;
		
		int target =  sumActual - sumExpected;
		System.out.println();
		System.out.println("Found: " + target);
	}
	
	private static void findByArr(List<Integer> ints) {
		int [] dupes = new int[ints.size()];
		int found = -1;
		for(int i : ints) {
			dupes[i] += 1;
			if(dupes[i] > 1) {
				found = i;
				break;
			}
		}
		System.out.println();
		System.out.println("Found: " + found);
	}
	
	private static void findByHashMap(List<Integer> ints) {

		int found = -1;
		Map<Integer, Integer> counts = new HashMap<>();
		for(int i : ints) {
			if(counts.get(i) == null) {
				counts.put(i, 1);
			} else {
				found = i;
				counts.put(i, counts.get(i) + 1);
			}
		}
		System.out.println();
		System.out.println("Found: " + found);
	}

}
