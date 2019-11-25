package com.bestbuy.demotests.pageobjects.results;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.HtmlElement;
import com.bestbuy.demo.exceptions.HtmlElementsException;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demo.utils.Driver.BrowserDriver;
import com.bestbuy.demotests.page.Page;

public class SearchCategoryResultsPage extends Page{

	  @Name("Category_Name")
	  @FindBy(className = "x-crumb")
	  private HtmlElement categoryName;
	  
	  //private final String resultsPageError = "Category results page is not displayed";
	 // private final String expectedUrl = "https://www.bestbuy.ca/en-ca/category";
	  
	  BrowserDriver browserDriver;
	  WebDriverWait wait=new WebDriverWait(getDriver(),60);
	  public SearchCategoryResultsPage(WebDriver driver) {
		 super(driver);		 
		 browserDriver = (BrowserDriver)getDriver();
		 
		 HtmlElementLoader.populatePageObject(this, driver);
		 
	  }  
	  
	  public String getCategoryName() {
		 
			wait.until(ExpectedConditions.visibilityOf(categoryName));
			
		  return categoryName.getText();
	  }
}
