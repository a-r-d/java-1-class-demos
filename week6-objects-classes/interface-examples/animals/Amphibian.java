package animals;

public class Amphibian implements Animal {

	private String name;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void eat() {
		System.out.println(name + " had a meal");
	}

	@Override
	public void poop() {
		System.out.println(name + " pooped");
	}

	public boolean canSwim() {
		return true;
	}

	@Override
	public boolean canFly() {
		return false;
	}

	@Override
	public String toString() {
		return "Amphibian [name=" + name + "]";
	}
	
	
	
	
}
