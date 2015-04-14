/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carGame;

public class Car
{  
   private double gasInTank;
   private double mpg;

   /**
      Constructs a car with gas efficiency (miles per gallon).
   */
   public Car(double efficiency)
   {   
      mpg = efficiency;
      gasInTank = 0;
   }

   
   public void addGas(double amount)
   {  
 
	gasInTank = gasInTank + amount;
   }

   
   public void drive(double miles)
   {   
      gasInTank = gasInTank - miles/mpg;
         
   }

   
   public double getGas()
   {   
      return gasInTank;
   }
}
