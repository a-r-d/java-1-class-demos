package week4;

public class ValidateAnIPAddress {

	public static void main(String[] args) {

		String ip = "68.180.260.104";
		String ipv6 = "2605:a000:132f:2006:ffff:11ea:f89f:72f3";
		
		// let's validate an IP, how do we do it?
		
		// why did I have to escape the period? \\. is what??
		String [] parts = ip.split("\\.");
		
		for(String part : parts) {
			int num = Integer.parseInt(part);
			System.out.println(num);
			if(num < 0 || num > 255) {
				System.out.println("NOT A VALID IP! " + num);
			}
		}
		
		System.out.println();
		System.out.println();
		
		String [] partsv6 = ipv6.split(":");
		for(String part : partsv6) {
			int num = Integer.parseInt(part, 16);
			System.out.println(num);
			// each group is 16 bits.
			
			if(num < 0 && num >= 65536) {
				System.out.println("NOT A VALID IP! " + num);
			}
		}
		
		System.out.println("Done!");
		
	}

}
