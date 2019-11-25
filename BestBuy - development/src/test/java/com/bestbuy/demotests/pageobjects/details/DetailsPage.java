package com.bestbuy.demotests.pageobjects.details;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bestbuy.demo.annotations.FindByJS;
import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.exceptions.HtmlElementsException;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demo.utils.Driver.BrowserDriver;
import com.bestbuy.demotests.pageobjects.modal.*;
import com.bestbuy.demotests.pageobjects.basket.*;
import com.bestbuy.demotests.page.*;

public class DetailsPage extends Page {
	       
  @Name("ADD_TO_CART")
  //@FindByJS("document.getElementById('btn-cart')")
  @FindBy(className = "addToCartLabel_1eyxz")
  private WebElement addToCartButton;
  
  @Name("image_click")
  @FindBy(xpath = "//img[@src='https://multimedia.bbycastatic.ca/multimedia/products/100x100/135/13506/13506827_1.jpg']")
  private WebElement clickingToImage;
  
  @Name("image_click1")
  @FindBy(xpath = "//img[@src= 'https://multimedia.bbycastatic.ca/multimedia/products/100x100/135/13506/13506827_2.jpg']")
  private WebElement clickingToImage1;
  
  private final String detailsPageError = "details page is not displayed";
  
  private final String expectedUrl = "www.bestbuy.ca/en-ca/product";
    
  public DetailsPage(WebDriver driver) {
	 super(driver); 	 	 
	 HtmlElementLoader.populatePageObject(this, driver);
	 
	 if (urlContains(expectedUrl) == false) 		
	 	 throw new HtmlElementsException(detailsPageError);
	 
	 Modal modal = new Modal(driver);
	 modal.close();
  }
  
  
  public BasketPage addToCart() {	  
	  addToCartButton.click();
	  BasketPage basketPage = new BasketPage(getDriver());
	  
	  if (basketPage.cart().count() != 1 || basketPage.productCount() != 1)
		  throw new RuntimeException("product is not added to cart");
	  
	  return basketPage;
  }
  
   
   public DetailsPage clickimage(){

	   //BrowserDriver browserDriver = (BrowserDriver)getDriver();
	   //JavascriptExecutor jsExec = browserDriver.getJSDriver();
	   //jsExec.executeScript("arguments[0].scrollIntoView()", clickingToImage );
       clickingToImage.click();
	   
   return new DetailsPage(getDriver());
   
   }
   
  
   
   public DetailsPage clickimage1(){
	   
	   //BrowserDriver browserDriver = (BrowserDriver)getDriver();
	   //JavascriptExecutor jsExec = browserDriver.getJSDriver();
	   //jsExec.executeScript("arguments[0].scrollIntoView()", clickingToImage1 );
   clickingToImage1.click();
	   
   return new DetailsPage(getDriver());  
	  
  }
   
   /*@Name("first_tab")
   @FindBy(xpath = "//*[@id='productDetailsTab']/ul[1]/li")
   private WebElement clickToFirstTab;
   public DetailsPage clickingfirsttab() {
	   
	 BrowserDriver browserDriver = (BrowserDriver)getDriver();
	   JavascriptExecutor jsExec = browserDriver.getJSDriver();
	   jsExec.executeScript("arguments[0].scrollIntoView()", clickToFirstTab );
	   
	   clickToFirstTab.click(); 
	   
	 return new DetailsPage(getDriver());
   }*/
   
   @Name("second_tab")
   @FindBy(xpath = "//button[contains(@class,'tabButton_2LhEw')][2]/h2")
   private WebElement clickToSecondTab;
   public DetailsPage clickingsecondtab() {
	   
	   clickToSecondTab.click(); 
	   
	 return new DetailsPage(getDriver());
   } 
  
   @Name("third_tab")
   @FindBy(xpath = "//button[contains(@class,'tabButton_2LhEw')][3]/h2")
   private WebElement clickToThirdTab;
   public DetailsPage clickingthirdtab() {
	   
	   clickToThirdTab.click(); 
	   
	 return new DetailsPage(getDriver());
   }
   
   @Name("fourth_tab")
   @FindBy(xpath = "//button[contains(@class,'tabButton_2LhEw')][4]/h2")
   private WebElement clickToFourthTab;
   public DetailsPage clickingfourthtab() {
	   
	   clickToFourthTab.click(); 
	   
	 return new DetailsPage(getDriver());
   }
   
   @Name("fifth_tab")
   @FindBy(xpath = "//button[contains(@class,'tabButton_2LhEw')][5]/h2")
   private WebElement clickToFifthTab;
   public DetailsPage clickingfifthtab() {
	   
	   clickToFifthTab.click(); 
	   
	 return new DetailsPage(getDriver());
   }
   
   @Name("sixth_tab")
   @FindBy(xpath = "//button[contains(@class,'tabButton_2LhEw')][6]/h2")
   private WebElement clickToSixthTab;
   public DetailsPage clickingsixthtab() {
	   
	   clickToSixthTab.click(); 
	   
	 return new DetailsPage(getDriver());
   }
   
}
