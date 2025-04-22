package models;

import enums.StudyProfile;

public class Statistics {

    StudyProfile profile;
    double averageGreat;
    int quantityStudentsByProfile;
    int quantityUniversitiesByProfile;
    String fullUniversityName;

    public StudyProfile getProfile() {
        return profile;
    }

    public Statistics setProfile(StudyProfile profile) {
        this.profile = profile;
        return this;
    }

    public double getAverageGreat() {
        return averageGreat;
    }

    public Statistics setAverageGreat(double averageGreat) {
        this.averageGreat = averageGreat;
        return this;
    }

    public int getQuantityStudentsByProfile() {
        return quantityStudentsByProfile;
    }

    public Statistics setQuantityStudentsByProfile(int quantityStudentsByProfile) {
        this.quantityStudentsByProfile = quantityStudentsByProfile;
        return this;
    }

    public int getQuantityUniversitiesByProfile() {
        return quantityUniversitiesByProfile;
    }

    public Statistics setQuantityUniversitiesByProfile(int quantityUniversitiesByProfile) {
        this.quantityUniversitiesByProfile = quantityUniversitiesByProfile;
        return this;
    }

    public String getFullUniversityName() {
        return fullUniversityName;
    }

    public Statistics setFullUniversityName(String fullUniversityName) {
        this.fullUniversityName = fullUniversityName;
        return this;
    }
}
