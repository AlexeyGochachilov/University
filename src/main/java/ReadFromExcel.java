import models.Student;
import models.University;
import enums.StudyProfile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadFromExcel {

    public static List<University> readXlsUniversity (String fileName) throws IOException{

        List<University> universities = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Университеты");

        Iterator<Row> rows = sheet.iterator();
        rows.next();

        while (rows.hasNext()){
            Row currentRow = rows.next();
            University university = new University();
            universities.add(university);
            university.setId(currentRow.getCell(0).getStringCellValue());
            university.setFullName(currentRow.getCell(1).getStringCellValue());
            university.setShortName(currentRow.getCell(2).getStringCellValue());
            university.setYearOfFoundation((int)currentRow.getCell(3).getNumericCellValue());
            university.setMainProfile(StudyProfile.valueOf(
                    StudyProfile.class, currentRow.getCell(4).getStringCellValue()));
        }

        return universities;
    }

    public static List<Student> readXlsStudents(String filePath) throws IOException {

        List<Student> students = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Студенты");

        Iterator<Row> rows = sheet.iterator();
        rows.next();

        while (rows.hasNext()) {
            Row currentRow = rows.next();
            Student student = new Student();
            students.add(student);
            student.setUniversityId(currentRow.getCell(0).getStringCellValue());
            student.setFullName(currentRow.getCell(1).getStringCellValue());
            student.setCurrentCourseNumber((int)currentRow.getCell(2).getNumericCellValue());
            student.setAvgExamScore((float)currentRow.getCell(3).getNumericCellValue());
        }

        return students;
    }

    public static String read(String fileName){

        String result = "";
        FileInputStream fileInputStream = null;
        XSSFWorkbook readFromExcel = null;
        try {
            fileInputStream = new FileInputStream(fileName);
            readFromExcel = new XSSFWorkbook(fileInputStream);
        } catch (IOException e){
            e.printStackTrace();
        }
        XSSFSheet student = readFromExcel.getSheet("Студенты");
        Iterator<Row> itStudent = student.iterator();
        while (itStudent.hasNext()){
            Row row = itStudent.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()){
                Cell cell = cells.next();
                CellType cellType = cell.getCellType();
                switch (cellType) {
                    case STRING:
                        result += cell.getStringCellValue() + "=";
                        break;
                    case NUMERIC:
                        result += "[" + cell.getNumericCellValue() + "]";
                        break;

                    case FORMULA:
                        result += "[" + cell.getNumericCellValue() + "]";
                        break;
                    default:
                        result += "|";
                        break;
                }
            }
            result += "\n";
        }
        XSSFSheet university = readFromExcel.getSheet("Университеты");
        Iterator<Row> itUniversity = university.iterator();
        while (itUniversity.hasNext()){
            Row row = itUniversity.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()){
                Cell cell = cells.next();
                CellType cellType = cell.getCellType();
                switch (cellType) {
                    case STRING:
                        result += cell.getStringCellValue() + "=";
                        break;
                    case NUMERIC:
                        result += "[" + cell.getNumericCellValue() + "]";
                        break;

                    case FORMULA:
                        result += "[" + cell.getNumericCellValue() + "]";
                        break;
                    default:
                        result += "|";
                        break;
                }
            }
            result += "\n";
        }

        return result;
    }
}
