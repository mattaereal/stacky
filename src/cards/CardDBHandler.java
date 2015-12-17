package cards;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CardDBHandler {
	private HashMap<UUID, AbstractCard> cards;
	
	public CardDBHandler() {
		cards = new HashMap<UUID, AbstractCard>();
	}
	
	public void addCard(AbstractCard card) {
		cards.put(card.getID(), card);
	}
	
	public void delCard(UUID id) {
		cards.remove(id);
	}
	
	public AbstractCard getCard(UUID id) {
		
		return cards.get(id);
	}
	
	public void printCards() {
		for (Map.Entry<UUID, AbstractCard> entry : cards.entrySet()) {
		    System.out.print(entry.getKey() + "\t" + entry.getValue());
		    System.out.println("(" + entry.getValue().getCtype() + ")");
		}
	}
}
