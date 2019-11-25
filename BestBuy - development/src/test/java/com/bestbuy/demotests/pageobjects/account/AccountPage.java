package com.bestbuy.demotests.pageobjects.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.Link;
import com.bestbuy.demo.exceptions.HtmlElementsException;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demo.utils.Driver.BrowserDriver;
import com.bestbuy.demotests.page.Page;
import com.bestbuy.demotests.pageobjects.AddAddress.AddressPage;
import com.bestbuy.demotests.pageobjects.creditcard.CreditCardPage;
import com.bestbuy.demotests.testlisteners.TestListener;

public class AccountPage extends Page{

	  BrowserDriver browserDriver;
	  private final String expectedUrl = "credit-cards";
	  private final String creditCardPageError = "credit card  page is not displayed";
	  
	  @Name("CREADIT_CARD")
	  @FindBy(xpath  = "//div[@id='nav-side']/div[3]/a")
	  WebElement creditCards;
	  
	  @Name("AddAddress1")
	  @FindBy(xpath = "//*[@id=\"nav-side\"]/div[4]/a/span")
	  private Link addAnAddr;
	 
	  
	/**
	 * Instantiates a new account.
	 *
	 * @param driver the driver
	 */
	public AccountPage(WebDriver driver) {
		super(driver);
		browserDriver = (BrowserDriver) getDriver();
		HtmlElementLoader.populatePageObject(this, driver);
	}
	
	/**
	 * Click on credit cards in myaccount page.
	 */
	public CreditCardPage clickOnCreditCards()
	{
		browserDriver.waitUntilVisible(creditCards);
		creditCards.click();
		 TestListener.reportLog("Clciked on credit cards in account page.");
		if (!urlContains(expectedUrl))
		{
			 TestListener.reportLog(creditCardPageError);
			 throw new HtmlElementsException(creditCardPageError);		
		}
			
		return new CreditCardPage(getDriver());	
	}
	
	public AddressPage MoveAddAddress()  {
		addAnAddr.click();
		return  new AddressPage(getDriver());

	}

}
