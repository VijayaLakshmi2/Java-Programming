package com.bestbuy.demotests.testpages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bestbuy.demo.utils.Excel;
import com.bestbuy.demo.utils.Property.PropertyFile;
import com.bestbuy.demotests.BaseTest.BaseTestClass;
import com.bestbuy.demotests.pageobjects.home.HomePage;

@Listeners(com.bestbuy.demotests.testlisteners.TestListener.class)
public class SearchByCategory extends BaseTestClass {
	
	static PropertyFile propertyfile=new PropertyFile();
	
	static Excel excel= new Excel(propertyfile.get("ExcelPathForTestData"));
	
	Map<String, String> map=new HashMap<String, String>();
	
	@DataProvider(name = "categoryValues")
	public static Object[][] Categories() {
		Object[][] categories=excel.readData("Categories");
		return categories;
	    	  
	}
	

	@Test(groups={"Smoke"})
	public void TC166() throws IOException{
		//ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test1");
		HomePage homePage = new HomePage(driver);	
		
		//log.info("Test is started using log4j");
		Boolean result=homePage.open().navigation("Shop").getCategoriesList();
		Assert.assertTrue(result);

		//TestListener.reportLog("Get Categories List");
	}
	
	//@Test(dataProvider = "categoryValues",groups={"Smoke"})
	@Test(groups={"Smoke"})
	public void TC243() throws IOException{
		
		//map=categoryName;
		
		HomePage homePage = new HomePage(driver);	
		//String data=map.get("Category");
		
		Boolean result=homePage.open().navigation("Shop").getSubCategoriesList("Musical Instruments");
		//homePage.open().navigation("Shop").getSubCategoriesList(map.get("Category"));
		
		Assert.assertTrue(result);
		
		//TestListener.reportLog("Get Sub Categories List");
	}
	
	@Test(groups={"Regression"})
	public void TC246() throws IOException{
		HomePage homePage = new HomePage(driver);	
		
		
		Boolean result=homePage.open().navigation("Shop").clickOnCategory("Musical Instruments");
		Assert.assertTrue(result);
		
		//TestListener.reportLog("Click on Category");
	}
	
	//@Test(groups={"Regression"})
	@Test
	public void TC244() throws AWTException{
		HomePage homePage = new HomePage(driver);	
		
		//homePage.open().navigation("Shop").getSubCategoriesList("Musical Instruments");
		Boolean result=homePage.open().navigation("Shop").clickOnSubCategory("Musical Instruments","Karaoke, Audio & Recording");
		Assert.assertTrue(result);
		
		//TestListener.reportLog("Click on Sub Category");
		
	}
}
