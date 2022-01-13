package model.enumeration;

import exception.NoSuchOptionTypeException;

public enum MenuOption {
    EXIT(0,"Wyjście z programu"),
    ADD_STUDENT(1,"Dodaj ucznia"),
    PRINT_STUDENTS(2,"Wyświetl wszystkich uczniów"),
    ADD_TEACHER(3,"Dodaj nauczyciela"),
    PRINT_TEACHERS(4,"Wyświetl nauczycieli"),
    ADD_SUBJECT(5,"Dodaj przedmiot"),
    PRINT_SUBJECTS(6,"Wyświetl przedmioty nauczane w szkole"),
    PRINT_STUDENTS_ATTENDING_A_PROFILE(7,"Wyświetl uczniów uczeszczających na dany profil");
    private int menuOption;
    private String menuOptionDescription;

    public int getMenuOption() {
        return menuOption;
    }

    public String getMenuOptionDescription() {
        return menuOptionDescription;
    }

    MenuOption(int menuOption, String menuOptionDescription) {
        this.menuOption = menuOption;
        this.menuOptionDescription = menuOptionDescription;
    }

    @Override
    public String toString() {
        return menuOption+ " - " + menuOptionDescription;
    }
    public static MenuOption createFromInt(int option) throws NoSuchOptionTypeException
    {

        try{
            return MenuOption.values()[option];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            throw new NoSuchOptionTypeException("Brak opcji o id " + option);
        }
    }
}
