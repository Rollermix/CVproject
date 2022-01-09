package model;

public class Teacher extends Person {
    public static final String TYPE = "Nauczyciel";
    public Teacher(String firstName, String lastName, String pesel, String city, String street, String houseNo, String flatNo, String email, int phoneNo, int postalCode) {
        super(firstName, lastName, pesel, city, street, houseNo, flatNo, email, phoneNo, postalCode);
    }

    @Override
    public String toCsv() {
        return TYPE+";"+getFirstName()+";"+getLastName()+";"+getPesel()+";"+getCity()+";"+getStreet()+";"+
                getHouseNo()+";"+getFlatNo()+";"+getEmail()+";"+getPhoneNo()+";"+getPostalCode();
    }
//TODO implementacja wstawiania ocen
}
