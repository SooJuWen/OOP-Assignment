/*
author : Eric
file type : subclass
inherited from : Seat
 */
package menu;

public  class  Economy extends Seat
{
    private double seatPrice = 0.0;
    
    Economy(String sType, int numPass)
    {
        super(sType, numPass);
    }
    
    @Override
    public void setSeatPrice()
    {
        seatPrice = 5.0;
    };

    @Override
    public double getSeatPrice() 
    {
         return seatPrice;
    }
    
    public String decimalPoint(double price) {
        return String.format("%.2f", price);
    }

    @Override
    public String toString() {
        return super.toString() + "\n Economy Price     : RM" + decimalPoint(seatPrice) + " (per station)";
    }
}