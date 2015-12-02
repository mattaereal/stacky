package game;

import java.util.ArrayList;

import cards.AbstractCard;
import cards.CardDeck;

public class GameRecord {

	private ArrayList<Record> records;
	private Player p1;
	private Player p2;
	private CardDeck deck;
	
	public GameRecord(Player p1, Player p2, CardDeck startDeck) {
		this.p1 = p1;
		this.p2 = p2;
		this.deck = startDeck;
		records = new ArrayList<Record>();
	}
	
	public void addHand(AbstractCard c1, AbstractCard c2, Player turn, String attrib) {
		this.records.add(new Record(c1, c2, turn, attrib));
	}
	
	public ArrayList<Record> getRecordsList() {
		
		return this.records;
	}
	
	@Override
	public String toString() {
		
		return "Game record for " + this.p1 + " vs " + this.p2 + 
				". Using the deck " + this.deck.getName();
	}

	public CardDeck getDeck() {
		
		return deck;
	}
}
