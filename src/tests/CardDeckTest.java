package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import cards.AbstractCard;
import cards.Card;
import cards.CardDeck;
import cards.CardType;
import cards.CompositeCard;
import game.Player;
import game.strategies.PlayerStrategy;
import game.strategies.RandomStrategy;

public class CardDeckTest {

	@Test
	public void testAddDelCard() {
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
		
		CompositeCard league1 = new CompositeCard("League 1", superheroes);
		league1.addCard(Beast);
		league1.addCard(Cyclops);
		league1.addCard(IceMan);
		
		CardDeck deck = new CardDeck("Superheroes", superheroes);
		
		deck.addCard(Cyclops);
		
		assertTrue(deck.exists(Cyclops));
		assertTrue(deck.exists("Cyclops"));
		assertTrue(deck.exists("cyclopS"));
		assertFalse(deck.exists(IceMan));
		
		deck.addCard(IceMan);
		
		assertTrue(deck.exists(Cyclops));
		assertTrue(deck.exists(IceMan));
		assertTrue(deck.exists("iCe Man"));
		assertFalse(deck.exists(Thor));
				
		deck.addCard(Thor);
		
		assertTrue(deck.exists(Cyclops));
		assertTrue(deck.exists(IceMan));
		assertTrue(deck.exists("ThoR"));
		assertTrue(deck.exists(Thor));
		
		deck.delCard("Thor");
		assertFalse(deck.exists("ThoR"));
		
		deck.delCard(IceMan);
		assertFalse(deck.exists(IceMan));
		
		deck.delCard("Cyclops");
		deck.delCard(Cyclops);
		assertFalse(deck.exists(Cyclops));
		
		deck.addCard(league1);
		assertTrue(deck.exists(league1));
		assertTrue(deck.exists("LeagUe 1"));
		deck.delCard("lEague 1");
		assertFalse(deck.exists("LeagUe 1"));
		
	}
	
	@Test
	public void testEqualsCardDeck() {
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
		
		CompositeCard league1 = new CompositeCard("League 1", superheroes);
		league1.addCard(Beast);
		league1.addCard(Cyclops);
		league1.addCard(IceMan);
		
		CardDeck deck = new CardDeck("Superheroes", superheroes);
		deck.addCard(Cyclops);
		deck.addCard(Beast);
		deck.addCard(IceMan);
		deck.addCard(Thor);
		
		CardDeck deck_copy = new CardDeck("Superheroes", superheroes);
		deck_copy.addCard(Thor);
		deck_copy.addCard(Cyclops);
		deck_copy.addCard(IceMan);
		deck_copy.addCard(Beast);
		
		assertTrue(deck_copy.equals(deck));
		assertTrue(deck.equals(deck_copy));
		
		AbstractCard Beast2 = new Card("Beast", superheroes);
		Beast2.addAttribute("Altura", 183);
		Beast2.addAttribute("Peso", 112);
		Beast2.addAttribute("Fuerza", 1000);
		Beast2.addAttribute("Peleas ganadas", 999);
		Beast2.addAttribute("Velocidad", 86);
		
		CardDeck deck_other = new CardDeck("Superheroes", superheroes);
		deck_other.addCard(Thor);
		deck_other.addCard(Cyclops);
		deck_other.addCard(IceMan);
		deck_other.addCard(Beast2);
		
		assertFalse(deck_other.equals(deck));
		assertFalse(deck.equals(deck_other));
		
	}
	
	@Test
	public void testAddCards() {
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
		
		CompositeCard league1 = new CompositeCard("League 1", superheroes);
		league1.addCard(Beast);
		league1.addCard(Cyclops);
		league1.addCard(IceMan);
		
		CardDeck deck = new CardDeck("Superheroes", superheroes);
		CardDeck deck_from_list = new CardDeck("Superheroes", superheroes);
		
		ArrayList<AbstractCard> tmp = new ArrayList<AbstractCard>();
		tmp.add(Thor);
		tmp.add(IceMan);
		tmp.add(Beast);
		tmp.add(Cyclops);
		
		
		deck.addCard(Beast);
		deck.addCard(Thor);
		deck.addCard(IceMan);
		deck.addCard(Cyclops);
		
		deck_from_list.addCards(tmp);
		
		assertTrue(deck_from_list.equals(deck));
	}
	
	@Test
	public void testEmpty() {
		CardType superheroes = new CardType();
		superheroes.addAttribute("Altura");
		superheroes.addAttribute("Peso");
		superheroes.addAttribute("Fuerza");
		superheroes.addAttribute("Peleas ganadas");
		superheroes.addAttribute("Velocidad");
		
		CardDeck deck = new CardDeck("Superheroes", superheroes);
		
		assertTrue(deck.isEmpty());
		
		AbstractCard Beast = new Card("Beast", superheroes);
		Beast.addAttribute("Altura", 183);
		Beast.addAttribute("Peso", 112);
		Beast.addAttribute("Fuerza", 1000);
		Beast.addAttribute("Peleas ganadas", 800);
		Beast.addAttribute("Velocidad", 86);
		
		deck.addCard(Beast);
		
		assertFalse(deck.isEmpty());
		
		deck.clear();
		
		assertTrue(deck.isEmpty());
		
	}
	
	@Test
	public void testSplit() {
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

		CardDeck deck = new CardDeck("Superheroes", superheroes);
		deck.addCard(Beast);
		deck.addCard(Thor);
		deck.addCard(IceMan);
		deck.addCard(Cyclops);
		
		PlayerStrategy random = new RandomStrategy();
		Player p1 = new Player("matt", random);
		Player p2 = new Player("cpu", random);
		
		deck.split(p1, p2);
		
		CardDeck deck_2 = new CardDeck("Superheroes", superheroes);
		deck_2.addCards(p1.getCurrentDeck().getDeck());
		deck_2.addCards(p2.getCurrentDeck().getDeck());
		
		assertTrue(deck_2.equals(deck));
		
		AbstractCard WeakBeast = new Card("WeakBeast", superheroes);
		WeakBeast.addAttribute("Altura", 183);
		WeakBeast.addAttribute("Peso", 112);
		WeakBeast.addAttribute("Fuerza", 200);
		WeakBeast.addAttribute("Peleas ganadas", 800);
		WeakBeast.addAttribute("Velocidad", 86);
		
		deck.addCard(WeakBeast);
		
		deck.split(p1, p2);
		
		deck_2.clear();
		deck_2.addCards(p1.getCurrentDeck().getDeck());
		deck_2.addCards(p2.getCurrentDeck().getDeck());
		
		assertTrue(deck_2.equals(deck));
	}
	
	@Test
	public void testPop() {
		CardType superheroes = new CardType();
		superheroes.addAttribute("Altura");
		superheroes.addAttribute("Peso");
		superheroes.addAttribute("Fuerza");
		superheroes.addAttribute("Peleas ganadas");
		superheroes.addAttribute("Velocidad");
		
		CardDeck deck = new CardDeck("Superheroes", superheroes);
		
		assertTrue(deck.isEmpty());
		
		AbstractCard Beast = new Card("Beast", superheroes);
		Beast.addAttribute("Altura", 183);
		Beast.addAttribute("Peso", 112);
		Beast.addAttribute("Fuerza", 1000);
		Beast.addAttribute("Peleas ganadas", 800);
		Beast.addAttribute("Velocidad", 86);
		
		deck.addCard(Beast);
		
		assertTrue(deck.pop().equals(Beast));
		
		assertTrue(deck.isEmpty());
		
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
		
		deck.addCard(Cyclops);
		deck.addCard(IceMan);
		deck.addCard(Thor);
		deck.addCard(Beast);
		
		assertTrue(Cyclops.equals(deck.pop()));
		assertTrue(IceMan.equals(deck.pop()));
		assertTrue(Thor.equals(deck.pop()));
		assertTrue(Beast.equals(deck.pop()));
		
		assertTrue(deck.isEmpty());
		
		
	}
}
