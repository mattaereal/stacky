package application;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public abstract class AbstractCard {
	
	private String name;
	private String imagePath;
	private CardType ctype;
	protected Hashtable<String, Integer> attrs;
	
	public AbstractCard(String name, CardType ctype) {
		this.ctype = ctype;
		this.name = name;
		this.attrs = new Hashtable<String, Integer>();
		
		Iterator<String> iter = this.ctype.iterator();
		while(iter.hasNext()) {
			this.attrs.put(iter.next(), 0);
		}
	}

	public String getName() {
		
		return name;
	}
	
	public String getImagePath() {
		
		return imagePath;
	}

	public CardType getCtype() {
		
		return ctype;
	}
	
	public Integer getAttribute(String name) {
		
		return attrs.get(name);
	}
	
	public void addAttribute(String key, Integer value) {
		key = Stuff.capitalize(key);
		if (this.ctype.contains(key)) {
			this.attrs.put(key, value);
		} else {
			//Print error key?
			System.out.println("Adding an attribute that is not supported by CardType.");
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
	
	public boolean equals(AbstractCard other) {
		if (this.ctype.equals(other.getCtype())) {
			Iterator<String> it = this.getCtype().iterator();
			String key = "";
			while (it.hasNext()) {
				key = it.next();
				if (!this.getAttribute(key).equals(other.getAttribute(key))) {
					
					return false;
				}
			}

			return true;
		}
		
		return false;
	}


}
