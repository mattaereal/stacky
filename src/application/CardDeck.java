package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CardDeck {
	
	private List<AbstractCard> deck;
	private CardType ctype;

	public CardDeck(CardType type) {
		this.deck = new ArrayList<AbstractCard>();
		this.ctype = type;
	}

	public void addCard(AbstractCard card) throws RuntimeException {
		if (card.getCtype().equals(this.ctype)) {
			this.deck.add(card);
		} else {
			throw new RuntimeException("Adding a card to deck with different CardType.");
		}
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
	
	public boolean equals(CardDeck other) {
		if (other == null) return false;
	    if (other == this) return true;
	    if (!other.ctype.equals(this.ctype)) return false;
	    if (other.getDeck().size() != this.getDeck().size()) return false;
	    
	    Collections.sort(deck, new CardComparator());
	    Collections.sort(other.getDeck(), new CardComparator());
	    Iterator<AbstractCard> it = this.getDeck().iterator();
	    Iterator<AbstractCard> it2 = other.getDeck().iterator();
	    
	    AbstractCard f, g;
	    while (it.hasNext()) {
	    	f = it.next();
	    	g = it2.next();
	    	f.printAttributes();
	    	g.printAttributes();
	    	if (!f.equals(g)) {
	    		
	    		return false;
	    	}
	    }
	    
		return true;
	}
	
	

}
