package com.bestbuy.demotests.creditcard.addcreditcard;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.bestbuy.demo.utils.Excel;
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
public class TC334 extends BaseTestClass {

	PropertyFile propertyfile = new PropertyFile();
	Excel excel = new Excel(propertyfile.get("ExcelPathForTestData"));
	String sheetName = "AddCardDetails";

	// Check whether user is able to add duplicate credit card or not in Add credit
	// card.
	@Test(groups = {GroupNames.REGRESSION})
	public void TC334_Reg() throws InterruptedException {
		int rowNumber = 2;
		SystemInfo.getMemoryInfo();
		TestListener.reportLog("TC334");
		HomePage homePage = new HomePage(driver);
		// Opening application and clicking on SignIn.
		homePage.open().SignIn();
		SigninPage signIn = new SigninPage(driver);
		// Sign in into application
		signIn.Login(propertyfile.get("email"), propertyfile.get("password"));
		// Click on logged in username
		homePage.UsernameClick();
		AccountPage account = homePage.myAccountClick();
		// Click on CreditCards
		CreditCardPage creditcard = account.clickOnCreditCards();
		// Click on add new card.
		AddCreditCardPage addCreditCardPage = creditcard.clickOnNewCard();
		// Add new card.
		addCreditCardPage.addNewCard(excel.readData(sheetName, "CardNumber", rowNumber),
				Integer.parseInt(excel.readData(sheetName, "Month", rowNumber)),
				Integer.parseInt(excel.readData(sheetName, "Year", rowNumber)),
				excel.readData(sheetName, "FirstName", rowNumber), excel.readData(sheetName, "LastName", rowNumber),
				excel.readData(sheetName, "Address", rowNumber), excel.readData(sheetName, "City", rowNumber),
				excel.readData(sheetName, "Province", rowNumber), excel.readData(sheetName, "PostalCode", rowNumber),
				excel.readData(sheetName, "Country", rowNumber), excel.readData(sheetName, "PhoneNumber", rowNumber));
		// verify failure message.
		assertTrue(addCreditCardPage.verifyFailureMessage());
	}

}
