package com.bestbuy.demotests.pageobjects.emailpreference;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bestbuy.demotests.BaseTest.BaseTestClass;
import com.bestbuy.demotests.Login.Login;
import com.bestbuy.demotests.pageobjects.home.HomePage;

public class UpdateEmailPreferencesTest extends BaseTestClass {

	
	//WebDriverWait wait = new WebDriverWait(driver, 10);
	/*
	 * @BeforeMethod public void signin() {
	 * 
	 * // --implicit wait // driver.manage().timeouts().implicitlyWait(2,
	 * TimeUnit.SECONDS); // --explicit wait WebDriverWait wait = new
	 * WebDriverWait(driver, 10); //SignIn signIn = new SignIn(driver);
	 * //homePage.UsernameClick(); //WebElement signInButton =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated( //By.xpath(
	 * "//*[@id=\"root\"]/div/div/header/div/div/div[1]/div[2]/div[2]/a[2]/span")));
	 * // signIn.navigateToSignInPage(); //
	 * signIn.setEmailAddress("lavanyajami.pratian@gmail.com"); //
	 * signIn.setPassword("lavanya@10"); // signIn.signIn(); //WebElement myAccount
	 * = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( //
	 * "//*[@id=\"root\"]/div/div/header/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/a/span[1]/div/span"
	 * ))); //assertEquals("Stores", By.xpath( //
	 * "//*[@id=\"root\"]/div/div/header/div/div/div[1]/div[2]/div[2]/a/div")); //
	 * signIn.navigateToMyAccount(); }
	 */
	@Test
	public void UpdateEmailPreference() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		HomePage homePage = new HomePage(driver);
		homePage.open().SignIn().Login("lavanyajami.pratian@gmail.com", "lavanya@10").UsernameClick().myAccountClick();
		EmailPreferencePage emailPreference = new EmailPreferencePage(driver);
		emailPreference.navigateToEmailPreferences();
		Assert.assertTrue(emailPreference.getTextBeforeSignUp().contains("Want to stay in touch?"));
		WebElement emailAddress=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		emailPreference.setEmailAddressSignUp("lavanyajami.pratian@gmail.com");
		emailPreference.setPostalCode("M1L4R5");
		emailPreference.signUpEmailPreference();
		Assert.assertTrue(emailPreference.getTextAfterSigningUp().contains("Thanks for signing up!"));

		// emailPreference.textValue();

	}

}
