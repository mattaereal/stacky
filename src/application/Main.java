package application;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Logger;

// @Override hashCode en donde hay equals!

public class Main {
	
	public static void main(String[] args) {
		CardType superheroes = new CardType();
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
		
		Card Wonderwoman = new Card("Wonderwoman", superheroes);
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
		
		Card SilverSurfer = new Card("SilverSurfer", superheroes);
		SilverSurfer.addAttribute("Altura", 184);
		SilverSurfer.addAttribute("Peso", 87);
		SilverSurfer.addAttribute("Fuerza", 750);
		SilverSurfer.addAttribute("Peleas ganadas", 947);
		SilverSurfer.addAttribute("Velocidad", 245);
		
//		Card SilverSurfer = new Card("SilverSurfer", superheroes);
//		SilverSurfer.addAttribute("Altura", 184);
//		SilverSurfer.addAttribute("Peso", 87);
//		SilverSurfer.addAttribute("Fuerza", 750);
//		SilverSurfer.addAttribute("Peleas ganadas", 947);
//		SilverSurfer.addAttribute("Velocidad", 245);
//
//		Card SilverSurfer = new Card("SilverSurfer", superheroes);
//		SilverSurfer.addAttribute("Altura", 184);
//		SilverSurfer.addAttribute("Peso", 87);
//		SilverSurfer.addAttribute("Fuerza", 750);
//		SilverSurfer.addAttribute("Peleas ganadas", 947);
//		SilverSurfer.addAttribute("Velocidad", 245);
//
//		Card SilverSurfer = new Card("SilverSurfer", superheroes);
//		SilverSurfer.addAttribute("Altura", 184);
//		SilverSurfer.addAttribute("Peso", 87);
//		SilverSurfer.addAttribute("Fuerza", 750);
//		SilverSurfer.addAttribute("Peleas ganadas", 947);
//		SilverSurfer.addAttribute("Velocidad", 245);
		
//		CardType supertest = new CardType();
//		supertest.addAttribute("Altura");
//		supertest.addAttribute("Fuerza");
//		supertest.addAttribute("Peso");
//		supertest.addAttribute("Peleas ganadas");
//		supertest.addAttribute("Velocidad");
//		
//		Card batman = new Card("Batman", supertest);
//		batman.addAttribute("Altura", 250);
//		batman.addAttribute("Peso", 200);
//		batman.addAttribute("Fuerza", 50);
//		batman.addAttribute("Peleas ganadas", 45);
//		batman.addAttribute("Velocidad", 45);
//		
//		Card robin = new Card("Robin", supertest);
//		batman.addAttribute("Altura", 250);
//		batman.addAttribute("Peso", 200);
//		batman.addAttribute("Fuerza", 50);
//		batman.addAttribute("Peleas ganadas", 45);
//		batman.addAttribute("Velocidad", 45);
//		
//		Card superman = new Card("Superman", supertest);
//		superman.addAttribute("Fuerza", 2000);
//		superman.addAttribute("Velocidad", 1000);
//		superman.addAttribute("Batallas ganadas", 100);
//		superman.addAttribute("Edad", 50);
//		
//		Card spiderman = new Card("Spiderman", supertest);
//		spiderman.addAttribute("Fuerza", 300);
//		spiderman.addAttribute("Velocidad", 220);
//		spiderman.addAttribute("Batallas ganadas", 30);
//		spiderman.addAttribute("Edad", 27);
//		
//		Card wonderwoman = new Card("Wonderwoman", supertest);
//		wonderwoman.addAttribute("Fuerza", 250);
//		wonderwoman.addAttribute("Velocidad", 200);
//		wonderwoman.addAttribute("Batallas ganadas", 6);
//		wonderwoman.addAttribute("Edad", 40);
//		
//		Card hulk = new Card("Hulk", supertest);
//		hulk.addAttribute("Fuerza", 1500);
//		hulk.addAttribute("Velocidad", 170);
//		hulk.addAttribute("Batallas ganadas", 10);
//		hulk.addAttribute("Edad", 55);
//		
//		Card ironman = new Card("Ironman", supertest);
//		ironman.addAttribute("Fuerza", 250);
//		ironman.addAttribute("Velocidad", 200);
//		ironman.addAttribute("Batallas ganadas", 200);
//		ironman.addAttribute("Edad", 45);
//		
		CardType cars = new CardType();
		cars.addAttribute("RPM");
		cars.addAttribute("Velocidad");
		cars.addAttribute("Kms");
		cars.addAttribute("Año");
		
		Card v8 = new Card("V8 Car", cars);
		v8.addAttribute("RPM", 250);
		v8.addAttribute("Velocidad", 200);
		v8.addAttribute("Kms", 200);
		v8.addAttribute("Año", 45);
//		
//		
//		CompositeCard lj = new CompositeCard("Liga de la Justicia", supertest);
//		lj.addCard(batman);
//		lj.addCard(superman);
//		lj.addCard(wonderwoman);
//		System.out.println("[Test] Agregando una carta que tiene otro ctype:");
//		lj.addCard(v8);
//		
//		CompositeCard avengers = new CompositeCard("Avengers", supertest);
//		avengers.addCard(hulk);
//		avengers.addCard(spiderman);
//		
//		avengers.printAttributes();
//		
//		batman.printAttributes();
//		wonderwoman.printAttributes();
//		
//		lj.printAttributes();
//		lj.addCard(robin);
//		lj.printAttributes();
//		
//		CompositeCard ljav = new CompositeCard("Liga de la Justicia & Avengers", supertest);
//		ljav.addCard(avengers);
//		ljav.addCard(lj);
//		ljav.printAttributes();
//
//		CompositeCard all = new CompositeCard("Liga de la justicia & Avengers & All", supertest);
//		all.addCard(ljav);
//		all.addCard(ironman);
//		all.addCard(hulk);
//		all.addCard(avengers);
//		all.addCard(lj);
//		all.printAttributes();
		
		XStream xstream = new XStream(new StaxDriver());
//		xstream.setMode(XStream.NO_REFERENCES);
//		xstream.alias("Card deck", CardDeck.class);
		
		CardDeck deck = new CardDeck(superheroes);
		deck.addCard(SilverSurfer);
		deck.addCard(Hulk);
		deck.addCard(Wonderwoman);
		deck.addCard(Hulka);
		deck.addCard(Beast);
		deck.addCard(Cyclops);
		deck.addCard(IceMan);
		deck.addCard(Thor);
		
//		try {
//			deck.addCard(v8);
//		} catch(RuntimeException re) {
//			//Logger.error(re.getMessage());
//			//throw new Ex;
//			//System.err.println("error");
//		}
		
		
		String xml = xstream.toXML(deck);
		System.out.println(xml);
		
		CardDeck ddeck = (CardDeck) xstream.fromXML(xml);
		System.out.println(ddeck.toString());
		
		if (ddeck.equals(deck)) {
			System.out.println("Iguales!");
		} else {
			System.out.println("Difieren!");
		}
		
		try {
			File deckfile = new File("/home/matt/workspace/Stacky/decks/deck1.xml");
			
			if (!deckfile.exists()) {
				deckfile.createNewFile();
			}
			
			FileWriter fw = new FileWriter(deckfile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(xml);
			bw.close();
	
			System.out.println("Done");
			
				BufferedReader br = new BufferedReader(new FileReader("/home/matt/workspace/Stacky/decks/deck1.xml"));
			
			String sCurrentLine;
			xml = "";
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				xml += sCurrentLine+"\n";
			}
			
			CardDeck fddeck = (CardDeck) xstream.fromXML(xml);
			System.out.println(fddeck.toString());
			
			if (fddeck.equals(deck)) {
				System.out.println("Iguales!");
			} else {
				System.out.println("Difieren!");
			}
	
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
	}
}
