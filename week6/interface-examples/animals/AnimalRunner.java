package animals;

import java.util.ArrayList;
import java.util.List;

public class AnimalRunner {

	public static void main(String[] args) {

		Frog froggy = new Frog();
		froggy.setName("Bubbles");
		
		Bat batty = new Bat();
		batty.setName("Dracula");
		
		List<Animal> animals = new ArrayList<>();
		animals.add(froggy);
		animals.add(batty);
		
		for(Animal animal : animals) {
			System.out.println(animal.toString());
			System.out.println("Can it swim: " + animal.canSwim());
			System.out.println("Can it fly: " + animal.canFly());
			System.out.println();
		}
		
	}

}
