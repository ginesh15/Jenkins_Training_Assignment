package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import TestBase.Base;


public class CommonUtils extends Base{
	
	 /*** Method for capturing a screenshot on test failure***/
	public static String getCaptureFailedTestCaseScreenShot(WebDriver driver,String methodName,String error ) {
		
		/*** Capture a screenshot of the current WebDriver instance***/
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		 /*** Get the current date and time to create a unique file name***/
		SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date=new Date();
		String actualDate=format.format(date);
		
		 /*** Construct the path for the screenshot file
        The file name includes the test method name and the error message***/
		String screenshotPath=System.getProperty("user.dir")+"/Reports/screenshots/"+methodName+" "+error+".jpeg";
		
		/*** Copy the captured screenshot to the destination filee***/ 
		File dest = new File(screenshotPath); 
		try {
			 /*** Copy the captured screenshot to the destination file***/
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			 /*** Handle any IOException that may occur during the file copy***/
			e.printStackTrace();
		}
		 /*** Return the path to the saved screenshot***/
		return screenshotPath;
	}

}
