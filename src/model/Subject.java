package model;

public class Subject {
    private String subjectName;
    private int amountOfECTS;
    private String fieldOfStudy;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getAmountOfECTS() {
        return amountOfECTS;
    }

    public void setAmountOfECTS(int amountOfECTS) {
        this.amountOfECTS = amountOfECTS;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public Subject(String subjectName, int amountOfECTS, String fieldOfStudy) {
        this.subjectName = subjectName;
        this.amountOfECTS = amountOfECTS;
        this.fieldOfStudy = fieldOfStudy;
    }
}
