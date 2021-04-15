/*
author : Juwen
class type : subclass
inherited from : Station
 */
package menu;

public class DepartureStation extends Station implements DataInput{

    public boolean validDpStNum;
 
    public DepartureStation(){
        
    }

    public DepartureStation(int deptStNum, String deptStName) {
        super(deptStNum, deptStName);
    }
        
    //used to verify the departure station chose by the user
    public boolean verifyDepartureStation(int number){
        
        if(number < 1 || number > 5){
            System.out.println("\n ***************");
            System.out.println(" Invalid station number, please choose again");
            System.out.println(" ***************");
            
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
    public void howToInput() {        
        System.out.println("---Enter a number between 1 and 5----");
    }
    
    @Override
    public String toString() {
        return " Departure station   : " + super.toString() + " station";
    }  
}