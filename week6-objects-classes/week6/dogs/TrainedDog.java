package dogs;

public class TrainedDog extends Dog {

	private String breed;
	
	public TrainedDog() {
	}
	
	public TrainedDog(String name, int weight, int age, String breed) {
		super(name, weight, age);
		this.setBreed(breed);
	}
	
	public String attack() {
		return this.getName() + " attacks and bites you on the leg";
	}
	
	@Override
	public String bark() {
		System.out.println("Trained dog is barking");
		return super.bark();
	}
	
	

	@Override
	public String toString() {
		return "TrainedDog [breed=" + breed + ", getName()=" + getName() + ", getWeight()=" + getWeight()
				+ ", getAge()=" + getAge() + "]";
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
	
}
