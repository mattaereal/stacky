package cards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CardDBHandler {
	private HashMap<UUID, AbstractCard> cards;
	
	/**
	 * Card database handler constructor.
	 */
	public CardDBHandler() {
		cards = new HashMap<UUID, AbstractCard>();
	}
	
	/**
	 * Adds a card to the database.
	 * @param card Card to be added
	 */
	public void addCard(AbstractCard card) {
		cards.put(card.getID(), card);
	}
	
	/**
	 * Deletes a card from the database from its UUID.
	 * @param id UUID of the card.
	 */
	public void delCard(UUID id) {
		cards.remove(id);
	}
	
	/**
	 * Gathers a card located from its UUID.
	 * @param id UUID of the card.
	 * @return AbstractCard.
	 */
	public AbstractCard getCard(UUID id) {
		
		return cards.get(id);
	}
	
	/**
	 * Mostly used for debug purposes.
	 * Prints the cards the their type on the db.
	 */
	public void printCards() {
		for (Map.Entry<UUID, AbstractCard> entry : cards.entrySet()) {
		    System.out.print(entry.getKey() + "\t" + entry.getValue());
		    System.out.println("(" + entry.getValue().getCtype() + ")");
		}
	}
	
	/**
	 * Returns a list of the cards in the database.
	 * @return A list of AbstractCards.
	 */
	public List<AbstractCard> getList() {
		
		return new ArrayList<AbstractCard>(cards.values());
	}
}
