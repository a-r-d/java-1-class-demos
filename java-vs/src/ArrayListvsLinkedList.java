import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListvsLinkedList {

	public static void main(String[] args) {

		int [] ints = new int [] {1,2,3};
		
		List<Integer> alist = new ArrayList<>();
		List<Integer> alist2 = new LinkedList<>();
		
		alist.add(1);
		alist.add(2);
		
		alist2.add(5);
		alist2.add(8);
		alist2.add(10);
		
		System.out.println(alist);
		
		System.out.println(alist2);
		
	}

}
