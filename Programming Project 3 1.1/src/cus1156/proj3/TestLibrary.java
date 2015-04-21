package cus1156.proj3;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

public class TestLibrary {
	
	private static String collectionType;
	private static String filepath;
	
	public static void main(String[] args)
	         throws IOException, ParseException
	   { 
		  LocalDate currentDate = LocalDate.now();
	      CheckoutSystem system = new CheckoutSystem(currentDate);
	      loadProps();
	      system.load(filepath, collectionType);
	      CheckoutMenu menu = new CheckoutMenu(currentDate);
	      menu.run(system);
	   }
	
	public static void loadProps()
	{
	
			try {
				Scanner fileIn = new Scanner(new File("C:\\Users\\kennethngai\\workspace\\Programming Project 3 1.1\\props1.txt"));
				
				collectionType = fileIn.nextLine();
				filepath = fileIn.nextLine();
				fileIn.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
	}
}
