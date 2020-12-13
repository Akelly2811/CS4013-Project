package project;
/**
 * holds some of the methods that commandline uses.
 *
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.io.*;
public class propertySystem extends Property
{
    // instance variables - replace the example below with your own
    LocalDate myObj = LocalDate.now();
    propertyTax def = new propertyTax();
    /**
     * initalises defaults
  	*/
    public propertySystem()
    {
    }
    /**
     * initialise local date
  	*/
    public propertySystem(LocalDate a)
    {
        myObj = a;
    }
    /**
     * sets date
  	*/
    public void setDate(LocalDate a)
    {
    	myObj = a;
    }
    /**
     * returns date
  	*/
    public LocalDate getDate()
    {
    	return myObj;
    }
    /**
     * pays for property
  	*/
    public void pay(String payment,String locator, String name, ArrayList<Property> propertyList)
    {
      double ammount = Double.parseDouble(payment);
      for (Property p : propertyList)
      {
        if ((p.getAddress()).equals(locator)|| (p.getPostcode()).equals(locator))
        {
        	p.pay(ammount, locator);
        }
       }
    }
    /**
     * adds a property
  	*/
    public void addProperty(String payment, ArrayList<Property> propertyList )
    {
        String[] parts = payment.split(" ");
        String add = parts[0];
        String post = parts[1];
        String emv = parts[2];
        String loc = parts[3];
        String PR = parts[4];
        boolean pr = false;
        if (PR.contains("y")){pr = true;}
        String owner = parts[5];
        double estMarketVal = Double.parseDouble(emv);
        Property prop = new Property(add, post, estMarketVal, loc, pr);
        owners.add(owner);
        propertyList.add(prop);
        System.out.println("Test");
    }
    /**
     * returns the payments for a property
  	*/
    public void propertyPayments(String property, ArrayList<Property> propertyList)
    {
    	for (Property p : propertyList)
    	{
    		if ((p.address.equals(property)) || (p.postcode.equals(property)))
    		{
    			System.out.println(p.payments);
    		}
    	}
    }
    /**
     * returns the owners payments
  	*/
    public void ownerPayments(String owner, ArrayList<Property> propertyList)
    {
    	for(int i = 0; i < propertyList.size(); i++)
    	{
    		if(propertyList.get(i).getOwner().equals(owner))
    		{
    			System.out.println(propertyList.get(i).paymentsToString());
    		}
    	}
    		    	
    }
    /**
     * returns payments based off postcode
  	*/
    public void areaPayStatistics(String code, ArrayList<Property> propertyList)
    {
    	for (Property p : propertyList)	
    	{
    		if(code.equals((p.postcode).substring(0,3)))
    		{
    			System.out.println(p.payments);
    			System.out.println("got here");
    		}
    	}
    }
    /**
     * tests how different rates change the tax
  	*/
    public void testTaxChange(double tax, double rate,double locationTax,double notPrinciple,double penalty)
    {
    	propertyTax temp = new propertyTax();
    }
    /**
     * returns overdue payments
  	*/
    public void overDuePayments(ArrayList<Property> propertyList)
    {
    	for (Property p : propertyList)
    	{
    		if (p.lastPayment.getYear() < myObj.getYear())
    		{
    			for (Payment q : p.duePayments)
    			{
    				System.out.println(q.toString());
    			}
    		}
    	}
    }
    /**
     * loads in users from a file
  	*/
    public ArrayList<String> LoadUsers() throws IOException 
    {
    		ArrayList<String> temp = new ArrayList<String>();
    		File Input = new File("Users.txt");
    		Scanner in = new Scanner(Input);
    		while(in.hasNextLine())
    		{
    			String uwu = in.nextLine();
    			String[] split = uwu.split(",");
    			for(int i = 0; i < split.length; i++)
    			{
    				temp.add(split[i]);
    			}
    		}
    		
    		in.close();
    		return temp;
    }
    /**
     * loads in properties from a file
  	*/
    public ArrayList<Property> LoadProperties() throws IOException
    {
    	ArrayList<Property> temp = new ArrayList<Property>();
    	File Input = new File("Properties.txt");
    	Scanner in = new Scanner(Input);
    	while(in.hasNextLine())
    	{
    		String x = in.nextLine();
    		String[] split = x.split(",");
    		double y = Double.parseDouble(split[3]);
    		boolean t = Boolean.parseBoolean(split[5]);
    		int i = Integer.parseInt(split[6]);
    		temp.add(new Property(split[0], split[1], split[2], y, split[4], t, i));
    	}
    		in.close();
    		return temp;
    }
    /**
     * loads in payments from a file
  	*/
    public void LoadPayments(ArrayList<Property> propertyList) throws IOException
    {
    	File Input = new File("Payments.txt");
    	Scanner in = new Scanner(Input);
    	while(in.hasNextLine())
    	{
    		String y = in.nextLine();
    		String[] split = y.split(",");
    		double amount = Double.parseDouble(split[0]);
    		String owner = split[1];
    		String Locator = split[2];
    		LocalDate date = LocalDate.parse(split[3]);
    		boolean bool = Boolean.parseBoolean(split[4]);
    		for(int x = 0; x < propertyList.size(); x++)
    		{
    			if(propertyList.get(x).getOwner().equals(owner) && propertyList.get(x).getAddress().equals(Locator))
    			{
    				System.out.println("Test");
    				propertyList.get(x).getPayments().add(new Payment(amount, owner, date, Locator, bool));
    				
    			}
    			else if(propertyList.get(x).getOwner().equals(owner) && propertyList.get(x).getPostcode().equals(Locator))
    			{
    				System.out.println("Test");
    				propertyList.get(x).getPayments().add(new Payment(amount, owner, date, Locator, bool));
    			}

    		}
    		
    	}
    	in.close();
    }
    /**
     * saves data from properties and payments
  	*/
    public void SaveData(ArrayList<Property> propertyList) throws IOException
    {
    	FileWriter Properties = new FileWriter("Properties.txt", true);
    	for(int i = 0; i < propertyList.size(); i ++)
    	{
    		Properties.write(propertyList.get(i).toString() + "\n");
    	}
    	Properties.flush();
    	Properties.close();
    	
    	FileWriter Payments = new FileWriter("Payments.txt", true);
    	for(int x = 0; x < propertyList.size(); x++)
    	{
    		for(int y = 0; y < propertyList.get(x).getPayments().size(); y++)
    		{
    			Payments.write(propertyList.get(x).getPayments().get(y).SaveOutput() + "\n");
    		}
    	}
    	Payments.flush();
    	Payments.close();	
    }
}
