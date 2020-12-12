
/**
 * Write a description of class propertyTax here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class propertyTax
{
    double tax = 100;
    double rate = 0.04;
    double locationTax;
    double notPrinciple = 0;
    double penalty = .07;
    
    public propertyTax(double tax, double rate,double locationTax,double notPrinciple,double penalty)
    {
        tax = 100;
        rate = 0.04;
        locationTax = 25;
        notPrinciple = 0;
        penalty = .07;
    }
    
    public propertyTax()
    {
    	
    }
        
    
    public Payment2 getTax(int missedYears, double estMarketVal, String location, boolean privateResidence)
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
        return new Payment2(tax*(penalty*missedYears), true);
    }
}
