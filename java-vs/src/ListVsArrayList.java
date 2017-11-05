import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListVsArrayList {

	public static void main(String[] args) {

		int [] ints = new int [] {1,2,3};
		
		List<Integer> intsList = new LinkedList<>(); //new ArrayList<>(); 
		
		
		List<Integer> intsList2 = new ArrayList<>();
		intsList2.add(5);
		intsList2.add(10);
		
		ArrayList<Integer> intsList3 = new ArrayList<>();
		intsList3.add(8);
		intsList3.add(13);
		
		System.out.println(intsList2);
		System.out.println(intsList3);
	}

}
