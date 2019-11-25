package com.bestbuy.demotests.pageobjects.rating;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demotests.page.Page;

public class SmileyRating extends Page {

	@Name("RATING_1")
	@FindBy(xpath = "//*[@id='usabilla-metadata-container']/div/form/div[2]/fieldset/ul/li[1]/label")
	WebElement rating1;

	@Name("RATING_2")
	@FindBy(xpath = "//*[@id='usabilla-metadata-container']/div/form/div[2]/fieldset/ul/li[2]/label")
	WebElement rating2;

	@Name("RATING_3")
	@FindBy(xpath = "//*[@id='usabilla-metadata-container']/div/form/div[2]/fieldset/ul/li[3]/label")
	WebElement rating3;

	@Name("RATING_4")
	@FindBy(xpath = "//*[@id='usabilla-metadata-container']/div/form/div[2]/fieldset/ul/li[4]/label")
	WebElement rating4;

	@Name("RATING_5")
	@FindBy(xpath = "//*[@id='usabilla-metadata-container']/div/form/div[2]/fieldset/ul/li[5]/label")
	WebElement rating5;

	public SmileyRating(WebDriver driver) {
		super(driver);
		HtmlElementLoader.populatePageObject(this, driver);
	}

	public boolean isCompletelyLoaded() {
		System.out.println("Inside smileyrating ");
		return (rating1.isDisplayed() && rating2.isDisplayed() && rating3.isDisplayed() && rating4.isDisplayed()
				&& rating5.isDisplayed());
	}

	public void selectSmiley(int rating) {
		switch (rating) {
		case 1:
			rating1.click();
			break;
		case 2:
			rating2.click();
			break;
		case 3:
			rating3.click();
			break;
		case 4:
			rating4.click();
			break;
		case 5:
			rating5.click();
			break;
		default:
			break;
		}
	}

}
