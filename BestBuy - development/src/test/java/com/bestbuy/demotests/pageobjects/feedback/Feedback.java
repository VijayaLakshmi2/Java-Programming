package com.bestbuy.demotests.pageobjects.feedback;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.HtmlElement;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demotests.page.Page;
import com.bestbuy.demotests.pageobjects.popup.ChooseFeedbackCategory;

public class Feedback extends Page {

	public Feedback(WebDriver driver) {
		super(driver);
		HtmlElementLoader.populatePageObject(this, driver);
	}

	@Name("FEEDBACK_BUTTON")
	@FindBy(xpath = "//*[@id='root']/div/div/div[4]/div")
	HtmlElement feedBackButton;

	public ChooseFeedbackCategory clickFeedbackButton() {
		feedBackButton.click();
		return new ChooseFeedbackCategory(getDriver());
	}
	
	public boolean isFeedbackButtonDisplayed()
	{
		return feedBackButton.isDisplayed();
	}

}
