import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareUsingComparator {

	public static void main(String[] args) {

		List<Dog> dogs = new ArrayList<>();
		
		dogs.add(new Dog("fido"));
		dogs.add(new Dog("snoopy"));
		dogs.add(new Dog("alphie"));
		
		Collections.sort(dogs, new CompareDogs());
		
		System.out.println(dogs);
	}
	
	public static class CompareDogs implements Comparator<Dog> {

		@Override
		public int compare(Dog o1, Dog o2) {
			return o1.getName().compareTo(o2.getName());
		}
		
	}

}
