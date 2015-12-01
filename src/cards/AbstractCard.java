package cards;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import utils.Stuff;

public abstract class AbstractCard {
	
	protected String name;
	private String imagePath;
	protected CardType ctype;
	private static final Integer empty = 0;
	protected Hashtable<String, Integer> attrs;
	
	public AbstractCard(String name, CardType ctype) {
		this.ctype = ctype;
		this.name = name;
		this.attrs = new Hashtable<String, Integer>();
	
		init();

	}

	protected void init() {
		Iterator<String> iter = this.ctype.iterator();
		while(iter.hasNext()) {
			this.attrs.put(iter.next(), empty);
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
		
		return attrs.get(Stuff.capitalize(name));
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
	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + this.name.hashCode();
        return result;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final AbstractCard other = (AbstractCard) obj;
		if (!this.ctype.equals(other.getCtype()))
			return false;
		if (!this.name.equals(other.name))
			return false;
		
		Iterator<String> it = this.getCtype().iterator();
		String key = "";
		while (it.hasNext()) {
			key = it.next();
			if (!this.getAttribute(key).equals(other.getAttribute(key)))
				return false;
		}
		
		return true;
    }
    
    @Override
    public String toString() {
    	return this.name;
    }
    
    public abstract Object clone();
    
}

