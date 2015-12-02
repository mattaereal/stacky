package utils;

public final class Util {

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
