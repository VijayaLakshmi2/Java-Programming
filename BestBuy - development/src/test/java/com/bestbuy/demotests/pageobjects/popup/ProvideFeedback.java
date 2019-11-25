package com.bestbuy.demotests.pageobjects.popup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demotests.pageobjects.rating.SmileyRating;

public class ProvideFeedback extends BackgroundFadePopup {

	@Name("QUESTION_FOR_RATING")
	@FindBy(id = "star-input")
	WebElement qRating;

	SmileyRating smileyRating;

	@Name("QUESTON_FOR_FREETEXT_FEEDBACK")
	@FindBy(id = "comment-input")
	WebElement qFreeText;

	@Name("FREETEXT_FEEDBACK")
	@FindBy(xpath = "//*[@id='usabilla-metadata-container']/div/form/span/div[1]/textarea")
	WebElement freeTextFeedback;

	@Name("SUBMIT_FEEDBACK")
	@FindBy(xpath = "//*[@id='usabilla-metadata-container']/div/form/div[3]/button")
	WebElement submitFeedback;

	public ProvideFeedback(WebDriver driver) {
		super(driver);
		smileyRating = new SmileyRating(driver);
		HtmlElementLoader.populatePageObject(this, driver);

	}

	public boolean isCompletelyLoaded() {
		System.out.println("Inside provide feedback");
		return (/* super.isCompletelyLoaded() && */ qRating.isDisplayed() && smileyRating.isCompletelyLoaded());
	}

	public void giveRating(int rating) {
		smileyRating.selectSmiley(rating);
	}

	public boolean isFullFormLoaded() {
		return (qRating.isDisplayed() && qFreeText.isDisplayed() && freeTextFeedback.isDisplayed()
				&& submitFeedback.isDisplayed());
	}
	public void provideFreeTextFeedback(String feedback)
	{
		freeTextFeedback.sendKeys(feedback);
	}
	public FeedbackConfirmation submitFeedback()
	{
		submitFeedback.click();
		return new FeedbackConfirmation(getDriver());
		
	}

}
