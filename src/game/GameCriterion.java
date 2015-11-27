package game;

import cards.AbstractCard;


public abstract class GameCriterion {
	
	public final static int P1 = 1;
	public final static int P2 = 2;
	public final static int EQ = 3;
	public final static int EE = 1;

	public abstract int fight(AbstractCard c1, AbstractCard c2, String attribute);

}
