package cards;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import utils.Util;

public class CompositeCard extends AbstractCard {
	private List<AbstractCard> cards;

	/**
	 * CompositeCard constructor.
	 * @param name Name of the card.
	 * @param ctype CardType of the card.
	 */
	public CompositeCard(String name, CardType ctype) {
		super(name, ctype);
		cards = new ArrayList<AbstractCard>();
	}

	/**
	 * Gets all the Cards in the composite.
	 * @return List of AbstractCards.
	 */
	public List<AbstractCard> getCards() {
		
		return cards;
	}
	
	/**
	 * Gets the value of an attribute.
	 * @param name Name of the attribute.
	 * @return Attribute's value.
	 */
	@Override
	public Integer getAttribute(String name) {
		int sum = 0;
		name = utils.Util.capitalize(name);
		if (!this.ctype.contains(name))
			return null;
		int q = this.cards.size();
		if (q == 0)
			return new Integer(0);

		Iterator<AbstractCard> it = this.cards.iterator();
		while (it.hasNext()) {
			sum += it.next().getAttribute(name);
		 }
		
		return (new Integer(sum / q));
	}
	
	/**
	 * Adds an AbstractCard to the composite.
	 * @param card AbstractCard to be added.
	 * @throws RuntimeException
	 */
	public void addCard(AbstractCard card) throws RuntimeException {
		if (card.getCtype().equals(this.getCtype())) {
			this.cards.add(card);
		} else {
			throw new RuntimeException("Adding a card that has a different CardType.");
		}
	}
	
	/**
	 * Deletes an AbstractCard from the composite.
	 * @param name Name of the card to be deleted.
	 */
	public void delCard(String name) {
		/* Deletes the first occurrence */
		name = Util.capitalize(name);
		AbstractCard curr;
		Iterator<AbstractCard> it = this.cards.iterator();
		while (it.hasNext()) {
			curr = it.next();			
			if (name.equals(Util.capitalize(curr.getName()))) {
				delCard(curr);
				return;
			}
		 }
	}
	
	/**
	 * Deletes an AbstractCard from the composite.
	 * @param card AbstractCard of the card to be deleted.
	 */
	public void delCard(AbstractCard card) {
		this.cards.remove(card);
	}

	/**
	 * Clones the object.
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() {
		CompositeCard newCard = new CompositeCard(name, ctype);
		newCard.cards = new ArrayList<AbstractCard> (this.cards);
		return newCard;
	}

	/**
	 * Displays all the attributes and their
	 * values via stdout.
	 */
	@Override
	public void printAttributes() {
		System.out.println("["+this.getName()+"]");
		for(String key: this.ctype.getAttrs()) {
			System.out.println(key+": "+this.getAttribute(key));
		}
		System.out.println();
	}
	
	/**
	 * Gets all attributes concatenated in a String.
	 * @return Attributes.
	 */
	@Override
	public String getAttributes() {
		String buff = "["+this.getName()+"]";
		for(String key: this.ctype.getAttrs()) {
			buff += "\n" + key + ": " + this.getAttribute(key);
		}
		
		return buff;
	}
}
