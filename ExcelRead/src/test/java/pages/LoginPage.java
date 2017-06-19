package pages;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.ExcelUtility;
import base.CreateDriver;

public class LoginPage extends CreateDriver
{

	//This test method declares that its data should be supplied by the Data Provider
		// "getdata" is the function name which is passing the data
	       // Number of columns should match the number of input parameters
	
	
	
	@DataProvider(name="DP1")
	public String[][] getData() throws Exception
	{
		
		        String[][] retObjArr=ExcelUtility.getTableArray("D:\\data","testdata.xlsx","Sheet1");
		        return(retObjArr);
		 

	}
	
		@Test(dataProvider="DP1")
		public void setData(String username, String password)
		{
		
			System.out.println("you have provided username as::"+username);
			System.out.println("you have provided password as::"+password);
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
			driver.findElement(By.xpath("//input[@id='username']"))	.clear();
			driver.findElement(By.xpath("//input[@id='password']")).clear();
			
		}
		
		
	}
	

