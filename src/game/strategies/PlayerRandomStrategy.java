package game.strategies;

import java.util.Random;
import java.util.Set;

import cards.AbstractCard;
import game.GameCriterion;
import game.GameRecord;

public class PlayerRandomStrategy extends PlayerStrategy {

	private final String name = "Random";
	private AbstractCard current;
	
	@Override
	public String getAttribute() {
		Set<String> attrs = current.getCtype().getAttrs();
		int size = attrs.size();
		int item = new Random().nextInt(size);
		int i = 0;
		String ret = null;
		for(String attr : attrs) {
		    if (i == item)
		    	ret = attr;
		    i = i + 1;
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
