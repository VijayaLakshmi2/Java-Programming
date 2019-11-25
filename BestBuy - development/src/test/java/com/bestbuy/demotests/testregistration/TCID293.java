package com.bestbuy.demotests.testregistration;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.bestbuy.demo.utils.TextFile.TextFile;
import com.bestbuy.demotests.pageobjects.home.HomePage;
import com.bestbuy.demotests.testlisteners.TestListener;
import static org.testng.AssertJUnit.*;

@Listeners(TestListener.class)
public class TCID293 extends com.bestbuy.demotests.BaseTest.BaseTestClass {
	
	private void addToLog(String text) {
		(new TextFile()).add("\n " + text);
	}
	
	@Test(groups={"SMOKE"})
	public void tc293_NavigateToCreateAccount() {
		
		HomePage home = new HomePage(driver);
		home.open();
		(home.SignIn()).goToCreateAccount();

		assertEquals(driver.getPageSource().contains("Create an Account"), !driver.getPageSource().contains("Don't have an account?"));
		addToLog("Test Case: "+getClass().getName());		
	}
}
