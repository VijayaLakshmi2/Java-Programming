package com.bestbuy.demotests.testpages;

import org.openqa.selenium.WebDriver;

import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demotests.page.Page;

public class MarketplaceSellerApplicationForm extends Page {
	
	public MarketplaceSellerApplicationForm(WebDriver driver) {
		super(driver);
		HtmlElementLoader.populatePageObject(this, driver);
	}
}
