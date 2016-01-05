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
import cards.CardType;
import utils.Util;

public class CardTypeFactory {
	static Logger logger = Logger.getLogger(Main.class.getName());
    private static BufferedReader br;
    
    public static CardType fromFile(String name) {
    	String path = Util.ctypepath + name + Util.fileext; 
        try {
            XStream xstream = new XStream(new StaxDriver());
            br = new BufferedReader(new FileReader(path));
            String xml = "";
            String sCurrentLine;
                                    
            while ((sCurrentLine = br.readLine()) != null) {
                xml += sCurrentLine+"\n";
            }
            
            CardType ct = (CardType) xstream.fromXML(xml);
            logger.info("CardType loaded from" + path);
            return ct;
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static boolean toFile(String name, CardType ct) {
    	String path = Util.ctypepath + name + Util.fileext; 
        XStream xstream = new XStream(new StaxDriver());
        String xml = xstream.toXML(ct);
        try {
            File ctfile = new File(path);

            if (!ctfile.exists()) {
                ctfile.createNewFile();
            }
            
            FileWriter fw = new FileWriter(ctfile.getAbsoluteFile());
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
