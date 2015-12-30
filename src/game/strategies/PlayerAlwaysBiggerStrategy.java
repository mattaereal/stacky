package game.strategies;

import java.util.Set;

import cards.AbstractCard;
import game.GameCriterion;
import game.GameRecord;

public class PlayerAlwaysBiggerStrategy extends PlayerStrategy {
	
	private final String name = "Always Bigger";
	private AbstractCard current;

	@Override
	public String getAttribute() {
		Set<String> attrs = current.getCtype().getAttrs();
		int max = 0,tmp = 0;
		String ret = null;
		for(String attr : attrs) {
			tmp = current.getAttribute(attr);
			if (tmp > max)
				max = tmp;
				ret = attr;
			}

		return ret;
	}
	
	@Override
	public void setupNextPlay(AbstractCard current, GameRecord feedback, String preferedAttribute,
			GameCriterion gCrit) {
		this.current = current;
		
	}
	
	@Override
	public String toString() {
		return name + " " + super.name;
	}

	@Override
	public boolean isInteractive() {

		return false;
	}


}
