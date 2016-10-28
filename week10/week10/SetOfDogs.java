package week10;

import java.util.HashSet;
import java.util.Set;

public class SetOfDogs {

	public static void main(String[] args) {

		Set<Dog> dogs = new HashSet<>();
		
		Dog d1 = new Dog("fido");
		Dog d2 = new Dog("snoopy");
		
		dogs.add(d1);
		dogs.add(d2);
		
		System.out.println("dog size: " + dogs.size());
		
		Dog d3 = new Dog("fido");
		
		dogs.add(d3);

		System.out.println("dog size: " + dogs.size());
		
		
		
	}

}
