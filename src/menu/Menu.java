/*
author : Juwen, Eric, Jason
file : driver program / main program
 */
package menu;

import java.util.*;

public class Menu {  
    public static void main(String[] args) 
     {
        Station[] stationList = {new Station(1, "Johor", true), new Station(2, "KL", true),
        new Station(3, "Selangor", true), new Station(4, "Perak", true), new Station(5, "Kedah", true)};
      
        Scanner scanner = new Scanner(System.in);
        char routeMenuOption, option;
        int numStationDistance, numPass = 0;
        double TotalPrice;
        boolean InvalidNumPass = true;
        
        ///========================== author : All ==========================///
        do {        
            //display menu
            do{
                System.out.println(" ===========================");
                System.out.println("     Ticketing System      ");
                System.out.println(" ===========================");
                System.out.println("   [1] Buy tickets          ");
                System.out.println("   [2] Check stations       ");
                System.out.println("   [3] Exit                 ");
                System.out.println(" ===========================");
                System.out.println();
                System.out.print("What you want to do? >> ");
                option = scanner.next().charAt(0);
            
            
                if (option == '2'){                                             // check stations option
                    do{
                        routeMenuOption = 0;                
                        Station.showStationList(stationList);
                        System.out.println(" [1]Check routes     [Others]Exit");
                        System.out.print(" Enter your option >>>");
                        char stationMenuOption = scanner.next().charAt(0);

                        if(stationMenuOption == '1'){
                            System.out.println();
                            Station.showRoute();
                            System.out.println(" [1]Go back      [Others]Exit to menu");
                            System.out.print(" Enter your option >>>");
                            routeMenuOption = scanner.next().charAt(0);

                        }
                    }while(routeMenuOption == '1');

                }
                if(option == '3') {                                             // exit option
                    System.out.println("\nThank you and have a nice day!");
                    System.exit(0);
                }

                System.out.println();
            }while(option != '1');                                              // buy ticket option, out of loop and straight away start all the ticket buying process

            //call DeptStDetails method and return the deptSt obj
            DepartureStation departureStation = DeptStDetails(stationList);      

            //show departure station name             
            System.out.println();
            System.out.println("----------------------------------------------");
            System.out.println(departureStation.toString());

            //call DestStDetails method and return the destSt obj
            DestinationStation destinationStation = DestStDetails(stationList, departureStation.getStationNumber());

            //show departure and destinaton station name     
            System.out.println();
            System.out.println("----------------------------------------------");
            System.out.println(departureStation.toString());
            System.out.println(destinationStation.toString());

            //calculate number of stations travelled
            numStationDistance = Math.abs(destinationStation.getStationNumber() - departureStation.getStationNumber());

            System.out.println(" Number of station travelled: " + numStationDistance);


            ///========================= author : Eric ==========================///
            char seatTypeOneChar = chooseSeatType();

            do{ //This do while is for number of passenger and <= 10 person
                    try{
                        System.out.print("Enter Number of Passenger: ");
                        numPass = scanner.nextInt(); 
                        if(numPass <= 10) //error checking for user enter maximum up to 10 person only
                        {
                            InvalidNumPass = false;
                        }
                        else 
                        {
                            InvalidNumPass = true;

                        }
                        if(InvalidNumPass == true) //if above statement return true mean it will display this string and redo this step agian.
                        {
                        System.out.println();
                        System.out.println("Sorry. One purchase maximum of passenger only allow up to 10.");
                        }
                    }
                    catch(InputMismatchException ex){  //error checking for user enter digit only
                        System.out.println();
                        System.out.println("Invalid! please enter a digit number.");
                        scanner.nextLine();
                    }
                }while(InvalidNumPass);

            System.out.println("\n");
            System.out.println(" ==================================== ");
            System.out.println("           Seat Details           ");
            System.out.println(" ==================================== ");
            switch(seatTypeOneChar)
            {
                case 'e':
                case 'E':  //economy choice
                {               
                    Seat ecoSeats = new Economy("Economy", numPass);
                    ecoSeats.setSeatPrice();
                    System.out.println("Seat Type: Economy (RM 5 per Station)");
                    System.out.println("Number Of Passenger: " + numPass);
                    System.out.println("Number Of Station: " + numStationDistance);
                    TotalPrice = numStationDistance * numPass * ecoSeats.getSeatPrice();
                    System.out.printf("Total Price: RM %.2f" , TotalPrice);
                    PassengerDetails(TotalPrice, departureStation, destinationStation, numStationDistance, ecoSeats);       //call PassengerDetails() for Economy seats type
                    break;
                }
                case 'b':
                case 'B':  //Business choice
                {
                    Seat busSeats = new Business("Business", numPass);
                    busSeats.setSeatPrice();
                    System.out.println("Seat Type: Business (RM 10 per Station)");
                    System.out.println("Number Of Passenger: " + numPass);
                    System.out.println("Number Of Station: " + numStationDistance);
                    TotalPrice = numStationDistance * numPass * busSeats.getSeatPrice();
                    System.out.printf("Total Price: RM %.2f" , TotalPrice);
                    PassengerDetails(TotalPrice, departureStation, destinationStation, numStationDistance, busSeats);       //call PassengerDetails() for Business seats type
                    break;
                }           
            }
            ///==================================================================///

            System.out.println("Press any key to continue.");
            Scanner next = new Scanner(System.in);
            String nextCust = next.nextLine();
        
        } while (true);
        ///==================================================================///
    }

    ///========================= author : Juwen =========================///
    public static DepartureStation DeptStDetails(Station[] stationList){
        Scanner scanner = new Scanner(System.in);
        DepartureStation dpStVerification = new DepartureStation();
        int dpStNum = 0;        //variables that store dept number chose by users
        boolean inputNotValid;
        
        //display station list from DepartureStation class
        DepartureStation.showStationList(stationList);
        
        //start choosing departure station
            //check validity of the dept station number
        do{
            //try catch user input
            do{
                try{
                    System.out.println();
                    System.out.print("Choose your departure station: ");
                    dpStNum = scanner.nextInt();
                    inputNotValid = false;
                }
                catch(InputMismatchException ex){
                    System.out.println();
                    System.out.println("************");
                    System.out.println("Invalid input, please enter a number");
                    System.out.println("************");
                    inputNotValid = true;
                    scanner.nextLine();
                    
                }
                
            }while(inputNotValid);
              
            dpStVerification.validDpStNum = dpStVerification.verifyDepartureStation(dpStNum);
            
        }while(dpStVerification.validDpStNum == false);
        
        
        DepartureStation departureStation = new DepartureStation(dpStNum, stationList[dpStNum - 1].getStationName());
        
        return departureStation;
    }
    
    public static DestinationStation DestStDetails(Station[] stationList, int dpStNum){
        Scanner scanner = new Scanner(System.in);
        DestinationStation dtStVerification = new DestinationStation();
        int dtStNum = 0;        //variables that store dest number chose by users
        boolean inputNotValid;
        
        //display station list from DestinationStaion class
        DestinationStation.showStationList(stationList, dpStNum);
             
        //start choosing destination station
            //check validity of the dest station number     
        do{
            //try catch user input
            do{
                try{
                    System.out.println();
                    System.out.print("Choose your destination station: ");
                    dtStNum = scanner.nextInt();
                    
                    inputNotValid = false;
                }
                catch(InputMismatchException ex){
                    System.out.println();
                    System.out.println("************");
                    System.out.println("Invalid input, please enter a number");
                    System.out.println("************");
                    inputNotValid = true;
                    scanner.nextLine();
                }
                       
            }while(inputNotValid);
            
            
            dtStVerification.validDtStNum = dtStVerification.verifyDestinationStation(dtStNum, dpStNum);
            
        }while(dtStVerification.validDtStNum == false);
        
        DestinationStation destinationStation = new DestinationStation(dtStNum, stationList[dtStNum - 1].getStationName());
        
        return destinationStation;
    }
    ///==================================================================///
    
    ///========================= author : Eric =========================///
    public static char chooseSeatType()
    {
        boolean InvalidStType = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.println(" ==================================== ");
        System.out.println("           Seat Selection           ");
        System.out.println(" ==================================== ");     
        System.out.println(" Pricing Per Station: \n   [E] Economy  - RM 5.00 \n   [B] Business - RM 10.00");
        Scanner sType = new Scanner(System.in);
        char seatTypeOneChar = ' ';
        do  //This do while is for seatType
        {
            try
            {
                System.out.println(" ==================================== ");
                System.out.println();
                System.out.print("Choose your seat type: ");
                seatTypeOneChar = sType.next().charAt(0);
                if(seatTypeOneChar == 'e' || seatTypeOneChar == 'E' || seatTypeOneChar == 'b' || seatTypeOneChar == 'B')  //check whether user enter this 4 type of char if yes return false then direct go next step
                InvalidStType = false;
                if(InvalidStType == true) //if above statement return true = typeofseat will stil remain true to run this string and redo this step
                {
                System.out.println();
                System.out.println("Invalid! Please enter only 'e' or 'E' for Economy or 'b' or 'B' for Business.");
                }
                
            }
            catch(InputMismatchException ex)
            {
            }
        }
        while(InvalidStType);

        return seatTypeOneChar;
    }
    ///==================================================================///
    
    ///========================= author : Jason =========================///
    public static void PassengerDetails(double TotalPrice, DepartureStation departureStation, DestinationStation destinationStation, int numOfStation, Seat seats) {
        String name, IC, age;
        char gender, option;
        boolean invalid;
        
        System.out.println("\n\n");
        System.out.println(" ==================================== ");
        System.out.println("           Personal Details           ");
        System.out.println(" ==================================== ");
        System.out.println("Please only insert the buyer's details!\n");
        Scanner input = new Scanner(System.in);     // to capture new input for string
        Passenger checkPass = new Passenger();      // an object created just for checking
        do {
            System.out.print(" Name        : ");
            name = input.nextLine();
            invalid = checkPass.validifyName(name);
        } while(invalid);
        do {
            System.out.print(" IC number   : ");
            IC = input.nextLine();
            invalid = checkPass.validifyIC(IC);
        } while(invalid);
        do {
            System.out.print(" Age(years)  : ");
            age = input.nextLine();
            invalid = checkPass.validifyAge(age);
        } while(invalid);
        do {
            System.out.print(" Gender(M/F) : ");
            gender = input.next().charAt(0);
            invalid = checkPass.validifyGender(gender);
        } while(invalid);
        
        option = checkPass.confirmation(name, IC, age, gender);        
        switch (option) {
            case '1' : {
                Passenger newPass = new Passenger(name.trim(), IC, age, gender);   //create new Passenger per loop
                PaymentDetails(TotalPrice, departureStation, destinationStation, numOfStation, seats, newPass);       //call PaymentDetails() from here (not the main method), becuz if user cancel the purchase, it will just reloop
                break;
            }
            case '2' :
                break;
                // restart the whole system here to prompt the next user
        }
    }
    
    public static void PaymentDetails(double TotalPrice, DepartureStation departureStation, DestinationStation destinationStation, int numOfStation, Seat seats, Passenger newPass) {
        boolean inputNotValid;
        Scanner input = new Scanner(System.in);
        
        Payment pay = new Payment(TotalPrice);                  //create new Payment object for the current passenger
        System.out.println("\n ==================================== ");
        System.out.println("                Payment               ");
        System.out.println(" ==================================== ");
        System.out.printf(" Total Price   : RM%.2f \n", pay.getTotal_payment());
        do {                                                    //input validation for payment to be double
            try {
                System.out.print(" Payment       : RM");        
                pay.setPayment_input(input.nextDouble());
                if (pay.getPayment_input() < pay.getTotal_payment()) {
                    System.out.println("**");
                    System.out.println("Sorry, payment not enough!");
                    System.out.println("**");
                    inputNotValid = true;
                    input.nextLine();
                } else {
                    pay.calcBalance();
                    inputNotValid = false;
                }
            } catch (InputMismatchException ex) {
                System.out.println("**");
                System.out.println("Invalid payment!");
                System.out.println("Please enter [Eg. RM30.00 / RM30]");
                System.out.println("**");
                inputNotValid = true;
                input.nextLine();
            }
        } while(inputNotValid);
        System.out.printf(" Balance       : RM%.2f \n", pay.getBalance());
        System.out.println(" ==================================== ");
        System.out.println("          Payment Success!!!          ");
        System.out.println(" ==================================== ");
        
        displayTicket(departureStation, destinationStation, numOfStation, seats, newPass, pay);
    }
    ///==================================================================///
    
    ///========================== author : All ==========================///
    public static void displayTicket(DepartureStation departureStation, DestinationStation destinationStation, int numOfStation, Seat seats, Passenger newPass, Payment pay) {
        Ticket trainticket = new Ticket(departureStation, destinationStation, numOfStation, seats, newPass, pay);
        System.out.println(trainticket.toString());
    }
    ///==================================================================///
}