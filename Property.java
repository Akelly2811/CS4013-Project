package project;
import java.util.ArrayList;
import java.util.Arrays;
public class Property {
	String address;
	String postcode;
	double estMarketVal;
	String location;
	String privateResidence;
	String[] owners;
	double fixedTax = 100;
	int paymentNo = 0;
	ArrayList<Payment> payments;
	public void main(String[] args) {
		
	}
	public Property(String address, String postcode, double estMarketVal, String location, String privateResidence, String... owners) {
		this.address = address;
		this.postcode = postcode;
		this.estMarketVal = estMarketVal;
		this.location = location;
		this.privateResidence = privateResidence;
		this.owners = owners;
	}
	public double propertyTax(int missedYears) {
		double tax = 0;
		double rate = 0;
		double locationTax = 0;
		double notPrinciple = 0;
		double penalty = 0;
		if(estMarketVal < 150000) {
			rate = 0;
		}else if(estMarketVal >= 150000 && estMarketVal < 400000) {
			rate = 0.01;
		}else if(estMarketVal >= 400000 && estMarketVal < 650000) {
			rate = 0.02;
		}else{
			rate = 0.04;
		}
		if(location.equals("City")) {
			locationTax = 100;
		}else if(location.equals("Large town")) {
			locationTax = 80;
		}else if(location.equals("Small town")) {
			locationTax = 60;
		}else if(location.equals("Village")){
			locationTax = 50;
		}else {
			locationTax = 25;
		}
		if(privateResidence.equals(address) == false) {
			notPrinciple = 100;
		}
		if(missedYears != 0) {
			for (int i = 0; i < missedYears; i++) {
				penalty = penalty + 0.07;
			}
		}
		return tax;
	}
	public void pay(double ammount) {
		payments.add(new Payment(ammount));
		paymentNo++;
	}
	public String getPropertyTax() {
		String back = "";
		for (int i = 0; i < payments.size(); i++) {
			back = back + payments.get(i);
		}
		return back;
	}
}