package game.strategies;

import cards.AbstractCard;
import game.GameCriterion;
import game.GameRecord;

public class PlayerInteractiveStrategy extends PlayerStrategy {
	
	private final String name = "Interactive";
	private String nextAttribute;

	@Override
	public String getAttribute() {

		return nextAttribute;
	}
	
	@Override
	public void setupNextPlay(AbstractCard current, GameRecord feedback, String preferedAttribute,
			GameCriterion gCrit) {
		nextAttribute = preferedAttribute;
	}

	@Override
	public String toString() {
		return name + " " + super.name;
	}

	@Override
	public boolean isInteractive() {
		
		return true;
	}


}
