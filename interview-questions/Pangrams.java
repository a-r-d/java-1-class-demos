
public class Pangrams {

	public static void main(String[] args) throws Exception {

		// String [] pangrams = new String [] {
		// "The quick brown fox jumps over the lazy dog",
		// "Pack my box with five dozen liquor jugs",
		// "The five boxing wizards jump quickly"
		// };

		String pangram = "The five boxing wizards jump quickly";

		int[] ascii = new int[128];
		// should find all of the letters btwn 97 + 122 inclusive
		for (int i = 0; i < pangram.length(); i++) {
			int test = pangram.toLowerCase().charAt(i);
			if (test < 128) {
				ascii[test] += 1;
			}
		}

		boolean isPangram = true;
		for (int i = 97; i <= 122; i++) {
			if (ascii[i] == 0) {
				System.out.println("not pangram");
				isPangram = false;
				break;
			}
		}

		if (isPangram) {
			System.out.println("is a pangram");
		}
	}

}
