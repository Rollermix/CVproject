package model.enumeration;

import exception.NoSuchOptionException;

public enum MenuOption {
    EXIT(0,"Wyjście z programu"),
    ADD_STUDENT(1,"Dodaj ucznia"),
    PRINT_STUDENTS(2,"Wyświetl wszystkich uczniów");
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
    public static MenuOption createFromInt(int option) throws NoSuchOptionException
    {

        try{
            return MenuOption.values()[option];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            throw new NoSuchOptionException("Brak opcji o id " + option);
        }
    }
}
