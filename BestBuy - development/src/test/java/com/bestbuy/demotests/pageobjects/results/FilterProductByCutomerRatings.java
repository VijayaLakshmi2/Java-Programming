package com.bestbuy.demotests.pageobjects.results;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.CheckBox;
import com.bestbuy.demo.element.Link;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demo.utils.Driver.BrowserDriver;
import com.bestbuy.demotests.page.Page;

public class FilterProductByCutomerRatings extends Page {

	BrowserDriver browserDriver;

	public FilterProductByCutomerRatings(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		browserDriver = (BrowserDriver) getDriver();

		HtmlElementLoader.populatePageObject(this, driver);
		}

	@Name("Customer Rating")
	@FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[2]/div[1]/div[2]/div[1]/div/ul[7]/li")
	private Link customerRatingsTab;

	// Check boxes-----------------------------------------------------
	@Name("Rating-5")
	@FindBy(id = "facetFilter-5")
	private CheckBox checkboxRating_Five;

	@Name("Rating-4")
	@FindBy(id = "facetFilter-4")
	private CheckBox checkboxRating_Four;

	@Name("Rating-3")
	@FindBy(id = "facetFilter-3")
	private CheckBox checkboxRating_Three;

	@Name("Rating-2")
	@FindBy(id = "facetFilter-2")
	private CheckBox checkboxRating_Two;

	private Wait wait;

	public ResultsPage ClickCheckBoxes() throws InterruptedException {

		System.out.println("Scroll : 1");
		browserDriver = (BrowserDriver) getDriver();
		JavascriptExecutor jsExec = browserDriver.getJSDriver();
		jsExec.executeScript("arguments[0].scrollIntoView()", customerRatingsTab);		
		
		System.out.println("Checkbox : 5"+ " "+ customerRatingsTab.getText());
		customerRatingsTab.click();
		checkboxRating_Five.click();		

		System.out.println("Scroll : 2");		
		jsExec.executeScript("arguments[0].scrollIntoView()", customerRatingsTab);
		
		Thread.sleep(2000);			
		System.out.println("Checkbox : 4"+  " "+customerRatingsTab.getText());
		customerRatingsTab.click();
		checkboxRating_Four.click();

		System.out.println("Scroll : 3");		
		jsExec.executeScript("arguments[0].scrollIntoView()", customerRatingsTab);
		
		Thread.sleep(2000);			
		System.out.println("UnCheckbox : 5"+ " "+customerRatingsTab.getText());
		customerRatingsTab.click();
		checkboxRating_Five.click();

		System.out.println("Scroll : 4");		
		jsExec.executeScript("arguments[0].scrollIntoView()", customerRatingsTab);		
		
		Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		System.out.println("UnCheckbox : 4"+  " "+customerRatingsTab.getText());
		customerRatingsTab.click();
		checkboxRating_Four.click();

		/*
		 * checkboxRating_Three.click(); checkboxRating_Two.click();		 * 
		 * uncheckRating_Three.click(); uncheckRating_Two.click();
		 */

		return new ResultsPage(getDriver());
	}

}
