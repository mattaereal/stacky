package game.strategies;

import cards.AbstractCard;
import game.GameRecord;

public abstract class PlayerStrategy {

	public abstract String getAttribute(AbstractCard current, GameRecord feedback);
}
