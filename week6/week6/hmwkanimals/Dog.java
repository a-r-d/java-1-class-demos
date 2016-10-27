package hmwkanimals;

public class Dog extends Animal {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dog(String name) {
		super();
		this.name = name;
	}
	
	public Dog(String name, String type) {
		super();
		this.name = name;
		this.setType(type);
	}
	
	public void bark() {
		System.out.println("dog is barking");
	}
	
	
}
