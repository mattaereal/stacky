package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cards.AbstractCard;
import cards.Card;
import cards.CardType;

public class CardTest {

	@Test
	public void testName() {	
		AbstractCard c = new Card("Matt", new CardType());
		assertEquals("Matt", c.getName());
	}
	
	@Test
	public void testCtype() {	
		CardType superheroes = new CardType();
		superheroes.addAttribute("Altura");
		superheroes.addAttribute("Peso");
		superheroes.addAttribute("Fuerza");
		superheroes.addAttribute("Peleas ganadas");
		superheroes.addAttribute("Velocidad");
		AbstractCard c = new Card("Test ctype", superheroes);
		assertEquals(superheroes, c.getCtype());
	}


}
