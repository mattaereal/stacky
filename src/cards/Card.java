package cards;

import java.util.Hashtable;

public class Card extends AbstractCard {

	public Card(String name, CardType ctype) {
		super(name, ctype);
	}

	@Override
	public Object clone() {
		Card newCard = new Card(name, ctype);
		newCard.attrs = new Hashtable<String, Integer> (this.attrs);
		return newCard;
	}
}
