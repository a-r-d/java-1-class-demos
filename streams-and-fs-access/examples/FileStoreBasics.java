package week8;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class FileStoreBasics {

	public static void main(String[] args) throws Exception {

		/**
		 * 
		 * A FileSystem object encapsulates the fi le storage system on your computer. What this
			storage system consists of and how it is organized depends on the operating system you are using.
		 */
		FileSystem fileSystem = FileSystems.getDefault();
		Iterable<FileStore> stores = fileSystem.getFileStores();
		
		for(FileStore store : stores) {
			System.out.println(store.name() + ": " + store.type());
			System.out.println("    -> free space: " + freeSpaceFormatted(store));
		}
		
	}
	
	public static String freeSpaceFormatted(FileStore store) throws Exception {
		long mb = store.getUsableSpace() / (1000*1000); // 10^6 converts to megabytes.
		return mb + " mb";
	}

}
