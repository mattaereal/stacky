package game.strategies;

import java.util.ArrayList;

import cards.AbstractCard;

public abstract class PlayerStrategy {

	public abstract String getAttribute(AbstractCard current, ArrayList<AbstractCard> feedback);
}
