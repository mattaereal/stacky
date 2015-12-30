package game.strategies;

import cards.AbstractCard;
import game.GameCriterion;
import game.GameRecord;

public class PlayerStaticStrategy extends PlayerStrategy {

	private final static String name = "Static";
	private AbstractCard current;
	private GameRecord feedback;
	private GameCriterion gCrit;
	private String preferedAttribute;
	
	@Override
	public String getAttribute() {
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
		ps.setupNextPlay(current, feedback, preferedAttribute, gCrit);
		return ps.getAttribute();
	}
	
	@Override
	public void setupNextPlay(AbstractCard current, GameRecord feedback, String preferedAttribute,
			GameCriterion gCrit) {
		this.current = current;
		this.feedback = feedback;
		this.gCrit = gCrit;
		this.preferedAttribute = preferedAttribute;
		
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
