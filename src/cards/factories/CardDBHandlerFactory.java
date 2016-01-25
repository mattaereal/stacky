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
import utils.Util;

public class CardDBHandlerFactory {
	static Logger logger = Logger.getLogger(Main.class.getName());
    private static BufferedReader br;
    private static String db = Util.dbpath;
    
	/**
	 * Gathers from file a database handler.
	 * 
	 * @param path Where to retrieve the handler from.
	 * @return CardDBHandler.
	 */
    public static CardDBHandler fromFile(String path) {
        try {
            XStream xstream = new XStream(new StaxDriver());
            br = new BufferedReader(new FileReader(path));
            String xml = "";
            String sCurrentLine;
                                    
            while ((sCurrentLine = br.readLine()) != null) {
                xml += sCurrentLine+"\n";
            }
            
            CardDBHandler cdh = (CardDBHandler) xstream.fromXML(xml);
            logger.info("Deck loaded from " + path);
            return cdh;
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
	/**
	 * Gathers from file a a db handler from the default location.
	 * 
	 * @return CardDBHandler.
	 */
    public static CardDBHandler fromFile() {
    	return fromFile(db);
    }
    
	/**
	 * Saves a db handler to an XML file.
	 * 
	 * @param path Path where to be saved.
	 * @param cdh CardDBHandler to save.
	 * @return True if it saved correctly. False otherwise.
	 */
    public static boolean toFile(String path, CardDBHandler cdh) {
        XStream xstream = new XStream(new StaxDriver());
        String xml = xstream.toXML(cdh);
        try {
            File cdhfile = new File(path);

            if (!cdhfile.exists()) {
                cdhfile.createNewFile();
            }
            
            FileWriter fw = new FileWriter(cdhfile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(xml);
            bw.close();
            
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
	/**
	 * Saves a db handler to an XML file using default location.
	 * 
	 * @param cdh CardDBHandler to be saved.
	 * @return True if it saved correctly. False otherwise.
	 */
    public static boolean toFile(CardDBHandler cdh) {
    	return toFile(db, cdh);
    }
}
