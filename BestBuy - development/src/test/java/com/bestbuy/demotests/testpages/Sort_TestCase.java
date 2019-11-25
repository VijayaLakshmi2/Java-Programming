package com.bestbuy.demotests.testpages;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.bestbuy.demo.utils.TextFile.TextFile;
import com.bestbuy.demotests.pageobjects.home.HomePage;
import com.bestbuy.demotests.pageobjects.results.ResultsPage;
import com.bestbuy.demotests.pageobjects.results.SortProducts;
import com.bestbuy.demotests.testlisteners.TestListener;

//Owner: Richa Shrivastava
//Purpose: "Sort Products" Test cases for selecting the dropdowns

@Listeners(TestListener.class)
public class Sort_TestCase extends com.bestbuy.demotests.BaseTest.BaseTestClass {

	private void addToLog(String text) {
		(new TextFile()).add("\n " + text);
	}

	// Creating data providers for dynamic search
	@DataProvider(name = "keywordValues")
	public static Object[][] primeNumbers() {
		return new Object[][] { { "iphone" },
//	    	  						{"Phone"}, 
		};
	}

	// ---->TestCase-1: Sort products by "Price Low-High"

	@Test(priority = 1, dataProvider = "keywordValues")
	public void sortProductsByLowToHigh(String keyword) throws InterruptedException {
		HomePage homePage = new HomePage(driver);

		ResultsPage resultsPage = homePage.open().search(keyword);
		SortProducts sortProducts = new SortProducts(driver);
		resultsPage = sortProducts.sortLowToHigh();

	}

	// ---->TestCase-1: Sort products by "Price High-Low"

	@Test(priority = 2, dataProvider = "keywordValues")
	public void sortProductsByHighToLow(String keyword) throws InterruptedException {
		HomePage homePage = new HomePage(driver);

		ResultsPage resultsPage = homePage.open().search(keyword);
		SortProducts sortProducts = new SortProducts(driver);
		resultsPage = sortProducts.sortHighToLow();
	}

	// ---->TestCase-1: Sort products by "Highest Rated"

	@Test(priority = 3, dataProvider = "keywordValues")
	public void sortProductsByhighestRated(String keyword) throws InterruptedException {
		HomePage homePage = new HomePage(driver);

		ResultsPage resultsPage = homePage.open().search(keyword);
		SortProducts sortProducts = new SortProducts(driver);
		resultsPage = sortProducts.highestRated();
	}

	// ---->TestCase-1: Sort products by "Best Match"

	@Test(priority = 4, dataProvider = "keywordValues")
	public void sortProductsByBestMatch(String keyword) throws InterruptedException {
		HomePage homePage = new HomePage(driver);

		ResultsPage resultsPage = homePage.open().search(keyword);
		SortProducts sortProducts = new SortProducts(driver);
		resultsPage = sortProducts.sortBestMatch();
	}

}