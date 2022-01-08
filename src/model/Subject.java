package model;

import model.enumeration.EducationProfile;

public class Subject {
    private String subjectName;
    private int amountOfECTS;
    private EducationProfile educationProfile;

    public Subject(String subjectName, int amountOfECTS, EducationProfile educationProfile) {
        this.subjectName = subjectName;
        this.amountOfECTS = amountOfECTS;
        this.educationProfile = educationProfile;
    }

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

    public EducationProfile getEducationProfile() {
        return educationProfile;
    }

    public void setEducationProfile(EducationProfile educationProfile) {
        this.educationProfile = educationProfile;
    }
}
