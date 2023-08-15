package airlinereservationsystem;

import java.util.ArrayList;

public class Passenger extends Person
{
    private static Integer canceledSeatNumber;
    private static Integer canceledID;
    private ArrayList<Object> passenger = new ArrayList<>(); //store each passenger data(id,name,address,flight,...)
    
    //set and add pasenger personal information to his array list 
    Passenger(FlightDescription flight,String fName, String mName, String lName, Long NationalId)
    {
        if(flight.isCancelStatus()){
            passenger.add(getEmptyID());       //ArrayListIndex(0)
        }                                   
        else{
            passenger.add(flight.getTicketID());
        }
        
        setfName(fName);
        passenger.add(getfName());             //ArrayListIndex(1)
        
        setmName(mName);
        passenger.add(getmName());             //ArrayListIndex(2)
        
        setlName(lName);
        passenger.add(getlName());             //ArrayListIndex(3)
        
        setNationalId(NationalId);
        passenger.add(getNationalId());        //ArrayListIndex(4)
    }
    
    public void setEmptyseat(Integer emptyseat){
        Passenger.canceledSeatNumber = emptyseat;
    }
    public void setEmptyID(Integer emptyID) {
        Passenger.canceledID = emptyID;
    }

    //Add passenger Address to his array list
    void createAddress(int stNumber, String stName ,String city, String state, int postalCode){
        getPersonAddress().setStreetNumber(stNumber);
        getPersonAddress().setStreetName(stName);
        getPersonAddress().setCity(city);
        getPersonAddress().setState(state);
        passenger.add(getPersonAddress().getFullAddress());     //ArrayListIndex(5)

        getPersonAddress().setPostalCode(postalCode);
        passenger.add(getPersonAddress().getPostalcode());      //ArrayListIndex(6)
    }
    
    //A method to add passenger flight information to his array list
    void addPassengerFlightInfo(FlightDescription passengerFlight)
    { 
        passenger.add(passengerFlight.getFlightNumber());                       //ArrayListIndex(7)
        
        if(passengerFlight.isCancelStatus())passenger.add(getEmptyseat());      //ArrayListIndex(8)           
        else passenger.add(passengerFlight.getPassengerSeatNumber());
        
        passenger.add(passengerFlight.getOrigin());              //ArrayListIndex(9)
        passenger.add(passengerFlight.getDestination());         //ArrayListIndex(10)     
    }

    public Integer getEmptyseat() {
        return canceledSeatNumber;
    }
    public static Integer getEmptyID() {
        return canceledID;
    }
    
    //get back all passenger information
    public ArrayList<Object> getPassengerInfo(){
        return passenger;
    }
}