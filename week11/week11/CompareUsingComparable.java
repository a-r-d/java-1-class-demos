import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareUsingComparable {

  public static void main(String args []) {

	List<Cat> cats = new ArrayList<>();
	
	cats.add(new Cat("loki"));
	cats.add(new Cat("garfield"));
	cats.add(new Cat("enki"));
	cats.add(new Cat("art"));
	cats.add(new Cat("z"));
	
	// Sort with comparable interface.
	Collections.sort(cats);
	
	System.out.println(cats);

  }

}
