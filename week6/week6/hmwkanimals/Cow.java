package hmwkanimals;

public class Cow extends Animal {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cow(String name) {
		super();
		this.name = name;
	}
	
	public Cow(String name, String type) {
		super();
		this.name = name;
		this.setType(type);
	}
	
	public void chewGrass() {
		System.out.println("the cow stares off into the distance and chews");
	}
	
	
}
