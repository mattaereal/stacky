package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cards.CardType;
import cards.factories.CardTypeFactory;
import utils.Util;

public class CardTypeFactoryTest {

	@Test
	public void testToFileFromFile() {
		CardType superheroes = new CardType("Superheroes");
		superheroes.addAttribute("Altura");
		superheroes.addAttribute("Peso");
		superheroes.addAttribute("Fuerza");
		superheroes.addAttribute("Peleas ganadas");
		superheroes.addAttribute("Velocidad");
		
		CardTypeFactory.toFile(superheroes.toString(), superheroes);
		
		CardType superh2 = CardTypeFactory.fromFile("Superheroes");
		
		assertTrue(superh2.equals(superheroes));
	}

}
