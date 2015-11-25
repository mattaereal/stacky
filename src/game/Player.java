package game;

import cards.AbstractCard;
import cards.CardDeck;

public class Player {
	
	private String name;
	private GameStrategy gStrategy;
	private CardDeck current_deck;
	private CardDeck used_deck;
	private CardDeck tmp_deck;
	
	public Player(String name, GameStrategy strat) {
		this.setName(name);
		this.setgStrategy(strat);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GameStrategy getgStrategy() {
		return gStrategy;
	}

	public void setgStrategy(GameStrategy gStrategy) {
		this.gStrategy = gStrategy;
	}
	
	public void setDeck(CardDeck curr) {
		this.current_deck = curr;
		this.used_deck = new CardDeck(curr.getName(), curr.getType());
		this.tmp_deck = new CardDeck(curr.getName(), curr.getType());
	}
	
	public AbstractCard top() {
		if (current_deck.isEmpty()) {
			used_deck.shuffle();
			tmp_deck = current_deck;
			current_deck = used_deck;
			used_deck = tmp_deck;
		}
		
		return current_deck.pop();
	}
	
	public boolean hasCards() {
		
		if (current_deck.isEmpty() && used_deck.isEmpty()) {
			
			return false;
		}
		
		return true;
	}
	
	public void saveCard(AbstractCard card) {
		this.used_deck.addCard(card);
	}
	
	public void saveCards(AbstractCard c1, AbstractCard c2) {
		saveCard(c1);
		saveCard(c2);
	}

	public String selectAttribute() {
//		return this.gStrategy.getAttribute();
		return null;
	}
	
	

}
