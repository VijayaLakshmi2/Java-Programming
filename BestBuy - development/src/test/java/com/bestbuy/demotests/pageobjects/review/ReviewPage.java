package com.bestbuy.demotests.pageobjects.review;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.Button;

import com.bestbuy.demo.element.TextInput;
import com.bestbuy.demo.loader.HtmlElementLoader;

import com.bestbuy.demo.utils.Driver.BrowserDriver;
import com.bestbuy.demotests.page.Page;

import junit.framework.Assert;

@Name("Review Page")
@FindBy(className = "formContainer_SNmdi")
public class ReviewPage extends Page {

	// WebDriver driver;
	WebDriverWait wait;

	public ReviewPage(WebDriver driver) {
		super(driver);
		HtmlElementLoader.populatePageObject(this, driver);
		wait = new WebDriverWait(driver, 20);

	}

	// find the location of review title
	@Name("Review_Title")
	@FindBy(id = "title")
	private TextInput Title;

	// find the location of review comment box
	@Name("Review_Details")
	@FindBy(id = "comment")
	private TextInput reviewDetails;

	// find the reviewer name
	@Name("Reviewer_Name")
	@FindBy(id = "reviewerName")
	private TextInput reviewerName;

	// find the reviewerName Location
	@Name("Reviewer_Location")
	@FindBy(id = "reviewerLocation")
	private TextInput reviewerLocation;

	// to locate the submit button
	@Name("Submit_Review")
	@FindBy(css = ".content_3dXxd")
	private Button submitReview;

	// to select rating as one Star
	@Name("Rating_OneStart")
	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[2]/div/form/div[2]/div/div/div[1]/div[2]/div/button[1]/svg")
	private Button oneStar;

	// to select rating two Star
	@Name("Rating_TwoStart")
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div/form/div[2]/div/div/div[1]/div[2]/div/button[1]/svg/path")
	private Button twoStar;

	// to select rating three Star
	@Name("Rating_ThreeStart")
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div/form/div[2]/div/div/div[1]/div[2]/div/button[1]/svg/path")
	private Button threeStar;

	// to select rating four Star
	@Name("Rating_FourStart")
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div/form/div[2]/div/div/div[1]/div[2]/div/button[1]/svg/path")
	private Button fourStar;

	// to select successful message
	@Name("SuccessFul_Review")
	@FindBy(className = "thanksHeadline_1Dh6k")
	private WebElement successMessage;

	// to select blank title error message
	@Name("TitleBlank_Error")
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div/form/div[3]/div[1]/div[1]/div/div[2]")
	private WebElement ErrorMessage;

	// to select rating error message
	@Name("Rating_Error")
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[2]/div/form/div[2]/div/div/div[2]")
	private WebElement ratingErrorMsg;

	// method to fill the review
	public void fillReview(String title, String reviewDetail, String reviewerName1, String reviewerLocation1) {

		// to fill title
		Title.click();
		Title.clear();
		Title.sendKeys(title);

		// to fill review details
		reviewDetails.click();
		reviewDetails.clear();
		reviewDetails.sendKeys(reviewDetail);

		// to fill the reviewer name
		reviewerName.clear();
		reviewerName.click();
		reviewerName.sendKeys(reviewerName1);

		// to fill the reviewer location
		reviewerLocation.click();
		reviewerLocation.clear();
		reviewerLocation.sendKeys(reviewerLocation1);

	}

	// Select rating as oneStart
	public void OneStarReview() {

		try {

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector("button:nth-child(1) > .emptyStar_1G0Fx"))).click();

		} catch (ElementNotVisibleException e) {

			System.out.println(e);

		}
	}

	// Select rating as twoStart
	public void TwoStarReview() {

		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector("button:nth-child(2) > .emptyStar_1G0Fx"))).click();

		} catch (ElementNotVisibleException e) {

			System.out.println(e);

		}

	}

	// Select rating as threeStart
	public void ThreeStarReview() {

		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector("button:nth-child(3) > .emptyStar_1G0Fx"))).click();

		} catch (ElementNotVisibleException e) {

			System.out.println(e);

		}

	}

	// Select rating as FourStar
	public void FourStarReview() {

		try {

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector("button:nth-child(4) > .emptyStar_1G0Fx"))).click();

		} catch (ElementNotVisibleException e) {

			System.out.println(e);

		}

	}

	// to submit the review
	public void submitReview() {
		try {

			submitReview.click();

		} catch (TimeoutException e) {
			System.out.println(e);
		}
	}

	// to confirm successful review msg
	public String confirm(String successlMsg) {

		  
		//Code to scroll up - this is not working though
		BrowserDriver browserDriver = (BrowserDriver) getDriver();
		browserDriver = new BrowserDriver("chrome");
		JavascriptExecutor js;
		js = browserDriver.getBrowserDriver();
		js.executeScript("window.scrollBy(-250,0)", "");

		String msg;

		try {
			Assert.assertEquals(successlMsg, successMessage.getText());
			msg = "review submitted successfully";
		} catch (NoSuchElementException e) {
			System.out.println(e);
			msg = "Test Case failed, review submission failed";
		}
		return msg;
	}

	public void fillReviewWithoutTitle(String reviewDetail, String reviewerName1, String reviewerLocation1) {

		// to fill review details
		reviewDetails.click();
		reviewDetails.clear();
		reviewDetails.sendKeys(reviewDetail);

		// to fill the reviewer name
		reviewerName.clear();
		reviewerName.click();
		reviewerName.sendKeys(reviewerName1);

		// to fill the reviewer location
		reviewerLocation.click();
		reviewerLocation.clear();
		reviewerLocation.sendKeys(reviewerLocation1);

	}

	public String confirmError(String ErrorMsg, WebDriver driver) {

		String msg;
		try {
			Assert.assertEquals(ErrorMsg, ErrorMessage.getText());
			msg = "Test case passed:Title was not filled thus review submission failed";
		} catch (NoSuchElementException e) {

			System.out.println(e);
			msg = "Test case failed:Title not provided error message didn't match";
		}
		return msg;
	}

	public String confirmRatingError(String errorMsg, WebDriver driver) {

		String msg;
		try {
			Assert.assertEquals(errorMsg, ratingErrorMsg.getText());
			msg = "Test case passed: Rating was not selected thus review submission failed";
		} catch (NoSuchElementException e) {
			System.out.println(e);
			msg = "Test case failed:Rating not selected error message didn't match";

		}
		return msg;

	}
}
