package com.bestbuy.demotests.pageobjects.emailpreference;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.bestbuy.demotests.page.Page;

public class EmailPreferencePage extends Page {

	public EmailPreferencePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
		
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/footer/div[1]/div/div[1]/div/div[2]/div[2]/ul/li[3]/a/span")
	WebElement emailPreferences;
	
	@FindBy(xpath="//*[@id=\"email\"]")
	WebElement emailAddress;
	
	@FindBy(id="postalCode")
	WebElement postalCode;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[1]/div/div/div[2]/div[2]/form/div/button/span/span")
	WebElement signUp;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[1]/div/div/div[2]/div[2]/h2")
	WebElement textBeforeSignUp;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[1]/div/div/div[2]/h1")
	WebElement textAfterSignUp;
	
	public void navigateToEmailPreferences() {
		emailPreferences.click();
	}
	
public void setEmailAddressSignUp(String emailAddressValue) {
	emailAddress.sendKeys(emailAddressValue);
}

public void setPostalCode(String postalCodeValue) {
	postalCode.sendKeys(postalCodeValue);
}

public void signUpEmailPreference() {
	signUp.click();
}


public String getTextBeforeSignUp() {
	
	return textBeforeSignUp.getText();
}

public String getTextAfterSigningUp() {
	return textAfterSignUp.getText();
}
	
}
