package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cards.AbstractCard;
import cards.Card;
import cards.CardDeck;
import cards.CardType;
import game.Player;
import game.strategies.PlayerStrategy;
import game.strategies.RandomStrategy;

public class PlayerTest {

	@Test
	public void testTopSave() {
		PlayerStrategy gstrat = new RandomStrategy();
		Player p1 = new Player("Matt", gstrat);
		AbstractCard c = p1.top();
		assertNull(c);
		
		CardType superheroes = new CardType();
		superheroes.addAttribute("Altura");
		superheroes.addAttribute("Peso");
		superheroes.addAttribute("Fuerza");
		superheroes.addAttribute("Peleas ganadas");
		superheroes.addAttribute("Velocidad");
		
		CardDeck deck = new CardDeck("Superheroes", superheroes);
		
		AbstractCard Beast = new Card("Beast", superheroes);
		Beast.addAttribute("Altura", 183);
		Beast.addAttribute("Peso", 112);
		Beast.addAttribute("Fuerza", 1000);
		Beast.addAttribute("Peleas ganadas", 800);
		Beast.addAttribute("Velocidad", 86);
		
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
		
		AbstractCard WeakBeast = new Card("WeakBeast", superheroes);
		WeakBeast.addAttribute("Altura", 183);
		WeakBeast.addAttribute("Peso", 112);
		WeakBeast.addAttribute("Fuerza", 200);
		WeakBeast.addAttribute("Peleas ganadas", 800);
		WeakBeast.addAttribute("Velocidad", 86);
		
		deck.addCard(Beast);
		deck.addCard(Cyclops);
		deck.addCard(IceMan);
		deck.addCard(Thor);
		deck.addCard(WeakBeast);
		
		p1.setDeck(deck);
		
		c = p1.top();
		assertNotNull(c);
		assertTrue(c.equals(Beast));
		
		c = p1.top();
		assertNotNull(c);
		assertTrue(c.equals(Cyclops));
		
		c = p1.top();
		assertNotNull(c);
		assertTrue(c.equals(IceMan));
		
		c = p1.top();
		assertNotNull(c);
		assertTrue(c.equals(Thor));
		
		c = p1.top();
		assertNotNull(c);
		assertTrue(c.equals(WeakBeast));
		
		c = p1.top();
		assertNull(c);
		
		p1.saveCard(Beast);
		p1.saveCard(Thor);
		p1.saveCard(IceMan);
		
		//Unknown order
		c = p1.top();
		assertNotNull(c);
		
		c = p1.top();
		assertNotNull(c);
		
		c = p1.top();
		assertNotNull(c);
		
		c = p1.top();
		assertNull(c);
		
		c = p1.top();
		assertNull(c);
		
		//We repeat the same.
		
		p1.setDeck(deck);
		assertTrue(p1.hasCards());
		
		
		p1.saveCard(Beast);
		p1.saveCard(Thor);
		p1.saveCard(IceMan);
		
		c = p1.top();
		assertNotNull(c);
		assertTrue(c.equals(Beast));

		c = p1.top();
		assertNotNull(c);
		assertTrue(c.equals(Cyclops));
		
		c = p1.top();
		assertNotNull(c);
		assertTrue(c.equals(IceMan));
		
		c = p1.top();
		assertNotNull(c);
		assertTrue(c.equals(Thor));
		
		c = p1.top();
		assertNotNull(c);
		assertTrue(c.equals(WeakBeast));
		
		//Unknown order
		c = p1.top();
		assertNotNull(c);
		
		c = p1.top();
		assertNotNull(c);
		
		c = p1.top();
		assertNotNull(c);
		
		c = p1.top();
		assertNull(c);
		
		c = p1.top();
		assertNull(c);
	}


	@Test
	public void testEqualsObject() {
		PlayerStrategy gstrat = new RandomStrategy();
		PlayerStrategy gstrat2 = new RandomStrategy();
		Player p1 = new Player("Matt", gstrat);
		Player p2 = new Player("Matt", gstrat);
		Player p3 = new Player("Matt", gstrat2);
		
		assertTrue(p1.equals(p2));
		assertTrue(p1.equals(p3));
	}
	
//	@Test
//	public void testSelectAttribute() {
//		
//	}

}
