package cus1156.proj3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.DateFormatter;


/**
 * This class represents a Standardbook. A book has a call number, a title, and a due
 * date, author, publisher and publicationDate
 * 
 * @author Bonnie MacKellar
 * @author Sukhjinder Nahal
 * @author Kenneth ngai
 *
 */
public class StandardBook implements Book {
	private LocalDate dueDate=null;
	private String title;
	private String callNumber;
	private String author;
	private String publisher;
	private String publicationDate;
	

	/**
	 * create an empty Book
	 */
	public StandardBook()
	{
       // do nothing constructor
	}
	/**
	 * create a book with a title and call number
	 * 
	 * @param title
	 * @param callNumber
	 */
	public StandardBook(String title, String callNumber) {
		super();
		this.title = title;
		this.callNumber = callNumber;
	}

	
	@Override
	public String getTitle() {
		return title;
	}


	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	
	@Override
	public String getCallNumber() {
		return callNumber;
	}

	
	@Override
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}


	@Override
	public LocalDate getDueDate() {
		return dueDate;
	}

	
	@Override
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
	
	@Override
	public String getAuthor() {
		return author;
	}
	
	
	@Override
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	@Override
	public String getPublisher() {
		return publisher;
	}
	
	
	@Override
	public void setPublisher(String publisher) {
		this.publisher = publisher;
		
	}
	
	
	@Override
	public String getPublicationDate() {
		return publicationDate;
	}
	
	
	@Override
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	/**
	 * Determines if a StandardBook is
	 * checkedout or not.
	 */
	@Override
	public boolean isCheckedout()
	{
		if (dueDate !=null)
				return true;
		else
			return false;
	}

	/**
	 * Allows a Book that is a StandardBook
	 * to be displayed on the console.
	 */
	@Override
	public String toString() {

		String newline = System.getProperty("line.separator");
		StringBuffer buf = new StringBuffer();
		buf.append("--------BOOK--------");
		buf.append(newline);
		buf.append("Title: "+title);
		buf.append(newline);
		buf.append("Call Number: "+callNumber);
		buf.append(newline);
		buf.append("Author: "+author);
		buf.append(newline);
		buf.append("Publisher: "+publisher);
		buf.append(newline);
		buf.append("Publication Date: "+ publicationDate);
		buf.append(newline);
		if (dueDate == null)
			buf.append("not checked out");
		else {
			DateTimeFormatter format = DateTimeFormatter
					.ofPattern("MMM d yyyy");
			String dateStr = dueDate.format(format);
			buf.append("Due on " + dateStr);
		}
		buf.append(newline);
		String str = buf.toString();
		return str;
	}
	
	
	
	public void load(String line) {
		Scanner lineScanner = new Scanner(line);
		lineScanner.useDelimiter(",");
		callNumber = (lineScanner.next());
		title = (lineScanner.next());
		author = (lineScanner.next());
		publisher = (lineScanner.next());
		publicationDate= (lineScanner.next());
		String dateField = lineScanner.next();
		if (dateField.equals("R"))  // returned book
			dueDate=null;
		else
		{
			    DateTimeFormatter formatter =
			                      DateTimeFormatter.ofPattern("MM/dd/yyyy");
			    dueDate = LocalDate.parse(dateField, formatter);
		}
		 lineScanner.close();
		
	}



}
