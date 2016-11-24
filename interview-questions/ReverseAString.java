public class ReverseAString {

	public static void main(String[] args) {
		
		String test = "reverseme";
		char [] arr = test.toCharArray();
		for(int i=0; i < arr.length / 2; i++) {
			char last = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = arr[i];
			arr[i] = last;
		}
		String reversed = String.valueOf(arr);
		System.out.println(reversed);
	}

}
