package cards;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import utils.Util;

public class Card extends AbstractCard {
	
	protected Hashtable<String, Integer> attrs;

	public Card(String name, CardType ctype) {
		super(name, ctype);
		this.attrs = new Hashtable<String, Integer>();
		init();
	}

	@Override
	public Object clone() {
		Card newCard = new Card(name, ctype);
		newCard.attrs = new Hashtable<String, Integer> (this.attrs);
		return newCard;
	}
	
	protected void init() {
		Iterator<String> iter = this.ctype.iterator();
		while(iter.hasNext()) {
			this.attrs.put(iter.next(), empty);
		}
	}
	
	public void printAttributes() {
		System.out.println("["+this.getName()+"]");
		Set<String> keys = this.attrs.keySet();
		for(String key: keys) {
			System.out.println(key+": "+this.getAttribute(key));
		}
		System.out.println();
	}
	
	public String getAttributes() {
		String buff = "";
		buff += "["+this.getName()+"]";
		Set<String> keys = this.attrs.keySet();
		for(String key: keys) {
			buff += "\n" + key + ": " + this.getAttribute(key);
		}
		
		return buff;
	}
	
	public Integer getAttribute(String name) {
		
		return attrs.get(Util.capitalize(name));
	}
	
	public void addAttribute(String key, Integer value) throws RuntimeException {
		key = Util.capitalize(key);
		if (this.ctype.contains(key)) {
			this.attrs.put(key, value);
		} else {
			throw new RuntimeException("Adding an attribute that is not supported by CardType.");
		}
	}
	
}
