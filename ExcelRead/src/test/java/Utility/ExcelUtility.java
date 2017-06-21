package Utility;
import java.io.File;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility 
{
	public static XSSFSheet ExcelWSheet;

	public static XSSFWorkbook ExcelWBook = null;

	public static XSSFCell Cell1;

	public static XSSFRow Row1;
	public static Object[][] object1 = null;

	public static Object[][] getTableArray(String FilePath, String FileName,String SheetName) throws Exception
		{   

			try {
			   //Create a object of File class to open xlsx file
			   File file =    new File(FilePath+"\\"+FileName);
			   System.out.println(file);

			   FileInputStream ExcelFile = new FileInputStream(file);
			   
			   // Access the required test data sheet
			   //Find the file extension by splitting file name in substring and getting only extension name
			    String fileExtensionName = FileName.substring(FileName.indexOf("."));

			    //Check condition if the file is .xlsx file
			    if(fileExtensionName.equals(".xlsx"))
			    {
			    //If it is xlsx file then create object of XSSFWorkbook class
			    	ExcelWBook = new XSSFWorkbook(ExcelFile);
			    	//System.out.println(ExcelWBook);
			    	System.out.println("File Extension: "+fileExtensionName);
			    }

			    //Check condition if the file is xls file
			    else if(fileExtensionName.equals(".xls"))
			    {
			        //If it is xls file then create object of XSSFWorkbook class
			    	//ExcelWBook = new HSSFWorkbook(ExcelFile);
			    }

			    //To get Sheet Name
			    ExcelWSheet=ExcelWBook.getSheet(SheetName);
			  
			    //int rowCount = ExcelWSheet.getLastRowNum();
			    int rowCount=totalRows();
			    
			    //Total number of columns in the cell
			    int colCount= totalColumns();

			    object1 = new Object[rowCount][colCount];
			    
			    for(int i=1;i<=rowCount;i++)
			    {   		
 						for (int j = 0; j <colCount; j++) 
 						{
 						object1[i-1][j] = ExcelWSheet.getRow(i).getCell(j).getStringCellValue();
			    		//System.out.println(object1[i-1][j]);
			    	}
 				//System.out.println("i: "+i);
			    }
			   // System.out.println("");
				  
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
			return object1;
	}
	
	
	//Find number of rows in excel file
	public static int totalRows()
	{
	  	int rowCount=(ExcelWSheet.getPhysicalNumberOfRows())-1;
	    //System.out.println("Row count: " +rowCount);
	    return rowCount;
	}
	
	//Total number of columns in the cell
	public static int totalColumns()
	{
	    int colCount= ExcelWSheet.getRow(0).getLastCellNum();
	   // System.out.println("Column count: " +colCount);
	    return colCount;
	}
}

