package cus1156.proj3;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;


/**
 * the checkout and return system. The checkout and return system can checkout
 * books, return books, and list the books checked out by a given user
 * 
 * @author Bonnie MacKellar
 * @author Sukhjinder Nahal
 * @author Kenneth Ngai
 *
 */
public class CheckoutSystem {
	private BookCollection StandardBooks = new StandardBookCollection();
	private BookCollection NYTimesBooks = new NYTimesBookCollection();
	private ArrayList<UserCheckoutList> userLists;
	private LocalDate currentDate;
	private static final int CHECKOUT_PERIOD = 14;

	/**
	 * Constructs a CheckoutSystem object
	 */
	public CheckoutSystem(LocalDate currentDate) {
		
		userLists = new ArrayList<UserCheckoutList>();
		this.currentDate = currentDate;
	}

	/**
	 * checkout a book by adding it to the user's list of checked out books if
	 * the user has never checked out a book before, create a list for him or
	 * her
	 * 
	 * @param callNum
	 *            the call number of the book to be checked out
	 * @param userName
	 *            the name of the user who is checking out the book
	 */
	public CheckoutStatus checkout(String callNum, String userName) {
		UserCheckoutList list = find(userName);
		if (list == null) // user does not have a list yet, so create one
			list = addUserList(userName);
		
		// check if the book exists
		Book theBook = BookCollection.find(callNum);
		
		if (theBook == null)
			return CheckoutStatus.NOT_IN_LIBRARY;
		
		if (theBook.isCheckedout())
			return CheckoutStatus.IS_CHECKEDOUT;
			
		LocalDate dueDate = currentDate.plusDays(CHECKOUT_PERIOD);
		theBook.setDueDate(dueDate);
		list.addBook(theBook);
		return CheckoutStatus.SUCCESS;
	}

	private UserCheckoutList addUserList(String userName) {
		UserCheckoutList newList = new UserCheckoutList(userName);
		userLists.add(newList);
		return newList;
	}

	/**
	 * this removes a returned book from the user's list
	 * 
	 * @param cnum
	 *            the call number
	 * @param userName
	 *            the name of the user
	 * @return 0 if success, -1 if either the user or the book is not found
	 */
	public ReturnStatus returnBook(String cnum, String userName) {
		UserCheckoutList list = find(userName);
		if (list == null) // user does not have a list so return -1
			return ReturnStatus.NO_SUCH_USER;

		return (list.removeBook(cnum));
	}

	/**
	 * Finds a list corresponding to the user or returns null if not found
	 * 
	 * @param user
	 *            the user
	 * @return the list for the user
	 */
	public UserCheckoutList find(String user) {
		for (UserCheckoutList list : userLists)
			if (list.getUser().equals(user))
				return list;

		return null;
	}

	/**
	 * return a string which is a list of all books checked out for a given user, sorted by
	 * call number
	 * @param userName
	 * 
	 */
	public String listBooksForUserSortByCallNumber(String userName) {
		UserCheckoutList list = find(userName);
		if (list == null) // user does not have a list so return -1
			return "This user is not in our system";

		if (list.isEmpty())
			return userName + " has no checked out books";
		list.sortByCallNumber();
		return (list.toString());

	}

	/**
	 * return a string which is a list of all books checked out for a given user, sorted by
	 * title
	 * @param userName
	 */
	public String listBooksForUserSortByTitle(String userName) {
		UserCheckoutList list = find(userName);
		if (list == null) // user does not have a list so return -1
			return "This user is not in our system";

		if (list.isEmpty())
			return userName + " has no checked out books";
		list.sortByTitle();
		return (list.toString());

	}
	
	/**
	 * load the BookCollection from a file
	 * @param filepath
	 * @param type 
	 * @throws ParseException 
	 * @throws IOException 
	 */
	public void load(String filepath, String type)  throws IOException, ParseException {
		BookCollection collection = BookCollectionFactory.getBookCollection(type);
		collection.load(filepath);
}
	
	
	/**
	 * list all books in the StandardBookCollection
	 */
	public void listAllStandardBooks()
	{
		String display = StandardBooks.toString();
		System.out.println(display);
	}
	
	
	/**
	 * list all books in the NYTimesBookCollection
	 */
	public void listAllNYTimesBooks()
	{
		String display = NYTimesBooks.toString();
		System.out.println(display);
	}
}
