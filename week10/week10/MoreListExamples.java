package week10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MoreListExamples {

	public static void main(String[] args) {

		
		List<String> strings = new LinkedList<>();
		
		strings.add("I am a string!");
		strings.add("another string");
		
		String secondElement = strings.get(1); 
		
		System.out.println("2nd elem: " + secondElement);
		System.out.println("size of list: " + strings.size());
		
		strings.remove(0);
		
		System.out.println("Size of list: " + strings.size());
		
		System.out.println("1st element: " + strings.get(0));
		
		
	}

}
