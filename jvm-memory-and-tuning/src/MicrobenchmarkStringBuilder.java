
public class MicrobenchmarkStringBuilder {

	// this is 
	public static String concatTest(String[] arr) {
		String concatted = "";
		for (String s : arr) {
			concatted += s;
		}
		return concatted;
	}

	// this is linear
	public static String builderTest(String[] arr) {
		StringBuilder builder = new StringBuilder();
		for (String s : arr) {
			builder.append(s);
		}
		return builder.toString();
	}

	public static void main(String[] args) {

		String[] arr = new String[500];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Double.toString(Math.random());
		}

		System.out.println("String 0 = " + arr[0]);

		// warm up test 1.
		System.out.println("Warming up code...");
		String reString = null;
		for (int i = 0; i < 5000; i++) {
			reString = concatTest(arr);
		}
		System.out.println(reString.substring(0, 20));

		// do test 1
		System.out.println("Running benchmark 1.");
		long start = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			reString = concatTest(arr);
		}
		long end = System.currentTimeMillis();
		System.out.println(reString.substring(0, 20));
		System.out.println("Simple concat timing: " + (end - start));

		// warm up test 2
		System.out.println("Warming up code 2...");
		String reString2 = null;
		for (int i = 0; i < 5000; i++) {
			reString2 = builderTest(arr);
		}
		System.out.println(reString2.substring(0, 20));

		// do test 1
		System.out.println("Running benchmark 2.");
		long start2 = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			reString2 = builderTest(arr);
		}
		long end2 = System.currentTimeMillis();
		System.out.println(reString2.substring(0, 20));
		System.out.println("builder timing: " + (end2 - start2));

	}

}
