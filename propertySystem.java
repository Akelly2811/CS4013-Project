import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.io.*;
public class propertySystem extends property3
{
    // instance variables - replace the example below with your own
    ArrayList<property3> propertyList = new ArrayList<property3>();
    LocalDate myObj = LocalDate.now();
    propertyTax def = new propertyTax();
    public propertySystem()
    {
    }
    public propertySystem(LocalDate a)
    {
        myObj = a;
    }
    public void setDate(LocalDate a)
    {
    	myObj = a;
    }
    public LocalDate getDate()
    {
    	return myObj;
    }
     
    public void pay(String payment,String locator, String name)
    {
      double ammount = Double.parseDouble(payment);
      for (property3 p : propertyList)
      {
        if ((p.getAddress()).equals(locator)|| (p.getPostcode()).equals(locator))
        {
        	p.pay(ammount, locator);
        }
       }
    }
    
    public void addProperty(String payment)
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
        property3 prop = new property3(add, post, estMarketVal, loc, pr);
        owners.add(owner);
        propertyList.add(prop);
        System.out.println("Test");
    }
    
    public void propertyPayments(String property)
    {
    	for (property3 p : propertyList)
    	{
    		if ((p.address.equals(property)) || (p.postcode.equals(property)))
    		{
    			System.out.println(p.payments);
    		}
    	}
    }
    
    public void ownerPayments(String owner)
    {
    	for (property3 p : propertyList)
    	{
    		if (p.owners.contains(owner))
    		{
    			System.out.println(p.payments);
    			System.out.println("Success");
    		}
    		System.out.println("uwu");
    	}
    }
    
    public void areaPayStatistics(String code)
    {
    	for (property3 p : propertyList)	
    	{
    		if(code.equals((p.postcode).substring(0,3)))
    		{
    			System.out.println(p.payments);
    			System.out.println("got here");
    		}
    	}
    }
    
    public void testTaxChange(double tax, double rate,double locationTax,double notPrinciple,double penalty)
    {
    	propertyTax temp = new propertyTax(tax,rate,locationTax,notPrinciple,penalty);
    }
    
    public void overDuePayments()
    {
    	for (property3 p : propertyList)
    	{
    		if (p.lastPayment.getYear() < myObj.getYear())
    		{
    			for (Payment2 q : p.duePayments)
    			{
    				System.out.println(q.toString());
    			}
    		}
    	}
    }
    
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
    
    public ArrayList<property3> LoadProperties() throws IOException
    {
    	ArrayList<property3> temp = new ArrayList<property3>();
    	File Input = new File("Properties.txt");
    	Scanner in = new Scanner(Input);
    	while(in.hasNextLine())
    	{
    		String x = in.nextLine();
    		String[] split = x.split(",");
    		double y = Double.parseDouble(split[3]);
    		boolean t = Boolean.parseBoolean(split[5]);
    		int i = Integer.parseInt(split[6]);
    		temp.add(new property3(split[1], split[2], y, split[4], t, i));
    		owners.add(split[0]);
    	}
    		in.close();
    		return temp;
    }
    
    public void LoadPayments() throws IOException
    {
    	File Input = new File("Properties.txt");
    	Scanner in = new Scanner(Input);
    	while(in.hasNextLine())
    	{
    		String y = in.nextLine();
    		String[] split = y.split(",");
    		double amount = Double.parseDouble(split[0]);
    		String owner = split[1];
    		String Locator = split[3];
    		LocalDate date = LocalDate.parse(split[3]);
    		boolean bool = Boolean.parseBoolean(split[4]);
    		for(int x = 0; x < propertyList.size(); x++)
    		{
    			if(propertyList.get(x).getOwner().equals(owner) && ( propertyList.get(x).getAddress().equals(Locator) || propertyList.get(x).getPostcode().equals(Locator)))
    			{
    				propertyList.get(x).getPayments().add(new Payment2(amount, owner, date, Locator, bool));
    			}
    		}
    		
    	}
    	in.close();
    }
    
    public void SaveData() throws IOException
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
    			Payments.write(propertyList.get(x).getPayments().get(y).toString() + "\n");
    		}
    	}
    	Payments.flush();
    	Payments.close();	
    }
}
