package pages;
//import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
/*import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;*/

import Utility.ExcelUtility;
import base.CreateDriver;

public class LoginPage extends CreateDriver
{


/*	@DataProvider(name="DP1")
	public Object[][] getData() throws Exception
	{
		
		        Object[][] retObjArr=ExcelUtility.getTableArray("D:\\data","TestCases01.xlsx","validdata");
		        return(retObjArr);
		 

	}
	*/
//	
//	public Object[][] getData1() throws Exception
//	{
//		
//		        Object[][] retObjArr=ExcelUtility.getTableArray("D:\\data","testdata.xlsx","invaliddata");
//		        return(retObjArr);
//		 
//
//	}

	//This test method declares that its data should be supplied by the Data Provider
		// "getdata" is the function name which is passing the data
	       // Number of columns should match the number of input parameters
	
	/*@Test(dataProvider="DP1")
	public void setData(String username, String password) throws InterruptedException
	{
	
		System.out.println("you have provided username as::"+username);
		System.out.println("you have provided password as::"+password);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		Thread.sleep(1000);
		
		
		//Click on Login button
		Login_click();
		driver.navigate().back();
		//driver.findElement(By.xpath("//input[@id='username']")).clear();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='password']")).clear();
		Thread.sleep(2000);
		
		ExtentTest t1=r.startTest("Dataprovider");
		t1.log(LogStatus.PASS, "TEST CASE PASSED");
		r.endTest(t1);
	}*/
	
	
	/*
	public void Login_click()
	{
		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();
		
		
	}*/
}
	