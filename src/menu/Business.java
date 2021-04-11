package menu;

/**
 *
 * @author eric5
 */

public class Business extends Seat
{
    private double p = 0;

    Business()
    {
        
    }
    
    Business(String sType)
    {
        super(sType);
    }
    
    @Override
    public void setSeatPrice()
    {
        p = 10.0;
    };

    @Override
    public double getSeatPrice() {
        return p;
    }

}