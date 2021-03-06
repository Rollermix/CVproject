package model;


import model.enumeration.EducationProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class School {
    private static final int MAX_PEOPLE = 1000;
    private int peopleCounter;
    private Person[] persons = new Person[MAX_PEOPLE];
    private ArrayList<Subject> listOfSubjects = new ArrayList<>();

    public void addPerson(Person person) {
        if (peopleCounter < MAX_PEOPLE) {
            persons[peopleCounter] = person;
            peopleCounter++;
        } else
            System.out.println("Nie można dodać więcej osób do bazy");
    }

    public Person[] getPersons() {
        Person[] allPersons = new Person[peopleCounter];
        for (int i = 0; i < peopleCounter; i++) {
            allPersons[i] = persons[i];
        }
        return allPersons;
    }

    public ArrayList<Subject> getListOfSubjects() {
        return listOfSubjects;
    }

    public void printStudents() {
        int countStudents = 0;
        for (int i = 0; i < peopleCounter; i++) {
            if (persons[i] instanceof Student) {
                System.out.println(persons[i]);
                countStudents++;
            }
        }
        if (countStudents == 0) {
            System.out.println("Nie ma żadnego ucznia w bazie danych");
        }
    }

    public void printTeachers() {
        int countTeachers = 0;
        for (int i = 0; i < peopleCounter; i++) {
            if (persons[i] instanceof Teacher) {
                System.out.println(persons[i]);
                countTeachers++;
            }
        }
        if (countTeachers == 0) {
            System.out.println("Nie ma żadnego nauczyciela w bazie");
        }
    }

    public void addSubject(Subject subject) {
        listOfSubjects.add(subject);
    }

    public void printSubjects() {
        if (listOfSubjects.size() > 0) {
            for (Subject listOfSubject : listOfSubjects) {
                System.out.println(listOfSubject);
            }
        }
    }

    public void printStudentsOnProfile(EducationProfile educationProfile) {
        ArrayList<Student> studentList = new ArrayList<>();
        for (Person person : persons) {
            if (person instanceof Student)
                studentList.add((Student) person);
        }
        List<Student> studentProfileList = studentList.stream()
                .filter(student -> student.getEducationProfile().equals(educationProfile))
                .toList();
        if(!studentProfileList.isEmpty())
        {
            for (Student student : studentProfileList) {
                System.out.println(student);
            }
        }
        else System.out.println("Nie ma żadnego ucznia na profilu: " + educationProfile.getDescription());
    }
}
