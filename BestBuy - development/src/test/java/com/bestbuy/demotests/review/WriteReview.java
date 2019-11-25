package com.bestbuy.demotests.review;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bestbuy.demo.utils.TextFile.TextFile;
import com.bestbuy.demotests.pageobjects.home.HomePage;
import com.bestbuy.demotests.testlisteners.TestListener;

import com.bestbuy.demotests.pageobjects.review.ReviewPage;


@Listeners(TestListener.class)
public class WriteReview extends com.bestbuy.demotests.BaseTest.BaseTestClass {

	private void addToLog(String text) {
		(new TextFile()).add("\n " + text);
	}

	@DataProvider(name = "ReviewData")
	public static Object[][] ReviewData() {
		return new Object[][] { { "Review1", "Product was good", "Chanchal", "Bangalore", "Thanks for your review!" },

		};
	}

	// Rating with one star
	@Test(dataProvider = "ReviewData")
	public void provideReviewWithRatingOne(String title, String reviewDetail, String reviewerName1,
			String reviewerLocation1, String successfulMsg) {
		HomePage homePage = new HomePage(driver);

		homePage.openReview();

		ReviewPage review1 = new ReviewPage(driver);

		review1.OneStarReview();

		review1.fillReview(title, reviewDetail, reviewerName1, reviewerLocation1);
		review1.submitReview();
		review1.confirm(successfulMsg);

		// Add test result to the LOG (Text File)
		addToLog(review1.confirm(successfulMsg).toString());

	}

	// rating with two star
	@Test(dataProvider = "ReviewData")
	public void provideReviewWithRatingTwo(String title, String reviewDetail, String reviewerName1,
			String reviewerLocation1, String successfulMsg) {
		HomePage homePage = new HomePage(driver);

		homePage.openReview();

		ReviewPage review1 = new ReviewPage(driver);

		review1.TwoStarReview();

		review1.fillReview(title, reviewDetail, reviewerName1, reviewerLocation1);
		review1.submitReview();
		review1.confirm(successfulMsg);

		// Add test result to the LOG (Text File)
		addToLog(review1.confirm(successfulMsg).toString());

	}

	// rating with three star
	@Test(dataProvider = "ReviewData")
	public void provideReviewWithRatingThree(String title, String reviewDetail, String reviewerName1,
			String reviewerLocation1, String successfulMsg) {
		HomePage homePage = new HomePage(driver);

		homePage.openReview();

		ReviewPage review1 = new ReviewPage(driver);

		review1.ThreeStarReview();

		review1.fillReview(title, reviewDetail, reviewerName1, reviewerLocation1);
		review1.submitReview();
		review1.confirm(successfulMsg);

		// Add test result to the LOG (Text File)
		addToLog(review1.confirm(successfulMsg).toString());

	}

	// rating with four star
	@Test(dataProvider = "ReviewData")
	public void provideReviewWithRatingFour(String title, String reviewDetail, String reviewerName1,
			String reviewerLocation1, String successfulMsg) {
		HomePage homePage = new HomePage(driver);

		homePage.openReview();

		ReviewPage review1 = new ReviewPage(driver);

		review1.FourStarReview();

		review1.fillReview(title, reviewDetail, reviewerName1, reviewerLocation1);
		review1.submitReview();
		review1.confirm(successfulMsg);

		// Add test result to the LOG (Text File)
		addToLog(review1.confirm(successfulMsg).toString());

	}

}
