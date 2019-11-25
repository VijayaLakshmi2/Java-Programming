package com.bestbuy.demotests.creditcard.addcreditcard;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.bestbuy.demo.utils.SystemInfo;
import com.bestbuy.demo.utils.Property.PropertyFile;
import com.bestbuy.demo.utils.enumerations.GroupNames;
import com.bestbuy.demotests.BaseTest.BaseTestClass;
import com.bestbuy.demotests.Login.SigninPage;
import com.bestbuy.demotests.pageobjects.account.AccountPage;
import com.bestbuy.demotests.pageobjects.creditcard.AddCreditCardPage;
import com.bestbuy.demotests.pageobjects.creditcard.CreditCardPage;
import com.bestbuy.demotests.pageobjects.home.HomePage;
import com.bestbuy.demotests.testlisteners.TestListener;

@Listeners(TestListener.class)
public class TC338 extends BaseTestClass {

	PropertyFile propertyfile = new PropertyFile();

	// Check whether user is able to cancel the add new card page or not.
	@Test(groups = {GroupNames.SMOKE})
	public void TC338_Smoke() throws InterruptedException {
		SystemInfo.getMemoryInfo();
		TestListener.reportLog("TC338");
		HomePage homePage = new HomePage(driver);
		// Opening application and clicking on SignIn.
		homePage.open().SignIn();
		SigninPage signIn = new SigninPage(driver);
		// Sign in into application
		signIn.Login(propertyfile.get("email"), propertyfile.get("password"));
		// Click on logged in username
		homePage.UsernameClick();
		AccountPage account = homePage.myAccountClick();
		// click on credit cards.
		CreditCardPage creditcard = account.clickOnCreditCards();
		// Click on add new card.
		AddCreditCardPage addCreditCardPage = creditcard.clickOnNewCard();
		addCreditCardPage.clickOnCancelButton();
	}

}
