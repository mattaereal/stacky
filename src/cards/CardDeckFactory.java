package cards;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class CardDeckFactory {
	private static BufferedReader br;
	
	public static CardDeck fromFile(String path) {
		try {
			XStream xstream = new XStream(new StaxDriver());
			br = new BufferedReader(new FileReader(path));
			String xml = "";
			String sCurrentLine;
									
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				xml += sCurrentLine+"\n";
			}
			
			CardDeck deck = (CardDeck) xstream.fromXML(xml);
			System.out.println("Deck loaded from" + path);
			return deck;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void toFile(String path, CardDeck cd) {
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
		
			System.out.println("Deck saved at " + path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
