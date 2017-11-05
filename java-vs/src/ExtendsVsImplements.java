import pojo.Cat;
import pojo.Dog;

public class ExtendsVsImplements {

	public static void main(String[] args) {

		Cat cat = new Cat();
		
		cat.setAge(5);
		cat.setName("mittens");
		cat.setWeight(4);
		
		System.out.println(cat);
		
		
		Dog dog = new Dog();
		
		dog.setAge(4);
		dog.setName("fido");
		dog.setWeight(10);
		
		System.out.println(dog);
	}

}
