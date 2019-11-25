package com.bestbuy.demotests.pageobjects.popup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demotests.page.Page;

public class FeedbackConfirmation extends BackgroundFadePopup {

	public FeedbackConfirmation(WebDriver driver) {
		super(driver);
		HtmlElementLoader.populatePageObject(this, driver);
		// TODO Auto-generated constructor stub
	}

	@Name("QUESTION_FOR_RATING")
	@FindBy(xpath = "//*[@id='usabilla-metadata-container']/div/div/h2")
	WebElement confirmationMessage;

	@Name("QUESTION_FOR_RATING")
	@FindBy(xpath = "//*[@id='usabilla-metadata-container']/div/div/a[2]")
	WebElement continueBrowsing;

	public boolean isCompletelyLoaded() {
		System.out.println("confirmation message: "+confirmationMessage.getText());
		System.out.println("continue browsing: "+continueBrowsing.getText());
		return (confirmationMessage.isDisplayed() && continueBrowsing.isDisplayed());
	}

	public String continueBrowsing() {
		continueBrowsing.click();
		return this.getDriver().getCurrentUrl();
	}
}
