// This is the main package

package airlinereservationsystem;

import java.util.*;   //To import all classes from Java utility package

public class AirlineReservationSystem
{
        //A Method to provide the user with our main options
    private static void mainOptions()
    {   
        System.out.print("press 1 to Book a flight ticket \n"
                + "press 2 to Get your ticket info\n"
                + "press 3 to Cancle a ticket\n"
                + "press 0 to Exit\n"
                + "Enter a Number (1, 2, 3, or 0) to make a choice: ");
    }   //End mainOptions() method
    
    // A method to add the new passenger informaion
    private static Passenger passengerMainInformation(FlightDescription flight) 
    {
        System.out.print("Your Personal Information: Please Enter Your First Name: ");
        String Fname = new Scanner(System.in).nextLine();
        
        System.out.print("                           Please Enter Your Middel Name: ");
        String Mname = new Scanner(System.in).nextLine();
        
        System.out.print("                           Please Enter Your Last Name: ");
        String Lname = new Scanner(System.in).nextLine();
        
        Long ID;   //To store the passenger national ID
        
        while (true)   //A super loop to handle any exception in the entered passenger national ID
        {
            try 
            {
                System.out.print("                           Please Enter Your National ID: ");
                ID = new Scanner(System.in).nextLong();
                break;
            } catch (InputMismatchException exption)
            {
                System.out.println("\n\tYOUR INPUT MUST BE A NUMBER\n");
            }
        }   //End while(true)
        
        Passenger newpassenger = new Passenger(flight, Fname, Mname, Lname, ID);   //To assign the passenger to the flight

        return newpassenger;
    }   //End passengerMainInformation()method

    //A method to creat the passenger address
    private static void addressCreation(Passenger newPassenger) 
    {
        int streetNumber;
        
        while (true)   //A super loop to handle any exception in the entered passenger street number
        {
            try 
            {
                System.out.print("Your Address Information:  Please Enter Street Number: ");
                streetNumber = new Scanner(System.in).nextInt();
                break;
            } catch (InputMismatchException exption) 
            {
                System.out.println("\n\tYOUR INPUT MUST BE A NUMBER\n");
            }
        }   //End while(true)
        
        System.out.print("                           Please Enter Street Name: ");
        String streetName = new Scanner(System.in).nextLine();
        
        System.out.print("                           Please Enter City Name: ");
        String cityName = new Scanner(System.in).nextLine();
        
        System.out.print("                           Please Enter State Name: ");
        String stateName = new Scanner(System.in).nextLine();
        
        int postalCode;
        
        while (true)   //A super loop to handle any exception in the entered passenger postal code
        {
            try 
            {
                System.out.print("                           Please Enter Postal Code: ");
                postalCode = new Scanner(System.in).nextInt();
                break;
            } catch (InputMismatchException exption) {
                System.out.println("\n\tYOUR INPUT MUST BE A NUMBER\n");
            }
        }   //End while(true)
        
        newPassenger.createAddress(streetNumber, streetName, cityName, stateName, postalCode);   //To assign address to the passenger
    }   //End addressCreation() method
   
    //A method to generate the passenger ticket
    private static int getInfo(FlightDescription flight, Integer passengerID, Integer paseengerSeatNumber)
    {
       Passenger[] flightPassengers = flight.getFlightPassengers();   //To get the flight passengers

       for(int item = 0; item < flight.getPassengersOnBoard(); item++)
       {
          
           if(Objects.equals(passengerID, (Integer)flightPassengers[item].getPassengerInfo().get(0)) && 
              Objects.equals(paseengerSeatNumber, (Integer)flightPassengers[item].getPassengerInfo().get(8)))
           {
                System.out.println();
                System.out.println("\n\t\tPassenger number: "+(item+1)+" - Here is Your Ticket: ");
                System.out.println("\t\t------------------------------------------------");
                System.out.println("\t\t| Name of Passenger: "
                                + flightPassengers[item].getPassengerInfo().get(1) + " "
                                + flightPassengers[item].getPassengerInfo().get(2) + " "
                                + flightPassengers[item].getPassengerInfo().get(3)
                                +  "\n\t\t| Flight Number: "+ flightPassengers[item].getPassengerInfo().get(7) +"\t\t\t\t|\n"
                                +  "\t\t|  Seat  Number: "+ flightPassengers[item].getPassengerInfo().get(8)   +"\t\t\t\t|\n"
                                +  "\t\t|\t\t"                                                                 +"\t\t\t\t|\n"
                                +  "\t\t| FROM  "  + flightPassengers[item].getPassengerInfo().get(9)          +"\t\t\t\t\t|\n"
                                +  "\t\t| TO    " + flightPassengers[item].getPassengerInfo().get(10)          +"\t\t\t\t\t|\n"
                                +  "\t\t| Ticket ID  " + flightPassengers[item].getPassengerInfo().get(0)      +"\t\t\t\t\t|");
                System.out.println("\t\t-------------------------------------------------\n");
                return 1;
           }   //End if(conditon)
           
       }
       
        System.out.println("\n\tYou have no ticket on this flight\n");
        return 0;
    }   //End getInfo()method
    
    /*****************
    *                *
    *   Main Method  *
    *   @param args  *
    *                *
    *****************/

    public static void main(String[] args) 
    {
        System.out.println("\t\t Welcome in our Airline Reservation System");     //Welcome message
        FlightDescription flight1 = new FlightDescription("1", "EG", "US", 10);   //Our first available flight
        FlightDescription flight2 = new FlightDescription("2", "EG", "Uk", 10);   //Our second available flight
        
        while (true)   //Our main super loop to make the program always running 
        {
            int firstScreenInput;   //To store user option
            
            while (true)   //A super loop to handle any exception in the entered user option  
            {
                try
                {
                    mainOptions();   //TO provide the user with our main options
                    firstScreenInput = new Scanner(System.in).nextInt();
                    
                    while (firstScreenInput != 0 && firstScreenInput != 1 && firstScreenInput != 2 && firstScreenInput != 3) 
                    {
                        System.out.print("Your number must be 1, 2, 3, or 0 please Enter Again: ");
                        firstScreenInput = new Scanner(System.in).nextInt();
                    }
                    break;
                }catch(InputMismatchException exption)
                {
                    System.out.println("\n\tYOUR INPUT MUST BE A NUMBER\n");
                }
            }   //End while(true)
            
            
            //Main switch for main options
            switch(firstScreenInput)
            { 
                //First main option to Book a ticket
                case 1:   
                    System.out.print("\nOur available flights this weak are: \n"
                            + "\t1. From EG To US\n"
                            + "\t2. From EG To UK\n"
                            + "\t0. Go to Main Screen\n"
                            + "Enter a Flight Number(1, 2) or 0: ");
                    String flightNumber = new Scanner(System.in).nextLine();   //To store the user selected flight
                    
                    while (!"1".equals(flightNumber) && !"2".equals(flightNumber) && !"0".equals(flightNumber)) 
                    {
                        System.out.print("Your number must be 1, 2 or 0 please Enter Again: ");
                        flightNumber = new Scanner(System.in).nextLine();
                    }   //End while(!"1".equals(flightNumber) && !"2".equals(flightNumber) && !"0".equals(flightNumber))
                    
                    System.out.println();
                    
                    //Secondary switch to choose a flight
                    switch(flightNumber)   
                    {
                        case "1":   //First flight option
                            
                            if (flight1.isFull())System.out.println("\n\tSorry our plane is Full for this weak\n");                                      
                            else
                            {
                                Passenger NewPassenger1 = passengerMainInformation(flight1);   //To make the passenger enter his information
                                addressCreation(NewPassenger1);                                //To make the passenger enter his address
                                NewPassenger1.addPassengerFlightInfo(flight1);                 //To add passenger information to his ArrayList
                                flight1.addPassenger(NewPassenger1);                           //To assing the passenger to his desired flight
                                
                                getInfo(flight1, (int) NewPassenger1.getPassengerInfo().get(0), (int) NewPassenger1.getPassengerInfo().get(8));
                                System.out.println("\n\tConfirmed.\n");
                            }   //End else

                            break;
                            
                        case "2":   //Second flight option
                            if (flight2.isFull())System.out.println("\n\tSorry our plane is Full for this weak\n");
                            else 
                            {
                                Passenger NewPassenger2 = passengerMainInformation(flight2);
                                addressCreation(NewPassenger2);
                                NewPassenger2.addPassengerFlightInfo(flight2);
                                flight2.addPassenger(NewPassenger2);

                                getInfo(flight2, (int) NewPassenger2.getPassengerInfo().get(0), (int) NewPassenger2.getPassengerInfo().get(8));
                                System.out.println("\n\tConfirmed.\n");                     
                            }   //End else
                            break;
                            
                        case "0":   //get to Main options
                            continue;
                    }   //End switch(flightNumner)
                    break;

                case 2:     //Second main option to Display a ticket
                    System.out.print("Please Enter your Flight Number(or 0 to Main Screen): ");
                    String flightNum = new Scanner(System.in).nextLine();
                    while (!"1".equals(flightNum) && !"2".equals(flightNum) && !"0".equals(flightNum)) {
                        System.out.print("Your number must be 1, or 2 please Enter Again: ");
                        flightNum = new Scanner(System.in).nextLine();
                    }
                    //secondary switch
                    switch (flightNum) {
                        case "1":   //first flight option 
                            System.out.print("Please Enter your Ticket ID: ");
                            Integer flightId = new Scanner(System.in).nextInt();
                            System.out.print("Please Enter your Seat Number: ");
                            Integer flightSeatNum = new Scanner(System.in).nextInt();
                            if (flight1.getPassengersOnBoard() > 0) {
                                getInfo(flight1, flightId, flightSeatNum);
                            } else {
                                System.out.println("This flight has no passener yet");
                            }
                            break;
                        case "2":   //Second flight option
                            System.out.print("Please Enter your Ticket ID: ");
                            Integer flightId1 = new Scanner(System.in).nextInt();
                            System.out.print("Please Enter your Seat Number: ");
                            Integer flightSeatNum1 = new Scanner(System.in).nextInt();
                            if (flight2.getPassengersOnBoard() > 0) {
                                getInfo(flight2, flightId1, flightSeatNum1);
                            } else {
                                System.out.println("This flight has no passener yet");
                            }
                            break;
                        case "0":   //get to Main options
                            System.out.print("\n");
                            continue;
                    }
                    break;

                case 3: //third main oprion to Cancel Reservation 
                    System.out.print("Please Enter your Flight Number(or 0 to Main Screen): ");
                    String FlightNum = new Scanner(System.in).nextLine();
                    while (!"1".equals(FlightNum) && !"2".equals(FlightNum) && !"0".equals(FlightNum)) {
                        System.out.print("Your number must be 1, or 2 please Enter Again: ");
                        FlightNum = new Scanner(System.in).nextLine();
                    }
                    //secondary switch
                    switch (FlightNum)
                    {
                        case "1":    //First flight option
                            System.out.print("Please Enter your Ticket ID: ");
                            Integer FlightId = new Scanner(System.in).nextInt();
                            if (flight1.getPassengersOnBoard() > 0) {
                                flight1.cancelReservation(flight1, FlightId);
                                System.out.println("\n\tYour Reservation get canceled\n");
                            } else {
                                System.out.println("This flight has no passener yet");
                            }
                            break;
                        case "2":    //Second flight option
                            System.out.print("Please Enter your Ticket ID: ");
                            Integer FlightId1 = new Scanner(System.in).nextInt();
                            if (flight2.getPassengersOnBoard() > 0) {
                                flight2.cancelReservation(flight2, FlightId1);
                                System.out.println("\n\tYour Reservation get canceled\n");
                            } else {
                                System.out.println("This flight has no passener yet");
                            }
                            break;
                        case "0":   //get to Main options
                            System.out.print("\n");
                            continue;
                    }
                    break;

                case 0: //Exit the program
                    System.out.print("Are you sure? (1 to exit, 0 to Main Screen): ");
                    int insureness = new Scanner(System.in).nextInt();
                    //secondary switch
                    switch (insureness) {
                        case 1:   //Exit
                            System.out.println("\n\t\tThank You. Goodbye\n");
                            System.exit(0);
                            break;
                        case 0:   //get to Main options
                            System.out.print("\n");
                            continue;
                    }
                    break;
            }
        }
    }
}