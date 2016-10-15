package week8;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StreamToArray {

	public static void main(String[] args) throws Exception {

		//InputStream is = System.in;
		System.out.println("Write a char: =>");
		InputStreamReader isr = new InputStreamReader(System.in);

		// create a buffer to read data into,
		char [] arr = new char [1000];

		// listen for input (program now blocks execution)
		isr.read(arr);

		// convert to array
		String myInput = new String(arr);

		// convert to uppercase
		myInput = myInput.toUpperCase();

		// write to std out
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		osw.write(myInput);
		osw.flush();

		// write to std error
		OutputStreamWriter oswerr = new OutputStreamWriter(System.err);
		oswerr.write(myInput);
		oswerr.flush();

		System.out.println("Program done.");
	}

}
