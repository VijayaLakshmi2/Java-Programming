package com.bestbuy.demotests.BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bestbuy.demo.utils.Driver.BrowserDriver;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

public class BaseTestClass {
	
	public WebDriver driver;
	public static Logger log = Logger.getLogger("errorLogger");
	static Test test;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp(Method m) {	
		test = m.getAnnotation(Test.class);
		driver = new BrowserDriver("chrome"); 	
		driver.manage().window().maximize(); 
		
	}   
	      
	/*@AfterMethod(alwaysRun = true)
	public void tearDown() { 
		driver.quit(); 
		
	}*/
	
	/**
	 * Gets the group name of the test case.
	 *
	 * @return the group name
	 */
	public static String getGroupName()
	{
		return test.groups()[0];
	}

}
