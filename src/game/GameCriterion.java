package game;

import cards.AbstractCard;


public abstract class GameCriterion {
	
	public final static int P1 = 1;
	public final static int P2 = 2;
	public final static int EQ = 3;
	public final static int EE = 1;

	/**
	 * Confronts two cards with the selected attribute.
	 * @param c1 Card from player 1.
	 * @param c2 Card from player 2.
	 * @param attribute Selected attribute
	 * @return an int representing the result based on the static ints defined.
	 */
	public abstract int fight(AbstractCard c1, AbstractCard c2, String attribute);

}
