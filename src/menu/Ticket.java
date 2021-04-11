/*
Class: Ticket
Author: Jason, Ju Wen, Eric
*/

package menu;

import  java.time.LocalDate;
import java.time.format.DateTimeFormatter; 

public class Ticket {
    private DepartureStation deptstations;
    private DestinationStation deststaions;
    private String purchasedDate;

    public Ticket(DepartureStation deptstations, DestinationStation deststaions) {
        this.deptstations = deptstations;
        this.deststaions = deststaions;
        
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy (E)");
      
        purchasedDate = currentDate.format(formater);
    }

    @Override
    public String toString() {
        return "\n ==================================== \n                Ticket\n ==================================== \n" + 
                "\nPurchased date: " + purchasedDate + "\n\n" + deptstations + "\n" + deststaions;
    }
  
}
