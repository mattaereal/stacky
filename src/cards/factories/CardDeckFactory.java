package cards.factories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import application.Main;
import cards.CardDBHandler;
import cards.CardDeck;
import utils.Util;

public class CardDeckFactory {
	static Logger logger = Logger.getLogger(Main.class.getName());
	private static BufferedReader br;
	
	/**
	 * Gathers from file a CardDeck. Also loads the cards.
	 * 
	 * @param path Where to retrieve the deck from.
	 * @return CardDeck.
	 */
	public static CardDeck fromFile(String path) {
		return fromFileWithDB(path, null);
	}
	
	/**
	 * Gathers from file a CardDeck. Also loads the cards from
	 * specific  db. It's replicated code, but the intended use
	 * is mainly for tests.
	 * 
	 * @param path Where to retrieve the deck from.
	 * @param db Database name.
	 * @return CardDeck.
	 */
	public static CardDeck fromFileWithDB(String path, String db) {
		path = Util.deckspath + path; 
		try {
			XStream xstream = new XStream(new StaxDriver());
			br = new BufferedReader(new FileReader(path));
			String xml = "";
			String sCurrentLine;
									
			while ((sCurrentLine = br.readLine()) != null) {
				xml += sCurrentLine+"\n";
			}
			
			CardDeck deck = (CardDeck) xstream.fromXML(xml);
			logger.info("Deck loaded from " + path);
			CardDBHandler cdh;
			if (db == null) {
				cdh = CardDBHandlerFactory.fromFile();
			} else {
				cdh = CardDBHandlerFactory.fromFile(db);	
			}
			
			deck.load(cdh);
			return deck;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Saves a deck to an XML file. It also clears the
	 * deck from any actual card, leaving just the uuids.
	 * 
	 * @param path Path where to be saved.
	 * @param cd CardDeck to save.
	 * @return True if it saved correctly. False otherwise.
	 */
	public static boolean toFile(String path, CardDeck cd) {
		path = Util.deckspath + path;
		XStream xstream = new XStream(new StaxDriver());
		cd.clear();
		String xml = xstream.toXML(cd);
		try {
			File deckfile = new File(path);

			if (!deckfile.exists()) {
				deckfile.createNewFile();
			}
			
			FileWriter fw = new FileWriter(deckfile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(xml);
			bw.close();
			
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
