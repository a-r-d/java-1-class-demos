
public class ReverseInt {

	public static void main(String[] args) {

		int x = 12345; // -> 54321   size 4
		int y = 12340; // -> 4321
		int z = 679;   // -> 679     size 2
		
		System.out.println(reverse(x));
		System.out.println(reverse(y));
		System.out.println(reverse(z));
	}
	
	public static int getSize(int x) {
		return ((int) Math.floor(Math.log10(x)));
	}
	
	public static int reverse(int x) {
		int size = getSize(x);
		int reversed = 0;
		int iter = 0;
		while(x > 0) {
			int lastDigit = x % 10;
			x = x / 10;
			
			// if x was 5 and size was 4 we want to add 
			// 50000
			// next iter...
			// if x was 4 then size is actually 3 
			reversed += lastDigit * ((int) Math.pow(10, size - iter));
			iter++;
		}
		
		return reversed;
	}

}
