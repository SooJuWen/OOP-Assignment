/*
author : Eric
file type : subclass
inherited from : Seat
 */
package menu;

public class Business extends Seat implements ChooseNumber
{
    private double seatPrice = 0.0;
    
    public Business(String sType, int numPass)
    {
        super(sType, numPass);
    }
    
    @Override
    public void setSeatPrice()
    {
        this.seatPrice = 10.0;
    };

    @Override
    public double getSeatPrice() {
        return this.seatPrice;
    }
    
    public String decimalPoint(double price) {
        return String.format("%.2f", price);
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n Business Price    : RM" + decimalPoint(seatPrice) + " (per station)";
    }

    @Override
    public void disMsgNumberPass() 
    {
        System.out.println();
        System.out.println("---Enter a number between 1 and 10---");
    }
}