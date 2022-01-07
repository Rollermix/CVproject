package model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.enumeration.FieldOfStudy;
@Getter
@Setter
@AllArgsConstructor
public class Subject {
    private String subjectName;
    private int amountOfECTS;
    private FieldOfStudy fieldOfStudy;



}
