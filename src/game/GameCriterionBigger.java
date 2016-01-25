package game;

import java.util.logging.Logger;

import application.Main;
import cards.AbstractCard;

public class GameCriterionBigger extends GameCriterion {
	private final String name = "Bigger (Criterion)";
	static Logger logger = Logger.getLogger(Main.class.getName());

	/**
	 * Confronts two cards with the selected attribute.
	 * @param c1 Card from player 1.
	 * @param c2 Card from player 2.
	 * @param attribute Selected attribute
	 * @return an int representing the result based on the static ints defined.
	 */
	@Override
	public int fight(AbstractCard c1, AbstractCard c2, String attribute) throws RuntimeException {
		logger.info("Fighting over -> " + attribute + ": " +
				c1.getAttribute(attribute) + " (" + c1 + ") " + "vs" + " (" + c2 + ") " + c2.getAttribute(attribute)); 
		if (c1.getAttribute(attribute).equals(c2.getAttribute(attribute))) {
			return GameCriterion.EQ;
		} else if (c1.getAttribute(attribute) > c2.getAttribute(attribute)) {
			return GameCriterion.P1;
		} else if (c1.getAttribute(attribute) < c2.getAttribute(attribute)) {
			return GameCriterion.P2;
		}

		throw new RuntimeException("Something happened @ GameCriterionBigger");
	}

	/**
	 * Returns deck name and the quantity of the cards in it.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.name;
	}
}
