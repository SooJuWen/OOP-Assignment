/*
author : Jason
file type : subclass
inherits : Person
 */
package menu;

import java.util.*;

public final class Passenger extends Person{
    private static int total_passengers = 0;    // record down total number of passengers
    private String passengerID;                 // an ID to identify the tickets buyer
    
    public Passenger() {}
    
    public Passenger(String name, String IC, String age, char gender) {
        super(name, IC, age, gender);
        total_passengers++;
        createID(total_passengers);             // once new passenger buy a ticket, they are given an ID
    }

    public static int getTotal_passengers() {
        return total_passengers;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(String passengerID) {
        this.passengerID = passengerID;
    }

    // to create a new ID for a passenger whenever a new passenger buy a ticket
    public void createID(int number) {
        if (number < 10)
            this.passengerID = "T00" + number;
        else if (number >= 10 && number <= 100)
            this.passengerID = "T0" + number;
        else
            this.passengerID = "T" + number;
    }
    
    public boolean validifyName(String name) {
        int spaceCount = 0;
        for (int i = 0; i < name.length() ; i++) {
            if (!(Character.isLetter(name.charAt(i)))) {                        // if the character is not a letter
                if (!(Character.isWhitespace(name.charAt(i)))) {                // if the character is not a whitespace
                    System.out.println("Invalid name! No other symbols except letters in name.");
                    return true;
                } else {
                    spaceCount++;
                    if (spaceCount == name.length()) {                          // to check if every characters are whitespaces
                        System.out.println("Invalid name! Please enter with letters.");
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean validifyIC(String IC) {
        for (int i = 0; i < IC.length() ; i++) {
            if (!(Character.isDigit(IC.charAt(i)))) {                           // if character is not a digit
                System.out.println("Invalid IC number! Please enter in digits.");
                return true;
            }
        }
        if (IC.length() != 12) {                                                // if the length of IC number not fulfill the actual condition
            System.out.println("Invalid IC number! IC number need 12 digits.");
            return true;
        }
        return false;
    }
    
    public boolean validifyAge(String age) {
        boolean check;
        char confirm;
        for (int i = 0; i < age.length() ; i++) {
            if (!(Character.isDigit(age.charAt(i)))) {                          // if character is not a digit
                System.out.println("Invalid Age! Please enter in digits.");
                return true;
            }
        }
        return false;
    }
    
    public boolean validifyGender(char gender) {       
        if (!(Character.isLetter(gender))){                                     // if character is not a letter
            System.out.println("Invalid gender! Please enter [M/F].");
            return true;
        }
        if (!((Character.toUpperCase(gender) == 'M') || (Character.toUpperCase(gender) == 'F'))) {
            System.out.println("Invalid gender! Please enter [M/F].");          // if character keyed in not M or F
            return true;
        }
        return false;
    }
    
    public char confirmation(String name, String IC, String age, char gender) {
        Scanner input = new Scanner(System.in);
        char option = '0';
        boolean invalid;
        System.out.println("\n ==================================== ");
        System.out.println("             Confirmation             ");
        System.out.println(" ==================================== ");
        System.out.println(" Name      : " + name);
        System.out.println(" IC number : " + IC);
        System.out.println(" Age       : " + age);
        if (Character.toUpperCase(gender) == 'M')
            System.out.println(" Gender    : Male");
        else
            System.out.println(" Gender    : Female");
        System.out.println(" ==================================== ");        
        System.out.println(" [1] Confirm and Proceed   [2] Cancel");            // if customers decided to cancel the ticket purchase   
        System.out.println(" ==================================== ");
        do {
            try {
                System.out.print("Enter option : ");
                option = input.next().charAt(0);
                if (option != '1' && option != '2') {                           //to check if user's value is within 1 or 2
                    System.out.println("************");
                    System.out.println("Invalid option! Please enter [1/2].");
                    System.out.println("************");
                    invalid = true;
                } else
                    System.out.println();
                    invalid = false;
            } catch (InputMismatchException ex) {
                System.out.println("************");
                System.out.println("Invalid option! Please enter [1/2].");
                System.out.println("************");
                invalid = true;
                input.nextLine();
            }
        } while(invalid);
        return option;
    }

    @Override
    public String toString() {
        return " PassengerID : " + passengerID + super.toString();
    }  
}