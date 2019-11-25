package com.bestbuy.demotests.creditcard.addcreditcard;

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
public class TC332 extends BaseTestClass {

	PropertyFile propertyfile = new PropertyFile();
	Excel excel = new Excel(propertyfile.get("ExcelPathForTestData"));
	String sheetName = "AddCardDetails";

	// Check whether user is able to add credit card or not by providing mandatory
	// data in add new card.
	// Check whether user is able to add new card with different address or not from
	// add new card page.--336
	@Test(groups = {GroupNames.SMOKE})
	public void TC332_Smoke() throws InterruptedException {
		int rowNumber = 1;
		SystemInfo.getMemoryInfo();
		TestListener.reportLog("TC332");
		// Creating object for home page.
		HomePage homePage = new HomePage(driver);
		// Opening application and clicking on SignIn.
		homePage.open().SignIn();
		// creating object for SignIn page.
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
		// Add new card
		addCreditCardPage.addNewCard(excel.readData(sheetName, "CardNumber", rowNumber),
				Integer.parseInt(excel.readData(sheetName, "Month", rowNumber)),
				Integer.parseInt(excel.readData(sheetName, "Year", rowNumber)),
				excel.readData(sheetName, "FirstName", rowNumber), excel.readData(sheetName, "LastName", rowNumber),
				excel.readData(sheetName, "Address", rowNumber), excel.readData(sheetName, "City", rowNumber),
				excel.readData(sheetName, "Province", rowNumber), excel.readData(sheetName, "PostalCode", rowNumber),
				excel.readData(sheetName, "Country", rowNumber), excel.readData(sheetName, "PhoneNumber", rowNumber));
		// verifying success message.
		assertTrue(addCreditCardPage.verifySuccessMessage());
	}

	/*
	 * @Test public void TC332() throws InterruptedException {
	 * PropertyConfigurator.configure("Log4j.properties");
	 * ActivityLogger.intializeLogger("TC332"); ActivityLogger.startTest("TC332");
	 * HomePage homePage = new HomePage(driver); homePage.open();
	 * TestListener.reportLog("looged from test case."); SigninPage
	 * signIn=homePage.navigateTosignIn(); signIn.signIn(propertyfile.get("email"),
	 * propertyfile.get("password")); homePage.clickOnLoggedinUserName();
	 * AccountPage account=homePage.clickOnMyAccount(); CreditCardPage
	 * creditcard=account.clickOnCreditCards(); AddCreditCardPage
	 * addCreditCardPage=creditcard.clickOnNewCard();
	 * addCreditCardPage.addNewCard(PaymentInfo.CARD_NUMBER.toString(),
	 * PaymentInfo.MONTH.getValue(), PaymentInfo.YEAR.getValue(),
	 * UserInfo.FIRST_NAME.toString(), UserInfo.LAST_NAME.toString(),
	 * UserInfo.ADDRESS.toString(), UserInfo.CITY.toString(),
	 * UserInfo.PROVINCE.toString(), UserInfo.POSTAL_CODE.toString(),
	 * UserInfo.COUNTRY.toString(), UserInfo.PHONE1.toString()); }
	 */
}
