package com.bestbuy.demotests.review;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bestbuy.demo.utils.TextFile.TextFile;
import com.bestbuy.demotests.pageobjects.home.HomePage;
import com.bestbuy.demotests.pageobjects.review.ReviewPage;
import com.bestbuy.demotests.testlisteners.TestListener;

@Listeners(TestListener.class)
public class WriteReviewNegativeScenarios extends com.bestbuy.demotests.BaseTest.BaseTestClass {

	private void addToLog(String text) {
		(new TextFile()).add("\n " + text);
	}

	@DataProvider(name = "ReviewData1")
	public static Object[][] reviewData1() {
		return new Object[][] { { "Review1", "Product was good", "Chanchal", "Bangalore",
				"Please write a review title. Write a short headline for your review." },

		};
	}

	@DataProvider(name = "ReviewData2")
	public static Object[][] ReviewData2() {
		return new Object[][] { { "Review1", "Product was good", "Chanchal", "Bangalore", "Please rate this product." },

		};
	}

	// Test Case without title
	@Test(dataProvider = "ReviewData1")
	public void provideReviewWithoutTitle(String title, String reviewDetail, String reviewerName1,
			String reviewerLocation1, String errorMsg) {
		HomePage homePage = new HomePage(driver);

		homePage.openReview();

		ReviewPage review1 = new ReviewPage(driver);

		review1.OneStarReview();

		review1.fillReviewWithoutTitle(reviewDetail, reviewerName1, reviewerLocation1);
		review1.submitReview();
		review1.confirmError(errorMsg, driver);

		// Add test result to the LOG (Text File)
		addToLog(review1.confirmError(errorMsg, driver).toString());

	}

	// Test Case without Rating
	@Test(dataProvider = "ReviewData2")
	public void provideReviewWithoutSelectingRating(String title, String reviewDetail, String reviewerName1,
			String reviewerLocation1, String errorMsg) {
		HomePage homePage = new HomePage(driver);

		homePage.openReview();

		ReviewPage review1 = new ReviewPage(driver);
		review1.fillReview(title, reviewDetail, reviewerName1, reviewerLocation1);
		review1.submitReview();
		review1.confirmRatingError(errorMsg, driver);

		// Add test result to the LOG (Text File)
		addToLog(review1.confirmRatingError(errorMsg, driver).toString());

	}

}
