package com.bestbuy.demotests.pageobjects.popup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.loader.HtmlElementLoader;

public class ChooseFeedbackCategory extends BackgroundFadePopup {
	@Name("CARD_FOR_SPECIFIC_FEEDBACK")
	@FindBy(xpath = "//*[@id='contents']/div[2]")
	WebElement cardForSpecificFeedback;

	@Name("CARD_FOR_GENERAL_FEEDBACK")
	@FindBy(xpath = "//*[@id='contents']/div[3]")
	WebElement cardForGeneralFeedback;

	public ChooseFeedbackCategory(WebDriver driver) {
		super(driver);
		HtmlElementLoader.populatePageObject(this, driver);
	}

	public boolean isCompletelyLoaded(WebDriver driver) {
		return (super.isCompletelyLoaded() && cardForSpecificFeedback.isDisplayed()
				&& cardForGeneralFeedback.isDisplayed());
	}

	public ProvideFeedback clickGeneralFeedbackCard() {

		cardForGeneralFeedback.click();
		return new ProvideFeedback(getDriver());

	}

}
