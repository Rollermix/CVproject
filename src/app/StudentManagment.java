package app;

import io.DataReader;
import model.Person;
import model.Student;

public class StudentManagment {
    public static void main(String[] args) {
        StudentManagmentControl studentManagmentControl = new StudentManagmentControl();
        studentManagmentControl.controlLoop();
    }
}
