/*
Author: juwen
Class: Station
*/

package menu;

public class Station {
    
    private int stationNumber;
    private String stationName;
    private boolean isOpen;
    
    public Station(){
        
    }
    
    public Station(int stationNumber, String stationName){
        this.stationNumber = stationNumber;
        this.stationName = stationName;
    }

    public Station(int stationNumber, String stationName, boolean isOpen) {
        this.stationNumber = stationNumber;
        this.stationName = stationName;
        this.isOpen = isOpen;
    }

    public int getStationNumber() {
        return stationNumber;
    }

    public void setStationNumber(int stationNumber) {
        this.stationNumber = stationNumber;
    }
   
    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getIsOpen() {
        if(this.isOpen == true)
            return "Open";
        else
            return "Closed";     
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
    
    //show the station list and their status
    public static void showStationList(Station[] stationList){
        System.out.println();
        System.out.println(" ==================================== ");
        System.out.println("            Stations List             ");
        System.out.println(" ==================================== ");
        System.out.println("      Station\t\t  Status ");
        System.out.println("     ---------\t\t  ------- ");
        for(int i = 0; i < stationList.length; i++){
            System.out.println("   [" + stationList[i].getStationNumber() + "] " + stationList[i].getStationName() +
                "\t\t   " + stationList[i].getIsOpen());
        }
        System.out.println(" ==================================== ");
    }
    
    //show the route
    public static void showRoute(){
        System.out.println(" =========================================== ");
        System.out.println("                     Routes               ");
        System.out.println(" =========================================== ");
        System.out.println(" Departure           Destination     ");
        System.out.println(" ------------------------------");
        System.out.println("|South -> North|");
        System.out.println(" Johor    ----->      KL            ");
        System.out.println(" KL       ----->      Selangor      ");
        System.out.println(" Selangor ----->      Perak         ");
        System.out.println(" Perak    ----->      Kedah         ");
        System.out.println();
        System.out.println("|North -> South|");
        System.out.println(" Kedah    ----->      Perak         ");
        System.out.println(" Perak    ----->      Selangor      ");
        System.out.println(" Selangor ----->      KL            ");
        System.out.println(" KL       ----->      Johor         ");
        System.out.println();
        System.out.println(" '----->' means number of stations travelled");
        System.out.println(" =========================================== "); 
    }

    @Override
    public String toString() {
        return " " + this.getStationName();
    }
}
