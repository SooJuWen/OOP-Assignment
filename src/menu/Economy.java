/*
author : Eric
file type : subclass
inherited from : Seat
 */
package menu;

public  class  Economy extends Seat implements DataInput
{
    private double seatPrice = 0.0;
    
    public Economy(String sType, int numPass)
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

    @Override
    public void howToInput() 
    {
        System.out.println();
        System.out.println("---Enter a number between 1 and 10---");    
    }    

    
}