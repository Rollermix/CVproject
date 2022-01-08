package model;

public class Teacher extends Person {
    public Teacher(String firstName, String lastName, String pesel, String city, String street, String houseNo, String flatNo, String email, int phoneNo, int postalCode) {
        super(firstName, lastName, pesel, city, street, houseNo, flatNo, email, phoneNo, postalCode);
    }

    @Override
    public String toCsv() {
        return null;
    }
//TODO implementacja wstawiania ocen
}
