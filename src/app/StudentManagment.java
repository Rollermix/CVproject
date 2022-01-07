package app;

import io.DataReader;
import model.Person;
import model.Student;

public class StudentManagment {
    public static void main(String[] args) {
        int currentNumberOfStudents=0;
        Person[] persons = new Student[1000];
        DataReader dataReader = new DataReader();
        Student student = dataReader.readAndCreatePerson(persons);
        persons[currentNumberOfStudents]=student;
        for (Person student1 : persons) {
            if(student1!=null)
                System.out.println(student1.toString());
        }
    }
}
