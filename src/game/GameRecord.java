package game;

import java.util.ArrayList;

import cards.AbstractCard;
import cards.CardDeck;

public class GameRecord {

	private ArrayList<Record> records;
	private Player p1;
	private Player p2;
	private CardDeck deck;
	
	/**
	 * GameRecord constructor.
	 * @param p1 Player 1
	 * @param p2 Player 2
	 * @param startDeck Deck used
	 */
	public GameRecord(Player p1, Player p2, CardDeck startDeck) {
		this.p1 = p1;
		this.p2 = p2;
		this.deck = startDeck;
		records = new ArrayList<Record>();
	}
	
	/**
	 * Adds the data to recreate a hand when needed.
	 * @param c1 Card played by player 1.
	 * @param c2 Card played by player 2.
	 * @param turn Player whose turn was.
	 * @param attrib Selected attribute to fight.
	 */
	public void addHand(AbstractCard c1, AbstractCard c2, Player turn, String attrib) {
		this.records.add(new Record(c1, c2, turn, attrib));
	}
	
	/**
	 * Gets the list of the recorded hands.
	 * @return Array of records.
	 */
	public ArrayList<Record> getRecordsList() {
		
		return this.records;
	}
	
	/**
	 * Returns deck name and the quantity of the cards in it.
	 * @see java.lang.Object#toString()
	 * 
	 */
	@Override
	public String toString() {
		
		return "Game record for " + this.p1 + " vs " + this.p2 + 
				". Using the deck " + this.deck.getName();
	}

	/**
	 * Returns current deck used by players.
	 * @return CardDeck
	 */
	public CardDeck getDeck() {
		
		return deck;
	}
}
