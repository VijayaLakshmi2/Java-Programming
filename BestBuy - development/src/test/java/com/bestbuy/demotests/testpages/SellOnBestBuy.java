package com.bestbuy.demotests.testpages;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import com.bestbuy.demotests.BaseTest.BaseTestClass;
import com.bestbuy.demotests.pageobjects.home.HomePage;

public class SellOnBestBuy extends BaseTestClass {
	JavascriptExecutor js;

	
	@Test(priority = 1)
	public void ScrollHorizontally() {

		HomePage homePage = new HomePage(driver);
		homePage.open();
		// js= (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,1000)");
		ScrollDownforSellOnBestBuy scroll = new ScrollDownforSellOnBestBuy(driver);
		scroll.SellOnBestBuyClick();
		System.out.println("Sell On Best Buy button is clicked");
	}

	@Test(priority = 2)
	public void ApplyButtonClick() {
		HomePage homePage = new HomePage(driver);
		homePage.open();
		// js= (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,1000)");
		ScrollDownforSellOnBestBuy scroll = new ScrollDownforSellOnBestBuy(driver);
		scroll.SellOnBestBuyClick();
		System.out.println("Sell On Best Buy button is clicked");
		scroll.ApplyClick();
		System.out.println("Apply On Best Seller");
	}
}
