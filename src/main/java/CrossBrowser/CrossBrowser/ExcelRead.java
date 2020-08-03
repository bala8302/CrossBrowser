package CrossBrowser.CrossBrowser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelRead {
	
    //@SuppressWarnings("null")
    @DataProvider(name="testDPCheck",parallel=true)
	public String[][] readExcel() throws Exception
	{
		String[][] data = null;
		
	  FileInputStream fis = new FileInputStream(new File("C:\\testfile\\FilloFile.xlsx"));
	  XSSFWorkbook wb = new XSSFWorkbook(fis);
	  XSSFSheet sheet = wb.getSheetAt(0);
	  
	  //getting rowcount
	  
	   int rowCnt = sheet.getLastRowNum();
	   
	   //getting colcount
	   
	   int colcnt = sheet.getRow(0).getLastCellNum();
	  
	   System.out.println("Rowcnt"+rowCnt);
	   
	   System.out.println("Colcnt"+colcnt);
	   
	   //Array intialization
	   data = new String[rowCnt][colcnt];
	   
	   for(int i=1;i<rowCnt+1;i++)
	   {
		   XSSFRow row = sheet.getRow(i);
		   
		   for(int j=0;j<colcnt;j++)
		   {
		   String cellValue="";
		   cellValue = row.getCell(j).getStringCellValue();
		   System.out.println("cellvalue"+cellValue);
		   data[i-1][j] = cellValue;
		   }
	   }
	   
	   fis.close();
	   wb.close();
	   System.out.println("Data+++++"+data);
	   
	   return data; 
	}

  
}
