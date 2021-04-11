/*
Author: juwen
Class: DepartureStation
*/

package menu;

public class DepartureStation extends Station{

    public boolean validDpStNum;
 
    public DepartureStation(){
        
    }

    public DepartureStation(int deptStNum, String deptStName) {
        super(deptStNum, deptStName);
    }
        
    //used to verify the departure station chose by the user
    public boolean verifyDepartureStation(int number){
        
        if(number < 1 || number > 5){
            System.out.println(" *******************************************");
            System.out.println(" Invalid station number, please choose again");
            System.out.println(" *******************************************");
            
            return false;
        }
        else
            return true;
    }
    
    //overridding superclass method, used to be displayed when selecting departure station
    public static void showStationList(Station[] stationList){
        System.out.println();
        System.out.println(" ==================================== ");
        System.out.println("          Departure Station           ");
        System.out.println(" ==================================== ");
        for(int i = 0; i < stationList.length; i++){
            System.out.println("   [" + stationList[i].getStationNumber() + "] " + stationList[i].getStationName());
        }
        System.out.println(" ==================================== ");
    }
    
    @Override
    public String toString() {
        return "Departure station : " + super.toString() + " station";
    }
}