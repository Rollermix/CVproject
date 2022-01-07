package model;
public class Person {
    private String firstName;
    private String lastName;
    private String pesel;
    private String city;
    private String street;
    private String houseNo;
    private String flatNo;
    private String email;
    private int phoneNo;
    private int postalCode;

    public Person(String firstName, String lastName, String pesel,
                   String city, String street, String houseNo, String flatNo,
                   String email, int phoneNo, int postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.city = city;
        this.street = street;
        this.houseNo = houseNo;
        this.flatNo = flatNo;
        this.email = email;
        this.phoneNo = phoneNo;
        this.postalCode = postalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNo='" + houseNo + '\'' +
                ", flatNo='" + flatNo + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo=" + phoneNo +
                ", postalCode=" + postalCode +
                '}';
    }
}
