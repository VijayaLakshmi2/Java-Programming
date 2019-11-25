package com.bestbuy.demotests.testpages.bestbuycreditcard;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.bestbuy.demo.utils.TextFile.TextFile;
import com.bestbuy.demotests.pageobjects.bestbuycreditcard.BestBuyCreditCardPageApplication;
import com.bestbuy.demotests.pageobjects.bestbuycreditcard.CreditCardApplication;
import com.bestbuy.demotests.pageobjects.home.HomePage;
import com.bestbuy.demotests.testlisteners.TestListener;

@Listeners(TestListener.class)
public class BestBuyCreditCardTC extends com.bestbuy.demotests.BaseTest.BaseTestClass {
	@Test(priority = 0)
	public void navigateToBestBuyCreditCardApplication() {
		HomePage homePage = new HomePage(driver);
		homePage.open();
		BestBuyCreditCardPageApplication bestBuyCreditCardPageApplication = new BestBuyCreditCardPageApplication(
				driver);
		bestBuyCreditCardPageApplication.scrolltoBestBuyCreditCardLink();
		bestBuyCreditCardPageApplication.navigatetoBestBuyCreditCard();
		String actualresult = bestBuyCreditCardPageApplication.getTitle();
		System.out.println(actualresult + "actual result");
		assertEquals(actualresult, "Best Buy Credit Card | Best Buy Canada");
	}
	@Test(priority = 1)
	public void applyBestBuyCreditCard() {
		HomePage homePage = new HomePage(driver);
		homePage.open();
		BestBuyCreditCardPageApplication bestBuyCreditCardPageApplication = new BestBuyCreditCardPageApplication(
				driver);
		bestBuyCreditCardPageApplication.scrolltoBestBuyCreditCardLink();
		bestBuyCreditCardPageApplication.navigatetoBestBuyCreditCard();
		bestBuyCreditCardPageApplication.applyBestBuyCreditCard();		
	}
	@Test(priority = 1)
	public void applyBestBuyCreditCardwithAllValidData() throws Exception {
		HomePage homePage = new HomePage(driver);
		homePage.open();
		BestBuyCreditCardPageApplication bestBuyCreditCardPageApplication = new BestBuyCreditCardPageApplication(
				driver);
		bestBuyCreditCardPageApplication.scrolltoBestBuyCreditCardLink();
		bestBuyCreditCardPageApplication.navigatetoBestBuyCreditCard();
		bestBuyCreditCardPageApplication.applyBestBuyCreditCard();
		//driver.switchTo().defaultContent();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		Thread.sleep(5000);		
		bestBuyCreditCardPageApplication.getpage();
		System.out.println("navigate to credit page 2");
		
	}

}