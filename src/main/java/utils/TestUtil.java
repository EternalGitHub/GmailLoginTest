package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.TestBase;

public class TestUtil extends TestBase
{

	public static long PAG_LOAD_TIMEOUT = 20;
	 public static long IMPLICIT_WAIT = 20;
	 
	 public static void takeScreenShot() throws IOException
	 {
	 	File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 	String currentDir = System.getProperty("user.dir");
	 	FileUtils.copyFile(f, new File(currentDir + "/ScreenShot/" + System.currentTimeMillis()+ ".png"));
	 	
	 }
}


