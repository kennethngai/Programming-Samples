package cus1156.proj3;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * A Junit Class to test if all the methods 
 * that a Standard Book should have work and works
 * properly.
 * @author Kenneth Ngai
 * @author Sukhjinder Nahal
 *
 */

public class StandardBookTest {

		
	StandardBook book = new StandardBook();
	String title = "Gone Girl";
	String callNumber = "123";
	String author = "Gillian Flynn";
	String publisher = "Broadway";
	LocalDate date;
	

	@Before
	public void setUp() throws Exception {
	book.setTitle(title);
	book.setCallNumber(callNumber);
	book.setAuthor(author);
	book.setPublisher(publisher);
	
	}

	@Test
	public void testGetTitle() {
	String title = book.getTitle();
	assertEquals(title,"Gone Girl");	
	}

	@Test
	public void testSetTitle() {
	book.setTitle("New Girl");
	assertEquals(book.getTitle(),"New Girl");
	}

	@Test
	public void testGetCallNumber() {
	String callnumber = book.getCallNumber();
	assertEquals(callnumber, "123");
	}

	@Test
	public void testSetCallNumber() {
	book.setCallNumber("1234");
	assertEquals(book.getCallNumber(),"1234");
	}

	@Test
	public void testGetDueDate() {
	LocalDate date = book.getDueDate();
	assertEquals(book.getDueDate(), date);
	}

	@Test
	public void testSetDueDate() {
	LocalDate date = null;
	book.setDueDate(date);
	LocalDate dueDate = book.getDueDate();
	assertEquals(book.getDueDate(), dueDate);
	}

	@Test
	public void testGetAuthor() {
	String author = book.getAuthor();
	assertEquals(author, "Gillian Flynn");
	}

	@Test
	public void testSetAuthor() {
	book.setAuthor("Kanye");
	assertEquals(book.getAuthor(), "Kanye");
	}

	@Test
	public void testGetPublisher() {
	String publisher = book.getPublisher();
	assertEquals(publisher, "Broadway");
	}
	
	@Test
	public void testSetPublisher() {
	book.setPublisher("Kinda Funny");
	assertEquals(book.getPublisher(), "Kinda Funny");
	}

	@Test
	public void testIsCheckedout() {
	assertEquals(book.isCheckedout(), false);
	}
	
	@Test
	public void testToString() {
		assertEquals(book.getTitle().toString(), "Gone Girl");
		assertEquals(book.getAuthor().toString(), "Gillian Flynn");
		assertEquals(book.getCallNumber().toString(),"123");
	}


}
