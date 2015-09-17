package application;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class CardType {
	private Set<String> attrs;
	
	public CardType() {
		this.attrs = new HashSet<String>();
	}
	
	public void addAttribute(String newAttr) {
		this.attrs.add(Stuff.capitalize(newAttr));
	}
	
	public boolean contains(String key) {
		key = Stuff.capitalize(key);
		return this.attrs.contains(key);
	}
	
	public void printKeys() {
		Iterator<String> iter = this.attrs.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	public Iterator<String> iterator() {
		return this.attrs.iterator();
	}
	
	
	public boolean equals(CardType other) {
		
		return (this.attrs.equals(other.attrs));
	}
}