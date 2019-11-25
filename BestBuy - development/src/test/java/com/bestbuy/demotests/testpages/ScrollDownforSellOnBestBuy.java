package com.bestbuy.demotests.testpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.bestbuy.demo.element.HtmlElement;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demo.utils.Driver.BrowserDriver;
import com.bestbuy.demotests.page.Page;
import junit.framework.Assert;

public class ScrollDownforSellOnBestBuy extends Page {
	@FindBy(xpath = "//div[@class='internalPrimaryLinksContainer_3Nanc']/div[4]/div[2]/ul/li[4]/a")

	private HtmlElement SellOnBestBuy;
	JavascriptExecutor jsExec;

	@FindBy(xpath = "//div[@class='contentContainerLeftAlign_1Vz7c dark_vc_ZV bannerContent']/div[3]/a/button/span")
	private HtmlElement Apply;

	public ScrollDownforSellOnBestBuy(WebDriver driver) {
		super(driver);
		BrowserDriver browserDriver = (BrowserDriver) getDriver();
		jsExec = browserDriver.getJSDriver();
		HtmlElementLoader.populatePageObject(this, driver);
		// TODO Auto-generated constructor stub
	}

	public void SellOnBestBuyClick() {
		// TODO Auto-generated method stub

		jsExec.executeScript("arguments[0].scrollIntoView()", SellOnBestBuy);
		SellOnBestBuy.click();
		String ExpectedValue = "Apply to be a Seller";
		Assert.assertEquals(ExpectedValue, "Apply to be a Seller");
		System.out.println("The user is navigated to the Apply to be a Seller page!!");

	}

	public MarketplaceSellerApplicationForm ApplyClick() {
		MarketplaceSellerApplicationForm marketseller = new MarketplaceSellerApplicationForm(driver);
		Apply.click();
		System.out.println("Apply To Be A Seller button is clicked");
		String ExpectedValue = Apply.getText();
		// Assert.assertEquals(ExpectedValue, Apply);
		return marketseller;
	}

}
