package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility 
{
	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver;//creating object for creating screenshot//captures screenshot
		java.io.File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//saves screenshot file
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//generate timestamp

		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");
		if (!f1.exists()) {
			f1.mkdirs();
		}
String destination = System.getProperty("user.dir") + "//outputScreenShot//" +

				failedTestCase + timeStamp + ".png";

		File finalDestination = new File(destination);//create final desination for screenshot

		FileHandler.copy(screenShot, finalDestination);//copy Screenshot
	}
}
