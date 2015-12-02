package cards;

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

public class CardDeckFactory {
	static Logger logger = Logger.getLogger(Main.class.getName());
	private static BufferedReader br;
	
	public static CardDeck fromFile(String path) {
		try {
			XStream xstream = new XStream(new StaxDriver());
			br = new BufferedReader(new FileReader(path));
			String xml = "";
			String sCurrentLine;
									
			while ((sCurrentLine = br.readLine()) != null) {
				xml += sCurrentLine+"\n";
			}
			
			CardDeck deck = (CardDeck) xstream.fromXML(xml);
			logger.info("Deck loaded from" + path);
			return deck;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static boolean toFile(String path, CardDeck cd) {
		XStream xstream = new XStream(new StaxDriver());
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
