package cus1156.proj3;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * A JUnit for making sure the methods NYTimes Book
 * work properly and can become a string.
 * 
 * @author kennethngai
 *
 */

public class NYTimesBookTest {

	
	NYTimesBook book = new NYTimesBook();
	String title = "Gone Girl";
	String author = "Gillian Flynn";
	String callNumber = "9780307588371";
	String Isbn13 = "9780307588371";
	String Isbn10 = "0307588378";
	String description = "Hello World";
	String publisher = "Broadway";
	long bestsellerRank = 1;
	LocalDate dueDate;
	String listName = "Combined Print and E-Book Fiction";
	
	
	@Before
	public void setUp() throws Exception {
		
	book.setTitle(title);
	book.setAuthor(author);
	book.setCallNumber(callNumber);
	book.setIsbn10(Isbn10);
	book.setIsbn13(Isbn13);
	book.setDescription(description);
	book.setPublisher(publisher);
	book.setBestsellerRank(bestsellerRank);
	book.setDueDate(dueDate);
	book.setListName(listName);	
	}
	


	@Test
	public void testGetTitle() {
	String title = book.getTitle();
	assertEquals(title, "Gone Girl");
	}

	@Test
	public void testSetTitle() {
	book.setTitle("Gone Boy");
	assertEquals(book.getTitle(),"Gone Boy");
		
	}

	@Test
	public void testGetCallNumber() {
	String callNumber = book.getCallNumber();
	assertEquals(callNumber,"9780307588371");	
	}

	@Test
	public void testSetCallNumber() {
	book.setCallNumber("123");
	assertEquals(book.getCallNumber(),"123");
	}

	@Test
	public void testGetDueDate() {
	LocalDate dueDate = book.getDueDate();
	assertEquals(dueDate,book.getDueDate());
	}

	@Test
	public void testSetDueDate() {
	
	book.setDueDate(dueDate);
	assertEquals(dueDate,book.getDueDate());
	}

	@Test
	public void testGetAuthor() {
	String author =book.getAuthor();
	assertEquals(author,"Gillian Flynn");		
	}

	@Test
	public void testSetAuthor() {
	String author = "Kanye West";
	book.setAuthor(author);
	assertEquals(author,"Kanye West");
	}

	@Test
	public void testGetPublisher() {
	String publisher = book.getPublisher();
	assertEquals(publisher,"Broadway");
	}

	@Test
	public void testSetPublisher() {
	book.setPublisher("Hello");
	assertEquals(book.getPublisher(),"Hello");
	}

	@Test
	public void testGetDescription() {
	String description = book.getDescription();
	assertEquals(description,"Hello World");
	}

	@Test
	public void testSetDescription() {
	book.setDescription("This Is A Test");
	assertEquals(book.getDescription(), "This Is A Test");
	}

	@Test
	public void testGetIsbn13() {
	String isbn13 =book.getIsbn13();
	assertEquals(isbn13, "9780307588371");
	} 

	@Test
	public void testSetIsbn13() {
	book.setIsbn13("123");
	assertEquals(book.getIsbn13(),"123" );
	}

	@Test
	public void testGetIsbn10() {
	String isbn10 = book.getIsbn10();
	assertEquals(isbn10, "0307588378");
	}

	@Test
	public void testSetIsbn10() {
	book.setIsbn10("123");
	assertEquals(book.getIsbn10(),"123");
	}

	@Test
	public void testGetBestsellerRank() {
	long rank = book.getBestsellerRank();
	assertEquals(rank, 1);
	}

	@Test
	public void testSetBestsellerRank() {
	book.setBestsellerRank(2);
	assertEquals(book.getBestsellerRank(),2);
	}

	@Test
	public void testGetListName() {
	String listName = book.getListName();
	assertEquals(listName,"Combined Print and E-Book Fiction");
	}

	@Test
	public void testSetListName() {
	book.setListName("Faves");
	assertEquals(book.getListName(),"Faves");
		
	}

	@Test
	public void testIsCheckedout() {
	assertEquals(book.isCheckedout(), false);
	}

	@Test
	public void testToString() {
	
	
	assertEquals(book.getTitle().toString(), "Gone Girl");
	assertEquals(book.getAuthor().toString(), "Gillian Flynn");
	assertEquals(book.getCallNumber().toString(),"9780307588371");
	assertEquals(book.getIsbn13().toString(), "9780307588371");
	assertEquals(book.getDescription().toString(),"Hello World");
	}

}
