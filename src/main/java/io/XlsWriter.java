package io;

import models.Statistics;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {

    public static void generateAndWriteXLSFile(List<Statistics> statisticsList, String filePath) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet statisticSheet = workbook.createSheet("Статистика");

        Font headFont = workbook.createFont();
        headFont.setBold(true);
        headFont.setFontHeight((short) 16);
        CellStyle headStyle = workbook.createCellStyle();
        headStyle.setFont(headFont);

        int row = 0;

        Row headRow = statisticSheet.createRow(row++);
        Cell cellProfileHeaderRow = headRow.createCell(0);
        cellProfileHeaderRow.setCellValue("Профиль Обучения");
        cellProfileHeaderRow.setCellStyle(headStyle);
        Cell cellAVGRow = headRow.createCell(1);
        cellAVGRow.setCellValue("средний балл за экзамен");
        cellAVGRow.setCellStyle(headStyle);
        Cell cellQuantityStudentsByProfile = headRow.createCell(2);
        cellQuantityStudentsByProfile.setCellValue("количество студентов по профилю");
        cellQuantityStudentsByProfile.setCellStyle(headStyle);
        Cell cellQuantityUniversitiesByProfile = headRow.createCell(3);
        cellQuantityUniversitiesByProfile.setCellValue("количество университетов по профилю");
        cellQuantityUniversitiesByProfile.setCellStyle(headStyle);
        Cell cellFullUniversityName = headRow.createCell(4);
        cellFullUniversityName.setCellValue("названия университетов");
        cellFullUniversityName.setCellStyle(headStyle);

        for (Statistics statistics : statisticsList) {
            Row data = statisticSheet.createRow(row++);
            Cell profileCell = data.createCell(0);
            profileCell.setCellValue(statistics.getProfile().getProfileName());
            Cell AVGCell = data.createCell(1);
            AVGCell.setCellValue(statistics.getAverageGreat());
            Cell quantityStudentProfileCell = data.createCell(2);
            quantityStudentProfileCell.setCellValue(statistics.getQuantityStudentsByProfile());
            Cell quantityUniversityProfileCell = data.createCell(3);
            quantityUniversityProfileCell.setCellValue(statistics.getQuantityUniversitiesByProfile());
            Cell universityNameCell = data.createCell(4);
            universityNameCell.setCellValue(statistics.getFullUniversityName());
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            workbook.write(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
