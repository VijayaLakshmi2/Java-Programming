package com.bestbuy.demotests.creditcard.addcreditcard;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bestbuy.demo.utils.SystemInfo;
import com.bestbuy.demo.utils.Property.PropertyFile;
import com.bestbuy.demo.utils.enumerations.GroupNames;
import com.bestbuy.demo.utils.enumerations.MandatoryMessageInAddNewCard;
import com.bestbuy.demotests.BaseTest.BaseTestClass;
import com.bestbuy.demotests.Login.SigninPage;
import com.bestbuy.demotests.pageobjects.account.AccountPage;
import com.bestbuy.demotests.pageobjects.creditcard.AddCreditCardPage;
import com.bestbuy.demotests.pageobjects.creditcard.CreditCardPage;
import com.bestbuy.demotests.pageobjects.home.HomePage;
import com.bestbuy.demotests.testlisteners.TestListener;

@Listeners(TestListener.class)
public class TC335 extends BaseTestClass{
	
	PropertyFile propertyfile= new PropertyFile();
	List<String> mandatoryMessages= new ArrayList<String>();
	//Check whether user is able to add invalid credit card or not from Add new card page.
	@Test(groups = {GroupNames.REGRESSION})
	public void TC335_Reg() throws InterruptedException
	{
		SystemInfo.getMemoryInfo();
		TestListener.reportLog("TC335");
		HomePage homePage = new HomePage(driver);
		//Opening application and clicking on SignIn.
		homePage.open().SignIn();
		SigninPage signIn=new SigninPage(driver);
		//Sign in into application
		signIn.Login(propertyfile.get("email"), propertyfile.get("password"));
		//Click on logged in username
		homePage.UsernameClick();
		AccountPage account=homePage.myAccountClick();
		//Click on CreditCards
		CreditCardPage creditcard=account.clickOnCreditCards();
		//Click on add new card.
		AddCreditCardPage addCreditCardPage=creditcard.clickOnNewCard();
		addCreditCardPage.enterCreditCardNumber("878787876565");
		mandatoryMessages.add(MandatoryMessageInAddNewCard.CARDNUMBER.toString());
		addCreditCardPage.checkAllMandatoryFieldsInAddCard(mandatoryMessages);
	}

}
