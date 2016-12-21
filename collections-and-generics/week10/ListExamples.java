package week10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExamples {

	public static void main(String[] args) {

		// Lists
		
		// Array list can be declared specifically
		// the type in the angle brackets on the right side is optional
		ArrayList<String> arrayList = new ArrayList<String>();
		
		arrayList.add("I am a string");
		arrayList.add("I am an another string");
		
		System.out.println("What is in the ArrayList? - \n" + arrayList.get(1));
		System.out.println();
		
		// Great, but there is a better way.
		List<String> aList = new ArrayList<>();
		
		aList.add("I am also a string");
		aList.add("I am yet another string");
		
		System.out.println("What is in the List? - \n" + aList.get(1));
		System.out.println();
		
		// wow, so we called all of the same methods on List
		// that we could also call on ArrayList.
		// so just use List.
		// why?
		
		// because we can swap it out for a linked list, and nobody can tell.
		
		List<String> anotherList = new LinkedList<>();
		
		anotherList.add("yet another string");
		anotherList.add("yet another another string");
		
		System.out.println("What is in this list (that is actually a linked list?) - \n" + 
				anotherList.get(1));
		System.out.println();
		
		// of course you can iterate over any of these:
		
		for(String str : anotherList) {
			System.out.println("In the another list: " + str);
		}
		
	}

}
