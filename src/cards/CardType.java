package cards;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import utils.Util;


public class CardType {
	private Set<String> attrs;
	private String name = "blank";
	
	/**
	 * CardType constructor.
	 */
	@Deprecated
	public CardType() {
		this.attrs = new HashSet<String>();
	}
	
	/**
	 * CardType constructor.
	 * @param name of the deck.
	 */
	public CardType(String name) {
		this.attrs = new HashSet<String>();
		this.name = name;
	}
	
	/**
	 * Adds a new attribute to the type.
	 * @param newAttr Attribute name
	 */
	public void addAttribute(String newAttr) {
		this.attrs.add(Util.capitalize(newAttr));
	}
	
	/**
	 * Checks if an attribute is already on the type.
	 * @param key Attribute to check
	 * @return True if it already exists.
	 */
	public boolean contains(String key) {
		key = Util.capitalize(key);
		return this.attrs.contains(key);
	}
	
	/**
	 * Prints attributes names.
	 */
	public void printKeys() {
		Iterator<String> iter = this.attrs.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	/**
	 * Returns an iterator for the attributes.
	 * @return An Iterator of Strings.
	 */
	public Iterator<String> iterator() {
		return this.attrs.iterator();
	}
	
	/**
	 * HashCode.
	 * @see java.lang.Object#hashCode()
	 */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + this.attrs.hashCode();
        return result;
    }
	
	/**
	 * Checks whether 2 card types are equal.
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final CardType other = (CardType) obj;
		if (!this.attrs.equals(other.attrs)) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Gets the amount of attributes.
	 * @return int with quantity.
	 */
	public int size() {
		
		return attrs.size();
	}
	
	/**
	 * Checks if the attribute list is empty.
	 * @return True if it is, False otherwise.
	 */
	public boolean isEmpty() {
		
		return attrs.isEmpty();
	}
	
	/**
	 * Converts the set of attributes to an Array.
	 * @return an Array of attributes.
	 */
	public Object[] toArray() {
		
		return attrs.toArray();
	}
	
	/**
	 * Get attributes.
	 * @return Set of attributes.
	 */
	public Set<String> getAttrs() {
		
		return this.attrs;
	}
	
	/**
	 * Returns deck name and the quantity of the cards in it.
	 * @see java.lang.Object#toString()
	 * 
	 */
	public String toString() {
		
		return this.name;
	}
}