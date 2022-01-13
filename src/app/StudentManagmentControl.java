package app;

import exception.DataExportException;
import exception.NoSuchOptionTypeException;
import io.DataReader;
import io.file.FileManager;
import io.file.FileManagerBuilder;
import model.School;
import model.Student;
import model.Subject;
import model.Teacher;
import model.enumeration.EducationProfile;
import model.enumeration.MenuOption;

import java.util.InputMismatchException;

public class StudentManagmentControl {
    MenuOption menuOption;
    DataReader dataReader = new DataReader();
    private School school = new School();
    private FileManager fileManager;

    StudentManagmentControl()
    {
        fileManager = new FileManagerBuilder(dataReader).build();
        try {
            school= fileManager.importData();
            System.out.println("Wczytano dane z pliku");
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Stworzono nowy plik");
            school = new School();
        }
    }
    public void controlLoop()
    {

        do
        {

            menuOption = getFromInt();
            switch (menuOption)
            {
                case ADD_STUDENT -> addStudent();
                case PRINT_STUDENTS -> printStudents();
                case ADD_TEACHER -> addTeacher();
                case PRINT_TEACHERS -> printTeachers();
                case ADD_SUBJECT -> addSubject();
                case PRINT_SUBJECTS -> printSubjects();
                case PRINT_STUDENTS_ATTENDING_A_PROFILE -> printStudentsAttendingAProfile();
                case EXIT -> exit();
            }
        }
        while (menuOption!= MenuOption.EXIT);
    }

    private void printStudentsAttendingAProfile() {
        EducationProfile profile = dataReader.getEducationProfile();
        school.printStudentsOnProfile(profile);
    }

    private void printSubjects() {
        school.printSubjects();
    }

    private void exit() {
        try
        {
            fileManager.exportData(school);
            System.out.println("Wyexportowano dane");
        }
        catch (DataExportException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private MenuOption getFromInt() {
        boolean check=false;
        MenuOption menuOption = null;
        while (!check)
        {
            printMenuOptions();
           try{
               menuOption=MenuOption.createFromInt(dataReader.readInt());
               check = true;
           }
           catch (NoSuchOptionTypeException e)
           {
               System.out.println(e.getMessage());
           }
           catch (InputMismatchException ignored)
           {
               System.out.println("Wprowadzono wartość co nie jest liczbą");
               dataReader.nextLine();
           }
        }
        return menuOption;
    }

    private void printStudents() {
        school.printStudents();
    }

    private void printTeachers() {school.printTeachers();}

    private void addStudent() {
        Student student = dataReader.readAndCreateStudent();
        school.addPerson(student);
    }

    private void addTeacher()
    {
        Teacher teacher = dataReader.readAndCreateTeacher();
        school.addPerson(teacher);
    }

    private void printMenuOptions() {
        System.out.println("Wybierz opcję");
        for(MenuOption menuOption: MenuOption.values())
        {
            System.out.println(menuOption);
        }
    }
    private void addSubject()
    {
        Subject subject = dataReader.readAndCreateSubject();
        school.addSubject(subject);
    }


}
