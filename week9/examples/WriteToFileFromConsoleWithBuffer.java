package week9;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteToFileFromConsoleWithBuffer {

	public static void main(String[] args) throws Exception {

		// remember from last week we could do it like this:
		// 		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// and this would manage the buffer for us.
		// we could call reader.readLine()
		// but we will do it manually.
		
		BufferedInputStream bis = new BufferedInputStream(System.in);
		
		// leave room for 100 chars.
		byte [] bytes = new byte [Character.BYTES * 100];
		
		// read into the buffer.
		System.out.println("Type something => ");
		bis.read(bytes);
		
		// the buffer now has data.
		String input = new String(bytes);
		System.out.println("You typed this: "+ input);
		
		Path file = Paths.get(System.getProperty("user.dir")).resolve("what-you-just-typed.txt");

		BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(file, 
				StandardOpenOption.CREATE,
				StandardOpenOption.APPEND));
		bos.write(bytes);
		bos.flush();
		bos.close();
		
		System.out.println("File written");
		
	}

}
