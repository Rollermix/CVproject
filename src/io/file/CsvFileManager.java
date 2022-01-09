package io.file;

import exception.DataExportException;
import model.*;
import model.enumeration.EducationProfile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CsvFileManager implements FileManager{
    private static final String FILE_NAME = "School.csv";
    private static final String SUBJECT_FILE_NAME = "Subject.csv";
    @Override
    public School importData() throws Exception {
        School school = new School();
        try
                (Scanner fileReader = new Scanner(new File(FILE_NAME));
                 Scanner subjectFileReader = new Scanner(new File(SUBJECT_FILE_NAME));)
        {
            while (fileReader.hasNextLine())
            {
                String line = fileReader.nextLine();
                Person person = createObjectFromString(line);
                school.addPerson(person);
            }
            while (subjectFileReader.hasNextLine())
            {
                String line = subjectFileReader.nextLine();
                Subject subject = createSubjectFromString(line);
                school.addSubject(subject);
            }
        }
        return school;
    }

    private Subject createSubjectFromString(String line) {
        String[] split=line.split(";");
        return createSubject(split);
    }

    private Subject createSubject(String[] split) {
        String name = split[0];
        EducationProfile educationProfile = EducationProfile.createFromInt(Integer.valueOf(split[1]));
        return new Subject(name,educationProfile);
    }

    @Override
    public void exportData(School school) {
        Person[] persons = school.getPersons();
        ArrayList<Subject> subjects = school.getListOfSubjects();
        try (
                FileWriter fileWriter = new FileWriter(FILE_NAME);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                FileWriter fileWriter2 = new FileWriter(SUBJECT_FILE_NAME);
                BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);)
        {
            for (Person person : persons) {
                bufferedWriter.write(person.toCsv());
                bufferedWriter.newLine();
            }
            for (Subject subject : subjects) {
                bufferedWriter2.write(subject.toCsv());
                bufferedWriter2.newLine();
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
        if (Teacher.TYPE.equals(type))
            return createTeacher(split);

       throw new Exception("Not implemented yet");
    }

    private Person createTeacher(String[] split) {
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

        return new Teacher
                (firstName,lastName,pesel,city,street,houseNo,flatNo,email,phoneNo,postalCode);
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
