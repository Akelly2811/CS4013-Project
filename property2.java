package project;
import java.util.ArrayList;
import java.util.Arrays;
public class property2 {
	String address;
	String postcode;
	double estMarketVal;
	String location;
	String privateResidence;
	int[] owners;
	double fixedTax = 100;
	int paymentNo = 0;
	ArrayList<Payment> payments;
	public void main(String[] args) {
		
	}
	public property2(String address, String postcode, double estMarketVal, String location, String privateResidence, int... owners) {
		this.address = address;
		this.postcode = postcode;
		this.estMarketVal = estMarketVal;
		this.location = location;
		this.privateResidence = privateResidence;
		this.owners = owners;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress(String address) {
		return address;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public String getPostcode(String postcode) {
		return postcode;
	}
	
	public void setEstMarketVal(double estMarketVal) {
		this.estMarketVal = estMarketVal;
	}
	
	public double getEstMarketVal(double estMarketVal) {
		return estMarketVal;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getLocation(String location) {
		return location;
	}
	
	public void setPrivateResidence(String privateResidence) {
		this.privateResidence = privateResidence;
	}
	
	public String getPrivateResidence(String privateResidence) {
		return privateResidence;
	}
	public void setOwners(int[] owners) {
		this.owners = owners;
	}
	
	public int[] getOwners(int[] owners) {
		return owners;
	}
	
	
}