package game;

import java.util.ArrayList;

import cards.AbstractCard;
import cards.CardDeck;
import game.strategies.PlayerStrategy;
import utils.Util;

public class Player {
	
	private String name;
	private PlayerStrategy gStrategy;
	private CardDeck current_deck = null;
	private CardDeck used_deck = null;
	private CardDeck tmp_deck = null;
	private GameRecord feedback;
	
	/**
	 * Class that represents a card Player.
	 * @param name Name of the player.
	 * @param strat Strategy that will be used to play.
	 */
	public Player(String name, PlayerStrategy strat) {
		this.setName(name);
		this.setgStrategy(strat);
	}

	/**
	 * Class that represents a card Player.
	 * @param name Name of the player.
	 * @param strat Strategy that will be used to play.
	 * @param curr CardDeck that the player will be using.
	 */
	public Player(String name, PlayerStrategy strat, CardDeck curr) {
		this.setName(name);
		this.setgStrategy(strat);
		this.setDeck(curr);
	}
	
	/**
	 * Returns the name of the player.
	 * @return Name of the player.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the player.
	 * @param name Name to be set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the strategy set by the player.
	 * @return Current GameStrategy.
	 */
	public PlayerStrategy getgStrategy() {
		return gStrategy;
	}

	/**
	 * Set the Game Strategy to be used by the player.
	 * @param gStrategy
	 */
	public void setgStrategy(PlayerStrategy gStrategy) {
		this.gStrategy = gStrategy;
	}
	
	/**
	 * Sets the main deck of the player, and additionally
	 * adds another deck where the used cards will go.
	 * Also a temporary deck to use as a buffer in the
	 * future will be set too, both with the same ctype
	 * of the main deck.
	 * @param curr The deck that the player will use.
	 */
	public void setDeck(CardDeck curr) {
		this.current_deck = (CardDeck) curr.clone();
		this.used_deck = new CardDeck(curr.getName(), curr.getType());
		this.tmp_deck = new CardDeck(curr.getName(), curr.getType());
	}

	/**
	 * Gets the main deck of the player.
	 * @return Current deck.
	 */
	public CardDeck getCurrentDeck() {
		return current_deck;
	}
	
	/**
	 * Gets the used cards deck.
	 * @return
	 */
	public CardDeck getUsedDeck() {
		return used_deck;
	}
	
	/**
	 * Returns the top card of the deck.
	 * If the main deck is empty, then the
	 * cards from the used deck should be reused
	 * and must be shuffled first.
	 * @return The top card of player's cards.
	 */
	public AbstractCard top() {
		if (hasCards()) {
			if (current_deck.isEmpty()) {
				used_deck.shuffle();
				tmp_deck = current_deck;
				current_deck = used_deck;
				used_deck = tmp_deck;
			}
			
			return current_deck.pop();
		}
		
		return null;
	}
	
	/**
	 * Checks whether the player has remaining
	 * cards or not.
	 * @return True if the player has any card left
	 * , false otherwise.
	 */
	public boolean hasCards() {
		if (current_deck == null)
			
			return false;
		
		if (current_deck.isEmpty() && used_deck.isEmpty())
			
			return false;
		
		return true;
	}
	
	/**
	 * Saves a card with the rest of the deck.
	 * @param card AbstractCard to be saved.
	 */
	public void saveCard(AbstractCard card) {
		this.used_deck.addCard(card);
	}

	/**
	 * Saves a pile of cards with the rest of the deck.
	 * @param pile 
	 */
	public void saveCards(ArrayList<AbstractCard> pile) {
		this.used_deck.addCards(pile);
	}

	/**
	 * Selects an attribute based on the strategy.
	 * @return An attribute.
	 */
	public String selectAttribute(AbstractCard current, String preferedAttribute, GameCriterion gCrit) {
		this.gStrategy.setupNextPlay(current, feedback, preferedAttribute, gCrit);
		return this.gStrategy.getAttribute();
	}

	/**
	 * HashCode.
	 * @see java.lang.Object#hashCode()
	 */
	@Override
    public int hashCode() {
        final int prime = 37;
        int result = 1;
        result = prime * result
                + this.name.hashCode();
        return result;
    }
    
	/**
	 * Equals.
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Player other = (Player) obj;
		if (!Util.capitalize(this.name).equals(Util.capitalize(other.name)))
			return false;
		if ((this.current_deck != null && other.current_deck != null)) {
			if (!this.current_deck.equals(other.current_deck))
				return false;
		} else if (this.current_deck != null || other.current_deck != null) {
			return false;
		} else {
			return true;
		}
		if (!this.gStrategy.equals(other.gStrategy))
			return false;
		
		return true;
    }

	public void setFeedback(GameRecord gameRecord) {
		this.feedback = gameRecord;
	}
	
	public GameRecord getFeedback() {
		return this.feedback;
	}
	
	public String toString() {
		return "\"" + this.getName() + "\"";
	}
	
	public AbstractCard peek() {
		if (hasCards()) {
			if (current_deck.isEmpty()) {
				used_deck.shuffle();
				tmp_deck = current_deck;
				current_deck = used_deck;
				used_deck = tmp_deck;
			}
			
			return current_deck.getDeck().get(0);
		}
		
		return null;
	}
	
	public int getRemainingCards() {
		
		return current_deck.size() + used_deck.size();
	}
	
}
