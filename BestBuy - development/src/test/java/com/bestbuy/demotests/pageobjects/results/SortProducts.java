package com.bestbuy.demotests.pageobjects.results;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.bestbuy.demo.element.Select;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demotests.page.Page;

//Owner: Richa Shrivastava
//Purpose: Page object model for "Sorting" logic 

public class SortProducts extends Page {

	// @Name("Sort")
	// @FindBy(xpath="//select[@id='Sort']")

	@FindBy(name = "Sort") // Defining a location of "Sort Button"
	private Select sortButton; // Creating a variable for "Sort Button"

	// Creating a driver constructor for SortProducts
	public SortProducts(WebDriver driver) {
		super(driver);
		HtmlElementLoader.populatePageObject(this, driver);
	}

	// Logic to Sort the products by "Price Low-High"
	public ResultsPage sortLowToHigh() throws InterruptedException {
		ResultsPage resultsPage = new ResultsPage(getDriver());
		Select select = (Select) sortButton;
		select.selectByValue("priceLowToHigh");
		Thread.sleep(3000);
		return resultsPage;
	}

	// Logic to Sort the products by "Price High-Low"
	public ResultsPage sortHighToLow() throws InterruptedException {
		ResultsPage resultsPage = new ResultsPage(getDriver());
		Select select = (Select) sortButton;
		select.selectByValue("priceHighToLow");
		Thread.sleep(3000);
		return resultsPage;
	}

	// Logic to Sort the products by "Highest Rated"
	public ResultsPage highestRated() throws InterruptedException {
		ResultsPage resultsPage = new ResultsPage(getDriver());
		Select select = (Select) sortButton;
		select.selectByValue("highestRated");
		Thread.sleep(3000);
		return resultsPage;
	}

	// Logic to Sort the products by "Best Match"
	public ResultsPage sortBestMatch() throws InterruptedException {
		ResultsPage resultsPage = new ResultsPage(getDriver());
		Select select = (Select) sortButton;
		select.selectByValue("bestMatch");
		Thread.sleep(3000);
		return resultsPage;
	}

}
