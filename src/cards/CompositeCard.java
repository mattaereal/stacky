package cards;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import utils.Util;

public class CompositeCard extends AbstractCard {
	private List<AbstractCard> cards;

	public CompositeCard(String name, CardType ctype) {
		super(name, ctype);
		cards = new ArrayList<AbstractCard>();
	}

	public List<AbstractCard> getCards() {
		
		return cards;
	}
	
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
	
	public void addCard(AbstractCard card) throws RuntimeException {
		if (card.getCtype().equals(this.getCtype())) {
			this.cards.add(card);
		} else {
			throw new RuntimeException("Adding a card that has a different CardType.");
		}
	}
	
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
	
	public void delCard(AbstractCard card) {
		this.cards.remove(card);
	}

	@Override
	public Object clone() {
		CompositeCard newCard = new CompositeCard(name, ctype);
		newCard.cards = new ArrayList<AbstractCard> (this.cards);
		return newCard;
	}

	@Override
	public void printAttributes() {
		System.out.println("["+this.getName()+"]");
		for(String key: this.ctype.getAttrs()) {
			System.out.println(key+": "+this.getAttribute(key));
		}
		System.out.println();
	}
	
	@Override
	public String getAttributes() {
		String buff = "["+this.getName()+"]";
		for(String key: this.ctype.getAttrs()) {
			buff += "\n" + key + ": " + this.getAttribute(key);
		}
		
		return buff;
	}
}
