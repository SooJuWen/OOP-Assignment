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
    private Seat seats;
    private Passenger passenger;
    private Payment payment;
    private String purchasedDate;

    public Ticket(DepartureStation deptstations, DestinationStation deststaions, Seat seats, Passenger newPass, Payment pay) {
        this.deptstations = deptstations;
        this.deststaions = deststaions;
        this.seats = seats;
        this.passenger = newPass;
        this.payment = pay;
        
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy (E)");
      
        purchasedDate = currentDate.format(formater);
    }

    @Override
    public String toString() {
        return "\n\n\n ========================================= \n                  Ticket\n ========================================= \n" + 
                "\n Purchased date: " + purchasedDate + "\n\n" + deptstations + "\n" + deststaions + 
                "\n" + seats +
                "\n -----------------------------------------" + 
                "\n" + passenger + 
                "\n -----------------------------------------" + 
                "\n" + payment +
                "\n\n ========================================= \n";
    }
  
}

//changed