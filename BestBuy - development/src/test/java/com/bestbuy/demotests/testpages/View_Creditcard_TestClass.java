package com.bestbuy.demotests.testpages;
import com.bestbuy.demotests.pageobjects.creditcard.View_Credit_Card;
import com.bestbuy.demotests.pageobjects.home.*;
import com.bestbuy.demotests.testlisteners.TestListener;
import com.bestbuy.demotests.Login.SigninPage;

import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class View_Creditcard_TestClass extends com.bestbuy.demotests.BaseTest.BaseTestClass
{	
  
	@Test(enabled=false)
	 public void TC268() throws InterruptedException 
	 {
		 
		TestListener.reportLog("TC268");
		HomePage objHomePage= new HomePage(driver); 
	    objHomePage.open();
	    objHomePage.SignIn();
	    SigninPage signin= new SigninPage(driver);
	  
	    signin.Login("user123@gmail.com","Password@123");
	    objHomePage.UsernameClick();
	    objHomePage.myAccountClick();
	    
	    View_Credit_Card card=new View_Credit_Card(driver);
	     Thread.sleep(2000);
	     
	     //Verifying the Credit card link is present and enabled in the page
		 if(card.getPagelink())
		 { 
			 System.out.println("Credit card Link is Present"); 
			 
		 }

		 
	 }
		    	
	
@Test(enabled=false)
 public void TC270() throws InterruptedException 
 {
	 TestListener.reportLog("TC270");
	
	HomePage objHomePage= new HomePage(driver); 
    objHomePage.open();
    objHomePage.SignIn();
    SigninPage signin= new SigninPage(driver);
    
    signin.Login("user123@gmail.com","Password@123");
    objHomePage.UsernameClick();
    objHomePage.myAccountClick();
    
    View_Credit_Card card=new View_Credit_Card(driver);
    card.getCreditCardpage();
    Thread.sleep(2000);
	 String expectedTitle = "Credit Cards";
     String actualTitle = card.getPageTitle();
     
     //Verifying  page title
     
     Assert.assertEquals(actualTitle, expectedTitle); 

	 
 }
 
    
@Test(enabled=false)
public void TC271() throws InterruptedException 
{
	 
	TestListener.reportLog("TC271");
	HomePage objHomePage= new HomePage(driver); 
   objHomePage.open();
   objHomePage.SignIn();
   SigninPage signin= new SigninPage(driver);
   
   signin.Login("user123@gmail.com","Password@123");
   objHomePage.UsernameClick();
   objHomePage.myAccountClick();
   
   View_Credit_Card card=new View_Credit_Card(driver);
   card.getCreditCardpage();
   Thread.sleep(2000);
    
    //Verifying the Credit card page text is present  in the page
   
   String expectedText = "You can add, edit, or delete your credit cards.";
   String actualText = card.checkPageText();
   Assert.assertEquals(actualText, expectedText); 
	
}

@Test(enabled=true)
public void TC272() throws InterruptedException 
{
	 
	TestListener.reportLog("TC272");
	HomePage objHomePage= new HomePage(driver); 
   objHomePage.open();
   objHomePage.SignIn();
   SigninPage signin= new SigninPage(driver);
   
   signin.Login("user123@gmail.com","Password@123");
   objHomePage.UsernameClick();
   objHomePage.myAccountClick();
   
   View_Credit_Card card=new View_Credit_Card(driver);
   card.getCreditCardpage();
   Thread.sleep(2000);
    
    //Verifying the Saved Credit card edit and Delete link is present and enabled in the page
	 if(card.checkCardDeleteEditlink())
	 { 
		 System.out.println("Delete and Edit Link is Present for Saved Credit card"); 
		 
	 }
	 
}

@Test(enabled=true)
public void TC273() throws InterruptedException 
{
	 
	TestListener.reportLog("TC273");
	HomePage objHomePage= new HomePage(driver); 
   objHomePage.open();
   objHomePage.SignIn();
   SigninPage signin= new SigninPage(driver);
   
   signin.Login("user123@gmail.com","Password@123");
   objHomePage.UsernameClick();
   objHomePage.myAccountClick();
   
   View_Credit_Card card=new View_Credit_Card(driver);
   card.getCreditCardpage();
   Thread.sleep(2000);
    
    //Verifying the Add new Credit card link is present and enabled in the page
	 if(card.checkAddCreditCardlink())
	 { 
		 System.out.println("Add new Credit card Link is Present in the page"); 
		 
	 }
	 
}

}
