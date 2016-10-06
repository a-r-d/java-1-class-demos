package dogs;

public class Dog {
	
	private String name;
	private int weight;    // this is in units of lbs
	private int age;
	
	// Constructor for Dog class
	public Dog() {
		System.out.println("Looks like you are building a new dog");
	}
	
	
	public Dog(String name, int weight, int age) {
		super();
		this.name = name;
		this.weight = weight;
		this.age = age;
	}



	public String bark() {
		return String.format("%s says hello", name);
	}
	
	public String bark(String message) {
		return String.format("%s says %s", name, message);
	}
	
	public String bark(String name, String message) {
		return String.format("%s says %s", name, message);
	}
	
	// can't do this, only datatype matters in overloading
	/*public String bark(String message, String name) {
		return String.format("%s says %s", name, message);
	}
*/
	
	// can do this, datatype order is different
	public String bark(Integer message, String name) {
		return String.format("%s says %s", name, message);
	}
	
	// can do this, datatype order is different
	public String bark(String name, Integer message) {
		return String.format("%s says %s", name, message);
	}
	
	

	@Override
	public String toString() {
		return "Dog [name=" + name + ", weight=" + weight + ", age=" + age + "]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		if(name.equals("fido")) {
			this.name = "not fido";
			return;
		}
		this.name = name;
	}


	public int getWeight() {
		if(weight == 0) {
			weight = 1;
		}
		return weight;
	}


	public void setWeight(int weight) throws Exception {
		if(weight < 1) {
			throw new Exception("Whoa you cant have a dog that light");
		}
		this.weight = weight;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
