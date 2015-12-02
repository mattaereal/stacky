package game.strategies;

import java.util.Set;

import cards.AbstractCard;
import game.GameRecord;

public class PlayerAlwaysBiggerStrategy extends PlayerStrategy {

	@Override
	public String getAttribute(AbstractCard current, GameRecord feedback) {
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

}
