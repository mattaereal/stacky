package cards;

import java.util.Comparator;

public class CardComparator implements Comparator<AbstractCard> {
	
	/**
	 * Compares 2 abstract cards.
	 * @return Returns an int representing whether they are equal.
	 */
	@Override
	public int compare(AbstractCard c1, AbstractCard c2) {
		
		return  c1.getName().compareTo(c2.getName());
	}
}