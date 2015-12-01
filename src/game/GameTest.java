package game;

import static org.junit.Assert.*;

import org.junit.Test;

import cards.AbstractCard;
import cards.Card;
import cards.CardDeck;
import cards.CardDeckFactory;
import cards.CardType;
import game.strategies.PlayerStrategy;
import game.strategies.RandomStrategy;

public class GameTest {

	
	public void testDeal() {
		CardType superheroes = new CardType();
		superheroes.addAttribute("Altura");
		superheroes.addAttribute("Peso");
		superheroes.addAttribute("Fuerza");
		superheroes.addAttribute("Peleas ganadas");
		superheroes.addAttribute("Velocidad");
		
		AbstractCard Thor = new Card("Thor", superheroes);
		Thor.addAttribute("Altura", 210);
		Thor.addAttribute("Peso", 103);
		Thor.addAttribute("Fuerza", 1100);
		Thor.addAttribute("Peleas ganadas", 975);
		Thor.addAttribute("Velocidad", 250);
		
		AbstractCard IceMan = new Card("Ice man", superheroes);
		IceMan.addAttribute("Altura", 177);
		IceMan.addAttribute("Peso", 65);
		IceMan.addAttribute("Fuerza", 800);
		IceMan.addAttribute("Peleas ganadas", 936);
		IceMan.addAttribute("Velocidad", 100);
		
		AbstractCard Cyclops = new Card("Cyclops", superheroes);
		Cyclops.addAttribute("Altura", 189);
		Cyclops.addAttribute("Peso", 74);
		Cyclops.addAttribute("Fuerza", 950);
		Cyclops.addAttribute("Peleas ganadas", 936);
		Cyclops.addAttribute("Velocidad", 130);
		
		AbstractCard Beast = new Card("Beast", superheroes);
		Beast.addAttribute("Altura", 183);
		Beast.addAttribute("Peso", 112);
		Beast.addAttribute("Fuerza", 1000);
		Beast.addAttribute("Peleas ganadas", 800);
		Beast.addAttribute("Velocidad", 86);

		AbstractCard WeakBeast = new Card("WeakBeast", superheroes);
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
		
		PlayerStrategy gstrat = new RandomStrategy();
		GameCriterion gcrit = new GameCriterionBigger();
		Player p1 = new Player("CPU1", gstrat);
		Player p2 = new Player("CPU2", gstrat);
		Game game = new Game(p1, p2, deck, gcrit);
		
		game.setup();
		
		CardDeck deck_2 = new CardDeck("Superheroes", superheroes);
		deck_2.addCards(p1.getCurrentDeck().getDeck());
		deck_2.addCards(p2.getCurrentDeck().getDeck());
		
		assertTrue(deck_2.equals(deck));
		
		
	}
	
	public void testHandAndPlay() {
		CardType superheroes = new CardType();
		superheroes.addAttribute("Altura");
		superheroes.addAttribute("Peso");
		superheroes.addAttribute("Fuerza");
		superheroes.addAttribute("Peleas ganadas");
		superheroes.addAttribute("Velocidad");
		
		AbstractCard Thor = new Card("Thor", superheroes);
		Thor.addAttribute("Altura", 210);
		Thor.addAttribute("Peso", 103);
		Thor.addAttribute("Fuerza", 1100);
		Thor.addAttribute("Peleas ganadas", 975);
		Thor.addAttribute("Velocidad", 250);
		
		AbstractCard IceMan = new Card("Ice man", superheroes);
		IceMan.addAttribute("Altura", 177);
		IceMan.addAttribute("Peso", 65);
		IceMan.addAttribute("Fuerza", 800);
		IceMan.addAttribute("Peleas ganadas", 936);
		IceMan.addAttribute("Velocidad", 100);
		
		AbstractCard Cyclops = new Card("Cyclops", superheroes);
		Cyclops.addAttribute("Altura", 189);
		Cyclops.addAttribute("Peso", 74);
		Cyclops.addAttribute("Fuerza", 950);
		Cyclops.addAttribute("Peleas ganadas", 936);
		Cyclops.addAttribute("Velocidad", 130);
		
		AbstractCard Beast = new Card("Beast", superheroes);
		Beast.addAttribute("Altura", 183);
		Beast.addAttribute("Peso", 112);
		Beast.addAttribute("Fuerza", 1000);
		Beast.addAttribute("Peleas ganadas", 800);
		Beast.addAttribute("Velocidad", 86);

		AbstractCard WeakBeast = new Card("WeakBeast", superheroes);
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
		
		PlayerStrategy gstrat = new RandomStrategy();
		GameCriterion gcrit = new GameCriterionBigger();
		Player p1 = new Player("CPU1", gstrat);
		Player p2 = new Player("CPU2", gstrat);
		Game game = new Game(p1, p2, deck, gcrit);
		
		game.setup();
		
		int min = 0;
		int max = 100;
		int rand = min + (int)(Math.random() * ((max - min) + 1));
		Player player_turn = null;
		
		if (rand < 50) {
			player_turn = p1;
		} else {
			player_turn = p2;
		}
		
//		System.out.println("Starts " + player_turn);
//		
//		System.out.println("Player ONE current deck beggining:\n" + p1.getCurrentDeck());
//		System.out.println("Player TWO current deck beggining:\n" + p2.getCurrentDeck());
		
		while (p1.hasCards() && p2.hasCards()) {
			player_turn = game.hand(player_turn, p1, p2, gcrit);
//			System.out.println("The turn of the next hand is for " + player_turn);
//			System.out.println("Player one current deck:\n" + p1.getCurrentDeck());
//			System.out.println("Player one used deck:\n" + p1.getUsedDeck());
//			
//			System.out.println("Player two current deck:\n" + p2.getCurrentDeck());
//			System.out.println("Player two used deck:\n" + p2.getUsedDeck());
		}	
		
		CardDeck tmp = new CardDeck("Superheroes", superheroes);
		if (p1.hasCards()) {
//			System.out.println("Player one won.");
			tmp.addCards(p1.getCurrentDeck().getDeck());
			tmp.addCards(p1.getUsedDeck().getDeck());
		} else if (p2.hasCards()) {
			tmp.addCards(p2.getCurrentDeck().getDeck());
			tmp.addCards(p2.getUsedDeck().getDeck());
//			System.out.println("Player two won.");
		}
		
		assertTrue(tmp.equals(deck));
		
	}

	public void testEqualsObject() {
		CardType superheroes = new CardType();
		superheroes.addAttribute("Altura");
		superheroes.addAttribute("Peso");
		superheroes.addAttribute("Fuerza");
		superheroes.addAttribute("Peleas ganadas");
		superheroes.addAttribute("Velocidad");
		
		AbstractCard Thor = new Card("Thor", superheroes);
		Thor.addAttribute("Altura", 210);
		Thor.addAttribute("Peso", 103);
		Thor.addAttribute("Fuerza", 1100);
		Thor.addAttribute("Peleas ganadas", 975);
		Thor.addAttribute("Velocidad", 250);
		
		AbstractCard IceMan = new Card("Ice man", superheroes);
		IceMan.addAttribute("Altura", 177);
		IceMan.addAttribute("Peso", 65);
		IceMan.addAttribute("Fuerza", 800);
		IceMan.addAttribute("Peleas ganadas", 936);
		IceMan.addAttribute("Velocidad", 100);
		
		AbstractCard Cyclops = new Card("Cyclops", superheroes);
		Cyclops.addAttribute("Altura", 189);
		Cyclops.addAttribute("Peso", 74);
		Cyclops.addAttribute("Fuerza", 950);
		Cyclops.addAttribute("Peleas ganadas", 936);
		Cyclops.addAttribute("Velocidad", 130);
		
		AbstractCard Beast = new Card("Beast", superheroes);
		Beast.addAttribute("Altura", 183);
		Beast.addAttribute("Peso", 112);
		Beast.addAttribute("Fuerza", 1000);
		Beast.addAttribute("Peleas ganadas", 800);
		Beast.addAttribute("Velocidad", 86);

		AbstractCard WeakBeast = new Card("WeakBeast", superheroes);
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
		
		CardDeck deck2 = new CardDeck("Superheroes", superheroes);
		deck2.addCard(WeakBeast);
		deck2.addCard(Cyclops);
		deck2.addCard(Thor);
		deck2.addCard(IceMan);
		deck2.addCard(Beast);
		
		PlayerStrategy gstrat = new RandomStrategy();
		GameCriterion gcrit = new GameCriterionBigger();
		Player p1 = new Player("CPU1", gstrat);
		Player p2 = new Player("CPU2", gstrat);
		Game g1 = new Game(p1, p2, deck, gcrit);
		Game g2 = new Game(p1, p2, deck, gcrit);
		Game g3 = new Game(p1, p2, deck2, gcrit);
		Game g4 = new Game(p2, p1, deck2, gcrit);
		
		assertTrue(g1.equals(g2));
		assertTrue(g1.equals(g3));
		assertFalse(g1.equals(g4));
	}
	
	@Test
	public void startTest() {
		PlayerStrategy random = new RandomStrategy();
		Player p1 = new Player("CPU-1", random);
		Player p2 = new Player("CPU-2", random); //Siempre atrib aleatorio			
		
		GameCriterion gCrit = new GameCriterionBigger();
		CardDeck filedeck = CardDeckFactory.fromFile("decks/DeckTest1.xml");
		Game g = new Game(p1, p2, filedeck, gCrit);
		g.start();
		
		assertNotNull(g.getWinner());
	}

}
