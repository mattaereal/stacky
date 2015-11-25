package game;

import java.util.concurrent.ThreadLocalRandom;

import cards.AbstractCard;
import cards.CardDeck;

public class Game {
	
	private CardDeck deck;
	private Player p1, p2, winner;
	private GameCriterion gcrit;
	
	public Game(Player p1, Player p2, CardDeck cd, GameCriterion gCrit) {
		this.deck = cd;
		this.gcrit = gCrit;
		this.p1 = p1;
		this.p2 = p2;
	}
	

	public void setup() {
		deal(); //bajara + repartir
		// algo más?
	}
	
	private void deal() {
		deck.shuffle();
		deck.split(p1, p2);
	}
	
	public void start() {
		setup();
		play();
		showWinner();
	}
	
	
	private void play() {
		int min = 0;
		int max = 100;
		int rand = min + (int)(Math.random() * ((max - min) + 1));
		Player last_winner;
		
		if (rand < 50) {
			last_winner = p1;
		} else {
			last_winner = p2;
		}
		
		last_winner = hand(last_winner, p1, p2, gcrit);
		
		while (p1.hasCards() && p2.hasCards()) {
			last_winner = hand(last_winner, p1, p2, gcrit);
		}	
		
		if (p1.hasCards()) {
			winner = p1;
		} else {
			winner = p2;
		}
		
	}
	
	private Player hand(Player turn, Player p1, Player p2, GameCriterion gc) {
		String attribute = null;
		AbstractCard c1 = p1.top();
		AbstractCard c2 = p2.top();
		AbstractCard cr = null;
		
		if (turn.equals(p1)) {
			attribute = p1.selectAttribute();
		} else {
			attribute = p2.selectAttribute();
		}
			
		// ver que pasa cuando son iguales
		// se tienen que ir acumulando las cartas
		cr = gc.fight(c1, c2, attribute);
		
		if (cr.equals(c1)) {
			//darle las cartas
			return p1;
		} else {
			//darle las cartas
			return p2;
		}
	}
	
	private void showWinner() {
		System.out.println(winner);
	}
	
//	public boolean equals() {
//		
//	}
//	
//	private int hashCode() {
//		
//	}
}
