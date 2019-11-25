package com.bestbuy.demotests.pageobjects.AddAddress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.Button;
import com.bestbuy.demo.element.Link;
import com.bestbuy.demo.element.TextInput;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demo.utils.SystemInfo;
import com.bestbuy.demo.utils.Driver.BrowserDriver;
import com.bestbuy.demotests.page.Page;
import com.bestbuy.demotests.pageobjects.details.DetailsPage;

public class AddressPage extends Page {

	BrowserDriver browserDriver;

	public AddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub

		browserDriver = (BrowserDriver) getDriver();

		HtmlElementLoader.populatePageObject(this, driver);
	}

	@Name("AddAddress")
	@FindBy(xpath = "//*[@id=\"nav-side\"]/div[4]/a/span")
	private Link addAnAddr;
	@Name("AddAddress")
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/div/div[2]/div/main/div/div/div[2]/div/div/button/span")
	private Link clickaddress;

	@Name("DeleteAddress")
	@FindBy(xpath = "//div[@class='LSlTh']/button")
	private Button delete;

	/**
	 * Calling the method for adding address
	 */
	public AddingAddresses addAnAddress() {

		clickaddress.click();
		/**
		 * Generating Report for Performance
		 */
		SystemInfo.getMemoryInfo();
		return new AddingAddresses(getDriver());

	}

	public AddressPage DeleteAddress() {
		delete.click();
		return new AddressPage(getDriver());
	}

}
