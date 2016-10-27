package week10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MicroBenchmarkLists {
	
	public static final Random random = new Random();


	public static void main(String[] args) {

		List<Integer> numsArrayList = new ArrayList<>();
		List<Integer> numsLinkedList = new LinkedList<>();
		
		final int listSize = 1000000;
		final int timesToAccess = 5000;
		
		long startArrayList = System.currentTimeMillis();
		for(int i = 0; i < listSize; i++) {
			numsArrayList.add(getRandomInt());
		}
		long endArrayList = System.currentTimeMillis();
		
		System.out.println("The array list took this long to populate: ");
		System.out.println((endArrayList - startArrayList) + " ms\n");
		
		System.out.println("Array List random access * " + timesToAccess);
		
		long startALAccess = System.currentTimeMillis();
		for(int i = 0; i < timesToAccess; i++) {
			numsArrayList.get(random.nextInt(listSize - 1));
		}
		long endALAccess = System.currentTimeMillis();
		
		System.out.println("It took " + (endALAccess - startALAccess) + " ms\n");
		
		
		////////////////////////////////
		
		long startLinkedList = System.currentTimeMillis();
		for(int i = 0; i < listSize; i++) {
			numsLinkedList.add(getRandomInt());
		}
		long endLinkedList = System.currentTimeMillis();
		
		System.out.println("The linked list took this long to populate: ");
		System.out.println((endLinkedList - startLinkedList) + " ms\n");
		
		System.out.println("Linked List random access * " + timesToAccess);

		long startLLAccess = System.currentTimeMillis();
		for(int i = 0; i < timesToAccess; i++) {
			numsLinkedList.get(random.nextInt(listSize - 1));
		}
		long endLLAccess = System.currentTimeMillis();
		
		System.out.println("It took " + (endLLAccess - startLLAccess) + " ms\n");
		
	}
	
	public static int getRandomInt() {
		return (int)Math.floor((random.nextInt() * 1000*1000) + 1000*1000);
	}

}
