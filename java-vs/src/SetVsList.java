import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pojo.Fish;

public class SetVsList {

	public static void main(String[] args) {

		Fish f1 = new Fish("tuna");
		Fish f2 = new Fish("salmon");
		Fish f3 = new Fish("cod");
		Fish f4 = new Fish("guppie");
		
		
		List<Fish> fishList = new ArrayList<>();
		Set<Fish> fishSet = new HashSet<>();
		
		fishList.add(f1);
		fishList.add(f2);
		fishList.add(f3);
		
		System.out.println(fishList);
		
		fishSet.add(f1);
		fishSet.add(f2);
		fishSet.add(f3);
		
		System.out.println(fishSet);
		
		fishList.add(f1);
		System.out.println(fishList);
		
		fishSet.add(f1);
		System.out.println(fishSet);
	}

}
