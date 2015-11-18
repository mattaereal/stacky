package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cards.CardType;

public class CardTypeTest {

	@Test
	public void testAddAttribute() {
		CardType cars = new CardType();
		cars.addAttribute("RPM");
		cars.addAttribute("Velocidad");
		cars.addAttribute("Kms");
		cars.addAttribute("Año");
		
		assertTrue(cars.contains("RPM"));
		assertTrue(cars.contains("Velocidad"));
		assertTrue(cars.contains("Kms"));
		assertTrue(cars.contains("Año"));
		assertTrue(cars.contains("Año"));
		
		assertFalse(cars.contains("Modelo"));
		
	}

	@Test
	public void testContains() {
		CardType cars = new CardType();
		cars.addAttribute("RPM");
		cars.addAttribute("Velocidad");
		
		assertTrue(cars.contains("RPM"));
		assertTrue(cars.contains("VELOCIDAD"));
		assertTrue(cars.contains("rpm"));
		assertTrue(cars.contains("Velocidad"));
		assertTrue(cars.contains("rPm"));
		assertTrue(cars.contains("VeLoCiDad"));
		
		assertFalse(cars.contains(""));
		assertFalse(cars.contains("Velócidad"));
		assertFalse(cars.contains("etc"));
		
	}

	@Test
	public void testEqualsCardType() {
		CardType cars = new CardType();
		cars.addAttribute("RPM");
		cars.addAttribute("Velocidad");
		cars.addAttribute("Kms");
		cars.addAttribute("Año");
		
		CardType carscopy = new CardType();
		carscopy.addAttribute("RPM");
		carscopy.addAttribute("Velocidad");
		carscopy.addAttribute("Kms");
		carscopy.addAttribute("Año");
		
		CardType carsref = cars;
		
		CardType carsless = new CardType();
		carsless.addAttribute("RPM");
		carsless.addAttribute("Velocidad");
		carsless.addAttribute("Año");
		
		CardType carsmore = new CardType();
		carsmore.addAttribute("RPM");
		carsmore.addAttribute("Velocidad");
		carsmore.addAttribute("Kms");
		carsmore.addAttribute("Año");
		carsmore.addAttribute("Modelo");
		
		assertTrue(cars.equals(carscopy));
		assertTrue(carscopy.equals(cars));
		assertTrue(cars.equals(carsref));
		assertTrue(carsref.equals(cars));

		assertFalse(cars.equals(carsless));
		assertFalse(carsless.equals(cars));
		assertFalse(cars.equals(carsmore));
		assertFalse(carsmore.equals(cars));
	}

}
