package cus1156.proj3;

import java.util.Comparator;

/**
 * This allows a collection of Book objects to be sorted by call number
 * @author Bonnie MacKellar
 *
 */
public class CallNumberComparator implements Comparator<Book> {

	@Override
	public int compare(Book book1, Book book2) {
		return (book1.getCallNumber().compareTo(book2.getCallNumber()));
	}

}
