package io.file;

import exception.DataExportException;
import model.Person;
import model.School;
import model.Student;
import model.enumeration.EducationProfile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CsvFileManager implements FileManager{
    private static final String FILE_NAME = "School.csv";
    @Override
    public School importData() throws Exception {
        School school = new School();
        try
                (Scanner fileReader = new Scanner(new File(FILE_NAME)))
        {
            while (fileReader.hasNextLine())
            {
                String line = fileReader.nextLine();
                Person person = createObjectFromString(line);
                school.addPerson(person);
            }
        }
        return school;
    }
    @Override
    public void exportData(School school) {
        Person[] persons = school.getPersons();
        try (
                FileWriter fileWriter = new FileWriter(FILE_NAME);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter))
        {
            for (Person person : persons) {
                bufferedWriter.write(person.toCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new DataExportException("Błąd zapisu danych do pliku "+ FILE_NAME);
        }

    }
    private Person createObjectFromString(String line) throws Exception {
        String[] split=line.split(";");
        String type = split[0];
        if (Student.TYPE.equals(type))
        {
            return createStudent(split);
        }

       throw new Exception("Not implemented yet");
    }

    private Student createStudent(String[] split) {
        String firstName = split[1];
        String lastName = split[2];
        String pesel = split[3];
        String city = split[4];
        String street = split[5];
        String houseNo = split[6];
        String flatNo = split[7];
        String email = split[8];
        int phoneNo = Integer.valueOf(split[9]);
        int postalCode = Integer.valueOf(split[10]);
        EducationProfile educationProfile = EducationProfile.createFromInt(Integer.valueOf(split[11]));
        return new Student
                (firstName,lastName,pesel,city,street,houseNo,flatNo,email,phoneNo,postalCode,educationProfile);

    }


}
