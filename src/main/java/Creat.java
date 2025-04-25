import comparator.StudentComparator;
import comparator.UniversityComparator;
import enums.StudentComparatorType;
import enums.UniversityComparatorType;
import io.ReadFromExcel;
import io.XlsWriter;
import models.Student;
import models.University;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.ComparatorProg;
import util.StatisticsUtil;

import java.util.List;

public class Creat {

    private static final Logger log = LogManager.getLogger(Creat.class);

    public static void main(String[] args) {

        List<University> universities = ReadFromExcel.readXlsUniversity("universityInfo.xlsx");
        UniversityComparator universityComparator = ComparatorProg.getUniversityComparator(UniversityComparatorType.YEAR);
        universities.stream().sorted(universityComparator);
        log.info("readUniversitiesFromXL" + universities);

        List<Student> students = ReadFromExcel.readXlsStudents("universityInfo.xlsx");
        StudentComparator studentComparator = ComparatorProg.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        students.stream().sorted(studentComparator);
        log.info("readStudentsFromXL" + students);

        XlsWriter.generateAndWriteXLSFile(StatisticsUtil.studAndUniByStat(students, universities),
                "statisticUniversityInfo.xlsx");
        log.info("CreatStatisticUniversityInfo.xlsx");
    }
}
