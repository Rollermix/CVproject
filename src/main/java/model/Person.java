package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
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
