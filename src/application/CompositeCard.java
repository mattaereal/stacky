package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

	public void addCard(AbstractCard card) {
		if (card.getCtype().equals(this.getCtype())) {
			this.cards.add(card);
			update = true;
		} else {
			System.out.println("Adding a card that has a different CardType.");
		}
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
		}
		
	}
	

	
}
