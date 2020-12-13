package project;
/**
 * Keeps Track of payment Data
 *
 * 
 */
import java.time.LocalDate;
public class Payment {
    double ammount;
    String owner;
    LocalDate date;
    String Locator;
    boolean due = true;
    /**
     * initialise based off the values given
  	*/
    public Payment(double ammount, String Locator) 
    {
        this.ammount = ammount;
        this.Locator = Locator;
    }
    /**
     * initialise based off the values given
  	*/
    public Payment(double ammount, String Locator, boolean due) 
    {
        this.ammount = ammount;
        this.due = due;
        this.Locator = Locator;
    }
    /**
     * initialise based off the values given
  	*/
    public Payment(double amount, String owner, LocalDate date, String Locator, boolean due)
    {
    	this.ammount = amount;
    	this.owner = owner;
    	this.date = date;
    	this.Locator = Locator;
    	this.due = due;
    }
    /**
     * initialise based off the values given
  	*/
    public Payment(double amount, boolean due)
    {
    	this.ammount = amount;
    	this.due = due;
    }
    /**
     * returns due payments
  	*/
    public boolean isDue() {
    	return due;
    }
    /**
     * return the payments as a string
  	*/
    public String toString() 
    {
      String temp = "";
      temp = ammount + "," + owner + "," + Locator + "," + date + "," + due;
      return temp;
    }
    /**
     * return the payments as a string
  	*/
    public String SaveOutput() 
    {
      String temp = "";
      temp = ammount + "," + owner + "," + Locator + "," + date + "," + due;
      return temp;
    }

}