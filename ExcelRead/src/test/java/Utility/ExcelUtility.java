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

	public static XSSFCell Cell;

	public static XSSFRow Row;
	public static String[][] object = null;

	public static String[][] getTableArray(String FilePath, String FileName,String SheetName) throws Exception
		{   

			try {
			   //Create a object of File class to open xlsx file
			   File file =    new File(FilePath+"\\"+FileName);
			   System.out.println(file);

			   FileInputStream ExcelFile = new FileInputStream(file);
			   System.out.println("Hello world");

			   // Access the required test data sheet
			   //Find the file extension by splitting file name in substring and getting only extension name
			    String fileExtensionName = FileName.substring(FileName.indexOf("."));


			    //Check condition if the file is .xlsx file
			    if(fileExtensionName.equals(".xlsx"))
			    {
			    //If it is xlsx file then create object of XSSFWorkbook class
			    	ExcelWBook = new XSSFWorkbook(ExcelFile);
			    	System.out.println(ExcelWBook);
			    	System.out.println(fileExtensionName);
			    }

			    //Check condition if the file is xls file
			    else if(fileExtensionName.equals(".xls"))
			    {
			        //If it is xls file then create object of XSSFWorkbook class
			    	//ExcelWBook = new HSSFWorkbook(ExcelFile);
			    }


			   ExcelWSheet=ExcelWBook.getSheet(SheetName);
			   System.out.println(ExcelWSheet);

			  //Find number of rows in excel file
			    //System.out.println(ExcelWSheet.getPhysicalNumberOfRows());
			    System.out.println(ExcelWSheet.getLastRowNum());
			    System.out.println(ExcelWSheet.getFirstRowNum());

			    int rowCount = ExcelWSheet.getLastRowNum()-ExcelWSheet.getFirstRowNum();

			    int colCount= ExcelWSheet.getRow(0).getLastCellNum();



			    System.out.println("Row count: " +rowCount);
			    System.out.println("Column count: " +colCount);

			    for(int i=1;i<rowCount;i++)
			    {
			    	int k =i-1;
 			    	for(int j=0;j<colCount;j++)
			    	{
			    		System.out.println("Total number of rows"+ i + "cols" + j );
			    		//object[ci][cj] = ExcelWSheet.
			    		//object[i][j] = ExcelWSheet.getRow(i).getCell(j).getStringCellValue();
			    		//object[][] = ExcelWSheet.getActiveCell();
			    		object[k][j] = ExcelWSheet.getRow(i).getCell(j).getStringCellValue();
			    		System.out.println(object[i][j]);
			    	}
			    }
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }

		  System.out.println("");
		return object;


		}
}


 
/*package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	@SuppressWarnings("unused")
	private static XSSFRow Row;

	static int startRow = 1;

	static int startCol = 0;

	static int ci = 0, cj = 0;
	static int totalRows = 0;
	static int totalCols = 0;
	static String[][] tabArray = null;

	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {

		try {

			FileInputStream ExcelFile = new FileInputStream(FilePath);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			int totalRows = ExcelWSheet.getLastRowNum();
			int totalCols = ExcelWSheet.getRow(0).getLastCellNum();

			// you can write a function as well to get Column count

			tabArray = new String[totalRows][totalCols];

			for (int i = startRow; i <= totalRows; i++) {

				int k = i - 1;
				for (int j = startCol; j < totalCols; j++) {

					tabArray[k][j] = getCellData(i, j);

				}

			}

		}

		catch (FileNotFoundException e) {

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e) {

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		return (tabArray);

	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			int dataType = Cell.getCellType();

			if (dataType == 3) {

				return "";

			} else {

				String CellData = Cell.getStringCellValue();

				return CellData;
			}
		} catch (Exception e) {

			throw (e);

		}

	}
}
*/