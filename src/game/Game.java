package game;

import java.util.ArrayList;
import java.util.logging.Logger;

import application.Main;
import cards.AbstractCard;
import cards.CardDeck;

public class Game {
	static Logger logger = Logger.getLogger(Main.class.getName());
	protected CardDeck deck;
	protected Player p1, p2;
	public Player winner;
	protected GameCriterion gcrit;
	public ArrayList<AbstractCard> tiePool;
	private String attribute;
	private boolean tie;
	private GameRecord gameRecord;
	private int limit = 100;
	private int handCount = 0;
	
	public Game(Player p1, Player p2, CardDeck cd, GameCriterion gCrit) {
		this.deck = cd;
		this.gcrit = gCrit;
		this.p1 = p1;
		this.p2 = p2;
		this.tiePool = new ArrayList<AbstractCard>();
		this.gameRecord = new GameRecord(p1, p2, cd);
		this.tie = false;
	}
	
	/**
	 * Deals cards.
	 */
	public void setup() {
		System.out.println(gameRecord);
		p1.setFeedback(gameRecord);
		p2.setFeedback(gameRecord);
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
	
	public void setLimit(int lim) {
		this.limit = lim;
	}
	
	public int getLimit() {
		
		return limit;
	}
	
	public int getHandCount() {
		
		return handCount;
	}
	
//	/**
//	 * Starts a game between 2 players.
//	 * Setups what's needed before starting,
//	 * and plays until a winner is found.
//	 */
//	public void start() {
//		setup();
//		play();
//		showWinner();
//	}
	
	public Player getWinner() {
		return this.winner;
	}
	
//	/**
//	 * Plays ...
//	 */
//	public void play() throws RuntimeException {
//		int min = 0;
//		int max = 100;
//		int rand = min + (int)(Math.random() * ((max - min) + 1));
//		Player player_turn;
//		
//		if (rand < 50) {
//			player_turn = p1;
//		} else {
//			player_turn = p2;
//		}
//		
//		player_turn = hand(player_turn, p1, p2, gcrit);
//		
//		while (p1.hasCards() && p2.hasCards()) {
//			player_turn = hand(player_turn, p1, p2, gcrit);
//		}	
//		
//		if (p1.hasCards()) {
//			this.winner = p1;
//		} else if (p2.hasCards()) {
//			this.winner = p2;
//		} else {
//			throw new RuntimeException("Something happened @ game play.");
//		}
//		
//	}
	
	/**
	 * 
	 * @param turn Player who owns the turn.
	 * @param p1 Player one.
	 * @param p2 Player two.
	 * @param gc GameCriterion to use in each hand.
	 * @return Returns the Player that won the hand.
	 */
	public Player hand(Player turn, Player p1, Player p2, GameCriterion gc) throws RuntimeException {
		handCount += 1;
		AbstractCard c1 = p1.top();
		AbstractCard c2 = p2.top();
		int result = 0;
		String preferedAttribute = null;
		
		if (!this.tie) {
			if (turn.equals(p1)) {
				logger.info(p1 + " selects attribute.");
				if (p1.getgStrategy().isInteractive())
					preferedAttribute = null;
				attribute = p1.selectAttribute(c1, preferedAttribute, gc);
			} else {
				logger.info(p2 + " selects attribute.");
				if (p2.getgStrategy().isInteractive())
					preferedAttribute = null;
				attribute = p2.selectAttribute(c2, preferedAttribute, gc);
			}
		}		

		result = gc.fight(c1, c2, attribute);
		tiePool.add(c1);
		tiePool.add(c2);
		
		if (result == GameCriterion.P1) {
			logger.info("Pool cards won by " + p1);
			p1.saveCards(tiePool);
			tiePool.clear();
			this.tie = false;
			turn = p1;
		} else if (result == GameCriterion.P2) {
			logger.info("Pool cards won by " + p2);
			p2.saveCards(tiePool);
			tiePool.clear();
			this.tie = false;
			turn = p2;
		} else if (result == GameCriterion.EQ) {
			logger.info("[TIE] Cards added to tie pool.");
			this.tie = true;
		} else {
			throw new RuntimeException("Something happened @ hand");
		}
		
		this.gameRecord.addHand(c1, c2, turn, attribute);
		
		return turn;
		
	}
	
	/**
	 * Shows the winner of the game.
	 */
	private void showWinner() {
		System.out.println("Winner: " + winner);
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
