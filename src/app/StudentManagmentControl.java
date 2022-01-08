package app;

import exception.NoSuchOptionException;
import io.DataReader;
import model.School;
import model.Student;
import model.enumeration.MenuOption;

import java.util.InputMismatchException;

public class StudentManagmentControl {
    MenuOption menuOption;
    DataReader dataReader = new DataReader();
    private School school = new School();
    public void controlLoop()
    {

        do
        {

            menuOption = getFromInt();
            switch (menuOption)
            {
                case ADD_STUDENT -> addStudent();
                case PRINT_STUDENTS -> printStudents();
            }
        }
        while (menuOption!= MenuOption.EXIT);
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
           catch (NoSuchOptionException e)
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
