package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cards.Card;
import cards.CardDBHandler;
import cards.CardDeck;
import cards.CardType;
import cards.CompositeCard;
import cards.factories.CardDBHandlerFactory;
import cards.factories.CardDeckFactory;

public class CardDBHandlerTest {

	@Test
	public void mainTest() {
		CardType superheroes = new CardType("Superheroes");
		superheroes.addAttribute("Altura");
		superheroes.addAttribute("Peso");
		superheroes.addAttribute("Fuerza");
		superheroes.addAttribute("Peleas ganadas");
		superheroes.addAttribute("Velocidad");
		
		Card Thor = new Card("Thor", superheroes);
		Thor.addAttribute("Altura", 210);
		Thor.addAttribute("Peso", 103);
		Thor.addAttribute("Fuerza", 1100);
		Thor.addAttribute("Peleas ganadas", 975);
		Thor.addAttribute("Velocidad", 250);
		
		Card IceMan = new Card("Ice man", superheroes);
		IceMan.addAttribute("Altura", 177);
		IceMan.addAttribute("Peso", 65);
		IceMan.addAttribute("Fuerza", 800);
		IceMan.addAttribute("Peleas ganadas", 936);
		IceMan.addAttribute("Velocidad", 100);
		
		Card Cyclops = new Card("Cyclops", superheroes);
		Cyclops.addAttribute("Altura", 189);
		Cyclops.addAttribute("Peso", 74);
		Cyclops.addAttribute("Fuerza", 950);
		Cyclops.addAttribute("Peleas ganadas", 936);
		Cyclops.addAttribute("Velocidad", 130);
		
		Card Beast = new Card("Beast", superheroes);
		Beast.addAttribute("Altura", 183);
		Beast.addAttribute("Peso", 112);
		Beast.addAttribute("Fuerza", 1000);
		Beast.addAttribute("Peleas ganadas", 800);
		Beast.addAttribute("Velocidad", 86);
		
		Card Hulka = new Card("Hulka", superheroes);
		Hulka.addAttribute("Altura", 190);
		Hulka.addAttribute("Peso", 85);
		Hulka.addAttribute("Fuerza", 1500);
		Hulka.addAttribute("Peleas ganadas", 815);
		Hulka.addAttribute("Velocidad", 85);
		
		Card Wonderwoman = new Card("Wonder Woman", superheroes);
		Wonderwoman.addAttribute("Altura", 170);
		Wonderwoman.addAttribute("Peso", 48);
		Wonderwoman.addAttribute("Fuerza", 800);
		Wonderwoman.addAttribute("Peleas ganadas", 815);
		Wonderwoman.addAttribute("Velocidad", 130);
		
		Card Hulk = new Card("Hulk", superheroes);
		Hulk.addAttribute("Altura", 240);
		Hulk.addAttribute("Peso", 450);
		Hulk.addAttribute("Fuerza", 2500);
		Hulk.addAttribute("Peleas ganadas", 997);
		Hulk.addAttribute("Velocidad", 130);
		
		Card SilverSurfer = new Card("Silver Surfer", superheroes);
		SilverSurfer.addAttribute("Altura", 184);
		SilverSurfer.addAttribute("Peso", 87);
		SilverSurfer.addAttribute("Fuerza", 750);
		SilverSurfer.addAttribute("Peleas ganadas", 947);
		SilverSurfer.addAttribute("Velocidad", 245);
		
		Card Hawkeye = new Card("Hawkeye", superheroes);
		Hawkeye.addAttribute("Altura", 197);
		Hawkeye.addAttribute("Peso", 95);
		Hawkeye.addAttribute("Fuerza", 350);
		Hawkeye.addAttribute("Peleas ganadas", 936);
		Hawkeye.addAttribute("Velocidad", 130);
		
		Card Storm = new Card("Storm", superheroes);
		Storm.addAttribute("Altura", 250);
		Storm.addAttribute("Peso", 200);
		Storm.addAttribute("Fuerza", 50);
		Storm.addAttribute("Peleas ganadas", 45);
		Storm.addAttribute("Velocidad", 45);
		
		Card IronMan = new Card("Iron Man", superheroes);
		IronMan.addAttribute("Altura", 190);
		IronMan.addAttribute("Peso", 587);
		IronMan.addAttribute("Fuerza", 930);
		IronMan.addAttribute("Peleas ganadas", 900);
		IronMan.addAttribute("Velocidad", 197);
		
		Card MisterFantastic = new Card("Mister Fantastic", superheroes);
		MisterFantastic.addAttribute("Altura", 186);
		MisterFantastic.addAttribute("Peso", 81);
		MisterFantastic.addAttribute("Fuerza", 120);
		MisterFantastic.addAttribute("Peleas ganadas", 836);
		MisterFantastic.addAttribute("Velocidad", 85);
		
		Card TheThing = new Card("The Thing", superheroes);
		TheThing.addAttribute("Altura", 188);
		TheThing.addAttribute("Peso", 430);
		TheThing.addAttribute("Fuerza", 2100);
		TheThing.addAttribute("Peleas ganadas", 800);
		TheThing.addAttribute("Velocidad", 80);
		
		Card HumanTorch = new Card("Human Torch", superheroes);
		HumanTorch.addAttribute("Altura", 160);
		HumanTorch.addAttribute("Peso", 77);
		HumanTorch.addAttribute("Fuerza", 150);
		HumanTorch.addAttribute("Peleas ganadas", 815);
		HumanTorch.addAttribute("Velocidad", 160);
		
		Card InvisibleWoman = new Card("Invisible Woman", superheroes);
		InvisibleWoman.addAttribute("Altura", 167);
		InvisibleWoman.addAttribute("Peso", 54);
		InvisibleWoman.addAttribute("Fuerza", 105);
		InvisibleWoman.addAttribute("Peleas ganadas", 873);
		InvisibleWoman.addAttribute("Velocidad", 70);
		
		CompositeCard f4 = new CompositeCard("Fantstic Four", superheroes);
		f4.addCard(MisterFantastic);
		f4.addCard(TheThing);
		f4.addCard(HumanTorch);
		f4.addCard(InvisibleWoman);
		
		CompositeCard avengers = new CompositeCard("The Avengers", superheroes);
		avengers.addCard(Thor);
		avengers.addCard(Hulk);
		avengers.addCard(Hawkeye);
		avengers.addCard(IronMan);
		
		CardDBHandler cdbh = new CardDBHandler();
		cdbh.addCard(SilverSurfer);
		cdbh.addCard(Hulk);
		cdbh.addCard(Wonderwoman);
		cdbh.addCard(Hulka);
		cdbh.addCard(Beast);
		cdbh.addCard(Cyclops);
		cdbh.addCard(IceMan);
		cdbh.addCard(Thor);
		cdbh.addCard(SilverSurfer);
		cdbh.addCard(Hawkeye);
		cdbh.addCard(Storm);
		cdbh.addCard(InvisibleWoman);
		cdbh.addCard(HumanTorch);
		cdbh.addCard(TheThing);
		cdbh.addCard(MisterFantastic);
		cdbh.addCard(f4);
		cdbh.addCard(avengers);
		
		CardDBHandlerFactory.toFile("db/cards/test.xml", cdbh);
		cdbh.printCards();
		
		CardDeck deck = new CardDeck("Superheroes #1", superheroes);
		deck.addCard(SilverSurfer);
		deck.addCard(Hulk);
		deck.addCard(Wonderwoman);
		deck.addCard(Hulka);
		deck.addCard(Beast);
		deck.addCard(Cyclops);
		deck.addCard(IceMan);
		deck.addCard(Thor);
		deck.addCard(SilverSurfer);
		deck.addCard(Hawkeye);
		deck.addCard(Storm);
		deck.addCard(InvisibleWoman);
		deck.addCard(HumanTorch);
		deck.addCard(TheThing);
		deck.addCard(MisterFantastic);
		deck.addCard(f4);
		deck.addCard(avengers);
		
		assertTrue(CardDeckFactory.toFile("db/decks/DeckTest1.xml", deck));
		CardDeck filedeck = CardDeckFactory.fromFileWithDB("db/decks/DeckTest1.xml", "db/cards/test.xml" );
		assertNotNull(filedeck);
		deck.load(cdbh);
		assertTrue(deck.equals(filedeck));
		
	}

}
