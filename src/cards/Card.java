package cards;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import utils.Util;

public class Card extends AbstractCard {
	
	protected Hashtable<String, Integer> attrs;

	/**
	 * Card constructor.
	 * @param name Name of the card.
	 * @param ctype CardType of the card.
	 */
	public Card(String name, CardType ctype) {
		super(name, ctype);
		this.attrs = new Hashtable<String, Integer>();
		init();
	}

	/**
	 * Clones the object.
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() {
		Card newCard = new Card(name, ctype);
		newCard.attrs = new Hashtable<String, Integer> (this.attrs);
		return newCard;
	}
	
	/**
	 * Setups the attributes of the card bases on its type.
	 */
	protected void init() {
		Iterator<String> iter = this.ctype.iterator();
		while(iter.hasNext()) {
			this.attrs.put(iter.next(), empty);
		}
	}
	
	/**
	 * Displays all the attributes and their
	 * values via stdout.
	 */
	public void printAttributes() {
		System.out.println("["+this.getName()+"]");
		Set<String> keys = this.attrs.keySet();
		for(String key: keys) {
			System.out.println(key+": "+this.getAttribute(key));
		}
		System.out.println();
	}
	
	/**
	 * Gets all attributes concatenated in a String.
	 * @return Attributes.
	 */
	public String getAttributes() {
		String buff = "";
		buff += "["+this.getName()+"]";
		Set<String> keys = this.attrs.keySet();
		for(String key: keys) {
			buff += "\n" + key + ": " + this.getAttribute(key);
		}
		
		return buff;
	}
	
	/**
	 * Gets the value of an attribute.
	 * @param name Name of the attribute.
	 * @return Attribute's value.
	 */
	@Override
	public Integer getAttribute(String name) {
		
		return attrs.get(Util.capitalize(name));
	}
	
	/**
	 * Adds an attribute value to the card.
	 * @param key Attribute to be added.
	 * @param value Value to be set.
	 * @throws RuntimeException
	 */
	public void addAttribute(String key, Integer value) throws RuntimeException {
		key = Util.capitalize(key);
		if (this.ctype.contains(key)) {
			this.attrs.put(key, value);
		} else {
			throw new RuntimeException("Adding an attribute that is not supported by CardType.");
		}
	}
	
}
