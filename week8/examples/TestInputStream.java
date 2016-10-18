import java.io.InputStreamReader;

public class TestInputStream {

	public static void main(String[] args) throws Exception {

		InputStreamReader isr = new InputStreamReader(System.in);
		
		// reading in single chars
		System.out.println("Please enter a piece of data: ");
		int byteData = isr.read();
		
		while(byteData != -1) {
			char c = (char)byteData;
			System.out.println("Byte: " + c);
			byteData = isr.read();
			
			if((char)byteData == '\n') {
				System.out.println("Done!");
				System.exit(0);
			}
		}
	}
	
}
