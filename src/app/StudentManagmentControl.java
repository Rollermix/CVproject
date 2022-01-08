package app;

import io.DataReader;
import model.Person;
import model.School;
import model.Student;
import model.enumeration.MenuOption;

public class StudentManagmentControl {
    MenuOption menuOption;
    DataReader dataReader = new DataReader();
    private School school = new School();
    public void controlLoop()
    {

        do
        {
            printMenuOptions();
            menuOption = MenuOption.createFromInt(dataReader.readInt());
            switch (menuOption)
            {
                case ADD_STUDENT -> addStudent();
                case PRINT_STUDENTS -> printStudents();
            }
        }
        while (menuOption!= MenuOption.EXIT);
    }

    private void printStudents() {
        school.printStudents();
    }

    private void addStudent() {
        Student student = dataReader.readAndCreateStudent();
        school.addStudent(student);
    }

    private void printMenuOptions() {
        System.out.println("Wybierz opcję");
        for(MenuOption menuOption: MenuOption.values())
        {
            System.out.println(menuOption);
        }
    }


}
