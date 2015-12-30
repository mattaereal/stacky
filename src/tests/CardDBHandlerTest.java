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
		
		Card Dazzler = new Card("Dazzler", superheroes);
		Dazzler.addAttribute("Altura", 172);
		Dazzler.addAttribute("Peso", 50);
		Dazzler.addAttribute("Fuerza", 130);
		Dazzler.addAttribute("Peleas ganadas", 856);
		Dazzler.addAttribute("Velocidad", 70);
		
		Card Wonderwoman = new Card("Wonder Woman", superheroes);
		Wonderwoman.addAttribute("Altura", 170);
		Wonderwoman.addAttribute("Peso", 48);
		Wonderwoman.addAttribute("Fuerza", 800);
		Wonderwoman.addAttribute("Peleas ganadas", 815);
		Wonderwoman.addAttribute("Velocidad", 130);
		
		Card Spiderwoman = new Card("Spider Woman", superheroes);
		Spiderwoman.addAttribute("Altura", 176);
		Spiderwoman.addAttribute("Peso", 56);
		Spiderwoman.addAttribute("Fuerza", 315);
		Spiderwoman.addAttribute("Peleas ganadas", 836);
		Spiderwoman.addAttribute("Velocidad", 105);
		
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
		
		Card Daredevil = new Card("Daredevil", superheroes);
		Daredevil.addAttribute("Altura", 250);
		Daredevil.addAttribute("Peso", 103);
		Daredevil.addAttribute("Fuerza", 830);
		Daredevil.addAttribute("Peleas ganadas", 857);
		Daredevil.addAttribute("Velocidad", 120);
		
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
		
		Card Tigra = new Card("Tigra", superheroes);
		Tigra.addAttribute("Altura", 160);
		Tigra.addAttribute("Peso", 60);
		Tigra.addAttribute("Fuerza", 930);
		Tigra.addAttribute("Peleas ganadas", 906);
		Tigra.addAttribute("Velocidad", 180);
		
		Card Angel = new Card("Angel", superheroes);
		Angel.addAttribute("Altura", 192);
		Angel.addAttribute("Peso", 63);
		Angel.addAttribute("Fuerza", 500);
		Angel.addAttribute("Peleas ganadas", 876);
		Angel.addAttribute("Velocidad", 237);
		
		Card Spiderman = new Card("Spiderman", superheroes);
		Spiderman.addAttribute("Altura", 182);
		Spiderman.addAttribute("Peso", 83);
		Spiderman.addAttribute("Fuerza", 500);
		Spiderman.addAttribute("Peleas ganadas", 986);
		Spiderman.addAttribute("Velocidad", 150);
		
		Card Colossus = new Card("Colossus", superheroes);
		Colossus.addAttribute("Altura", 240);
		Colossus.addAttribute("Peso", 123);
		Colossus.addAttribute("Fuerza", 1500);
		Colossus.addAttribute("Peleas ganadas", 915);
		Colossus.addAttribute("Velocidad", 250);
		
		Card Nightwalker = new Card("Nightwalker", superheroes);
		Nightwalker.addAttribute("Altura", 155);
		Nightwalker.addAttribute("Peso", 75);
		Nightwalker.addAttribute("Fuerza", 750);
		Nightwalker.addAttribute("Peleas ganadas", 800);
		Nightwalker.addAttribute("Velocidad", 206);
		
		Card GreenGoblin = new Card("Green Goblin", superheroes);
		GreenGoblin.addAttribute("Altura", 152);
		GreenGoblin.addAttribute("Peso", 60);
		GreenGoblin.addAttribute("Fuerza", 830);
		GreenGoblin.addAttribute("Peleas ganadas", 2);
		GreenGoblin.addAttribute("Velocidad", 205);
		
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
		
		Card Wolverine = new Card("Wolverine", superheroes);
		Wolverine.addAttribute("Altura", 164);
		Wolverine.addAttribute("Peso", 81);
		Wolverine.addAttribute("Fuerza", 900);
		Wolverine.addAttribute("Peleas ganadas", 805);
		Wolverine.addAttribute("Velocidad", 215);
		
		Card Xavier = new Card("Xavier", superheroes);
		Xavier.addAttribute("Altura", 200);
		Xavier.addAttribute("Peso", 90);
		Xavier.addAttribute("Fuerza", 150);
		Xavier.addAttribute("Peleas ganadas", 915);
		Xavier.addAttribute("Velocidad", 50);
		
		Card Mephisto = new Card("Mephisto", superheroes);
		Mephisto.addAttribute("Altura", 180);
		Mephisto.addAttribute("Peso", 82);
		Mephisto.addAttribute("Fuerza", 730);
		Mephisto.addAttribute("Peleas ganadas", 4);
		Mephisto.addAttribute("Velocidad", 137);
		
		Card DrDoom = new Card("Dr. Doom", superheroes);
		DrDoom.addAttribute("Altura", 230);
		DrDoom.addAttribute("Peso", 115);
		DrDoom.addAttribute("Fuerza", 1000);
		DrDoom.addAttribute("Peleas ganadas", 1);
		DrDoom.addAttribute("Velocidad", 185);
		
		Card RedSkull = new Card("Red Skull", superheroes);
		RedSkull.addAttribute("Altura", 190);
		RedSkull.addAttribute("Peso", 90);
		RedSkull.addAttribute("Fuerza", 250);
		RedSkull.addAttribute("Peleas ganadas", 3);
		RedSkull.addAttribute("Velocidad", 37);
		
		Card Dormammu = new Card("Dormammu", superheroes);
		Dormammu.addAttribute("Altura", 200);
		Dormammu.addAttribute("Peso", 100);
		Dormammu.addAttribute("Fuerza", 630);
		Dormammu.addAttribute("Peleas ganadas", 2);
		Dormammu.addAttribute("Velocidad", 150);
		
		Card DrOctopus = new Card("Dr. Octopus", superheroes);
		DrOctopus.addAttribute("Altura", 176);
		DrOctopus.addAttribute("Peso", 90);
		DrOctopus.addAttribute("Fuerza", 750);
		DrOctopus.addAttribute("Peleas ganadas", 4);
		DrOctopus.addAttribute("Velocidad", 42);
				
		Card Loki = new Card("Loki", superheroes);
		Loki.addAttribute("Altura", 280);
		Loki.addAttribute("Peso", 100);
		Loki.addAttribute("Fuerza", 1000);
		Loki.addAttribute("Peleas ganadas", 5);
		Loki.addAttribute("Velocidad", 190);
		
		CompositeCard f4 = new CompositeCard("Fantastic Four", superheroes);
		f4.addCard(MisterFantastic);
		f4.addCard(TheThing);
		f4.addCard(HumanTorch);
		f4.addCard(InvisibleWoman);
		
		CompositeCard avengers = new CompositeCard("The Avengers", superheroes);
		avengers.addCard(Thor);
		avengers.addCard(Hulk);
		avengers.addCard(Hawkeye);
		avengers.addCard(IronMan);
		
		CompositeCard xmen = new CompositeCard("X-Men", superheroes);
		xmen.addCard(Xavier);
		xmen.addCard(Storm);
		xmen.addCard(Wolverine);
		xmen.addCard(Cyclops);
		
		CardDBHandler cdbh = new CardDBHandler();
		cdbh.addCard(Thor);
		cdbh.addCard(IceMan);
		cdbh.addCard(Cyclops);
		cdbh.addCard(Beast);
		cdbh.addCard(Hulka);
		cdbh.addCard(Dazzler);
		cdbh.addCard(Wonderwoman);
		cdbh.addCard(Spiderwoman);
		cdbh.addCard(Hulk);
		cdbh.addCard(SilverSurfer);
		cdbh.addCard(Daredevil);
		cdbh.addCard(Hawkeye);
		cdbh.addCard(InvisibleWoman);
		cdbh.addCard(Storm);
		cdbh.addCard(Tigra);
		cdbh.addCard(Angel);
		cdbh.addCard(Spiderman);
		cdbh.addCard(Colossus);
		cdbh.addCard(Nightwalker);
		cdbh.addCard(GreenGoblin);
		cdbh.addCard(MisterFantastic);
		cdbh.addCard(TheThing);
		cdbh.addCard(HumanTorch);
		cdbh.addCard(Wolverine);
		cdbh.addCard(Xavier);
		cdbh.addCard(IronMan);
		cdbh.addCard(Mephisto);
		cdbh.addCard(DrDoom);
		cdbh.addCard(RedSkull);
		cdbh.addCard(Dormammu);
		cdbh.addCard(DrOctopus);
		cdbh.addCard(Loki);
		cdbh.addCard(avengers);
		cdbh.addCard(f4);
		cdbh.addCard(xmen);

		

		
		CardDeck deck = new CardDeck("Superheroes #1", superheroes);
		deck.addCard(Thor);
		deck.addCard(IceMan);
		deck.addCard(Cyclops);
		deck.addCard(Beast);
		deck.addCard(Hulka);
		deck.addCard(Dazzler);
		deck.addCard(Wonderwoman);
		deck.addCard(Spiderwoman);
		deck.addCard(Hulk);
		deck.addCard(SilverSurfer);
		deck.addCard(Daredevil);
		deck.addCard(Hawkeye);
		deck.addCard(InvisibleWoman);
		deck.addCard(Storm);
		deck.addCard(Tigra);
		deck.addCard(Angel);
		deck.addCard(Spiderman);
		deck.addCard(Colossus);
		deck.addCard(Nightwalker);
		deck.addCard(GreenGoblin);
		deck.addCard(MisterFantastic);
		deck.addCard(TheThing);
		deck.addCard(HumanTorch);
		deck.addCard(Wolverine);
		deck.addCard(Xavier);
		deck.addCard(IronMan);
		deck.addCard(Mephisto);
		deck.addCard(DrDoom);
		deck.addCard(RedSkull);
		deck.addCard(Dormammu);
		deck.addCard(DrOctopus);
		deck.addCard(Loki);
		deck.addCard(avengers);
		deck.addCard(f4);
		deck.addCard(xmen);
	
		
		CardDeck classic = new CardDeck("Classic superheroes", superheroes);
		classic.addCard(Thor);
		classic.addCard(IceMan);
		classic.addCard(Cyclops);
		classic.addCard(Beast);
		classic.addCard(Wonderwoman);
		classic.addCard(Hulk);
		classic.addCard(SilverSurfer);
		classic.addCard(Daredevil);
		classic.addCard(Hawkeye);
		classic.addCard(InvisibleWoman);
		classic.addCard(Storm);
		classic.addCard(Spiderman);
		classic.addCard(Nightwalker);
		classic.addCard(GreenGoblin);
		classic.addCard(MisterFantastic);
		classic.addCard(TheThing);
		classic.addCard(HumanTorch);
		classic.addCard(Wolverine);
		classic.addCard(Xavier);
		classic.addCard(IronMan);
		classic.addCard(DrDoom);
		classic.addCard(DrOctopus);
		classic.addCard(Loki);
		
		
		CardType engines = new CardType("Engines");
		engines.addAttribute("Km/h");
		engines.addAttribute("HP");
		engines.addAttribute("RPM");
		engines.addAttribute("cm³");
		engines.addAttribute("Acel: 0-100 Km/h");
		engines.addAttribute("Cilindros");

		CardDeck cars = new CardDeck("Cars", engines);

		Card reno_fuego = new Card("Renault Fuego", engines);
		reno_fuego.addAttribute("Km/h", 198);
		reno_fuego.addAttribute("HP", 100);
		reno_fuego.addAttribute("RPM", 7000);
		reno_fuego.addAttribute("cm³", 1995);
		reno_fuego.addAttribute("Acel: 0-100 Km/h", (int) (9.8*1000));
		reno_fuego.addAttribute("Cilindros", 4);
		
		Card vw_break = new Card("BW Break", engines);
		vw_break.addAttribute("Km/h", 150);
		vw_break.addAttribute("HP", 76);
		vw_break.addAttribute("RPM", 5000);
		vw_break.addAttribute("cm³", 1798);
		vw_break.addAttribute("Acel: 0-100 Km/h", (int) (16.0*1000));
		vw_break.addAttribute("Cilindros", 4);
		
		Card torino = new Card("Torino", engines);
		torino.addAttribute("Km/h", 200);
		torino.addAttribute("HP", 158);
		torino.addAttribute("Cilindros", 6);
		torino.addAttribute("RPM", 5000);
		torino.addAttribute("Acel: 0-100 Km/h", (int) (10.2*1000));
		torino.addAttribute("cm³", 3770);
		
		Card accord = new Card("Honda Accord 1600", engines);
		accord.addAttribute("Km/h", 163);
		accord.addAttribute("HP", 140);
		accord.addAttribute("Cilindros", 4);
		accord.addAttribute("RPM", 5000);
		accord.addAttribute("Acel: 0-100 Km/h", (int) (13.5*1000));
		accord.addAttribute("cm³", 3500);
		
		Card fiatse1500 = new Card("Fiat Super Europa 1500", engines);
		fiatse1500.addAttribute("Km/h", 160);
		fiatse1500.addAttribute("HP", 82);
		fiatse1500.addAttribute("Cilindros", 4);
		fiatse1500.addAttribute("RPM", 4000);
		fiatse1500.addAttribute("Acel: 0-100 Km/h", (int) (13.5*1000));
		fiatse1500.addAttribute("cm³", 1498);
		
		Card taunus = new Card("Taunus Ghia", engines);
		taunus.addAttribute("Km/h", 165);
		taunus.addAttribute("HP", 114);
		taunus.addAttribute("Cilindros", 4);
		taunus.addAttribute("RPM", 5500);
		taunus.addAttribute("Acel: 0-100 Km/h", (int) (14.0*1000));
		taunus.addAttribute("cm³", 2298);
		
		Card r12b = new Card("Renault 12 Break", engines);
		r12b.addAttribute("Km/h", 155);
		r12b.addAttribute("HP", 74);
		r12b.addAttribute("Cilindros", 4);
		r12b.addAttribute("RPM", 5500);
		r12b.addAttribute("Acel: 0-100 Km/h", (int) (16.1*1000));
		r12b.addAttribute("cm³", 1397);
		
		Card c3cv = new Card("Citroen 3 CV", engines);
		c3cv.addAttribute("Km/h", 113);
		c3cv.addAttribute("HP", 31);
		c3cv.addAttribute("Cilindros", 2);
		c3cv.addAttribute("RPM", 6700);
		c3cv.addAttribute("Acel: 0-100 Km/h", (int) (45.0*1000));
		c3cv.addAttribute("cm³", 602);
		
		Card p404 = new Card("Peugeot 404", engines);
		p404.addAttribute("Km/h", 125);
		p404.addAttribute("HP", 60);
		p404.addAttribute("Cilindros", 4);
		p404.addAttribute("RPM", 4500);
		p404.addAttribute("Acel: 0-100 Km/h", (int) (23.0*1000));
		p404.addAttribute("cm³", 1748);
		
		Card p505 = new Card("Peugeot 505", engines);
		p505.addAttribute("Km/h", 155);
		p505.addAttribute("HP", 96);
		p505.addAttribute("Cilindros", 4);
		p505.addAttribute("RPM", 5000);
		p505.addAttribute("Acel: 0-100 Km/h", (int) (16.4*1000));
		p505.addAttribute("cm³", 1971);
		
		cdbh.addCard(p505);
		cdbh.addCard(p404);
		cdbh.addCard(c3cv);
		cdbh.addCard(r12b);
		cdbh.addCard(taunus);
		cdbh.addCard(fiatse1500);
		cdbh.addCard(accord);
		cdbh.addCard(vw_break);
		cdbh.addCard(torino);
		cdbh.addCard(reno_fuego);
		
		cars.addCard(p505);
		cars.addCard(p404);
		cars.addCard(c3cv);
		cars.addCard(r12b);
		cars.addCard(taunus);
		cars.addCard(fiatse1500);
		cars.addCard(accord);
		cars.addCard(vw_break);
		cars.addCard(torino);
		cars.addCard(reno_fuego);
		
		CardDBHandlerFactory.toFile("db/cards/all.xml", cdbh);
		cdbh.printCards();
		assertTrue(CardDeckFactory.toFile("db/decks/superheroes.xml", deck));
		assertTrue(CardDeckFactory.toFile("db/decks/superheroes_classic.xml", classic));
		assertTrue(CardDeckFactory.toFile("db/decks/cars.xml", cars));
		
		CardDeck filedeck = CardDeckFactory.fromFileWithDB("db/decks/superheroes.xml", "db/cards/all.xml" );
		assertNotNull(filedeck);
		deck.load(cdbh);
		assertTrue(deck.equals(filedeck));
		

	}

}
