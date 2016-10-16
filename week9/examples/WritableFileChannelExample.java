package week9;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.EnumSet;

public class WritableFileChannelExample {

	public static void main(String[] args) {

		Path file = Paths.get(System.getProperty("user.dir")).resolve("randomnums.txt");

		System.out.println("Will write file to: " + file);
		
		// this is just like an array that you don't need to size
		java.util.List<String> numbers = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			// casting to string from int, casting to int from double!
			numbers.add("" + (int)Math.floor((Math.random() * 1000*1000) + 1000*1000));
		}

		// temporary buffer, for each iteration.
		ByteBuffer buf = null;
		try {
			
			/***
			 * Why use a fileChannel over other methods?
			 * 
			 * https://dzone.com/articles/java-nio-vs-io
			 * 
			 * NIO vs IO
			 * 
			 * NIO uses buffers
			 * IO uses streams
			 * 
			 * Read about the differences, however you may not understand them until you understand what a "Thread" is.
			 * 
			 * 
			 * FileChannels are NIO.
			 * 
			 * InputStream / OutputStream ar IO.
			 * 
			 * 
			 * Streams are byte by byte, buffers work in blocks of bytes.
			 * 
			 * 
			 */
			// the file channel 
			WritableByteChannel channel =
					Files.newByteChannel(file, EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE));

			for (String num : numbers) {
				buf = ByteBuffer.wrap((num + "\n").getBytes());
				channel.write(buf);
			}
			System.out.println("File written.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
