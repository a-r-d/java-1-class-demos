package week10;

import java.util.HashMap;
import java.util.Map;

public class MapExamples {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();
		
		map.put("45215", "Blue Ash");
		map.put("45202", "Business District");
		
		System.out.println(map);
	
		System.out.println();
		System.out.println(map.get("45215"));
		
		map.put("11011", "Times Square");
		
		System.out.println("Size: " + map.size());
		
		map.remove("45202");
		
		System.out.println("Size: " + map.size());
		
		System.out.println();
		for(String key : map.keySet()) {
			System.out.println("I am looping over key=" + key);
			System.out.println("The value for this key is: " + map.get(key) + "\n");
			
		}
		
		
		
	}

}
