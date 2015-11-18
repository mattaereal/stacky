package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cards.AbstractCard;
import cards.Card;
import cards.CardType;
import cards.CompositeCard;

public class AbstractCardTest {

	@Test
	public void testAddAttribute() {
		Integer r;
		CardType superheroes = new CardType();
		superheroes.addAttribute("Altura");
		
		AbstractCard c = new Card("Test", superheroes);
		
		c.addAttribute("Altura", 100);
		r = c.getAttribute("Altura"); 
		assertTrue(r.equals(100));
		
		c.addAttribute("Altura", 999);
		r = c.getAttribute("Altura");
		assertTrue(r.equals(999));
		
		c.addAttribute("Velocidad", 90);
		r = c.getAttribute("Velocidad");
		assertNull(r);
		
	}
	
	@Test
	
	public void testGetAttribute() {
		CardType superheroes = new CardType();
		superheroes.addAttribute("Altura");
		AbstractCard c = new Card("Test", superheroes);
		Integer r;
		
		r = c.getAttribute("Test");
		assertNull(r);
		
		r = c.getAttribute("Altura");
		assertTrue(r.equals(0));
		
		
	}

	@Test
	public void testEqualsObject() {
		// Card
		CardType cars = new CardType();
		cars.addAttribute("RPM");
		cars.addAttribute("Velocidad");
		cars.addAttribute("Kms");
		cars.addAttribute("Año");
		
		CardType cars_other = new CardType();
		cars.addAttribute("RPM");
		cars.addAttribute("Velocidad");
		cars.addAttribute("Kms");
		
		AbstractCard card = new Card("Prueba", cars);
		card.addAttribute("RPM", 100);
		card.addAttribute("Velocidad", 220);
		card.addAttribute("Kms", 0);
		card.addAttribute("Año", 2002);
		
		
		AbstractCard card_other = new Card("Prueba", cars_other);
		card_other.addAttribute("RPM", 100);
		card_other.addAttribute("Velocidad", 220);
		card_other.addAttribute("Kms", 0);
		card_other.addAttribute("Año", 2002);
		
		AbstractCard card_copy = new Card("Prueba", cars);
		card_copy.addAttribute("RPM", 100);
		card_copy.addAttribute("Velocidad", 220);
		card_copy.addAttribute("Kms", 0);
		card_copy.addAttribute("Año", 2002);
		
		assertFalse(card.equals(card_other));
		assertFalse(card_other.equals(card));
		
		assertTrue(card.equals(card_copy));
		assertTrue(card_copy.equals(card));
		
		card_other = card;
		assertTrue(card.equals(card));
		assertTrue(card.equals(card_other));
		
		// CompositeCard
		
		Card v8 = new Card("V8 Car", cars);
		v8.addAttribute("RPM", 250);
		v8.addAttribute("Velocidad", 200);
		v8.addAttribute("Kms", 200);
		v8.addAttribute("Año", 45);
		
		CompositeCard compcard = new CompositeCard("Prueba composite", cars);
		compcard.addCard(card);
		compcard.addCard(v8);
		
		CompositeCard compcard_other = new CompositeCard("Prueba composite otro", cars);
		compcard_other.addCard(card);
		compcard_other.addCard(v8);
		
		assertFalse(compcard_other.equals(compcard));
		assertFalse(compcard.equals(compcard_other));
		
		CompositeCard compcard_other_same_name = new CompositeCard("Prueba composite", cars);
		compcard_other_same_name.addCard(card);
		compcard_other_same_name.addCard(v8);
		
		assertTrue(compcard_other_same_name.equals(compcard));
		assertTrue(compcard.equals(compcard_other_same_name));
		
		/* Dos cartas compuestas con el mismo nombre, y mismo promedio
		serán consideradas iguales */
		
		Card v8_i = new Card("V8 Car", cars);
		v8_i.addAttribute("RPM", 100);
		v8_i.addAttribute("Velocidad", 220);
		v8_i.addAttribute("Kms", 0);
		v8_i.addAttribute("Año", 2002);
		
		AbstractCard card_i = new Card("Prueba", cars);
		card_i.addAttribute("RPM", 250);
		card_i.addAttribute("Velocidad", 200);
		card_i.addAttribute("Kms", 200);
		card_i.addAttribute("Año", 45);
		
		CompositeCard compcard_values = new CompositeCard("Prueba composite", cars);
		compcard_values.addCard(card_i);
		compcard_values.addCard(v8_i);
		
		assertTrue(compcard_values.equals(compcard));
		assertTrue(compcard.equals(compcard_values));
		
		compcard_values = compcard;
		assertTrue(compcard_values.equals(compcard));
	}

}
