package models;

import com.google.gson.annotations.SerializedName;

public class Student {

    @SerializedName("Name")
    String fullName;
    @SerializedName("IDofUniversity")
    String universityId;
    @SerializedName("CurrentCourse")
    int currentCourseNumber;
    @SerializedName("AvgGreat")
    float avgExamScore;

    public Student() {
    }

    public Student(float avgExamScore, int currentCourseNumber, String universityId, String fullName) {
        this.avgExamScore = avgExamScore;
        this.currentCourseNumber = currentCourseNumber;
        this.universityId = universityId;
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

    public Student setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    @Override
    public String toString() {
        return "DATA.Student{" +
                "fullName='" + fullName + '\'' +
                ", universityId='" + universityId + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore +
                '}';
    }
}
