package game;

import cards.AbstractCard;

public final class Record {

	private AbstractCard card1;
	private AbstractCard card2;
	private Player playerTurn;
	private String attribute;

	/**
	 * Record constructor.
	 * 
	 * @param c1 AbstractCard from player 1.
	 * @param c2 AbstractcCard from player2.
	 * @param turn Player whose turn was.
	 * @param attrib Selected attribute.
	 */
	public Record(AbstractCard c1, AbstractCard c2, Player turn, String attrib) {
		this.card1 = c1;
		this.card2 = c2;
		this.playerTurn = turn;
		this.attribute = attrib;
	}

	/**
	 * Gets the card played by player 1.
	 * @return Card
	 */
	public AbstractCard getCard1() {
		return card1;
	}

	/**
	 * Gets the card played by player 2.
	 * @return Card
	 */
	public AbstractCard getCard2() {
		return card2;
	}

	/**
	 * Gets the player whose turn it was.	
	 * @return Player
	 */
	public Player getPlayerTurn() {
		return playerTurn;
	}

	/**
	 * Gets current attribute.
	 * @return attribute.
	 */
	public String getAttribute() {
		return attribute;
	}

}
