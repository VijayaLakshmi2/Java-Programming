package com.bestbuy.demotests.pageobjects.creditcard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.TextInput;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demo.utils.Driver.BrowserDriver;
import com.bestbuy.demotests.page.Page;
import com.bestbuy.demotests.testlisteners.TestListener;

public class CreditCardPage extends Page{
	
	BrowserDriver browserDriver;
	@Name("ADD_NEW_CARD")
	@FindBy(xpath  = "//button[@class='_1iZ4o']")
	TextInput addNewCardButton;
	
	public CreditCardPage(WebDriver driver) {
		super(driver);
		browserDriver = (BrowserDriver) getDriver();
		HtmlElementLoader.populatePageObject(this, driver);
	}

	
	/**
	 * Click on new card in myaccount page.
	 */
	public AddCreditCardPage clickOnNewCard()
	{
		browserDriver.waitUntilVisible(addNewCardButton);
		addNewCardButton.click();
		TestListener.reportLog("Clicked on add new card button. element is :" +addNewCardButton);
		return new AddCreditCardPage(getDriver());
	}
	
	 
	
}
