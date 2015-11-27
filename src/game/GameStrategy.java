package game;

import java.util.ArrayList;

import cards.AbstractCard;
import cards.CardType;

public abstract class GameStrategy {

	public abstract String getAttribute(CardType cardType, ArrayList<AbstractCard> feedback);
}
