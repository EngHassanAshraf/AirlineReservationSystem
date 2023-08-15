package airlinereservationsystem;

public class Person{
    private String fName;
    private String mName;
    private String lName;
    private Long NationalId;
    private Address personAddress = new Address();
    
    public void setfName(String firstName) {
        this.fName = firstName;
    }
    public void setmName(String mName) {
        this.mName = mName;
    }    
    public void setlName(String lastName) {
        this.lName = lastName;
    }
    public void setNationalId(Long NationalId) {
        this.NationalId = NationalId;
    }
    
    public String getfName() {
        return fName;
    }
    public String getmName() {
        return mName;
    }    
    public String getlName() {
        return lName;
    }
    public Long getNationalId() {
        return NationalId;
    }
    public Address getPersonAddress() {
        return personAddress;
    }
    
}