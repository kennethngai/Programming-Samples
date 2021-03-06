package cus1156.proj3;
/**
 * Represents all of the books in the library.
 * Books can be added, searched for, and displayed
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class keeps all the standard books in the library in
 * one place.
 * @author Sukhjinder Nahal
 * @author Kenneth Ngai
 *
 */


public class StandardBookCollection extends BookCollection {
    
    /**
     * Display the entire collection as a formatted string
     */
    @Override
    public String toString()
    {
    	String newline = System.getProperty("line.separator");
		StringBuffer buf = new StringBuffer();
		buf.append("Books in the library" + newline);
    	Collection<Book> bookVals = books.values();
    	for (Book book : bookVals)
    	{
    			buf.append(book.toString());
    	}
    	return buf.toString();
    		
    }
    /**
     * Loads the txt file into the system and adds it to the BookCollection
     * @param filepath
     */
    @Override
    public void load(String filepath) throws FileNotFoundException
    {
    	Scanner fileIn = new Scanner(new File(filepath));
		while (fileIn.hasNextLine())
	    {
		 String line = fileIn.nextLine();
		 StandardBook book = new StandardBook();
		 book.load(line);
		 acquire(book);
	    }
		fileIn.close();
    }
	
		
	
}
