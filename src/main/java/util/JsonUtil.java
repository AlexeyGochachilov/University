package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import models.Student;
import models.University;

import java.util.List;

public class JsonUtil {

    private JsonUtil() {
    }

    public static String universityToJson(University university) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }

    public static String studentToJson(Student student) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(student);
    }

    public static String universityListToJson(List<University> universities) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(universities);
    }

    public static String studentListToJson(List<Student> students) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(students);
    }

    public static University jsonUniversityToUniversity(String json) {
        return new Gson().fromJson(json, University.class);
    }

    public static Student jsonStudentToStudent(String json) {
        return new Gson().fromJson(json, Student.class);
    }

    public static List<University> jsonListToUniversityList(String json) {
        return new Gson().fromJson(json, new TypeToken<List<University>>() {}.getType());
    }

    public static List<Student> jsonListToStudentlist(String json){
        return new Gson().fromJson(json, new TypeToken<List<Student>>() {}.getType());
    }
}
