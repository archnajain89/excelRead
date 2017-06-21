package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class Screenshot 
{
	
	public static String GetScreenShot(WebDriver driver) throws IOException
	{
	//Save screenshot
	
    File f1 =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    
    String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new Date());

    File f2=new File("D://mysoftware//bhavna//Tasks13062017//Screenshot//"+filename+".png");
    
    FileUtils.copyFile(f1, f2);
    System.out.println(filename+".png"+" ScreenShot saved successfully!!!!!!!");
	return filename;

	}
		
}
