package cards;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import utils.Util;

public class CompositeCard extends AbstractCard {
	private List<AbstractCard> cards;
	private boolean update = false;

	public CompositeCard(String name, CardType ctype) {
		super(name, ctype);
		cards = new ArrayList<AbstractCard>();
	}

	public List<AbstractCard> getCards() {
		
		return cards;
	}
	
	@Override
	public Integer getAttribute(String name) {
		if(update) {
			this.update();
		}
		
		return super.getAttribute(name);
	}

	public void addCard(AbstractCard card) throws RuntimeException {
		if (card.getCtype().equals(this.getCtype())) {
			this.cards.add(card);
			update = true;
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
		this.update = true;
	}

	@Override
	public void printAttributes() {
		if(update) {
			this.update();
		}
		super.printAttributes();
	}
	
	private void clearAttrs() {
		this.attrs.clear();
	}
	
	
	private void update() {
		// This method can be replaced with a runtime check. Less optimal.
		this.clearAttrs();
		update = false;
		if (this.getCards().size() != 0) {
			Iterator<String> iter = this.getCtype().iterator();
			String key = "";
			int sum = 0;
			int q = 0;
			while (iter.hasNext()) {
				key = iter.next();
				sum = 0;
				q = this.getCards().size();
				for (int i = 0; i < q; i++) {
					sum += this.getCards().get(i).getAttribute(key);
				}
				this.addAttribute(key, new Integer(sum / q));
			}
		} else {
			super.init();
		}
	}

	@Override
	public Object clone() {
		CompositeCard newCard = new CompositeCard(name, ctype);
		newCard.attrs = new Hashtable<String, Integer> (this.attrs);
		newCard.cards = new ArrayList<AbstractCard> (this.cards);
		return newCard;
	}
	

	
}