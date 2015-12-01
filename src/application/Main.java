package application;

//import java.io.IOException;

import cards.*;
import game.*;
import game.strategies.PlayerStrategy;
import game.strategies.RandomStrategy;


public class Main {
	
	public static void main(String[] args) {
		
//		GameStrategy interactive = new InteractiveStrategy();
		PlayerStrategy random = new RandomStrategy();
		
//		Player p1 = new Player("Matt", interactive); //Se pregunta por prompt (user)
		Player p1 = new Player("CPU2", random);
		Player p2 = new Player("CPU", random); //Siempre atrib aleatorio			
		
		GameCriterion gCrit = new GameCriterionBigger();
		CardDeck filedeck = CardDeckFactory.fromFile("decks/DeckTest1.xml");
//		System.out.println(filedeck);
//		Game g = new Game(p1, p2, filedeck, gCrit);
//		g.start();
		
	}	
}
