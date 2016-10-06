package week6;

import dogs.Dog;
import dogs.TrainedDog;
import dogs.UntrainedDog;

public class DogCreator {

	public static void main(String[] args) throws Exception {

		Dog fido = new Dog();
		
		// encapsulation of the properties
		fido.setName("Fido");
		fido.setAge(5);
		
		Dog dingo = new Dog("Charlie", 30, 11);
		
		//System.out.println("what is fido's weight: " + fido.getWeight());
		
		System.out.println(fido.bark());
		System.out.println(fido.bark("take me for a walk"));
		System.out.println(fido);
		System.out.println(dingo);
		
		// inheritance
		TrainedDog cujo = new TrainedDog();
		cujo.setName("Bill");
		cujo.setAge(15);
		
		
		System.out.println(cujo.attack());
		System.out.println(cujo);
		
		
		UntrainedDog coolDog = new UntrainedDog();
		coolDog.setName("Mr cool dog");
		
		
		// polymorphism
		Dog [] dogs = new Dog [2];
		dogs[0] = cujo;
		dogs[1] = coolDog;
		/*
		for(Dog dog : dogs) {
			System.out.println("the dog is: " + dog.getName());
		}
		*/
		
		for(int i = 0; i < dogs.length; i++) {
			Dog dog = dogs[i];
			System.out.println("the dog is: " + dog.getName());
			// The class is still what it was originally created as,
			// but we are treating them all as base Dog classes. 
			// We can find out the true class like so:
			System.out.println("The actual class name: " + dog.getClass().getName());
		}
		
		
		
		
		
		
		
		
	}

}
