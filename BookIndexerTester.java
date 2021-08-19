import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class BookIndexerTester {
	
    /**
     * TODO: complete the main method for building
     * and displaying an index.

     * 1. Create an object of the BookIndexer class.
     * 2. Call the compileIndex method. Pass to this
     * method a Scanner object for reading notes from 
     * a file.
     * 3. Call the displayCompiledIndex method to 
     * display an index to the standard output. 
     */
	public static void main(String[] args) {
		
		BookIndexer bi = new BookIndexer();
		
		Scanner sc = null;
		try {
			 sc = new Scanner(new FileReader(args[0]));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		bi.compileIndex(sc);
		
		bi.displayCompiledIndex();	
		
	}

}
