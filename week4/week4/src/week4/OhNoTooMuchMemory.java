import java.text.NumberFormat;

public class OhNoTooMuchMemory {

	public static void main(String[] args) {
		
		long millis = System.currentTimeMillis();
		int [] notManyInts = new int [256]; // 2^8
		System.out.println("How long 1: " + (System.currentTimeMillis() - millis));
		printMemoryUsage();
		
		long millis2 = System.currentTimeMillis();
		int [] soManyInts2 = new int [16777216]; // 2^24
		System.out.println("How long 2: " + (System.currentTimeMillis() - millis2));
		printMemoryUsage();
		
		
		// what is heap space? WHy did I run out? with 2^30 How many bytes does an int take up?
		// what is default heap space?
		long millis3 = System.currentTimeMillis();
		int [] soManyInts3 = new int [268435456]; //  2^28 = 268435456  .... 2^30 = 1073741824   
		System.out.println("How long 3: " + (System.currentTimeMillis() - millis3));
		printMemoryUsage();
		
		// java -XX:+PrintFlagsFinal -version | findstr HeapSize
		// how to get more?
		// what is the default?
		// -Xmx1g
		// -Xmx4g
	}
	
	public static void printMemoryUsage() {
		Runtime runtime = Runtime.getRuntime();

		NumberFormat format = NumberFormat.getInstance();

		StringBuilder sb = new StringBuilder();
		long maxMemory = runtime.maxMemory();
		long allocatedMemory = runtime.totalMemory();
		long freeMemory = runtime.freeMemory();

		sb.append("free memory: " + format.format(freeMemory / 1024) + "|");
		sb.append("allocated memory: " + format.format(allocatedMemory / 1024) + "|");
		sb.append("max memory: " + format.format(maxMemory / 1024) + "|");
		sb.append("total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024) + "|");
		
		System.out.println(sb.toString());
	}

}
