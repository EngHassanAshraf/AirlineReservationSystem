
package airlinereservationsystem;

import java.util.Objects;

public class FlightDescription {
    private String flightNumber;
    private String origin;
    private String destination;
    private int passengersOnBoard;
    private int seatsNumber;
    private Integer passengerSeatNumber = 1;
    private Integer newSeatNumber = 1;
    private Integer passengerTticketID = 1;     //each passenger will take a unique id on the flight
    private Integer newID = 1;
    private boolean cancelStatus;
    private Passenger[] flightPassengers;       //each flight has a number of passengers
    
    FlightDescription(String flightNumber, String origin, String destination, int numSeats){
            this.flightNumber = flightNumber;
            this.origin = origin;
            this.destination = destination; 
            this.flightPassengers = new Passenger[numSeats];
            this.passengersOnBoard = 0;
            this.seatsNumber = numSeats;
        }

    public void setPassengerSeatNumber(Integer passengerSeatNumber){
        this.passengerSeatNumber = passengerSeatNumber;
    }

    public void setTicketID(Integer passengerTticketID) {
        this.passengerTticketID = passengerTticketID;
    }
   public void setCancelStatus(boolean cancelStatus) {
        this.cancelStatus = cancelStatus;
    }
    
    public String getFlightNumber(){
        return flightNumber;
    }
    public String getOrigin() {
        return origin;
    }
    public String getDestination(){
        return destination;
    }
    public Integer getPassengerSeatNumber(){
        return passengerSeatNumber;
    }
    public Integer getTicketID() {
        return passengerTticketID;
    }
    public int getSeatsNumber() {
        return seatsNumber;
    }
    public int getPassengersOnBoard() {
        return passengersOnBoard;
    }
    public Passenger[] getFlightPassengers() {
        return flightPassengers;
    }
    
    public boolean isFull(){
        return this.passengersOnBoard >= this.seatsNumber;
    }
    public boolean isCancelStatus() {
        return cancelStatus;
    }
    
    //add a passenger to the flight
    public int addPassenger(Passenger Newpassenger)
    {
        if (this.isFull())
            return 0;
        else{
            flightPassengers[passengersOnBoard++] = Newpassenger;
            newID +=1;
            setTicketID(newID);
            newSeatNumber += 1;
            setPassengerSeatNumber(newSeatNumber);
            return 1;
        }
    }
    
    //delete a passenger from the flight and each passenger has eleven(11) elements in his array list
    void cancelReservation(FlightDescription flight, Integer ID)
    {
        for(int i =0; i < flight.getPassengersOnBoard(); i++){
            if (Objects.equals((Integer)flight.flightPassengers[i].getPassengerInfo().get(0), ID)){
          
                flight.flightPassengers[i].setEmptyID((Integer) flight.flightPassengers[i].getPassengerInfo().get(0));
                flight.flightPassengers[i].setEmptyseat((Integer) flight.flightPassengers[i].getPassengerInfo().get(8));  
                flight.setCancelStatus(true);
            }
        }
        //shifting Flight Passengers Array to remove the canceled passenger
        for(int i=0; i< flight.flightPassengers.length; i++)
        {
            if (Objects.equals((Integer)flight.flightPassengers[i].getPassengerInfo().get(0), ID)){
                for(int j = i; j < flight.flightPassengers.length - 1; j++){
                    flight.flightPassengers[j] = flight.flightPassengers[j+1];
                }
                break;
            }
        }
        flight.passengersOnBoard -= 1;
    }
}
