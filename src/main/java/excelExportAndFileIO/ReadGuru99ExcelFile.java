package excelExportAndFileIO;

import java.io.File;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface ReadGuru99ExcelFile {

	File getFile();

	Workbook getWorkBook();

	XSSFWorkbook getXssfWorkbook();

	void setFile(File file);

	void setWorkBook(Workbook workBook);

	void setXssfWorkbook(XSSFWorkbook xssfWorkbook);

	void readExcel(String filePath, String fileName, String sheetName) throws IOException;

}