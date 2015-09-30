package cards;

import java.util.Comparator;

public class CardComparator implements Comparator<AbstractCard> {
	@Override
	public int compare(AbstractCard c1, AbstractCard c2) {
		
		return  c1.getName().compareTo(c2.getName());
	}
}