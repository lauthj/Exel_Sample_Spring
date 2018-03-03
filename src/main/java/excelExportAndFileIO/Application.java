package excelExportAndFileIO;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String...strings) throws IOException{

		//Create an object of ReadGuru99ExcelFile class

		//ReadGuru99ExcelFile objExcelFile = new ReadGuru99ExcelFileImpl();

		//Prepare the path of excel file
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ReadGuru99ExcelFile objExcelFile = appContext.getBean("ReadGuru99ExcelFile", ReadGuru99ExcelFile.class);

		String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\excelExportAndFileIO";

		//Call read file method of the class to read data
		objExcelFile.readExcel(filePath,"ExportExcel.xlsx","Sheet6");

		}

}
