package cus1156.proj3;

import java.io.IOException;
import java.time.LocalDate;

import org.json.simple.parser.ParseException;
/**
 * this is a test class (not a Junit class, just a simple test) to make sure all of the books
 * are read from the file and can be displayed
 * @author Bonnie MacKellar
 * @author Kenneth Ngai
 * @author Sukhjinder Nahal
 *
 */
public class TestBookCollection {
	private static final String FILEPATH="C:\\Users\\snaha815\\workspace\\Programming Project 3\\Books.txt";
	private static String type = "Standard";
	public static void main(String[] args)
	         throws IOException, ParseException
	   { 
		  LocalDate currentDate = LocalDate.now();
	      CheckoutSystem system = new CheckoutSystem(currentDate);
	      system.load(FILEPATH, type);
	      system.listAllStandardBooks();
	   }
}

