package game;

import cards.AbstractCard;

public final class Record {

	private AbstractCard card1;
	private AbstractCard card2;
	private Player playerTurn;
	private String attribute;

	public Record(AbstractCard c1, AbstractCard c2, Player turn, String attrib) {
		this.card1 = c1;
		this.card2 = c2;
		this.playerTurn = turn;
		this.attribute = attrib;
	}

	public AbstractCard getCard1() {
		return card1;
	}


	public AbstractCard getCard2() {
		return card2;
	}

	public Player getPlayerTurn() {
		return playerTurn;
	}


	public String getAttribute() {
		return attribute;
	}

}
