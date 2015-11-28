package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Player;
import game.strategies.GameStrategy;
import game.strategies.RandomStrategy;

public class PlayerTest {

	@Test
	public void testTop() {
		fail("Not yet implemented");
	}
//
//	@Test
//	public void testSaveCard() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testEqualsObject() {
		GameStrategy gstrat = new RandomStrategy();
		GameStrategy gstrat2 = new RandomStrategy();
		Player p1 = new Player("Matt", gstrat);
		Player p2 = new Player("Matt", gstrat);
		Player p3 = new Player("Matt", gstrat2);
		
		assertTrue(p1.equals(p2));
		assertTrue(p1.equals(p3));
	}

}
