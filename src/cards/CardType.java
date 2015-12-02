package cards;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import utils.Util;


public class CardType {
	private Set<String> attrs;
	
	public CardType() {
		this.attrs = new HashSet<String>();
	}
	
	public void addAttribute(String newAttr) {
		this.attrs.add(Util.capitalize(newAttr));
	}
	
	public boolean contains(String key) {
		key = Util.capitalize(key);
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
	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + this.attrs.hashCode();
        return result;
    }
	
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
	
	public int size() {
		
		return attrs.size();
	}
	
	public boolean isEmpty() {
		
		return attrs.isEmpty();
	}
	
	public Object[] toArray() {
		
		return attrs.toArray();
	}
	
	public Set<String> getAttrs() {
		
		return this.attrs;
	}

}