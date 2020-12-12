package project;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
public class Property {
	String address;
	String postcode;
	double estMarketVal;
	String location;
	String privateResidence;
	ArrayList<String> owners = new ArrayList<>();
	double fixedTax = 100;
	int paymentNo = 0;
	ArrayList<Payment> duePayments = new ArrayList<>();
	ArrayList<Payment> payments = new ArrayList<>();
	LocalDate lastPayment = LocalDate.now();
	public void main(String[] args) {
		
	}
	public Property(String address, String postcode, double estMarketVal, String location, String privateResidence, String ownersStr) {
		this.address = address;
		this.postcode = postcode;
		this.estMarketVal = estMarketVal;
		this.location = location;
		this.privateResidence = privateResidence;
		if (ownersStr.contains(" ")) {
			String[] parts = ownersStr.split(" ");
			for(int i = 0; i < parts.length; i++) {
				owners.add(parts[i]);
			}
		}else {
			owners.add(ownersStr);
		}
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
	public void pay(String address, String ammount) {
		String ammountStr = ammount;
	    double amount = Double.parseDouble(ammountStr);
		payments.add(new Payment(address, amount));
		paymentNo++;
	}
	public String getPropertyTax() {
		String back = "";
		for (int i = 0; i < payments.size(); i++) {
			back = back + payments.get(i);
		}
		return back;
	}
	public String paymentsToString() {
		String payments = "";
		for (int i = 0; i < this.payments.size(); i++) {
			payments = payments + this.payments.get(i).toString();
		}
		return payments;
	}
	/*public String getOwner(String owner){
		int index = payments.indexOf(owner);
		String ownerRet = payments.get(index).owner;
		return ownerRet;
	}*/
	public ArrayList<String> getOwner() {
		return owners;
	}
	public void setAddress(String address) {
        this.address = address;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    
    public String getPostcode() {
        return postcode;
    }
    public ArrayList<String> getOwners() {
        return owners;
    }
    public void setEstMarketVal(double estMarketVal) {
        this.estMarketVal = estMarketVal;
    }
    
    public double getEstMarketVal() {
        return estMarketVal;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setPrivateResidence(String privateResidence) {
        this.privateResidence = privateResidence;
    }
    
    public String getPrivateResidence() {
        return privateResidence;
    }
    /*public ArrayList<Payment2> propertyTax(LocalDate x, propertyTax p) {
            for (int missedYears = lastPayment.getYear() - x.getYear();missedYears > 0; missedYears++){
            duePayments.add(p.getTax(missedYears,estMarketVal,location,privateResidence));
          }
          return duePayments;
    }*/
    
    
}