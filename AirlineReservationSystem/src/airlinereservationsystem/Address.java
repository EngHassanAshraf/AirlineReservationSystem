
package airlinereservationsystem;

public class Address {
    private int streetNumber;
    private String streetName;
    private String city;
    private String state;
    private int postalcode;
    private String fullAddress;
    
    public void setState(String city){
        this.state = city;
    }
    public void setCity(String city){
        this.city = city;
    }
    public void setStreetName(String streetName){
        this.streetName = streetName;
    }
    public void setStreetNumber(int streetNumber){
        this.streetNumber = streetNumber;
    }
    public void setPostalCode(int postalcode) {
        this.postalcode = postalcode;
    }
    
    public int getStreetNumber(){
        return streetNumber;
    }
    public String getStreetName(){
        return streetName;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public int getPostalcode() {
        return postalcode;
    } 
    public String getFullAddress() {
        fullAddress = getStreetNumber()+ ", " + getStreetName() + ", " + getCity() + ", " + getState();
        return fullAddress;
    }
    
}

