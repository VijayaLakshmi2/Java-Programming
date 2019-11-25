package com.bestbuy.demotests.pageobjects.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.Link;
import com.bestbuy.demo.element.HtmlElement;
import com.bestbuy.demo.exceptions.HtmlElementsException;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demotests.Login.SigninPage;
import com.bestbuy.demotests.page.*;
import com.bestbuy.demotests.pageobjects.popup.ChooseFeedbackCategory;
import com.bestbuy.demotests.pageobjects.account.AccountPage;
import com.bestbuy.demotests.pageobjects.results.ResultsPage;
import com.bestbuy.demotests.shopByCategory.CategoriesPage;
import com.bestbuy.demotests.testlisteners.TestListener;

public class HomePage extends Page {
	
	private final String siteUrl = "http://www.bestbuy.ca";
	// wrote by chanchal
	private final String reviewUrl = "https://www.bestbuy.ca/en-ca/create-review/13527021/";
	private final String expectedUrl = "www.bestbuy.ca";
	private final String expectedUrl1 = "https://www.bestbuy.ca/en-ca/create-review/13527021/";
	private final String expectedTitle = "Best Buy Canada";

	@Name("FEEDBACK_BUTTON")
	@FindBy(xpath = "//*[@id='root']/div/div/div[4]/div")
	HtmlElement feedBackButton;

	private final String homePageError = "home page is not displayed";
	private final String searchError="There are no results for the search";
	private SearchHeader searchHeader;
	private NavigationBar navigationBar;

//	@Name("SIGNIN_BUTTON")
//	@FindBy(linkText = "Sign In")
//	private Link signinBtn;

	@Name("User_Name")
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/header/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/a/span[1]/div/span")
	private Link userclick;

	@Name("Account_Name")
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/header/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/ul/li[1]/a/span")
	private Link accountClick;

	@Name("SignIn_Name")
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/header/div/div/div[1]/div[2]/div/a[2]/span")
	private Link signIn;

	public HomePage(WebDriver driver) {
		super(driver);
		HtmlElementLoader.populatePageObject(this, driver);
	}

	/**
	 * Open the application
	 *
	 * @return the home page
	 */
	public HomePage open() {		
		getDriver().get(siteUrl);		 
		 TestListener.reportLog("Application opened  "+siteUrl);
		if (!urlContains(expectedUrl) || !titleContains(expectedTitle)) 
		{
			 TestListener.reportLog(homePageError);
			throw new HtmlElementsException(homePageError);
		}	
		return this;
	}		
	
	// created new
	public HomePage openReview() {
		getDriver().get(reviewUrl);

		if (!urlContains(expectedUrl1))
			throw new HtmlElementsException(homePageError);

		return this;
	}		
	
//	public SigninPage getSigninPage() {
//		wait.until(ExpectedConditions.visibilityOf(signinBtn)).click();
//		return new SigninPage(getDriver());
//	}
	
	public ResultsPage search(String keyword) {				
		searchHeader.search(keyword);
		ResultsPage resultsPage = new ResultsPage(getDriver());
		if (resultsPage.totalCount() == 0)
		{
			 TestListener.reportLog(searchError);
			throw new RuntimeException(searchError);
		}
		
		return resultsPage;
	}

	public ChooseFeedbackCategory clickFeedbackButton() {
		feedBackButton.click();
		return new ChooseFeedbackCategory(getDriver());
	}
		
	
	public SigninPage SignIn() {

		signIn.click();
		SigninPage signin = new SigninPage(getDriver());

		return signin;
	}

	public HomePage UsernameClick() throws InterruptedException {

		userclick.click();
		return new HomePage(getDriver());

	}

	public AccountPage myAccountClick() throws InterruptedException {

		accountClick.click();
		AccountPage accpage1 = new AccountPage(getDriver());
		return accpage1;
	}

	public Page navigateTo(String pageName)
	{

	return new HomePage(getDriver());
	}
	public CategoriesPage navigation(String name){
		
		navigationBar.clickOnNavigationHeader(name);
		@SuppressWarnings("unused")
		//WebDriver driver=getDriver();
		CategoriesPage shopModel=new CategoriesPage(getDriver());
		
		if(shopModel.isVisible()){
			TestListener.reportLog("Clicked on Shop");
			System.out.println(name+" model is visible");
		}
		else
			System.out.println(name+" model is not visible");
		
		return shopModel;
	}
	
	
}
