package dogs;

public class DogUtility {

	public static Dog compareDogWeight(Dog dog1, Dog dog2) {
		if(dog1.getWeight() > dog2.getWeight()) {
			return dog1;
		} else {
			return dog2;
		}
	}
	
	
}
