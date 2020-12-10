package project;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
/**
   A menu from the vending machine.
*/
public class commandline2
{    
   private Scanner in;
   ArrayList<Property> propertyList = new ArrayList<Property>();
   public commandline2(int ownerNumber)
   {
      in = new Scanner(System.in);
   }

   public void run(Property machine)
         throws IOException
   {
      boolean more = true;
      boolean logged = false;
      login loggedIn = new login("name", "password");
      while (more)
      { 
    	  
    	  
    	  if (logged == false) {
    		  System.out.println("Please Login: (use name 'admin' to log in as an admin. Password: 1234)");
    		  System.out.println("Name");
    		  String name = in.nextLine();
    		  System.out.println("Password");
    		  String password = in.nextLine();
    		  loggedIn = new login(name, password);
    		  logged = true;
    	  }
    	  if(loggedIn.getName().toUpperCase().equals("ADMIN") && loggedIn.getPassword().equals("1234")) {
    		  System.out.println("Admin Logged in");
    		  System.out.println("Command list:\n get property tax \n overdue payments \n Area pay statistics \n enter a different rate \n quit \n");
    		  System.out.println("Type 'help' to show explanation of commands");
    	  }else {
    		  System.out.println("Command list:\n make payment \n add property \n my payments \n property payments \n owner payments \n quit \n");
    		  System.out.println("Type 'help' to show explanation of commands");
    	  }
         String command = in.nextLine();
         switch(command) {
         
         case "make payment":
        
        	 System.out.println("enter ammount and owner");
        	 String payment = in.nextLine();
        	 String[] parts = payment.split(" ");
        	 String ammountStr = parts[0];
             String owner = parts[1];
             double ammount = Double.parseDouble(ammountStr);
             machine.pay(owner, ammount);
             break;
         
         case "add property":
        	 System.out.println("Enter Address, Postcode, Estimated Market Value, Location, Private Residence(yes/no) and owner(s)");
        	 String payment = in.nextLine();
        	 String[] parts = payment.split(" ");
        	 String add = parts[0];
             String post = parts[1];
             String emv = parts[2];
             String loc = parts[3];
             String PR = parts[4];
             String owner = parts[5];
             double estMarketVal = Double.parseDouble(emv);
             Property prop = new Property(add, post, estMarketVal, loc, PR, owner);
             propertyList.add(prop);
             break;
             
         case "my payments":
        	 System.out.println("Your Payments: " );
        	 break;
        	 
         case "property payments": 
          System.out.println("enter address or postcode");
           String property = in.nextLine();
           System.out.println(property);
           /*
           for (int i = 0; i < propertyList.size(); i++) {
        	   Property check = propertyList.get(i);
        	 	System.out.println(check);
            */
            //for(Property p : machine){
                if((machine.address.equals(property)) || (machine.postcode.equals(property))){
                    System.out.println(machine.payments);
                    System.out.println("got here");
                }
            //}
           //}
                break;
         
         case "owner payments":
           System.out.println("enter address or postcode");
           String owners = in.nextLine();  
            for(Property p : propertyList){
                if(p.owners.toString().equals(owners)){
                    System.out.println(p.payments.toString());
                }else {
                	System.out.println("could not find address");
                }
            }
            break;
            
         
         // connect to overdue payments from property once made
         case "overdue payments":         
        	 for (int i = 0; i < OP.length; i++) {
        		 System.out.println(OP[i]);
        	 }
        	 break;
         //do stuff
         case "Area pay statistics":
        	 break;
        	 
         case "test tax changes":         
          for(Property p : propertyList){
        	 System.out.println("enter address or postcode");
             String owners = in.nextLine(); 
            }
           break;
         
         case "help":
          System.out.println("Command list:");
          System.out.println("make payment");
          System.out.println("add property");
          System.out.println("my payments");
          System.out.println("property payments");
          System.out.println("owner payments");
          System.out.println("overdue payments");
          System.out.println("Area pay statistics");
          System.out.println("test tax changes");
          break;
         }
      }
   }
}
