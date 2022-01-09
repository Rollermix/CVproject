package model;

import model.enumeration.EducationProfile;

import java.security.spec.EdDSAParameterSpec;
import java.util.ArrayList;

public class Subject {
    public final static String TYPE = "Przedmiot";
    private String subjectName;
    private EducationProfile educationProfile;
    public Subject(String subjectName, EducationProfile educationProfile) {
        this.subjectName = subjectName;
        this.educationProfile = educationProfile;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public EducationProfile getEducationProfile() {
        return educationProfile;
    }

    public void setEducationProfile(EducationProfile educationProfile) {
        this.educationProfile = educationProfile;
    }

    @Override
    public String toString() {
        return subjectName+";"+ educationProfile.getDescription();
    }
    public String toCsv()
    {
        return TYPE+";"+subjectName+";"+educationProfile.getOption();
    }
}
