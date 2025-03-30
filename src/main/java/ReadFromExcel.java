import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ReadFromExcel {

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
