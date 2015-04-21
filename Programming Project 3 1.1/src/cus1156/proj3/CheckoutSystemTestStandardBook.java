package cus1156.proj3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;


/**
 * This is a test class that tests checking out a Standard Book
 * through the checkout system.
 * @author Bonnie MacKellar
 * @author Kenneth Ngai
 * @author Sukhjinder Nahal
 */

public class CheckoutSystemTestStandardBook {
	
	CheckoutSystem system;
    StandardBook book;
    static final String CALL_NUM = "9780698144545";
    static final String TITLE = "Blood Magic";
    static final String USER_NAME = "Joe";
    static final String type = "Standard";
    private static final String FILEPATH="C:\\Users\\kennethngai\\workspace\\Programming Project 3 1.1\\books.txt";
  
  
    /**
     * Setups the CheckoutSystem that implements the Standard Book Library.
     */
	@Before
	public void setUp() throws Exception {
		system = new CheckoutSystem(LocalDate.now());
		system.load(FILEPATH, type);
	}

	/**
	 * Tests the ability for a user to checkout a book
	 * from the library of Standard Book.
	 */
	
	@Test
	public void testCheckout() {
		CheckoutStatus status = system.checkout(CALL_NUM, USER_NAME);
		UserCheckoutList list = system.find(USER_NAME);
		assertFalse(list.isEmpty());
		assertEquals(status, CheckoutStatus.SUCCESS);
		
	}
	
	/**
	 * Test the ability to show if a book doesn't exist.
	 */
	
	@Test
	public void testCheckoutNoSuchBook() {
		CheckoutStatus status = system.checkout("999", USER_NAME);
		assertEquals(status, CheckoutStatus.NOT_IN_LIBRARY);
		UserCheckoutList list = system.find(USER_NAME);
		assertTrue(list.isEmpty());
	}

	/**
	 * Tests the ability of returning a book to the library.
	 */
	
	@Test
	public void testReturnBook() {
		system.checkout(CALL_NUM, USER_NAME);
		ReturnStatus status = system.returnBook(CALL_NUM, USER_NAME);
		assertEquals(status, ReturnStatus.SUCCESS);
		UserCheckoutList list = system.find(USER_NAME);
		assertTrue(list.isEmpty());
	}
	
	/**
	 * Tests to see if a book is returned. 
	 */
	
	@Test
	public void testReturnBookNotCheckedout() {
		system.checkout(CALL_NUM, USER_NAME);
		ReturnStatus status = system.returnBook("999", USER_NAME);
		assertEquals(status, ReturnStatus.NOT_CHECKEDOUT);
	}
	
	/**
	 * Test the ability to return a book for a user that
	 * doesn't exist. 
	 */
	
	@Test
	public void testReturnBookNoSuchUser() {
		system.checkout(CALL_NUM, USER_NAME);
		ReturnStatus status = system.returnBook(CALL_NUM, "Mary");
		assertEquals(status, ReturnStatus.NO_SUCH_USER);
		UserCheckoutList list = system.find(USER_NAME);
		assertFalse(list.isEmpty());
	}

	/**
	 * Test the ability to find a book off a user's list that
	 * he or she checked out.
	 */
	
	@Test
	public void testFind() {
		system.checkout(CALL_NUM, USER_NAME);
	    UserCheckoutList list = system.find(USER_NAME);
	    assertEquals(list.getUser(), USER_NAME);
	}



}

	
	
