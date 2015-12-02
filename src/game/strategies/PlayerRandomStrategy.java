package game.strategies;

import java.util.Random;
import java.util.Set;

import cards.AbstractCard;
import game.GameRecord;

public class PlayerRandomStrategy extends PlayerStrategy {

	@Override
	public String getAttribute(AbstractCard current, GameRecord feedback) {
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
}
