package hmwkanimals;

public class AnimalRunner {

	public static void main(String[] args) {

		
		Animal [] animals = new Animal [3];
		
		Dog dog = new Dog("fido", "dog");
		Dragon dragon = new Dragon("smaug", "dragon");
		Cow cow = new Cow("bessie", "cow");
		
		animals[0] = dog;
		animals[1] = dragon;
		animals[2] = cow;
		
		
		for(Animal animal : animals) {
			System.out.println("Animal type: " + animal.getType());
			
			if(animal.getType().equals("cow")) {
				Cow aCow = (Cow)animal;
				System.out.println("Cows name: " + aCow.getName());
				System.out.println("Cow says:");
				aCow.chewGrass();
			}
			
			if(animal.getClass() == Dragon.class) {
				System.out.println("The class of the dragon is: " + 
							animal.getClass());
				System.out.println("The dragon says: ");
				((Dragon)animal).breatheFire();
			}
		}
		
	}

}
