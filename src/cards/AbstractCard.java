package cards;

import java.util.Iterator;
import java.util.UUID;

import utils.Util;

public abstract class AbstractCard {
	
	protected String name;
	private String imagePath;
	protected CardType ctype;
	protected static final Integer empty = 0;
	private UUID id;
	
	public AbstractCard(String name, CardType ctype) {
		this.ctype = ctype;
		this.name = name;
		this.id = UUID.randomUUID();
	}

	
	public UUID getID() {
		
		return this.id;
	}
	
	public String getName() {
		
		return name;
	}
	
	public String getImagePath() {
		
		return imagePath;
	}
	
	public void setImagePath(String path) {
		
		this.imagePath = path;
	}

	public CardType getCtype() {
		
		return ctype;
	}
	
	public abstract Integer getAttribute(String name);
		
	public abstract void printAttributes();
	
	public abstract String getAttributes();
	
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
		if (!Util.capitalize(this.name).equals(Util.capitalize(other.name)))
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

