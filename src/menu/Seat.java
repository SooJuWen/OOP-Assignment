/*
author : Eric
file type : superclass
inherits : Business, Economy
 */
package menu;

public abstract class Seat 
{
    protected String sType;
    protected int numPass;
    
    public Seat(String ssType, int numPass)
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
    
    public abstract void setSeatPrice(); //override inside economy and business so using abstract
    public abstract double getSeatPrice();

    @Override
    public String toString() {
        return " Seat Type         : " + sType + "\n Quantity of seats : " + numPass;
    }   
}