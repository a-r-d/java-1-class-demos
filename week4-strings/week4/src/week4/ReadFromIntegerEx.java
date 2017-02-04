package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReadFromIntegerEx {

	public static void main(String[] args) {

		System.out.println("Read an int from a user: ");
		int num = ReadIntegerFromUser();
		System.out.println("You entered: " + num );
	}
	
	public static int ReadIntegerFromUser( )
	{

		int intValue = 0;

		try
		{
			String strBuffer = "";	

			// Input stream
			BufferedReader burInput = 
					new BufferedReader( new InputStreamReader( System.in ) ) ;

			// Read a line from the user
			strBuffer = burInput.readLine( );
			
			// Convert from string to integer
			intValue = Integer.parseInt( strBuffer );
		}
		catch( Exception expError )
		{
			System.out.println( expError.toString( ) );
		}
		

		// Return integer value
		return intValue;
	}

}
