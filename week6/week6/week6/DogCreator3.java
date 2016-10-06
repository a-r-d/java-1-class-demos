package week6;

import dogs.Dog;
import dogs.DogUtility;

public class DogCreator3 {

	public static void main(String[] args) {

		Dog dog1 = new Dog("charlie", 30, 10);
		Dog dog2 = new Dog("chelsea", 20, 5);
		
		// static methods do not require the object to be 
		// instantiated
		Dog heavier = DogUtility.compareDogWeight(dog1, dog2);

		System.out.println("The heavier dog is: " + heavier);
		
	}

}
