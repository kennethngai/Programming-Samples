package cus1156.proj3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * The class test the functionality of a user's checkout list
 * that contains a NYTimesBook. 
 * This also test to see if the methods created for this UserCheckoutList
 * work properly as well.
 * @author Kenneth Ngai
 * @author Sukhjinder Nahal
 *
 */

public class UserCheckoutListTest {
    UserCheckoutList list;
    NYTimesBook book;
    static final String CALL_NUM = "9780698144545";
    static final String TITLE = "BLOOD MAGICK";
    static final String USER_NAME = "Joe";
    
	@Before
	public void setUp() throws Exception {
		list = new UserCheckoutList(USER_NAME);
		book = new NYTimesBook(TITLE, CALL_NUM);
	}

	@Test
	public void testGetUser() {
		assertEquals(list.getUser(), USER_NAME);
	}

	@Test
	public void testAddBook()
	{
		list.addBook(book);
		NYTimesBook b = (NYTimesBook) list.findByCallNumber(CALL_NUM);
		assertEquals(b.getCallNumber(), CALL_NUM);
		assertEquals(b.getTitle(), TITLE);
		assertNull(b.getDueDate());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(list.isEmpty());
		list.addBook(book);
		assertFalse(list.isEmpty());
	}

	@Test
	public void testFindByCallNumber() {
		list.addBook(book);
		NYTimesBook b = (NYTimesBook) list.findByCallNumber(CALL_NUM);
		assertEquals(b.getCallNumber(), CALL_NUM);
		assertEquals(b.getTitle(), TITLE);
	
	}

	@Test
	public void testRemoveBook() {
		list.addBook(book);
		assertEquals(list.removeBook(CALL_NUM), ReturnStatus.SUCCESS);
		assertTrue(list.isEmpty());
		
	}

	@Test
	public void testRemoveBookNotCheckedOut() {
		list.addBook(book);
		assertEquals(list.removeBook("444"), ReturnStatus.NOT_CHECKEDOUT);
		assertFalse(list.isEmpty());
		
	}
	
}
