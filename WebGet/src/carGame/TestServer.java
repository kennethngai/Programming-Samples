/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carGame;

import java.net.*;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class TestServer
{
  
    public static void main(String[] args)  {
    
            Car[] newList = new Car[5];
        for(int i =0; i< newList.length;i++){
            newList[i] = new Car(50);
        } 
        
        
        try {
       
            
	  ServerSocket sock = new ServerSocket(6010);
	  // now listen for connections
	  while (true) {
	      Socket client = sock.accept();
	      // we have a connection
	     InputStream inStream = client.getInputStream();
             Scanner in = new Scanner(inStream);
	     OutputStream outStream = client.getOutputStream();
                  
                 String secondWord = null;
                        String firstWord = in.next();
                        System.out.print(firstWord);
                        if(in.hasNext("Gas")){
                       secondWord = in.next();
                        }
                  String twoWords = firstWord + " " + secondWord;
                  
      
                       int objectNumber = in.nextInt();
                   
                        
                       int gas = in.nextInt();
                       
                       System.out.println();
            
                   PrintWriter out = new PrintWriter(outStream);
                   
                
                   if(firstWord.equalsIgnoreCase("Drive")){
                       Car newCar = newList[objectNumber];
                       newCar.drive(gas);
                       out.print(newCar.getGas());
                   }
                   else if (twoWords.equalsIgnoreCase("Get Gas")){
                       Car newCar = newList[objectNumber];
                       out.print(newCar.getGas());
                       }
   
                   
                   else if (twoWords.equalsIgnoreCase("Add Gas")) {
                      Car newCar = newList[objectNumber];
                      newCar.addGas(gas);
                      out.print(newCar.getGas());
                   }
                   else{
                       out.println("Invalid command");
                   }
                   
                 
	  
	      out.flush();
                   // close the socket and resume listening for more connections
	    client.close();
			}
		}
		catch (IOException ioe) {
				System.err.println(ioe);
		}
	}
}
