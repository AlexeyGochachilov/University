import comparator.StudentComparator;
import comparator.UniversityComparator;
import enums.StudentComparatorType;
import enums.UniversityComparatorType;
import io.ReadFromExcel;
import io.XlsWriter;
import models.Student;
import models.University;
import util.ComparatorProg;
import util.JsonUtil;
import util.StatisticsUtil;

import java.util.List;

public class Creat {

    public static void main(String[] args) {

        List<University> universities = ReadFromExcel.readXlsUniversity("universityInfo.xlsx");
        UniversityComparator universityComparator = ComparatorProg.getUniversityComparator(UniversityComparatorType.YEAR);
//        universities.stream().sorted(universityComparator).forEach(System.out::println);
//        String jsonUniversities = JsonUtil.universityListToJson(universities);
//        System.out.println(jsonUniversities);
//        List<University> universitiesFromJson = JsonUtil.jsonListToUniversityList(jsonUniversities);

        List<Student> students = ReadFromExcel.readXlsStudents("universityInfo.xlsx");
        StudentComparator studentComparator = ComparatorProg.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);

        XlsWriter.generateAndWriteXLSFile(StatisticsUtil.studAndUniByStat(students, universities),
                "statisticUniversityInfo.xlsx");

//        students.stream().sorted(studentComparator).forEach(System.out::println);
//        String jsonStudents = JsonUtil.studentListToJson(students);
//        System.out.println(jsonStudents);
//        List<Student> studentsFromJson = JsonUtil.jsonListToStudentlist(jsonStudents);

//        if (universitiesFromJson.size() == universities.size() && studentsFromJson.size() == students.size()) {
//            System.out.println("\n коллекции одинаковые \n".toUpperCase());
//        }

//        universities.forEach(university -> {
//            String universityJson = JsonUtil.universityToJson(university);
//            System.out.println(universityJson);
//            University universityFromJson = JsonUtil.jsonUniversityToUniversity(universityJson);
//            System.out.println(universityFromJson);
//        });
//
//        students.forEach(student -> {
//            String studentJson = JsonUtil.studentToJson(student);
//            System.out.println(studentJson);
//            Student studentFromJson = JsonUtil.jsonStudentToStudent(studentJson);
//            System.out.println(studentFromJson);
//        });
    }
}
