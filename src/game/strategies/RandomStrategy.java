package game.strategies;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import cards.AbstractCard;

public class RandomStrategy extends PlayerStrategy {

	@Override
	public String getAttribute(AbstractCard current, ArrayList<AbstractCard> feedback) {
		Set<String> attrs = current.getCtype().getAttrs();
		int size = attrs.size();
		int item = new Random().nextInt(size); //cambiar por otro mecanismo
		int i = 0;
		String ret = null;
		for(String attr : attrs) {
		    if (i == item)
		    	ret = attr;
		    i = i + 1;
		}
		
		return ret; //chequear si alguna vez llega acá
	}
}
