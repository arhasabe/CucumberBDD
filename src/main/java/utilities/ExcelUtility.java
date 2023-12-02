package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public static String getCellStringData(String xlPath, String sheet, int row, int cell) throws IOException {
		FileInputStream fis = new FileInputStream(xlPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheet);
		String cellValue = s.getRow(row).getCell(cell).getStringCellValue();
		return cellValue;
	}
}
