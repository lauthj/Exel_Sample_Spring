package excelExportAndFileIO;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadGuru99ExcelFileImpl implements ReadGuru99ExcelFile {
	
	
	File file;
	Workbook workBook;
	XSSFWorkbook xssfWorkbook;

	/* (non-Javadoc)
	 * @see excelExportAndFileIO.readGuru99ExcelFileInterface#getFile()
	 */
	@Override
	public File getFile() {
		return file;
	}
	
	/* (non-Javadoc)
	 * @see excelExportAndFileIO.readGuru99ExcelFileInterface#getWorkBook()
	 */
	@Override
	public Workbook getWorkBook() {
		return workBook;
	}
	
	/* (non-Javadoc)
	 * @see excelExportAndFileIO.readGuru99ExcelFileInterface#getXssfWorkbook()
	 */
	@Override
	public XSSFWorkbook getXssfWorkbook() {
		return xssfWorkbook;
	}
	
	/* (non-Javadoc)
	 * @see excelExportAndFileIO.readGuru99ExcelFileInterface#setFile(java.io.File)
	 */
	@Override
	public void setFile(File file) {
		this.file = file;
	}

	/* (non-Javadoc)
	 * @see excelExportAndFileIO.readGuru99ExcelFileInterface#setWorkBook(org.apache.poi.ss.usermodel.Workbook)
	 */
	@Override
	public void setWorkBook(Workbook workBook) {
		this.workBook = workBook;
	}

	    //Main function is calling readExcel function to read data from excel file

	/* (non-Javadoc)
	 * @see excelExportAndFileIO.readGuru99ExcelFileInterface#setXssfWorkbook(org.apache.poi.xssf.usermodel.XSSFWorkbook)
	 */
	@Override
	public void setXssfWorkbook(XSSFWorkbook xssfWorkbook) {
		this.xssfWorkbook = xssfWorkbook;
	}



	/* (non-Javadoc)
	 * @see excelExportAndFileIO.readGuru99ExcelFileInterface#readExcel(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void readExcel(String filePath,String fileName,String sheetName) throws IOException{

	    //Create an object of File class to open xlsx file

	    File file = new File(filePath+"\\"+fileName);
	    

	    //Create an object of FileInputStream class to read excel file

	    FileInputStream inputStream = new FileInputStream(file);

	    Workbook guru99Workbook = null;

	    //Find the file extension by splitting file name in substring  and getting only extension name

	    String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xlsx file

	    if(fileExtensionName.equals(".xlsx")){

	    //If it is xlsx file then create object of XSSFWorkbook class

	    guru99Workbook = new XSSFWorkbook(inputStream);

	    }

	  //Check condition if the file is xls file

	    else if(fileExtensionName.equals(".xls")){

	        //If it is xls file then create object of XSSFWorkbook class

	        guru99Workbook = new HSSFWorkbook(inputStream);

	    }
	    
	    //Read sheet inside the workbook by its name

	    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);

	    //Find number of rows in excel file

	    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();

	    //Create a loop over all the rows of excel file to read it

	    for (int i = 0; i < rowCount+1; i++) {
	    	if(i != 0)
	    		System.out.println();
	        Row row = guru99Sheet.getRow(i);
	        Cell cell;
	        
	        Iterator<Cell> cellIterator = row.cellIterator();

	        //Create a loop to print cell values in a row

	        for (int j = 0; j < row.getLastCellNum(); j++) {

	            //Print Excel data in console 
try {	        while (cellIterator.hasNext()) 
            {
                cell = cellIterator.next();
                
                switch (cell.getCellType()) 
                {
                    case Cell.CELL_TYPE_BOOLEAN:
                    	System.out.print(row.getCell(j).getBooleanCellValue()+"|| ");
                        break;

                    case Cell.CELL_TYPE_NUMERIC:
                        if(DateUtil.isCellDateFormatted(cell)) {
                            Date date = cell.getDateCellValue();
                            System.out.println(date.toString());
                            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                            String d = sdf.format(date);
                            System.out.println(d);
                        }
                        else if(cell.getNumericCellValue() == (int)cell.getNumericCellValue())
                        	System.out.print(row.getCell(j).getNumericCellValue()+"|| ");
                        else if(cell.getNumericCellValue() == (long)cell.getNumericCellValue())
                        	System.out.print(row.getCell(j).getNumericCellValue()+"|| ");
                        else
                        	System.out.print(row.getCell(j).getNumericCellValue()+"|| ");
                        break;

                    case Cell.CELL_TYPE_STRING:

        	        	System.out.print(row.getCell(j).getStringCellValue()+"|| ");
                            break;

                    case Cell.CELL_TYPE_BLANK:
                            System.out.print("" + "|| ");
                            break;
                            
                    default:
                            System.out.print(cell + "|| ");
                    }
                
                j = j + 1;

                    //data.append('\n'); 
            }
}	        
catch (Exception e)	  {;}      

	        }
	    }
	}



	
	    
	
}
