/*
author: Jason, Ju Wen, Eric
class : Ticket
*/

package menu;

import  java.time.LocalDate;
import java.time.format.DateTimeFormatter; 

///========================== author : All ==========================///
public class Ticket {                           // aggregation applied by taking in objects from different classes
    private final DepartureStation deptstations;
    private final DestinationStation deststaions;
    private final int numberOfStation;
    private final Seat seats;
    private final Passenger passenger;
    private final Payment payment;
    private final String purchasedDate;

    public Ticket(DepartureStation deptstations, DestinationStation deststaions, int numberOfStation, Seat seats, Passenger newPass, Payment pay) {
        this.deptstations = deptstations;
        this.deststaions = deststaions;
        this.numberOfStation = numberOfStation;
        this.seats = seats;
        this.passenger = newPass;
        this.payment = pay;
        
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy (E)");
      
        purchasedDate = currentDate.format(formater);
    }

    @Override
    public String toString() {              // retrieve all toString methods from all objects from different classes to make up a ticket
        return "\n\n\n ========================================= \n                  Ticket\n ========================================= \n" + 
                "\n Purchased date: " + purchasedDate + "\n\n" + deptstations + "\n" + deststaions + 
                "\n Stations travelled  : " + numberOfStation +
                "\n" + seats + "\n -----------------------------------------" + 
                "\n" + passenger + "\n -----------------------------------------" + 
                "\n" + payment + "\n\n This ticket has to be used before 11.59pm "
                + "\n        within the purchased date." + 
                "\n ========================================= \n                 THANK YOU \n ========================================= \n";
    }
  
}
///==================================================================///