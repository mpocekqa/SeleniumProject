package tests;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {
	File fajl;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	public ReadFromExcel(String filePath) throws IOException {
		this.fajl = new File(filePath);
		this.fis = new FileInputStream(fajl);
		this.wb = new XSSFWorkbook(fis);
	}
	
	public String getStringData(String sheetName, int rowNumber, int columnNumber) {
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNumber-1);
		cell = row.getCell(columnNumber-1);
		return cell.getStringCellValue();
	}
	
	public int getIntData(String sheetName, int rowNumber, int columnNumber) {
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNumber-1);
		cell = row.getCell(columnNumber-1);
		return (int)cell.getNumericCellValue();
	}
}
