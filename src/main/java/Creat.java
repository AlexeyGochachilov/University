import comparator.StudentComparator;
import comparator.UniversityComparator;
import enums.StudentComparatorType;
import enums.UniversityComparatorType;
import models.Student;
import models.University;
import util.ComparatorProg;

import java.io.IOException;
import java.util.List;

public class Creat {

    public static void main(String[] args)throws IOException {

        List<University> universities =
                ReadFromExcel.readXlsUniversity("universityInfo.xlsx");
        UniversityComparator universityComparator =
                ComparatorProg.getUniversityComparator(UniversityComparatorType.YEAR);
        universities.stream()
                .sorted(universityComparator)
                .forEach(System.out::println);

        List<Student> students =
                ReadFromExcel.readXlsStudents("universityInfo.xlsx");
        StudentComparator studentComparator =
                ComparatorProg.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        students.stream()
                .sorted(studentComparator)
                .forEach(System.out::println);
    }
}
