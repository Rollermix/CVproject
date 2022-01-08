package model.enumeration;

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
        description = description;
    }
    static EducationProfile createFromInt(int option)
    {
        return EducationProfile.values()[option];
    }

    @Override
    public String toString() {
        return option + " - " + description;
    }
}
