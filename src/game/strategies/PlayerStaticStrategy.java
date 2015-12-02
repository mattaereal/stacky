package game.strategies;

import cards.AbstractCard;
import game.GameRecord;

public class PlayerStaticStrategy extends PlayerStrategy {

	@Override
	public String getAttribute(AbstractCard current, GameRecord feedback) {
		if (feedback.getDeck().getName().equals("Superheroes")) {
			if (current.getAttribute("Peleas Ganadas") > 900) {
				return "Peleas Ganadas";
			} else if (current.getAttribute("Fuerza") > 1000) {
				return "Fuerza";
			} else if (current.getAttribute("Velocidad") > 500) {
				return "Velocidad";
			} else if (current.getAttribute("Peso") > 300) {
				return "Peso";
			}
		}
			
		PlayerStrategy ps = new PlayerAlwaysBiggerStrategy();
		return ps.getAttribute(current, feedback);
	}

}
