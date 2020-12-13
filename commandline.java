package project;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
/**
   A menu from the vending machine.
*/
public class commandline extends propertySystem
{    
   private Scanner in;
   ArrayList<property> propertyList = new ArrayList<property>();
   String input;
   String name;
   boolean loggedIn;
   
   public commandline(int ownerNumber)
   {
      in = new Scanner(System.in);
   }

   public void run(propertySystem machine)
         throws IOException
   {
	   LoadProperties();
	   LoadPayments();
	   ArrayList<String> Login = new ArrayList<String>();
	   Login = LoadUsers();
	   boolean more = true;
	   System.out.println("Please enter your username or enter 'quit' to exit the program: ");
		  String name = in.nextLine();
	   while (more)
	   { 
		 
    	  while(!loggedIn)
    	  {
    		  
    		  if(name.equals("quit"))
    		  {
    			  more = false;
    			  loggedIn = true;
    			  break;
    		  }
    		  
    		  for(int i = 0; i < Login.size(); i++)
    		  {
    			  if( name.equals(Login.get(i)))
    			  {
    				  int pos = Login.indexOf(Login.get(i));
    				  if(pos % 2 == 0 || pos == 0)
    				  {
    					  System.out.println("Please enter your password");
    					  String password = in.nextLine();
    					  if(password.equals(Login.get(i+1)) && (pos + 1) % 2 != 0)
    					  {
    						  System.out.println("Login succesful. Welcome " + name +"!");
    						  loggedIn = true;
    					  }
    					  else
    					  {
    						  System.out.println("Error, invalid password");
    						  break;
    					  }
    				  }
    				  else
    				  {
    					  System.out.println("Error, invalid password");
    					  break;
    				  }
    			  }
    		  }
    	  }
         System.out.println("command list: \n make payment \n add property \n my payments \n property payments \n owner payments \n overdue payments \n Area pay Statistics \n Test Tax Changes \n Logout");
         System.out.println("type help to show explanation of commands");
         input = in.nextLine();
         switch (input) 
         {
           case "make payment":
        	   System.out.println("Enter amount");
        	   String payment = in.nextLine();
        	   System.out.println("Enter Eircode of property you are paying for");
        	   String Locator = in.nextLine();
        	   machine.pay(payment,Locator,name);
           break;
           
           case "add property":
        		   System.out.println("Enter Address, Postcode, Estimated Market Value, Location, Private Residence(yes/no) and owner(s)");
            	   String property = in.nextLine();
            	   machine.addProperty(property);
           break;
           
           case "my payments":
        	   machine.ownerPayments(name);
           break;
           
           case "property payments":
        	  if(!name.equals("Admin"))
        	   {
        		   System.out.println("You do not have Admin privileages, you cannot access this function");
        	   }
        	   else
        	   { 
        		   System.out.println("enter address or postcode");
        		   String Property = in.nextLine();
        		   System.out.println(Property);
        		   machine.propertyPayments(Property);
        	  }
           break;
           
           case "owner payments":
        	   if(!name.equals("Admin"))
        	   {
        		   System.out.println("You do not have Admin privileages, you cannot access this function");
        	   }
        	   else
        	   {
        		   System.out.println("enter address or postcode");
        		   String owners = in.nextLine();  
        		   machine.ownerPayments(owners);
        	   }
           break;
           
           case "overdue payments":
        	   machine.overDuePayments();
           break;
           
           case "Area Pay Statistics":
        	   if(!name.equals("Admin"))
        	   {
        		   System.out.println("You do not have Admin privileages, you cannot access this function");
        	   }
        	   else
        	   {
        		   System.out.println("areaCode");
        		   String areaCode = in.nextLine();
        		   System.out.println(areaCode);
        		   machine.areaPayStatistics(areaCode);
        	   }
           break;
           
           case "Test Tax Change":
        	   if(!name.equals("Admin"))
        	   {
        		   System.out.println("You do not have Admin privileages, you cannot access this function");
        	   }
        	   else
        	   {
        	
        	   }
           break;
           
           case "help":
           System.out.println("make payment: add a new payment");
           System.out.println("add property: add a new property (Admin Only)");
           System.out.println("my payments: View your payments");
           System.out.println("property payments: View payments of a specific property (Admin Only)");
           System.out.println("owner payments: View payments of a specific owner (Admin only)");
           System.out.println("overdue payments: View all overdue payments (Admin Only)");
           System.out.println("Area Pay Statistics: View Statistics based on Area code of properties (Admin only)");
           System.out.println("Test Tax Change: Change tax rates to see how it would affect peoples tax payments (Admin only)");
           System.out.println("Logout: Exits the program");
           break;
           
           case "Logout":
        	   	SaveData();
           		System.out.println("Logging out, come back soon!");
           		more = false;
           break;
            
         }
      }
   }
}
