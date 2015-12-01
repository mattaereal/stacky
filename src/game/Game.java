package game;

import java.util.ArrayList;

import cards.AbstractCard;
import cards.CardDeck;

public class Game {
	
	protected CardDeck deck;
	protected Player p1, p2, winner;
	protected GameCriterion gcrit;
	private ArrayList<AbstractCard> tiePool;
	private String attribute;
	private boolean tie;
	private ArrayList<AbstractCard> feedback; //hacer otra clase con más información
	
	public Game(Player p1, Player p2, CardDeck cd, GameCriterion gCrit) {
		this.deck = cd;
		this.gcrit = gCrit;
		this.p1 = p1;
		this.p2 = p2;
		this.tiePool = new ArrayList<AbstractCard>();
		this.feedback = new ArrayList<AbstractCard>();
		this.tie = false;
	}
	
	/**
	 * Deals cards.
	 */
	public void setup() {
		p1.setFeedback(feedback);
		p2.setFeedback(feedback);
		deal();
	}
	
	/**
	 * Shuffles and splits cards
	 * between the 2 players.
	 */
	private void deal() {
		deck.shuffle();
		deck.split(p1, p2);
	}
	
	/**
	 * Starts a game between 2 players.
	 * Setups what's needed before starting,
	 * and plays until a winner is found.
	 */
	public void start() {
		setup();
		play();
		showWinner();
	}
	
	/**
	 * Plays ...
	 */
	private void play() {
		int min = 0;
		int max = 100;
		int rand = min + (int)(Math.random() * ((max - min) + 1));
		Player player_turn;
		
		if (rand < 50) {
			player_turn = p1;
		} else {
			player_turn = p2;
		}
		
		player_turn = hand(player_turn, p1, p2, gcrit);
		
		while (p1.hasCards() && p2.hasCards()) {
			player_turn = hand(player_turn, p1, p2, gcrit);
		}	
		
		if (p1.hasCards()) {
			winner = p1;
		} else if (p2.hasCards()) {
			winner = p2;
		} else {
			System.out.println("Something happened @ play.");
		}
		
	}
	
	/**
	 * 
	 * @param turn Player who owns the turn.
	 * @param p1 Player one.
	 * @param p2 Player two.
	 * @param gc GameCriterion to use in each hand.
	 * @return Returns the Player that won the hand.
	 */
	private Player hand(Player turn, Player p1, Player p2, GameCriterion gc) {
		AbstractCard c1 = p1.top();
		AbstractCard c2 = p2.top();
		int result = 0;
		
		if (!this.tie) {
			if (turn.equals(p1)) {
				attribute = p1.selectAttribute(c1);
			} else {
				attribute = p2.selectAttribute(c2);
			}
		}		

		result = gc.fight(c1, c2, attribute);
		
		if (result == GameCriterion.P1) {
			p1.saveCards(tiePool);
			tiePool.clear();
			this.tie = false;
			return p1;
		} else if (result == GameCriterion.P2) {
			p2.saveCards(tiePool);
			tiePool.clear();
			this.tie = false;
			return p2;
		} else if (result == GameCriterion.EE) {
			this.tie = true;
			tiePool.add(c1);
			tiePool.add(c2);
			return turn;
		} else {
			System.out.println("Something happened @ hand");
			return turn;
		}
	}
	
	/**
	 * Shows the winner of the game.
	 */
	private void showWinner() {
		System.out.println(winner);
	}
	
   @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Game other = (Game) obj;

		if (!this.deck.equals(other.deck))
			return false;
		if (!this.gcrit.equals(other.gcrit))
			return false;
		if (!this.p1.equals(other.p1))
			return false;
		if (!this.p2.equals(other.p2))
			return false;
		
		return true;
    }
	
   @Override
   public int hashCode() {
       final int prime = 31;
       int result = 1;
       result = prime * result
               + this.deck.hashCode();
       return result;
   }
}
