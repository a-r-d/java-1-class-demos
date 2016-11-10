import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareUsingComparator {

	public static void main(String[] args) {

		List<Dog> dogs = new ArrayList<>();
		
		dogs.add(new Dog("fido"));
		dogs.add(new Dog("snoopy"));
		dogs.add(new Dog("snoopy", 10));
		dogs.add(new Dog("snoopy", 5));
		dogs.add(new Dog("alphie"));
		
		Collections.sort(dogs, new CompareDogs());
		
		
		for(Dog dog : dogs) {
			System.out.println(dog);
		}
	}
	
	public static class CompareDogs implements Comparator<Dog> {

		@Override
		public int compare(Dog o1, Dog o2) {
			// step 1 primary sort
			int name = o1.getName().compareTo(o2.getName());
			if(name != 0) {
				return name;
			}
			
			// step 2, if they were equal, secondary sort
			// how to compare integers?
			// just subtract them
			return o1.getAge() - o2.getAge();
		}
		
	}

}
