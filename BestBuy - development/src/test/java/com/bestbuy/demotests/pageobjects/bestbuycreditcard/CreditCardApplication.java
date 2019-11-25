package com.bestbuy.demotests.pageobjects.bestbuycreditcard;

import java.util.ArrayList;

import org.apache.log4j.or.ThreadGroupRenderer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.Button;
import com.bestbuy.demo.exceptions.HtmlElementsException;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demo.utils.Driver.BrowserDriver;
import com.bestbuy.demotests.page.Page;

public class CreditCardApplication extends Page {
	private final String CreditCardApplicationPageError = "Credit Card Application page is not displayed";
	private final String expectedUrl = "https://pservices.desjardins.com/scd/wr/application.html?Open&pe=peBestBuyHQC&appopenmode=external";
	BrowserDriver browserDriver = (BrowserDriver) getDriver();

	JavascriptExecutor jsExec = browserDriver.getJSDriver();
	@Name("GET_THIS_CARD")
	@FindBy(xpath = "//*[@id='choixCarte']/div/div/div/div[3]/button")
	// @FindBy(linkText = "Get this card")
	private Button GetThisCard;

	public CreditCardApplication(WebDriver driver) {
		super(driver);
		HtmlElementLoader.populatePageObject(this, driver);

		if (urlContains(expectedUrl) == false)
			throw new HtmlElementsException(CreditCardApplicationPageError);
	}

	public void CreditCardApplicationNavigation() {
		ArrayList<String> tabs2 = new ArrayList<String>(browserDriver.getWindowHandles());
		browserDriver.switchTo().window(tabs2.get(1));
	}

	public void scrolltoGetThisCardLink() {
	    //WebDriverWait wait = new WebDriverWait(browserDriver, 100);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/form/div[1]/div[1]/div[1]/div/div/div/div/div/div/div/div/div[3]/button")));
		//	wait.until(ExpectedConditions.visibilityOfElementLocated(GetThisCard));
					this.jsExec.executeScript("arguments[0].scrollIntoView()", GetThisCard);
	}

	public void GetThisCard() {
		GetThisCard.click();
	}

}
