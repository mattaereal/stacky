package game.strategies;

import cards.AbstractCard;
import game.GameCriterion;
import game.GameRecord;

public abstract class PlayerStrategy {

	protected final String name = "(Strategy)";
	
	public abstract String getAttribute();
	
	public abstract void setupNextPlay(AbstractCard current, GameRecord feedback, String preferedAttribute, GameCriterion gCrit);
	
	public abstract String toString();
	
	public abstract boolean isInteractive();
}
