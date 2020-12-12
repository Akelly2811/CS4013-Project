package project;

public class Payment {
	double ammount;
	String owner;
	public Payment(String owner, double ammount) {
		this.ammount = ammount;
		this.owner = owner;
	}
	public String toString() {
        return "Payment{" +
        		"Owner =" + owner +
        		", Ammount =" + ammount +
                '}';
    }
}