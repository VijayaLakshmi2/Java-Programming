package com.bestbuy.demotests.pageobjects.bestbuycreditcard;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.Button;
import com.bestbuy.demo.exceptions.HtmlElementsException;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demo.utils.Driver.BrowserDriver;
import com.bestbuy.demotests.page.Page;

public class BestBuyCreditCardPageApplication extends Page {
	@Name("BEST_BUY_CREDIT_CARD")
	@FindBy(linkText = "Best Buy Credit Card")
	private Button bestBuyCreditCard;

	@Name("APPLY_BEST_BUY_CREDIT_CARD")
	@FindBy(linkText = "Apply now")
	private Button applyNow;

	private final String BestBuyCreditCardPageError = "Best Buy page is not displayed";
	private final String expectedUrl = "www.bestbuy.ca";

	private CreditCardApplication cardApplication;

	BrowserDriver browserDriver = (BrowserDriver) getDriver();
	JavascriptExecutor jsExec = browserDriver.getJSDriver();

	public BestBuyCreditCardPageApplication(WebDriver driver) {
		super(driver);
		HtmlElementLoader.populatePageObject(this, driver);

		if (urlContains(expectedUrl) == false)
			throw new HtmlElementsException(BestBuyCreditCardPageError);
	}

	public void scrolltoBestBuyCreditCardLink() {
		this.jsExec.executeScript("arguments[0].scrollIntoView()", bestBuyCreditCard);
	}

	public void navigatetoBestBuyCreditCard() {
		bestBuyCreditCard.click();
	}

	public void applyBestBuyCreditCard() {
		this.jsExec.executeScript("arguments[0].scrollIntoView()", applyNow);
		applyNow.click();
	}

	public CreditCardApplication getpage() {
		//cardApplication.CreditCardApplicationNavigation();
		cardApplication.scrolltoGetThisCardLink();
	//	cardApplication.CreditCardApplicationNavigation();
		cardApplication.GetThisCard();
		return cardApplication;

	}

}
