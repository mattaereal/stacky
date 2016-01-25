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
	
	/**
	 * Abstract card constructor.
	 * @param name Name of the card.
	 * @param ctype CardType of the card.
	 */
	public AbstractCard(String name, CardType ctype) {
		this.ctype = ctype;
		this.name = name;
		this.id = UUID.randomUUID();
	}

	/**
	 * Returns the identification of the card.
	 * @return An UUID.
	 */
	public UUID getID() {
		
		return this.id;
	}
	
	/**
	 * Sets a new identification for the card.
	 * @param id UUId to be set.
	 */
	public void setNewUUID(UUID id) {
		this.id = id;
	}
	
	/**
	 * Gets card's name.
	 * @return Card name.
	 */
	public String getName() {
		
		return name;
	}
	
	/**
	 * Gets an image for the card.
	 * (Currently not in use).
	 * @return Image path.
	 */
	public String getImagePath() {
		
		return imagePath;
	}
	
	/**
	 * Sets an image for the card.
	 * @param path of the image.
	 */
	public void setImagePath(String path) {
		
		this.imagePath = path;
	}

	/**
	 * Gets the type of the card.
	 * @return CardType.
	 */
	public CardType getCtype() {
		
		return ctype;
	}
	
	/**
	 * Gets the value of an attribute.
	 * @param name Name of the attribute.
	 * @return Attribute's value.
	 */
	public abstract Integer getAttribute(String name);
	
	/**
	 * Displays all the attributes and their
	 * values via stdout.
	 */
	public abstract void printAttributes();
	
	/**
	 * Gets all attributes concatenated in a String.
	 * @return Concatenated string
	 */
	public abstract String getAttributes();
	
	/**
	 * HashCode.
	 * @see java.lang.Object#hashCode()
	 */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + this.name.hashCode();
        return result;
    }
    
	/**
	 * Checks whether two AbstractCards are equal.
	 * @see java.lang.Object#equals()
	 */
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
    
	/**
	 * String representation of the object.
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString() {
    	return this.name;
    }
    
	/**
	 * Clones the object.
	 * @see java.lang.Object#clone()
	 */
    public abstract Object clone();
    
}

