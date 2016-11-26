
public class Pangrams {

	public static void main(String[] args) throws Exception {

		// is it a pangram?
		String pangram = "The five boxing wizards jump quickly!";

		int [] ascii = new int[128];
		
		char [] chars = pangram.toLowerCase().toCharArray();
		
		for(int i = 0; i < chars.length; i++) {
			int test = (int) chars[i];
			if(test < 128) {
				ascii[test] += 1;
			}
		}
		
		System.out.println(Arrays.toString(ascii));
		
		for(int i = 97; i <= 122; i++) {
			if(ascii[i] == 0) {
				System.out.println("not a pangram!");
				System.exit(1);
			}
		}
		
		System.out.println("Is a pangram!");
	}

}
