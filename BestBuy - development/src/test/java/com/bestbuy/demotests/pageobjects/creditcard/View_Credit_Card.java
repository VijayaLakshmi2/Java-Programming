package com.bestbuy.demotests.pageobjects.creditcard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.HtmlElement;
import com.bestbuy.demo.element.TextInput;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demotests.page.Page;
import com.bestbuy.demotests.testlisteners.TestListener;

public class View_Credit_Card extends Page  {


	
	public View_Credit_Card(WebDriver driver) {
		super(driver);
		HtmlElementLoader.populatePageObject(this, driver);
		
	}

	@Name("CREDIT_CARD")
	@FindBy(xpath="//div[@id='nav-side']/div[3]/a/span")
	private TextInput CreditCardLink;
	
	@Name("CREDITCARDPAGETITLE")
	@FindBy(xpath="//div[@class='_2MQxD']/h1/span")
	private HtmlElement CreditCardPageTitle;
	
	@Name("CREDIT_CARD_LINK")
	@FindBy(xpath="//div[@id='nav-side']/div[3]/a/span")
	private WebElement CreditCard;
	
	@Name("CREDIT_CARD_PAGE_TEXT")
	@FindBy(xpath="/html/body/div/div/div[1]/div/div/div[2]/div/main/div/div/div[1]/div/div/p[1]/span")
	private WebElement CreditCardPageText;
	
	@Name("CREDIT_CARD_PAGE_DELETE_LINK")
	@FindBy(xpath="/html/body/div/div/div[1]/div/div/div[2]/div/main/div/div/div[2]/div/div[1]/div/div/div/div[3]/button[1]/span")
	private WebElement CreditCardPageDeleteLink;
	
	@Name("CREDIT_CARD_PAGE_EDIT_LINK")
	@FindBy(xpath="/html/body/div/div/div[1]/div/div/div[2]/div/main/div/div/div[2]/div/div[1]/div/div/div/div[3]/button[1]/span")
	private WebElement CreditCardPageEditLink;
	
	@Name("ADD_CREDIT_CARD__LINK")
	@FindBy(xpath="//*[@id='root']/div/div[1]/div/div/div[2]/div/main/div/div/div[2]/div/div[2]/button/span")
	private WebElement AddCreditCardLink;
	
	
	
	public CreditCardPage getCreditCardpage()
	{

		CreditCardPage creditcardpage=new CreditCardPage(getDriver());
		CreditCardLink.click();
		TestListener.reportLog("Clicked on Link");
		return creditcardpage;
	}
	
	public String getPageTitle()
	   {
       
	     return  CreditCardPageTitle.getText();
	    }
	   
	public boolean getPagelink()
	   {
		if (CreditCard.isDisplayed() && CreditCard.isEnabled()) {
		   
	     return  true;
	    }
	     return false;
	   }
	 
	public String checkPageText()
	   {
		  
	     return  CreditCardPageText.getText();
	    
	    
	   }
	
	public boolean checkCardDeleteEditlink()
	   {
		if ((CreditCardPageDeleteLink.isDisplayed() && CreditCardPageDeleteLink.isEnabled())&&
				(CreditCardPageEditLink.isDisplayed() && CreditCardPageEditLink.isEnabled()))	
				{
		   
	     return  true;
	    }
	     return false;
	   }
	
	public boolean checkAddCreditCardlink()
	   {
		if (AddCreditCardLink.isDisplayed() && AddCreditCardLink.isEnabled()) {
		   
	     return  true;
	    }
	     return false;
	   }
	 
}
