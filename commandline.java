package project;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
/**
   A menu from the vending machine.
*/
public class commandline
{    
   private Scanner in;
   ArrayList<Property> propertyList = new ArrayList<Property>();
   public commandline(int ownerNumber)
   {
      in = new Scanner(System.in);
   }

   public void run(Property machine)
         throws IOException
   {
      boolean more = true;
      while (more)
      { 
         System.out.println("command list: \n my payments \n property payments \n owner payments \n");
         System.out.println("type help to show explanation of commands");
         String command = in.nextLine();

         if (command.equals("make payment")) {
        	 System.out.println("enter ammount and owner");
        	 String payment = in.nextLine();
        	 String[] parts = payment.split(" ");
        	 String ammountStr = parts[0];
             String owner = parts[1];
             double ammount = Double.parseDouble(ammountStr);
             machine.pay(owner, ammount);
         }else if (command.equals("add property")) {
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
         }if (command.equals("my payments")){
        	 
         }
         else if (command.equals("property payments"))
         { System.out.println("enter address or postcode");
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
         }
         else if (command.equals("owner payments"))
         {  System.out.println("enter address or postcode");
           String owners = in.nextLine();  
            for(Property p : propertyList){
                if(p.owners.toString().equals(owners)){
                    System.out.println(p.payments.toString());
                }else {
                	System.out.println("could not find address");
                }
            }
            
         }
         else if (command.equals("overdue payments"))
         {              
            
         }
         else if (command.equals("Area pay statistics"))
         {  
            
         }
         else if (command.equals("test tax changes"))
         { for(Property p : propertyList){
                
            }
           
         }
          else if (command.equals("help"))
         { 
          System.out.println("figure it out");
         }
      }
   }

   private Object getChoice(Object[] choices)
   {
      while (true)
      {
         char c = 'A';
         for (Object choice : choices)
         {
            System.out.println(c + ") " + choice); 
            c++;
         }
         String input = in.nextLine();
         int n = input.toUpperCase().charAt(0) - 'A';
         if (0 <= n && n < choices.length)
            return choices[n];
      }      
   }
}