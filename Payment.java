 
import java.time.LocalDate;
public class Payment2 {
    double ammount;
    String owner;
    LocalDate date;
    String Locator;
    boolean due;
    public Payment2(double ammount, String Locator) 
    {
        this.ammount = ammount;
        this.Locator = Locator;
    }
    public Payment2(double ammount, String Locator, boolean due) 
    {
        this.ammount = ammount;
        this.due = due;
        this.Locator = Locator;
    }
    
    public Payment2(double amount, String owner, LocalDate date, String Locator, boolean due)
    {
    	this.ammount = amount;
    	this.owner = owner;
    	this.date = date;
    	this.Locator = Locator;
    	this.due = due;
    }
    
    public Payment2(double amount, boolean due)
    {
    	this.ammount = amount;
    	this.due = due;
    }
    
    public String toString() 
    {
      String temp = "";
      temp = ammount + "," + owner + "," + Locator + "," + date + "," + due;
      return temp;
    }
}