package animals;

public class Mammal implements Animal{
	
	private String name;

	@Override
	public void eat() {
		System.out.println(name + " had a meal");
	}

	@Override
	public void poop() {
		System.out.println(name + " pooped");
	}

	@Override
	public boolean canSwim() {
		return false;
	}

	@Override
	public boolean canFly() {
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Mammal [name=" + name + "]";
	}
	
	
	

}
