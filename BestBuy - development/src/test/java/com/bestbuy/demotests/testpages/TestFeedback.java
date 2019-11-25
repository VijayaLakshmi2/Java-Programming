package com.bestbuy.demotests.testpages;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bestbuy.demo.utils.WebDriverOperations;
import com.bestbuy.demotests.page.Page;
import com.bestbuy.demotests.pageobjects.feedback.Feedback;
import com.bestbuy.demotests.pageobjects.home.HomePage;
import com.bestbuy.demotests.pageobjects.popup.ChooseFeedbackCategory;
import com.bestbuy.demotests.pageobjects.popup.FeedbackConfirmation;
import com.bestbuy.demotests.pageobjects.popup.ProvideFeedback;
import com.bestbuy.demotests.testlisteners.TestListener;

public class TestFeedback extends com.bestbuy.demotests.BaseTest.BaseTestClass {

	private Feedback feedback = null;

	public TestFeedback() {
		feedback = new Feedback(driver);
	}

	@DataProvider(name = "pageNameProvider")
	public static String providePageName() {
		//ArrayList<String> pageNames = new ArrayList<String>();
		//pageNames.add("homepage");
		return "homepage";

	}

	// Check whether or not the Feedback button is available in all the pages of Best Buy website.

	@Test
	public void TC_171() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.open();
		Page testPage = homePage.navigateTo("homepage");
		assertTrue(feedback.isFeedbackButtonDisplayed());

	}

	// Check whether or not the user is navigated to "ChooseFeedbackCategory" on clicking over Feedback button.
	/*@Test
	public void TC_205(String testPageName) throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.open();
		Page testPage = homePage.navigateTo(testPageName);
		ChooseFeedbackCategory chooseFbCategory = feedback.clickFeedbackButton();
		Thread.sleep(5000);
		driver.switchTo().frame(4);
		assertTrue(chooseFbCategory.isCompletelyLoaded());

	}

	// Check whether or not the user is navigated to "ProvideFeedback" page on clicking over the "General Feedback" card.
	@Test
	public void TC_197_a(String testPageName) throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.open();
		Page testPage = homePage.navigateTo(testPageName);
		ChooseFeedbackCategory chooseFbCategory = feedback.clickFeedbackButton();
		Thread.sleep(5000);
		driver.switchTo().frame(4);
		ProvideFeedback provideFeedback = chooseFbCategory.clickGeneralFeedbackCard();
		Thread.sleep(5000);
		driver.switchTo().frame(4);
		assertTrue(provideFeedback.isCompletelyLoaded());
	}

	// Check whether or not more web elements are shown in the pop up when clicked over the smiley rater.
	@Test
	public void TC_232(String testPageName) throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.open();
		Page testPage = homePage.navigateTo(testPageName);
		ChooseFeedbackCategory chooseFbCategory = feedback.clickFeedbackButton();
		Thread.sleep(5000);
		driver.switchTo().frame(4);
		ProvideFeedback provideFeedback = chooseFbCategory.clickGeneralFeedbackCard();
		Thread.sleep(5000);
		driver.switchTo().frame(4);
		provideFeedback.giveRating(5);
		assertTrue(provideFeedback.isFullFormLoaded());

	}

	// Check whether or not the user is navigated to "Feedback confirmation" screen when clicked on "Submit" button.
	@Test
	public void TC_235(String testPageName) throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.open();
		Page testPage = homePage.navigateTo(testPageName);
		ChooseFeedbackCategory chooseFbCategory = feedback.clickFeedbackButton();
		Thread.sleep(5000);
		driver.switchTo().frame(4);
		ProvideFeedback provideFeedback = chooseFbCategory.clickGeneralFeedbackCard();
		Thread.sleep(5000);
		driver.switchTo().frame(4);
		provideFeedback.giveRating(5);
		provideFeedback.provideFreeTextFeedback("Excellent shopping experience");
		FeedbackConfirmation confirmationPage = provideFeedback.submitFeedback();
		Thread.sleep(5000);
		assertTrue(confirmationPage.isCompletelyLoaded());
	}

	// Check whether or not "Feedback confirmation" screen is collapsed once user clicks on "Continue Browsing" button.
	@Test
	public void TC_238(String testPageName) throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.open();
		Page testPage = homePage.navigateTo(testPageName);
		String testPageUrl = driver.getCurrentUrl();
		ChooseFeedbackCategory chooseFbCategory = feedback.clickFeedbackButton();
		Thread.sleep(5000);
		driver.switchTo().frame(4);
		ProvideFeedback provideFeedback = chooseFbCategory.clickGeneralFeedbackCard();
		Thread.sleep(5000);
		driver.switchTo().frame(4);
		provideFeedback.giveRating(5);
		provideFeedback.provideFreeTextFeedback("Excellent shopping experience");
		FeedbackConfirmation confirmationPage = provideFeedback.submitFeedback();
		Thread.sleep(5000);
		assertTrue(testPageUrl.equals(confirmationPage.continueBrowsing()));
	}

	// @Test
	// public void TC_205() throws InterruptedException {
	// HomePage homePage = new HomePage(driver);
	// homePage.open();
	// ChooseFeedbackCategory feedbackType = homePage.clickFeedbackButton();
	// Thread.sleep(5000);
	// System.out.println(driver.findElements(By.tagName("iframe")).size());
	// driver.switchTo().frame(4);
	// assertTrue(feedbackType.isCompletelyLoaded(driver));
	//
	// }
	//
	// @Test
	// public void TC_197_a() throws InterruptedException {
	// HomePage homePage = new HomePage(driver);
	// homePage.open();
	// ChooseFeedbackCategory feedbackType = homePage.clickFeedbackButton();
	// Thread.sleep(5000);
	// System.out.println(driver.findElements(By.tagName("iframe")).size());
	// driver.switchTo().frame(4);
	// ProvideFeedback provideFeedback =
	// feedbackType.clickGeneralFeedbackCard();
	// Thread.sleep(5000);
	// driver.switchTo().frame(4);
	// System.out.println("Switched to provide feedback frame");
	// Thread.sleep(5000);
	// assertTrue(provideFeedback.isCompletelyLoaded());
	//
	// }
	//
	// @Test
	// public void TC_232() throws InterruptedException {
	// HomePage homePage = new HomePage(driver);
	// homePage.open();
	// ChooseFeedbackCategory feedbackType = homePage.clickFeedbackButton();
	// Thread.sleep(5000);
	// System.out.println(driver.findElements(By.tagName("iframe")).size());
	// driver.switchTo().frame(4);
	// ProvideFeedback provideFeedback =
	// feedbackType.clickGeneralFeedbackCard();
	// Thread.sleep(5000);
	// driver.switchTo().frame(4);
	// System.out.println("Switched to provide feedback frame");
	// Thread.sleep(5000);
	// provideFeedback.giveRating(5);
	// assertTrue(provideFeedback.isFullFormLoaded());
	//
	// }
	//
	// @Test
	// public void TC_235() throws InterruptedException {
	//
	// WebDriverOperations driverOperations = new WebDriverOperations(driver);
	//
	// HomePage homePage = new HomePage(driver);
	// homePage.open();
	// ChooseFeedbackCategory feedbackType = homePage.clickFeedbackButton();
	// Thread.sleep(5000);
	// System.out.println(driver.findElements(By.tagName("iframe")).size());
	// driverOperations.switchToFrame(5);
	// ProvideFeedback provideFeedback =
	// feedbackType.clickGeneralFeedbackCard();
	// Thread.sleep(5000);
	// driverOperations.switchToFrame(5);
	// System.out.println("Switched to provide feedback frame");
	// Thread.sleep(5000);
	// provideFeedback.giveRating(5);
	// provideFeedback.provideFreeTextFeedback("Excellent shopping experience");
	// FeedbackConfirmation feedConfirmation = provideFeedback.submitFeedback();
	// Thread.sleep(9000);
	// assertTrue(feedConfirmation.isCompletelyLoaded());
	// feedConfirmation.continueBrowsing();
	//
	// }*/

}
