package pojo;

import java.io.Serializable;

public class Dog implements IAnimal, Serializable, Comparable<Dog> {
	
	public double weight;
	public double age;
	public String name;
	
	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getAge() {
		return age;
	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Dog [weight=" + weight + ", age=" + age + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Dog arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
