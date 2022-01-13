package model;


import model.enumeration.EducationProfile;

public class Student extends Person {
    private EducationProfile educationProfile;
    public static final String TYPE = "Uczeń";

    public Student(String firstName, String lastName, String pesel, String city, String street, String houseNo,
                   String flatNo, String email, int phoneNo, int postalCode, EducationProfile educationProfile) {
        super(firstName, lastName, pesel, city, street, houseNo, flatNo, email, phoneNo, postalCode);
        this.educationProfile = educationProfile;
    }

    public EducationProfile getEducationProfile() {
        return educationProfile;
    }

    @Override
    public String toString() {
        return super.toString() +" " + educationProfile.getDescription();
    }

    @Override
    public String toCsv() {
        return TYPE+";"+getFirstName()+";"+getLastName()+";"+getPesel()+";"+getCity()+";"+getStreet()+";"+
                getHouseNo()+";"+getFlatNo()+";"+getEmail()+";"+getPhoneNo()+";"+getPostalCode()+";"+educationProfile.getOption();
    }
}
