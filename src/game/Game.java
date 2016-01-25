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
	
	/**
	 * Game constructor. 
	 * 
	 * @param p1 Player one.
	 * @param p2 Player two.
	 * @param cd CardDeck.
	 * @param gCrit GameCriterion.
	 */
	public Game(Player p1, Player p2, CardDeck cd, GameCriterion gCrit) {
		this.deck = cd;
		this.gcrit = gCrit;
		this.p1 = p1;
		this.p2 = p2;
		this.tiePool = new ArrayList<AbstractCard>();
		this.setGameRecord(new GameRecord(p1, p2, cd));
		this.tie = false;
	}
	
	/**
	 * Deals cards.
	 */
	public void setup() {
		System.out.println(getGameRecord());
		p1.setFeedback(getGameRecord());
		p2.setFeedback(getGameRecord());
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
	 * Sets a limit on how many hands can be played max.
	 * @param lim Int limit to be set.
	 */
	public void setLimit(int lim) {
		this.limit = lim;
	}
	
	/**
	 * Gets the hands limit.
	 * @return limit.
	 */
	public int getLimit() {
		
		return limit;
	}
	
	/**
	 * Gets the count of how many hands were already played.
	 * @return Hand count.
	 */
	public int getHandCount() {
		
		return handCount;
	}
		
		
	/**
	 * Plays a hand.
	 * The player that has the turn gets selects an attribute and battles
	 * the other card on that attribute. The winner will be returned as a 
	 * reference to that Player, and the card/s won will be assigned to
	 * his deck for future use.
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
		
		if (!this.tie) {
			if (turn.equals(p1)) {
				logger.info(p1 + " selects attribute.");
				attribute = p1.selectAttribute(c1);
			} else {
				logger.info(p2 + " selects attribute.");
				attribute = p2.selectAttribute(c2);
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
		
		this.getGameRecord().addHand(c1, c2, turn, attribute);
		
		return turn;
		
	}
	
	/**
	 * Checks whether the last hand was a tie or not.
	 * @return True if it was, False otherwise.
	 */
	public boolean isTie() {
		
		return this.tie;
	}
	
	/**
	 * End condition for the game. 
	 * Checks whether the amount of hands already played does not
	 * surpass the set limit and if one of the players ran out of cards.
	 * 
	 * @param p1 Player one
	 * @param p2 Player two
	 * @return True if it has to end, False otherwise.
	 */
	public boolean hasEnded(Player p1, Player p2) {
		
		return ((this.getHandCount() >= this.getLimit()) || (p1.getRemainingCards() == 0) || (p2.getRemainingCards() == 0));
	}
	
	/**
	 * Checks whether 2 card types are equal.
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
	
	/**
	 * HashCode.
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
               + this.deck.hashCode();
		
		return result;
   }

	/**
	 * Gets game record.
	 * @return GameRecord
	 */
	public GameRecord getGameRecord() {
		return gameRecord;
	}
	
	/**
	 * Sets game record.
	 * @param gameRecord
	 */
	private void setGameRecord(GameRecord gameRecord) {
		this.gameRecord = gameRecord;
	}

}
