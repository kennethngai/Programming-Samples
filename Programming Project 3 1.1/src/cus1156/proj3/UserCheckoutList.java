package cus1156.proj3;

import java.util.ArrayList;
import java.util.Collections;

/**
 * this class represents a list of books checked out by a library user it
 * contains the name of the user and a list of Book objects
 * 
 * @author Bonnie MacKellar
 *
 */
public class UserCheckoutList {
	private String user;
	private ArrayList<Book> checkoutBooks;

	/**
	 * Constructs a user checkout list object.
	 * 
	 * @param person
	 *            the owner
	 */
	public UserCheckoutList(String person) {
		user = person;
		checkoutBooks = new ArrayList<Book>();
	}

	/**
	 * Gets the user name
	 * 
	 * @returns the name of the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Adds a book to the list.
	 * 
	 * @param book
	 *            a Book object
	 */
	public void addBook(Book book) {
		checkoutBooks.add(book);
	}

	/**
	 * tests if the list is empty
	 * 
	 * @return true if the list contains no books, false otherwise
	 */
	public boolean isEmpty() {
		if (checkoutBooks.size() == 0)
			return true;
		else
			return false;
	}

	/**
	 * finds a particular book by its call number
	 * 
	 * @return the matching Book object or null if not found
	 */

	public Book findByCallNumber(String cnum) {

		for (Book curr : checkoutBooks) {
			if (curr.getCallNumber().equals(cnum))
				return curr;
		}
		// not found
		return null;
	}

	/**
	 * removes a book from the list, given its call number
	 * 
	 * @return 0 if the book is found and removed, -1 if the book is not on the
	 *         list
	 */
	public ReturnStatus removeBook(String cnum) {
		Book book = findByCallNumber(cnum);
		if (book == null) // not found
			return ReturnStatus.NOT_CHECKEDOUT;
		book.setDueDate(null);  // when a book is not checked out, it has a null due date
		checkoutBooks.remove(book);
		return ReturnStatus.SUCCESS;
	}

	/**
	 * return a formatted string, suitable for display, that contains
	 * information about the UserCheckoutList object, in particular, a list of
	 * books checked out by the user
	 */
	public String toString() {
		String newline = System.getProperty("line.separator");
		StringBuffer buf = new StringBuffer();
		buf.append("Checked out books for " + user + newline);
		for (Book book : checkoutBooks)
			buf.append(book.toString());

		return buf.toString();
	}

	/**
	 * Sorts the BookCollection by Call number 
	 */
	public void sortByCallNumber() {
		Collections.sort(checkoutBooks,new CallNumberComparator());
		
	}

	/**
	 * Sorts the BookCollection by Title
	 */
	public void sortByTitle() {
		Collections.sort(checkoutBooks,new TitleComparator());
		
	}
}
