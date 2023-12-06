package week5.day4A;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataLibrary {

	public static String[][] readData(String fileName) throws IOException {
		XSSFWorkbook book = new XSSFWorkbook("./data/"+fileName+".xlsx");
		XSSFSheet sheet = book.getSheet("Sheet1");
		
		int rowNum = sheet.getLastRowNum();
		int cellNum = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[rowNum][cellNum];
		
		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < cellNum; j++) {
				String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(stringCellValue);
				data[i-1][j] = stringCellValue;
			}
		}
		book.close();
		return data;
		
	}
}
