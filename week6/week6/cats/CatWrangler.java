package cats;

public class CatWrangler {

	public static void main(String[] args) {
		
		Cat [] cats = new Cat[100];
		
		for(int i = 0; i < cats.length; i++) {
			String catName = "Cat clone #" + 
					(int)(Math.floor(Math.random() * 10000));
			int age = (int)Math.floor(Math.random() * 18) + 1;
			
			Cat cat = new Cat(catName, age);
			cats[i] = cat;
		}
		
		for(Cat cat : cats) {
			//System.out.println(cat.meow());
		}
		
		boolean compared =  cats[0].equals(cats[1]);
		System.out.println("are they equal: " + compared);
		System.out.println("Name 1: " + cats[0]);
		System.out.println("Name 2: " + cats[1]);
		
		
		System.out.println("The first cat is called: " + 
				cats[0].getName());
		
	}
	
	
}
