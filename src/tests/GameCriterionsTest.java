package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cards.AbstractCard;
import cards.Card;
import cards.CardDeck;
import cards.CardType;
import game.Game;
import game.GameCriterion;
import game.GameCriterionBigger;
import game.Player;
import game.strategies.PlayerStrategy;
import game.strategies.PlayerRandomStrategy;

public class GameCriterionsTest {

	@Test
	public void testFight() {
		CardType superheroes = new CardType();
		superheroes.addAttribute("Altura");
		superheroes.addAttribute("Peso");
		superheroes.addAttribute("Fuerza");
		superheroes.addAttribute("Peleas ganadas");
		superheroes.addAttribute("Velocidad");
		
		Card Thor = new Card("Thor", superheroes);
		Thor.addAttribute("Altura", 210);
		Thor.addAttribute("Peso", 103);
		Thor.addAttribute("Fuerza", 1100);
		Thor.addAttribute("Peleas ganadas", 975);
		Thor.addAttribute("Velocidad", 250);
		
		Card IceMan = new Card("Ice man", superheroes);
		IceMan.addAttribute("Altura", 177);
		IceMan.addAttribute("Peso", 65);
		IceMan.addAttribute("Fuerza", 800);
		IceMan.addAttribute("Peleas ganadas", 936);
		IceMan.addAttribute("Velocidad", 100);
		
		Card Cyclops = new Card("Cyclops", superheroes);
		Cyclops.addAttribute("Altura", 189);
		Cyclops.addAttribute("Peso", 74);
		Cyclops.addAttribute("Fuerza", 950);
		Cyclops.addAttribute("Peleas ganadas", 936);
		Cyclops.addAttribute("Velocidad", 130);
		
		Card Beast = new Card("Beast", superheroes);
		Beast.addAttribute("Altura", 183);
		Beast.addAttribute("Peso", 112);
		Beast.addAttribute("Fuerza", 1000);
		Beast.addAttribute("Peleas ganadas", 800);
		Beast.addAttribute("Velocidad", 86);

		Card WeakBeast = new Card("WeakBeast", superheroes);
		WeakBeast.addAttribute("Altura", 183);
		WeakBeast.addAttribute("Peso", 112);
		WeakBeast.addAttribute("Fuerza", 200);
		WeakBeast.addAttribute("Peleas ganadas", 800);
		WeakBeast.addAttribute("Velocidad", 86);
		
		CardDeck deck = new CardDeck("Superheroes", superheroes);
		deck.addCard(Beast);
		deck.addCard(Thor);
		deck.addCard(IceMan);
		deck.addCard(Cyclops);
		deck.addCard(WeakBeast);
		

		GameCriterion gCrit = new GameCriterionBigger();
		PlayerStrategy gstrat = new PlayerRandomStrategy();
		Player p1 = new Player("CPU1", gstrat);
		Player p2 = new Player("CPU2", gstrat);
		Game game = new Game(p1, p2, deck, gCrit);
		
		game.setup();
		
		AbstractCard c1 = p1.top();
		AbstractCard c2 = p2.top();
		
		String attribute = p1.selectAttribute(c1);

		int result = gCrit.fight(c1, c2, attribute);
		
//		if (result == GameCriterion.P1) {
//			System.out.println("Player " + p1.getName() + " won.");
//		} else if (result == GameCriterion.P2) {
//			System.out.println("Player " + p2.getName() + " won.");
//		} else if (result == GameCriterion.EQ) {
//			System.out.println("There was a tie");
//		} else {
//			System.out.println("Something happened @ GameCritTest");
//		}
		
		if ((c1.getAttribute(attribute) > c2.getAttribute(attribute)) &&
		result != GameCriterion.P1) {
			fail("Player one must have won.");
		} else if ((c1.getAttribute(attribute) < c2.getAttribute(attribute)) &&
		result != GameCriterion.P2) {
			fail("Player two must have won.");
		} else if ((c1.getAttribute(attribute).equals(c2.getAttribute(attribute))) &&
		result != GameCriterion.EQ) {
			fail("There should be a tie.");
		}
	}

}
