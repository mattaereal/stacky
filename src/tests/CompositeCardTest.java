package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cards.AbstractCard;
import cards.Card;
import cards.CardType;
import cards.CompositeCard;

public class CompositeCardTest {

	@Test
	public void testAddCard() {
		CardType cars = new CardType();
		cars.addAttribute("RPM");
		cars.addAttribute("Velocidad");
		cars.addAttribute("Kms");
		cars.addAttribute("Año");
		
		AbstractCard card = new Card("Prueba", cars);
		card.addAttribute("RPM", 100);
		card.addAttribute("Velocidad", 220);
		card.addAttribute("Kms", 0);
		card.addAttribute("Año", 2002);
		
		AbstractCard v8 = new Card("V8 Car", cars);
		v8.addAttribute("RPM", 250);
		v8.addAttribute("Velocidad", 200);
		v8.addAttribute("Kms", 200);
		v8.addAttribute("Año", 1945);
		
		CompositeCard compcard = new CompositeCard("Prueba composite", cars);
		assertNull(compcard.getAttribute("Inexistente"));
		assertEquals(new Integer(0), compcard.getAttribute("RPM"));
				
		compcard.addCard(card);
		
		assertNull(compcard.getAttribute("Inexistente"));
		assertNotNull(compcard.getAttribute("RPM"));
		assertEquals(new Integer(100), compcard.getAttribute("RPM"));
		assertEquals(new Integer(100), compcard.getAttribute("rpm"));
		assertEquals(new Integer(220), compcard.getAttribute("Velocidad"));
		assertEquals(new Integer(0), compcard.getAttribute("Kms"));
		assertEquals(new Integer(2002), compcard.getAttribute("Año"));
		
		compcard.addCard(v8);

		assertEquals(new Integer((100+250)/2), compcard.getAttribute("Rpm"));
		assertEquals(new Integer((200+220)/2), compcard.getAttribute("Velocidad"));
		assertEquals(new Integer((200+0)/2), compcard.getAttribute("Kms"));
		assertEquals(new Integer((1945+2002)/2), compcard.getAttribute("Año"));
		
	}
	
	@Test
	public void testDelCard() {
		CardType cars = new CardType();
		cars.addAttribute("RPM");
		cars.addAttribute("Velocidad");
		cars.addAttribute("Kms");
		cars.addAttribute("Año");
		
		AbstractCard card = new Card("Prueba", cars);
		card.addAttribute("RPM", 100);
		card.addAttribute("Velocidad", 220);
		card.addAttribute("Kms", 0);
		card.addAttribute("Año", 2002);
		
		AbstractCard v8 = new Card("V8 Car", cars);
		v8.addAttribute("RPM", 250);
		v8.addAttribute("Velocidad", 200);
		v8.addAttribute("Kms", 200);
		v8.addAttribute("Año", 1945);
		
		CompositeCard compcard = new CompositeCard("Test", cars);
		
		compcard.addCard(card);
		compcard.addCard(v8);
		
		assertEquals(new Integer((100+250)/2), compcard.getAttribute("Rpm"));
		assertEquals(new Integer((200+220)/2), compcard.getAttribute("Velocidad"));
		assertEquals(new Integer((200+0)/2), compcard.getAttribute("Kms"));
		assertEquals(new Integer((1945+2002)/2), compcard.getAttribute("Año"));
		
		
		compcard.delCard("Prueba");
		
		
		assertEquals(new Integer(250), compcard.getAttribute("Rpm"));
		assertEquals(new Integer(200), compcard.getAttribute("Velocidad"));
		assertEquals(new Integer(200), compcard.getAttribute("Kms"));
		assertEquals(new Integer(1945), compcard.getAttribute("Año"));
		
		compcard.delCard("V8 Car");
		
		compcard.printAttributes();
		
		assertEquals(new Integer(0), compcard.getAttribute("Rpm"));
		assertEquals(new Integer(0), compcard.getAttribute("Velocidad"));
		assertEquals(new Integer(0), compcard.getAttribute("Kms"));
		assertEquals(new Integer(0), compcard.getAttribute("Año"));
		
		
		
	}

}
