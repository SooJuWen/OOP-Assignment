/*
Author: juwen
Class: DestinationStation
*/

package menu;

public class DestinationStation extends Station{

    public boolean validDtStNum;
    
    public DestinationStation(){
        
    }

    public DestinationStation(int stationNumber, String stationName) {
        super(stationNumber, stationName);
    }
      
    //used to verify the destination station chose by the user
    public boolean verifyDestinationStation(int dtStNum, int dpStNum){
        
        if(dtStNum == dpStNum){
            System.out.println("****************************************************");
            System.out.println("This is your departure station, please choose again!");
            System.out.println("****************************************************");
            
            return false;
        } 
        else if(dtStNum < 1 || dtStNum > 5){
            System.out.println("********************************************");
            System.out.println("Invalid station number, please choose again!");
            System.out.println("********************************************");
            
            return false;
        }
        else
            return true;
    }
    
    //overridding superclass method, used to be displayed when selecting destination station
    public static void showStationList(Station[] stationList, int dpStNum){
        System.out.println();
        System.out.println(" ==================================== ");
        System.out.println("         Destination Station           ");
        System.out.println(" ==================================== ");
        for(int i = 0; i < stationList.length; i++){
            if(dpStNum == (i + 1)){
                System.out.println("   [" + stationList[i].getStationNumber() + "] " + stationList[i].getStationName() + 
                    "\t  (selected)");
            }
            else
                System.out.println("   [" + stationList[i].getStationNumber() + "] " + stationList[i].getStationName());
        }
        System.out.println(" ==================================== ");
    }

    @Override
    public String toString() {
        return "Destination station : " + super.toString() + " station";
    }  
}
