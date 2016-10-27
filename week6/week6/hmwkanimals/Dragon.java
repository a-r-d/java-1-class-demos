package hmwkanimals;

public class Dragon extends Animal {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dragon(String name) {
		super();
		this.name = name;
	}
	
	public Dragon(String name, String type) {
		super();
		this.name = name;
		this.setType(type);
	}
	
	public void breatheFire() {
		System.out.println("fire is everywhere");
	}
	
	
}
