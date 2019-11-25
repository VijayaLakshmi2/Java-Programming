package com.bestbuy.demo.utils.Driver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.bestbuy.demo.utils.Property.PropertyFile;

public class Screenshot {
	org.apache.log4j.Logger log; 
	private WebDriver driver;	
	private final String folderPath;
	
	private final String folderNotExistError = "screenshot folder does not exist";
	private final String cannotCleanFolderError = "cannot clean screenshot folder";
	private final String cannotCaptureScreenshotError = "cannot capture the screenshot";
	
	
	public Screenshot(WebDriver driver) throws Exception {		
		this.driver = driver;
		folderPath = new PropertyFile().get("screenshotsFolderPath");
		validateFolderExists();	
		//log=ActivityLogger.intializeLogger("");
	}

	private void validateFolderExists() {
		File screenShotFolder = new File(folderPath);
		if (!screenShotFolder.exists()) {
			log.info(folderNotExistError);
			throw new RuntimeException(folderNotExistError);
		}
	}
	
	public void cleanFolder()
	{		
		try{					
			File screenShotFolder = new File(folderPath);
			for(File file: screenShotFolder.listFiles()) 
				file.delete();
		}
		catch(Exception ex) {
			log.info(cannotCleanFolderError);
			throw new RuntimeException(cannotCleanFolderError, ex);
		}
	}	
	
	public String capture(String methodName) 
	{		
		File scrFile;
		 
		 try {
			 scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 String screenshotName=getScreenshotName(methodName);
			 FileUtils.copyFile(scrFile, new File(screenshotName));	
			 return screenshotName;
		 } 
		 catch (IOException e) {
			 e.printStackTrace();
		 }
		 
		 log.info(cannotCaptureScreenshotError);
		 throw new RuntimeException(cannotCaptureScreenshotError);
        
    }
	
	private String getScreenshotName(String methodName) {
		 //String localDateTime = LocalDateTime.now().toString().replaceAll("[^0-9a-zA-Z]", "");
		String screenshotDate=new SimpleDateFormat("yyyyMMddHHmm'.png'").format(new Date());
		 String screenshotName ="./src/test/resources/Screenshots/"+methodName+"_"+screenshotDate; 
		//StringBuilder name = new StringBuilder().append(folderPath).append(methodName).append("_").append(screenshotDate).append(".png");
		 return screenshotName.toString();
	 }

}
