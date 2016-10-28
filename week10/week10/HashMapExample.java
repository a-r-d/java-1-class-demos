package week10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapExample {

	public static void main(String[] args) {

		Dog d1 = new Dog("fido", 1, 5);
		Dog d2 = new Dog("snoopy", 10, 15);
		Dog d3 = new Dog("buster", 1, 5);
		
		Map<String, Dog> dogs = new HashMap<>();
		
		dogs.put(d1.name, d1);
		dogs.put(d2.name, d2);
		dogs.put(d3.name, d3);
		
		System.out.println(dogs);
		
		System.out.println(dogs.get("snoopy"));
		
		
		List<Dog> dogsList = new ArrayList<>();
		
		dogsList.add(d1);
		dogsList.add(d2);
		dogsList.add(d3);
		
		String toFind = "snoopy";
		for(Dog dog: dogsList) {
			if(dog.name.equals(toFind)) {
				System.out.println(
						"Found the dog we searched for");
			}
		}
		
		
	}

}
