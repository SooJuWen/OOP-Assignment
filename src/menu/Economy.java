package menu;

/**
 *
 * @author eric5
 */
public  class  Economy extends Seat
{
    private double p = 0;

     Economy()
    {
        
    }
    
    Economy(String sType)
    {
        super(sType);
    }
    @Override
    public void setSeatPrice()
    {
        p = 5.0;
    };

    @Override
    public double getSeatPrice() 
    {
         return p;
    }
   
}