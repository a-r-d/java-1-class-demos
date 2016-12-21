package week10;

public class CustomArrayListRunner {

	public static void main(String[] args) {

		CustomArrayList<String> myCustomArray = new CustomArrayList<>();
		
		myCustomArray.add("Test value 1");
		myCustomArray.add("custom value 2");
		myCustomArray.add("3rd val");
		myCustomArray.add("the 4th val");
		
		for(String str : myCustomArray) {
			System.out.println(str);
		}
		
	}

}
