package week8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class BufferedReadFromKeyboard {

	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Type something =>");
		String line = reader.readLine();
		
		// this can throw exceptions.
		reader.close();
		
		System.out.println("\nWhat you typed: ");
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// this can throw exceptions
		writer.write(line);
		writer.flush();
		writer.close();
		
		System.out.println("\nNow, I will print this again with a print writer:");
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		pw.write(line);
		pw.flush();
		// with print writer you have to manually check
		if(pw.checkError()) {
			System.out.println("Wow some error occured!");
		}
	}

}
