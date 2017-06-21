package base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.relevantcodes.extentreports.ExtentReports;


public class CreateDriver 
{

	public static WebDriver driver;
	public static ExtentReports r;
	public static ExtentHtmlReporter htmlReporter;
	
	@BeforeSuite
	public void StartBrowser()
	{
			
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("https://sso.godaddy.com/?realm=idp&path=%2F&app=mya");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	
	
	@AfterSuite
	public void EndBrowser()
	{
		//driver.quit();
		r.flush();
	}
	
}