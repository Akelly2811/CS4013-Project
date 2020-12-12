 
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDate;
public class property3 {
	String owner;
    String address;
    String postcode;
    double estMarketVal;
    String location;
    boolean privateResidence;
    final double fixedTax = 100;
    int paymentNo = 0;
    ArrayList<Payment2> payments = new ArrayList<Payment2>();
    ArrayList<Payment2> duePayments = new ArrayList<Payment2>();
    int missedYears;
    LocalDate lastPayment = LocalDate.now();
    ArrayList<String> owners = new ArrayList<String>();
    
    public property3()
    {
    	
    }
    
    public property3(String address, String postcode, double estMarketVal, String location, boolean privateResidence) 
    {
        this.address = address;
        this.postcode = postcode;
        this.estMarketVal = estMarketVal;
        this.location = location;
        this.privateResidence = privateResidence;
    }
    
    public property3(String address, String postcode, double estMarketVal, String location, boolean privateResidence, int MissedYears) 
    {
        this.address = address;
        this.postcode = postcode;
        this.estMarketVal = estMarketVal;
        this.location = location;
        this.privateResidence = privateResidence;
        this.missedYears = MissedYears;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public void setPostcode(String postcode) 
    {
        this.postcode = postcode;
    }
    
    public String getPostcode() 
    {
        return postcode;
    }
    public ArrayList<String> getOwners() 
    {
        return owners;
    }
    public void setEstMarketVal(double estMarketVal) 
    {
        this.estMarketVal = estMarketVal;
    }
    
    public double getEstMarketVal() 
    {
        return estMarketVal;
    }
    
    public void setLocation(String location) 
    {
        this.location = location;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setPrivateResidence(boolean privateResidence) 
    {
        this.privateResidence = privateResidence;
    }
    
    public boolean getPrivateResidence() 
    {
        return privateResidence;
    }
    
    public ArrayList<Payment2> getPayments()
    {
    	return payments;
    }
    
    public void setMissedYears(int newYears)
    {
    	this.missedYears = newYears;
    }
    
    public void setLastPayment(LocalDate date)
    {
    	this.lastPayment = date;
    }
    
    public String getOwner()
    {
    	return owner;
    }
    
    public ArrayList<Payment2> propertyTax(LocalDate x, propertyTax p) 
    {
            for (int missedYears = lastPayment.getYear() - x.getYear();missedYears > 0; missedYears++)
            {
            	duePayments.add(p.getTax(missedYears,estMarketVal,location,privateResidence));
            }
          
            return duePayments;
    }
    
    public void pay(double ammount, String locator) 
    {
        payments.add(new Payment2(ammount, locator));
        paymentNo++;
        lastPayment = LocalDate.now();
    }
    
    public String getPropertyTax() 
    {
        String back = "";
        for (int i = 0; i < payments.size(); i++) 
        {
            back = back + payments.get(i);
        }
        return back;
    }
    
    public String toString()
    {
    	String temp = "";
    	temp = owner + "," + address + "," + postcode + "," + estMarketVal + "," + location + "," + privateResidence + "," + missedYears + "," + lastPayment + ",";
    	return temp;
    }
}