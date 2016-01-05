package utils;

public final class Util {

	public final static String dbpath = "db/cards/all.xml";
	public final static String ctypepath = "db/types/";
	public final static String deckspath = "db/decks/";
	public final static String fileext = ".xml";
			
	public static String capitalize(String str) {
	    if (str.length() == 0) {
	    	return "";
	    }
	    
	    if (str.length() == 1) {
	    	return str.toUpperCase();
	    }

	    return str.substring(0,1).toUpperCase()
	        + str.substring(1).toLowerCase();

	}
}
