package game.strategies;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import cards.AbstractCard;
import cards.CardType;

public class RandomStrategy extends GameStrategy {

	@Override
	public String getAttribute(CardType cardType, ArrayList<AbstractCard> feedback) {
		Set<String> attrs = cardType.getAttrs();
		int size = attrs.size();
		int item = new Random().nextInt(size); //cambiar por otro mecanismo
		int i = 0;
		for(String attr : attrs) {
		    if (i == item)
		        return attr;
		    i = i + 1;
		}
		
		return null; //chequear si alguna vez llega acá
	}
}
