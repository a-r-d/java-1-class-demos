package week6;

import dogs.DogConstants;
import dogs.TrainedDog;

public class DogCreator2 {

	public static void main(String[] args) throws Exception {

		TrainedDog dog = new TrainedDog("buster", 3, 10, DogConstants.BOXER);
		
		System.out.println(dog.bark());
		System.out.println(dog);
		
		
		
	}

}
