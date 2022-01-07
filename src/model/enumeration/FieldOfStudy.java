package model.enumeration;

public enum FieldOfStudy {
    IT(0,"Informatyka"),
    Logistic(1,"Logistyka"),
    ELECTRONICS(2,"Elektronika");
    private int value;
    private String description;

    FieldOfStudy(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return value+" - " +description;
    }

    static FieldOfStudy createFromInt (int option)
    {
        return FieldOfStudy.values()[option];
    }
}
