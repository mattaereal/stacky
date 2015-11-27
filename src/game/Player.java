package game;

import java.util.ArrayList;

import cards.AbstractCard;
import cards.CardDeck;

public class Player {
	
	private String name;
	private GameStrategy gStrategy;
	private CardDeck current_deck;
	private CardDeck used_deck;
	private CardDeck tmp_deck;
	private ArrayList<AbstractCard> feedback;
	
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

	public String selectAttribute() {
		return this.gStrategy.getAttribute(current_deck.getType(), feedback);
	}

	@Override
    public int hashCode() {
        final int prime = 37;
        int result = 1;
        result = prime * result
                + this.name.hashCode();
        return result;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Player other = (Player) obj;
		if (!this.name.equals(other.name))
			return false;
		if (!this.current_deck.equals(other.current_deck))
			return false;
		if (!this.gStrategy.equals(other.gStrategy))
			return false;
		
		return true;
    }

	public void saveCards(ArrayList<AbstractCard> pile) {
		this.used_deck.addCards(pile);
	}

	public void setFeedback(ArrayList<AbstractCard> feedback) {
		this.feedback = feedback;
	}
	
	public ArrayList<AbstractCard> getFeedback() {
		return this.feedback;
	}

}
