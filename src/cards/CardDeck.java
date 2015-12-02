package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import game.Player;
import utils.Util;

public class CardDeck {
	
	private List<AbstractCard> deck;
	private CardType ctype;
	private String name;

	/**
	 * Constructor of a card deck. It represents
	 * a collection of certain type of cards.
	 * 
	 * @param name Name of card collection.
	 * @param type Sets the type of the card set.
	 */
	public CardDeck(String name, CardType type) {
		this.deck = new ArrayList<AbstractCard>();
		this.setName(name);
		this.ctype = type;
	}
	
	/**
	 * Constructor of a card deck. It represents
	 * a collection of certain type of cards.
	 * 
	 * @param name Name of card collection.
	 * @param type Sets the type of the card set.
	 * @param tmp A card deck that is being set by a list
	 * of abstract cards.
	 */
	protected CardDeck(String name, CardType ctype2, ArrayList<AbstractCard> tmp) {
		this.deck = tmp;
		this.setName(name);
		this.ctype = ctype2;
	}

	/**
	 * Adds an AbstractCard to the collection.
	 * @param card The card to be added to the set.
	 * @throws RuntimeException
	 */
	public void addCard(AbstractCard card) throws RuntimeException {
		if (card.getCtype().equals(this.ctype)) {
			this.deck.add(card);
		} else {
			throw new RuntimeException("Adding a card to deck with a different CardType.");
		}
	}
	
	/**
	 * Deletes the first occurrence of a card by its name
	 * from the current deck.
	 * @param name The name of the card to be removed.
	 */
	public void delCard(String name) {
		/* Deletes the first occurrence */
		name = Util.capitalize(name);
		AbstractCard curr;
		Iterator<AbstractCard> it = this.deck.iterator();
		while (it.hasNext()) {
			curr = it.next();
			if (name.equals(Util.capitalize(curr.getName()))) {
				this.delCard(curr);
				return;
			}
		 }
	}
	
	/**
	 * Deletes a card from the deck.
	 * @param card The AbstractCard to be deleted.
	 */
	public void delCard(AbstractCard card) {
		this.deck.remove(card);
	}

	/**
	 * Returns a concatenation of the names of every
	 * card inside the deck.
	 * @see java.lang.Object#toString()
	 * 
	 */
	public String toString() {
		String buff = "";
		Iterator<AbstractCard> it = deck.iterator();
		while (it.hasNext()) {
			buff += it.next().getName() + "\n";
		}
		
		return buff;
	}
	
	/**
	 * Gets current deck.
	 * @return List of Abstract Cards
	 */
	public List<AbstractCard> getDeck() {
		
		return this.deck;
	}
	
	/**
	 * Checks whether a specific card exists or not.
	 * @param card Card to be checked its existence.
	 * @return True if exists, False otherwise.
	 */
	public boolean exists(AbstractCard card) {
		Iterator<AbstractCard> it = this.deck.iterator();
		while (it.hasNext()) {
			if (it.next().equals(card)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Checks whether a specific card exists or not
	 * by its name.
	 * @param name NAme of the card to be checked its existence.
	 * @return True if exists, False otherwise.
	 */
	public boolean exists(String name) {
		name = Util.capitalize(name);
		Iterator<AbstractCard> it = this.deck.iterator();
		while (it.hasNext()) {
			if (Util.capitalize(it.next().getName()).equals(name)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Equals.
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
		if (!Util.capitalize(this.name).equals(Util.capitalize(other.name)))
			return false;
	    if (other.deck.size() != this.deck.size())
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
	
	/**
	 * HashCode.
	 * @see java.lang.Object#hashCode()
	 */
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
	 * Sets the name of the deck.
	 * @param name The name to be set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 *  Shuffles the content of the deck.
	 */
	public void shuffle() {
		long seed = System.nanoTime();
		Collections.shuffle(deck, new Random(seed));
	}

	/**
	 * Returns the CardType of the deck.
	 * @return CardType
	 */
	public CardType getType() {
		
		return this.ctype;
	}
	
	
	/**
	 * Similar to a pop in a stack structure.
	 * Returns the first abstract card of the pile.
	 * 
	 * @return AbstractCard
	 */
	public AbstractCard pop() {
		return this.deck.remove(0);
	}
	
	/**
	 * Returns a boolean whether the deck
	 * has any cards on it or not.
	 * @return True if still has cards, False otherwise.
	 */
	public boolean isEmpty() {
		return this.deck.isEmpty();
	}
	
	/**
	 * Splits a deck in half between two players.
	 * It actually makes a copy of it and splits it.
	 * @param p1 Player one.
	 * @param p2 Player two.
	 */
	public void split(Player p1, Player p2) {
		ArrayList<AbstractCard> tmp;
		
		tmp = new ArrayList<AbstractCard>(deck.subList(0, deck.size()/2));
		p1.setDeck(new CardDeck(p1.getName() + ": " + this.name, this.ctype, tmp));
		
		tmp = new ArrayList<AbstractCard>(deck.subList(deck.size()/2, deck.size()));
		p2.setDeck(new CardDeck(p2.getName() + ": " + this.name, this.ctype, tmp));
		
	}
	
	/**
	 * Adds a list of AbstractCards to the deck
	 * @param list ArrayList<AbstractCard> to be added.
	 */
	public void addCards(List<AbstractCard> list) {
		this.deck.addAll(list);
	}
	
	/**
	 * Clears the card collection.
	 */
	public void clear() {
		this.deck.clear();
	}
	
	public Object clone() {
		return new CardDeck(name, ctype, cloneList());
	}
	
	private ArrayList<AbstractCard> cloneList() {
	    ArrayList<AbstractCard> clone = new ArrayList<AbstractCard>(deck.size());
	    for(AbstractCard card: deck) 
	    	clone.add((AbstractCard) card.clone());
	    return clone;
	}
}
