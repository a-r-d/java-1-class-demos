package pojo;

public class Cat extends Animal {

	@Override
	public String toString() {
		return "Cat [getWeight()=" + getWeight() + ", getAge()=" + getAge() + ", getName()=" + getName()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
