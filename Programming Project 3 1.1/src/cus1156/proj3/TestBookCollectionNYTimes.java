package cus1156.proj3;

import java.io.IOException;
import java.time.LocalDate;

import org.json.simple.*;
import org.json.simple.parser.ParseException;

/**
 * A test class to see if the Library can load up the NYTimes Book Collection from
 * the JSON File.
 * @ Kenneth Ngai
 * @ Sukhjinder Nahal
 *
 */
	
	public class TestBookCollectionNYTimes {
		private static final String FILEPATH="C:\\Users\\snaha815\\workspace\\Programming Project 3\\src\\cus1156\\proj3\\overviewlist.json";
		private static String type = "NYTimes";
		public static void main(String[] args)
		         throws IOException, ParseException
		   { 
			  LocalDate currentDate = LocalDate.now();
		      CheckoutSystem system = new CheckoutSystem(currentDate);
		      system.load(FILEPATH, type);
		      system.listAllNYTimesBooks();
		   }
	}
		
	
