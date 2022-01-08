package model.enumeration;

import exception.NoSuchOptionTypeException;

public enum EducationProfile {
    DEFAULT(0,"Ogólnokszałcący"),
    IT(1,"Informatyka"),
    LOGISTIC(2,"Logistyka");
    private int option;
    private String description;

    public int getOption() {
        return option;
    }

    public String getDescription() {
        return description;
    }


    EducationProfile(int option, String description) {
        this.option = option;
        this.description = description;
    }

    public static EducationProfile createFromInt(int option) throws NoSuchOptionTypeException
    {
        try{
            return EducationProfile.values()[option];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            throw new NoSuchOptionTypeException("Brak opcji o id " + option);
        }
    }

    @Override
    public String toString() {
            return option + " - " + description;

    }
}
