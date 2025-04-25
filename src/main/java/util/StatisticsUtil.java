package util;

import enums.StudyProfile;
import models.Statistics;
import models.Student;
import models.University;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class StatisticsUtil {

    private static final Logger log = LogManager.getLogger(StatisticsUtil.class);

    public static List<Statistics> studAndUniByStat(List<Student> studentList, List<University> universityList) {

        log.info("Started creating statistic");
        List<Statistics> statisticsList = new ArrayList<>();

        Set<StudyProfile> profiles = universityList.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        profiles.forEach(profile -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            statistics.setProfile(profile);

            List<String> profileUniversityIds = universityList.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId)
                    .collect(Collectors.toList());

            statistics.setQuantityUniversitiesByProfile(profileUniversityIds.size());
            statistics.setFullUniversityName(StringUtils.EMPTY);

            universityList.stream()
                    .filter(university -> profileUniversityIds.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullNameUniversity -> statistics.setFullUniversityName(
                            statistics.getFullUniversityName() + fullNameUniversity + ";"));

            List<Student> profileStudents = studentList.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());

            statistics.setQuantityStudentsByProfile(profileStudents.size());

            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();

            statistics.setAverageGreat(0);

            avgExamScore.ifPresent(value -> statistics.setAverageGreat(
                    (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });

        log.info(String.format("Finished creating statistics with created %s objects", statisticsList.size()));

        return statisticsList;
    }
}
