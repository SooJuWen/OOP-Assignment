package menu;

/**
 *
 * @author eric5
 */
public abstract class Seat 
{
    protected String seatType = "";
    protected Double seatPrice;
    private static int seatCount = 0; //because keep update so use static
    private int sNo = 0;
   // private String seatID = "";
    private String sType = "";
    
    Seat()
    {
    }
    
    Seat(String ssType)
    {
       // seatID = ssID;
        sType = ssType;
        seatCount++;
    }
    
    
    
//    public void setSeatID(int seatNo) // see how many passenger ticket needed, for loop each pass = 1 id 
//    {
//        sNo = seatNo;
//    }
//    
//    public int getSeatID() //return id in string with S represent as seatID infront
//    {
//        return sNo;
//    }
    
    
    public abstract void setSeatPrice(); //override inside ecomy and business so using abstract
    public abstract double getSeatPrice();

    public int getTotalSeatUsed()
    {
        return seatCount;
    }
    
}


