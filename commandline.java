
/**
 * takes input from the user and outputs the required data.
 *
 * 
 */
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;

public class commandline extends propertySystem
{    
   private Scanner in;
   ArrayList<Property> propertyList = new ArrayList<Property>();
   propertyTax propertyTax = new propertyTax();
   String input;
   String name;
   boolean loggedIn;
   /**
    * runs scanner for commandline
 	*/
   public commandline(int ownerNumber)
   {
      in = new Scanner(System.in);
   }
	/**
    * runs commandline
 	*/
   public void run(propertySystem machine)
         throws IOException
   {
	   propertyList = LoadProperties();
	   LoadPayments(propertyList);
	   ArrayList<String> Login = new ArrayList<String>();
	   Login = LoadUsers();
	   boolean more = true;
	   while (more)
	   { 
    	  while(!loggedIn)
    	  {
    		  System.out.println("Please enter your username or enter 'quit' to exit the program: ");
    		  String name = in.nextLine();
    		  this.name = name;
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
    					  System.out.println("Error, invalid Username");
    					  break;
    				  }
    			  }
    		  }
    	  }
         System.out.println("Command list: \n Make payment \n Add property \n My payments \n Property payments \n Owner payments \n overdue payments \n Area pay statistics \n Test tax change \n Logout");
         System.out.println("type Help to show explanation of commands");
         input = in.nextLine();
         switch (input) 
         {
           case "Make payment":
        	   System.out.println("Enter amount");
        	   String payment = in.nextLine();
        	   System.out.println("Enter Eircode or Address of property you are paying for");
        	   String Locator = in.nextLine();
        	   machine.pay(payment,Locator,name, propertyList);
           break;
           
           case "Add property":
        		   System.out.println("Enter Address, Postcode, Estimated Market Value, Location, Private Residence(yes/no) and owner(s)");
            	   String property = in.nextLine();
            	   machine.addProperty(property, propertyList);
           break;
           
           case "My payments":
        	   machine.ownerPayments(name,propertyList);
           break;
           
           case "Property payments":
        	   if(name.equals("Admin"))
        	   {
        		   System.out.println("enter address or postcode");
        		   String Property = in.nextLine();
        		   System.out.println(Property);
        		   machine.propertyPayments(Property, propertyList);
        	   }
        	   else
        	   {
        		   System.out.println("You do not have Admin privileages, you cannot access this function");        		   
        	   }
           break;
           
           case "Owner payments":
        	   if(name.equals("Admin"))
        	   {
        		   
        		   System.out.println("Enter owner Name");
        		   String owners = in.nextLine();  
        		   machine.ownerPayments(owners,propertyList);
        	   }
        	   else
        	   {
        		   System.out.println("You do not have Admin privileages, you cannot access this function");
        	   }
           break;
           
           case "Overdue payments":
        	   machine.overDuePayments(propertyList);
           break;
           
           case "Area pay statistics":
        	   if(name.equals("Admin"))
        	   {
        		   System.out.println("enter Eircode");
        		   String areaCode = in.nextLine();
        		   System.out.println(areaCode);
        		   machine.areaPayStatistics(areaCode, propertyList);
        	   }
        	   else
        	   {
        		   System.out.println("You do not have Admin privileages, you cannot access this function");
        	   }
           break;
           
           case "Test tax change":
        	   if(name.equals("Admin"))
        	   {
        		   
        		   System.out.println("Input number to get current tax rates: \n 0:tax rate \n 1:rate \n 2:locationTax \n 3:notPrinciple \n 4:penalty");
                   String taxChanges = in.nextLine();
                   int y = Integer.parseInt(taxChanges);
                   System.out.println(propertyTax.getTaxes());
                   
                   System.out.println("Input numbers to set current tax rates: tax rate locationTax notPrinciple penalty (seperate them with a comma; ',')");
                   String x = in.nextLine();
               	   String[] split = x.split(",");
                   double one = Double.parseDouble(split[0]);
                   double two = Double.parseDouble(split[1]);
                   double three = Double.parseDouble(split[2]);
                   double four = Double.parseDouble(split[3]);
                   double five = Double.parseDouble(split[4]);
                   propertyTax.setTaxes(one, two, three, four, five);
                   System.out.println("Done");
                   
                   System.out.println("Get Changed Tax: input number of missed years, the estimated market value, the location and if it is a private residence(true/false). ");
                   String param = in.nextLine();
                   String[] split2 = param.split(",");
                   int one2 = Integer.parseInt(split2[0]);
                   double two2 = Double.parseDouble(split2[1]);
                   boolean three2 = Boolean.parseBoolean(split2[3]);
                   System.out.println(propertyTax.getTax(one2, two2, split2[2], three2));
        	   }
        	   else
        	   {
        		   System.out.println("You do not have Admin privileages, you cannot access this function");
        	   }
           break;
           
           case "Help":
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
        	   	SaveData(propertyList);
           		System.out.println("Logging out, come back soon!");
           		more = false;
           break;
            
         }
      }
   }
}