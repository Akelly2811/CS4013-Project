package project;

/**
 * Keeps track of property data, payments and owners of properties
 *
 * 
 */
import java.util.ArrayList;
import java.time.LocalDate;
public class Property {
	String owner;
    String address;
    String postcode;
    double estMarketVal;
    String location;
    boolean privateResidence;
    final double fixedTax = 100;
    int paymentNo = 0;
    ArrayList<Payment> payments = new ArrayList<Payment>();
    ArrayList<Payment> duePayments = new ArrayList<Payment>();
    int missedYears;
    LocalDate lastPayment = LocalDate.now();
    ArrayList<String> owners = new ArrayList<String>();
    /**
    * initalise defaults
 	*/
    public Property()
    {
    	
    }
    /**
     * initialise based off the values given
  	*/
    public Property(String owner, String address, String postcode, double estMarketVal, String location, boolean privateResidence, int MissedYears) 
    {
        this.owner = owner;
        this.address = address;
        this.postcode = postcode;
        this.estMarketVal = estMarketVal;
        this.location = location;
        this.privateResidence = privateResidence;
        this.missedYears = MissedYears;
        owners.add(owner);
    }
    /**
     * initialise based off the values given
  	*/
    public Property(String address, String postcode, double estMarketVal, String location, String privateResidence, String ownersStr) {
		this.address = address;
		this.postcode = postcode;
		this.estMarketVal = estMarketVal;
		this.location = location;
		if (privateResidence.equals("yes")) {
			this.privateResidence = true;
		}else {
			this.privateResidence = false;
		}
		if (ownersStr.contains(" ")) {
			String[] parts = ownersStr.split(" ");
			for(int i = 0; i < parts.length; i++) {
				owners.add(parts[i]);
			}
		}else {
			owners.add(ownersStr);
		}
	}
    /**
     * initialise based off the values given
  	*/
    public Property(String address, String postcode, double estMarketVal, String location, boolean privateResidence) 
    {
        this.address = address;
        this.postcode = postcode;
        this.estMarketVal = estMarketVal;
        this.location = location;
        this.privateResidence = privateResidence;
    }
    /**
     * initialise based off the values given
  	*/
    public Property(String address, String postcode, double estMarketVal, String location, boolean privateResidence, int MissedYears) 
    {
        this.address = address;
        this.postcode = postcode;
        this.estMarketVal = estMarketVal;
        this.location = location;
        this.privateResidence = privateResidence;
        this.missedYears = MissedYears;
    }
    /**
     * sets address
  	*/
    public void setAddress(String address)
    {
        this.address = address;
    }
    /**
     * return address
  	*/
    public String getAddress()
    {
        return address;
    }
    /**
     * set postcode
  	*/
    public void setPostcode(String postcode) 
    {
        this.postcode = postcode;
    }
    /**
     * return postcode
  	*/
    public String getPostcode() 
    {
        return postcode;
    }
    /**
     * return owners
  	*/
    public ArrayList<String> getOwners() 
    {
        return owners;
    }
    /**
     * set market value
  	*/
    public void setEstMarketVal(double estMarketVal) 
    {
        this.estMarketVal = estMarketVal;
    }
    /**
     * return market value
  	*/
    public double getEstMarketVal() 
    {
        return estMarketVal;
    }
    /**
     * set location
  	*/
    public void setLocation(String location) 
    {
        this.location = location;
    }
    /**
     * return location
  	*/
    public String getLocation() {
        return location;
    }
    /**
     * set private residence
  	*/
    public void setPrivateResidence(boolean privateResidence) 
    {
        this.privateResidence = privateResidence;
    }
    /**
     * return private residence
  	*/
    public boolean getPrivateResidence() 
    {
        return privateResidence;
    }
    /**
     * return payments
  	*/
    public ArrayList<Payment> getPayments()
    {
    	return payments;
    }
    /**
     * set missed years
  	*/
    public void setMissedYears(int newYears)
    {
    	this.missedYears = newYears;
    }
    /**
     * set last Payments
  	*/
    public void setLastPayment(LocalDate date)
    {
    	this.lastPayment = date;
    }
    /**
     * return owner
  	*/
    public String getOwner()
    {
    	return owner;
    }
    /**
     * return an array of owners
  	*/
    public ArrayList<String> getOwnerArray() {
		return owners;
	}
    /**
     * returns property tax
  	*/
    public ArrayList<Payment> PropertyTax(LocalDate x, propertyTax p) 
    {
            for (int missedYears = lastPayment.getYear() - x.getYear();missedYears > 0; missedYears++)
            {
            	duePayments.add(p.getTax(missedYears,estMarketVal,location,privateResidence));
            }
          
            return duePayments;
    }
    /**
     * pays for a property
  	*/
    public void pay(double ammount, String locator) 
    {
        payments.add(new Payment(ammount, locator));
        paymentNo++;
        lastPayment = LocalDate.now();
    }
    /**
     * return property tax
  	*/
    public String getPropertyTax() 
    {
        String back = "";
        for (int i = 0; i < payments.size(); i++) 
        {
            back = back + payments.get(i);
        }
        return back;
    }
    /**
     * return the payments as a string
  	*/
    public String paymentsToString() {
        String payments = "";
        for (int i = 0; i < this.payments.size(); i++) {
            payments = payments + this.payments.get(i).toString();
        }
        return payments;
    }
    /**
     * return the property as a string
  	*/
    public String toString()
    {
    	String temp = "";
    	temp = owner + "," + address + "," + postcode + "," + estMarketVal + "," + location + "," + privateResidence + "," + missedYears + "," + lastPayment + ",";
    	return temp;
    }
}