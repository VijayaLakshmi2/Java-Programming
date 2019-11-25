
package com.bestbuy.demotests.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.Link;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demo.utils.Driver.BrowserDriver;
import com.bestbuy.demotests.page.Page;
import com.bestbuy.demotests.pageobjects.createaccount.CreateAccountPage;
import com.bestbuy.demotests.pageobjects.home.HomePage;

public class SigninPage extends Page {

	BrowserDriver browserDriver;
	private Login login;
	
	@Name("CREATEACCOUNT_LINK")
	@FindBy(linkText = "Create an account")
	private Link registrationLink;
	
	public SigninPage(WebDriver driver) {
		super(driver);
		browserDriver = (BrowserDriver) getDriver();
		HtmlElementLoader.populatePageObject(this, driver);
	}

	public HomePage Login(String Username, String Password) {
		login.Login(Username,Password);
		return new HomePage(getDriver());
	}
	
	public CreateAccountPage goToCreateAccount() {
		browserDriver.waitUntilVisible(registrationLink);
		registrationLink.click();
		return new CreateAccountPage(getDriver());
	}
}