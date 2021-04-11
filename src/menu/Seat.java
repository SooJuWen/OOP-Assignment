/*
author : Eric
date : 
file type : superclass
inherits : Business, Economy
 */
package menu;

public abstract class Seat 
{
    protected String sType;
    protected int numPass;
    
    Seat(String ssType, int numPass)
    {
        this.sType = ssType;
        this.numPass = numPass;
    }

    public int getNumPass() {
        return numPass;
    }

    public void setNumPass(int numPass) {
        this.numPass = numPass;
    }
    
    public abstract void setSeatPrice(); //override inside ecomy and business so using abstract
    public abstract double getSeatPrice();

    @Override
    public String toString() {
        return " Seat Type         : " + sType + "\n Quantity of seats : " + numPass;
    }   
}