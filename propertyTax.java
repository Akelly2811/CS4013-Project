

import java.util.ArrayList;

/**
 * Calculates property tax
 *
 * 
 */

public class propertyTax
{
    double tax = 100;
    double rate = 0.04;
    double locationTax;
    double notPrinciple = 0;
    double penalty = .07;
    double tax2 = 0;
    double rate2 = 0;
    double locationTax2;
    double notPrinciple2 = 0;
    double penalty2 = 0;
    
    /**
    * initialise based off the values given
 	*/
    public propertyTax(double tax, double rate,double locationTax,double notPrinciple,double penalty){
        this.tax = tax;
        this.rate = rate;
        this.locationTax = locationTax;
        this.notPrinciple = notPrinciple;
        this.penalty = penalty;
        }
    /**
    * Initialise default values
 	*/
    public propertyTax()
    {
        this.tax = 100;
        this.rate = 0.04;
        this.locationTax = 25;
        this.notPrinciple = 0;
        this.penalty = .07;
        
    }


    /**
    * set the tax rates
 	*/
public void setTaxes(double tax, double rate, double locationTax, double notPrinciple, double penalty) {
	this.tax2 = tax;
    this.rate2 = rate;
    this.locationTax2 = locationTax;
    this.notPrinciple2 = notPrinciple;
    this.penalty2 = penalty;
   }
	/**
	 * returns the default tax rates
	*/
public String getTaxes() {
	String back = tax + "," + rate + "," + locationTax + "," + notPrinciple + "," + penalty;
    return back;
}
	/**
	 * returns the specified tax rates
	*/
    public Payment getTax(int missedYears, double estMarketVal, String location, boolean privateResidence)
    {
        if(estMarketVal < 150000) {
            rate = 0;
        }else if(estMarketVal >= 150000 && estMarketVal < 400000) {
            rate = 0.01;
        }else if(estMarketVal >= 400000 && estMarketVal < 650000) {
            rate = 0.02;
        }
        if(location.equals("City")) {
            locationTax = 100;
        }else if(location.equals("Large town")) {
            locationTax = 80;
        }else if(location.equals("Small town")) {
            locationTax = 60;
        }else if(location.equals("Village")){
            locationTax = 50;
        }
        if(!privateResidence) {
            notPrinciple = 100;
        }
        return new Payment(tax*(penalty*missedYears), true);
    }
    /**
    * to string method
 	*/
    @Override
    public String toString() {
        return "propertyTax{" +
                "tax=" + tax +
                ", rate=" + rate +
                ", locationTax=" + locationTax +
                ", notPrinciple=" + notPrinciple +
                ", penalty=" + penalty +
                '}';
    }
    
}