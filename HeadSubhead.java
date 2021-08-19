/**
 * HeadSubhead is a generic class that represents the 
 * heading and sub-heading of a book index.
 * Any two objects of this class need to be Comparable.
 * To compare two objects of this class, HeadType and 
 * SubheadType need to be Comparable.
 */
public class HeadSubhead<HeadType extends Comparable<HeadType>, SubheadType extends Comparable<SubheadType>> implements Comparable<HeadSubhead<HeadType, SubheadType>> {

	/**
	 * TODO: declare generic fields
	 */
	private HeadType head;
	private SubheadType subhead;
	
	
       /**
	* TODO: define a two-parameter constructor 
	* that initializes heading and sub-heading.
	*/ 
	HeadSubhead(HeadType h1, SubheadType h2){
		head = h1;
		subhead = h2;
	}

	/**
	 * TODO: complete a method that returns
	 * the heading.
	 * @return heading
	 */
     
     public HeadType getHead( ) {    	 
    	 return this.head;
     }
	
	/**
	 * TODO: complete a method that returns
	 * the sub-heading.
	 * @return sub-heading
	 */
     public SubheadType getSubHead( ) {    	 
    	 return this.subhead;
     }     
     
	
	/**
	 * TODO: define a method that compares two 
	 * objects of the HeadSubhead class.
	 * This method overrides the compareTo method
	 * of Comparable interface.
	 * @param an instance of the HeadSubhead class
	 * @return an integer that indicates if 
	 * this object is smaller, larger, or equal to 
	 * the object passed as a parameter to this method.  
	 */
     public int compareTo(HeadSubhead<HeadType,SubheadType> hs) {
    	 if (this.getHead().compareTo(hs.getHead()) == 0) {
    		 return this.getSubHead().compareTo(hs.getSubHead());
    	 }
    	 return this.getHead().compareTo(hs.getHead());
     }
}
