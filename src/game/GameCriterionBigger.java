package game;

import cards.AbstractCard;

public class GameCriterionBigger extends GameCriterion {

	@Override
	public int fight(AbstractCard c1, AbstractCard c2, String attribute) throws RuntimeException {
		
//		c1.printAttributes();
//		c2.printAttributes();
		System.out.print("Fighting over -> " + attribute + ": ");
		System.out.println(c1.getAttribute(attribute) + " (" + c1 + ") " + "vs" + " (" + c2 + ") " + c2.getAttribute(attribute));
		
		if (c1.getAttribute(attribute).equals(c2.getAttribute(attribute))) {
			return GameCriterion.EQ;
		} else if (c1.getAttribute(attribute) > c2.getAttribute(attribute)) {
			return GameCriterion.P1;
		} else if (c1.getAttribute(attribute) < c2.getAttribute(attribute)) {
			return GameCriterion.P2;
		}
		
		throw new RuntimeException("Something happened @ GameCriterionBigger");
		//return GameCriterion.EE;
	}
}
