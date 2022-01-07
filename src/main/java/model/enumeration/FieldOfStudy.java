package model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FieldOfStudy {
    IT(0,"Informatyka"),
    Logistic(1,"Logistyka"),
    ELECTRONICS(2,"Elektronika");
    private int value;
    private String description;

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
