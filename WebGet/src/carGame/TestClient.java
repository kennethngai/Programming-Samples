/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carGame;

import java.net.*;
import java.io.*;
import java.util.*;

public class TestClient
{
	public static void main(String[] args)  {
    
            
	   try {
	     // this could be changed to an IP name or address other than the localhost
			Socket sock = new Socket("127.0.0.1",6010);
			InputStream instream = sock.getInputStream();
			OutputStream outstream = sock.getOutputStream();
			Scanner in = new Scanner (instream);
			PrintWriter out = new PrintWriter(outstream);	
			System.out.println("Enter In An Action");
                        Scanner keyboard = new Scanner(System.in);
                        String command = keyboard.nextLine();
                        
                        
			out.println(command);
			out.flush();
			while( in.hasNextLine())
			{
				String line = in.nextLine();
				System.out.println(line);
			}
				
			sock.close();
		}
		catch (IOException ioe) {
				System.err.println(ioe);
		}
	}
}
