package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import utils.Stuff;

public class CardDeck {
	
	private List<AbstractCard> deck;
	private CardType ctype;
	private String name;

	public CardDeck(String name, CardType type) {
		this.deck = new ArrayList<AbstractCard>();
		this.setName(name);
		this.ctype = type;
	}

	public void addCard(AbstractCard card) throws RuntimeException {
		if (card.getCtype().equals(this.ctype)) {
			this.deck.add(card);
		} else {
			throw new RuntimeException("Adding a card to deck with different CardType.");
		}
	}
	
	public void delCard(String name) {
		/* Deletes the first occurrence */
		name = Stuff.capitalize(name);
		AbstractCard curr;
		Iterator<AbstractCard> it = this.deck.iterator();
		while (it.hasNext()) {
			curr = it.next();
			if (name.equals(Stuff.capitalize(curr.getName()))) {
				this.delCard(curr);
				return;
			}
		 }
	}
	
	public void delCard(AbstractCard card) {
		this.deck.remove(card);
	}
	
	@Override
	public String toString() {
		String buff = "";
		Iterator<AbstractCard> it = deck.iterator();
		while (it.hasNext()) {
			buff += it.next().getName() + "\n";
		}
		
		return buff;
	}
	
	public List<AbstractCard> getDeck() {
		
		return this.deck;
	}
	
	public boolean exists(AbstractCard card) {
		Iterator<AbstractCard> it = this.deck.iterator();
		while (it.hasNext()) {
			if (it.next().equals(card)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean exists(String name) {
		name = Stuff.capitalize(name);
		Iterator<AbstractCard> it = this.deck.iterator();
		while (it.hasNext()) {
			if (it.next().getName().equals(name)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final CardDeck other = (CardDeck) obj;
		if (!this.ctype.equals(other.ctype))
			return false;
		if (!this.name.equals(other.name))
			return false;
	    if (other.getDeck().size() != this.getDeck().size())
	    	return false;
	    
	    Collections.sort(deck, new CardComparator());
	    Collections.sort(other.getDeck(), new CardComparator());
	    Iterator<AbstractCard> it = this.getDeck().iterator();
	    Iterator<AbstractCard> it2 = other.getDeck().iterator();
	    
	    AbstractCard f, g;
	    while (it.hasNext()) {
	    	f = it.next();
	    	g = it2.next();
	    	if (!f.equals(g)) {
	    		
	    		return false;
	    	}
	    }
	    
		return true;
	}
	
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + this.name.hashCode();
        return result;
    }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	

}
