import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * BookIndexer class builds and displays 
 * the index of notes.
 * Note that this class is not generic.
 */
public class BookIndexer {
	/**
	 * TODO: declare a field. This field 
	 * is an object of a Java built-in class. 
	 * It maps heading/sub-heading pairs 
	 * to page numbers. 
	 * Note that heading and sub-heading 
	 * are Strings. Page numbers are 
	 * Integers. 
	 */
	TreeMap<HeadSubhead<String, String>, TreeSet<Integer>> map;

	
	/**
	 * TODO: complete the zero-parameter constructor 
	 * that initializes the field described above.
	 */
	public BookIndexer( ) {
		map = new TreeMap<HeadSubhead<String, String>, TreeSet<Integer>>(); //Page (values), heading (keys)
	}
	
	/**
	 * TODO: complete a method that reads through notes
	 * and builds an index.
	 * @param sc a Scanner object for reading from a file 
	 * containing notes.
	 */
	public void compileIndex( Scanner sc ) {
	  /* hs stores a heading and sub-heading pair.
	   * For every line of file with the correct structure, 
	   * create a new object of the HeadSubhead class.
	   * Note that for a note that does not contain a
	   * sub-heading, the sub-heading is an empty string "".    
	   * */
	  HeadSubhead<String, String> hs;
	  
	  while (sc.hasNextLine()) {
		  	
		  String wholeStr = sc.nextLine();
		  
		    if (wholeStr.equals("")) {
		    	continue; // Skips empty line.
		    }
		    
			
			if (!wholeStr.contains(":")) {
				System.err.println("A line does not have a colon :.");
				continue;
			} // Checks if the line contains :, if not, print out the error and continue reading.
			
			String[] strArr = wholeStr.split(":", 2); // Splits the line before and after the :.
			int pageNO = Integer.valueOf(strArr[0]); // Converts the string type to integer.
			
			
			if (!Character.isWhitespace(strArr[1].charAt(0)) || strArr[1].matches("  (.*)")) {
				System.err.println("There is no space after colon or there are more than one space after colon.");
				continue;
			}
			
			if (!Character.isUpperCase(strArr[1].charAt(1))) {
				System.err.println("The heading does not start with an uppercase letter.");
				continue;
			}
			
			StringBuilder sb = new StringBuilder(strArr[1]);
			sb = sb.deleteCharAt(0);
			String newHSH = sb.toString();
			String newHead;
			String newSubHead;
			
			if (!strArr[1].contains("/")) {
				newHead = newHSH;
				newSubHead = "";
			}
			else {
				String[] strArr2 = newHSH.split("/", 2);
				
				if (!Character.isLowerCase(strArr2[1].charAt(0))) {
				System.err.println("The sub-heading does not start with a lowercase letter.");
				continue;
				}
				newHead = strArr2[0];
				newSubHead = strArr2[1];
			}
			hs = new HeadSubhead<String, String>(newHead, newSubHead); //Assign the Head and Subhead.
			
			if (!map.containsKey(hs)) {
				TreeSet<Integer> ts = new TreeSet<Integer>();
				ts.add(pageNO);
				map.put(hs, ts);
			}
			else {
				TreeSet<Integer> ts = map.get(hs);
				ts.add(pageNO);
		}
	}
}
	
	/**
	 * TODO: complete a method that displays an index
	 * to the standard output as shown in the description
	 * of the assignment.
	 */	
	public void displayCompiledIndex() {
		
		TreeSet<HeadSubhead<String,String>> ts2 = new TreeSet<HeadSubhead<String,String>>();
		TreeSet<String> ts3 = new TreeSet<String>();
		
		for(Entry<HeadSubhead<String, String>, TreeSet<Integer>>  entry : map.entrySet()) {
			ts2.add(entry.getKey());
		} // ts2 contains the HeadSubHead
		
		for(Entry<HeadSubhead<String, String>, TreeSet<Integer>>  entry : map.entrySet()) {
			ts3.add(entry.getKey().getHead());
		} // ts3 contains the Head

		
		while (!ts2.isEmpty()) {
			
			if (ts3.size()>=1 && ts2.first().getHead().equals(ts3.first()) && ts2.first().getSubHead().equals("")) {
				System.out.print(ts3.first());
				ts3.remove(ts3.first());
			} // Stays in line to insert pageNO
			
			else if (ts3.size()>=1 && ts2.first().getHead().equals(ts3.first()) && !ts2.first().getSubHead().equals("")) {
				System.out.println(ts3.first());
				ts3.remove(ts3.first());
			} // Skips line
			
			if(!ts2.first().getSubHead().equals("")) {
				System.out.print("    " + ts2.first().getSubHead());
			}
				
				
			TreeSet<Integer> page = map.get(ts2.first());
			Iterator<Integer> itr = page.iterator();
			while(itr.hasNext()) {
				System.out.print(", " + itr.next());
			}
			ts2.remove(ts2.first());
			System.out.println();
		}
		
	}
}

				
