package app;

import io.DataReader;
import model.Student;

public class StudentManagment {
    public static void main(String[] args) {
        int currentNumberOfStudents=0;
        Student[] students = new Student[1000];
        DataReader dataReader = new DataReader();
        Student student = dataReader.readAndCreateStudent(students);
        students[currentNumberOfStudents]=student;
        for (Student student1 : students) {
            if(student1!=null)
                System.out.println(student1.toString());
        }
    }
}
