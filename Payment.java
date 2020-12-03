package project;

public class Payment {
	double ammount;
	String owner;
	public Payment(double ammount) {
		this.ammount = ammount;
	}
	public String toString() {
        return "Payment{" +
                "Ammount =" + ammount +
                '}';
    }
}