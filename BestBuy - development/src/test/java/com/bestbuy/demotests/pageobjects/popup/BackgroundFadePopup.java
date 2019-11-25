package com.bestbuy.demotests.pageobjects.popup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.HtmlElement;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demotests.page.Page;

public class BackgroundFadePopup extends Page {

	@Name("CLOSE_POPUP_ICON")
	@FindBy(xpath = "//div[@id='contents']/a[1]")
	private HtmlElement ClosePopupIcon;

	@Name("POWERED_BY_LINK")
	@FindBy(xpath = "//*[@id='contents']/a[2]")
	private HtmlElement PoweredByLink;

	@Name("LOGO")
	@FindBy(id = "logo")
	WebElement logo;

	public void closePopupByIcon(WebDriver driver) {
		ClosePopupIcon.click();

	}

	public void navigateToPoweredByWebsite(WebDriver driver) {
		PoweredByLink.click();

	}

	public BackgroundFadePopup(WebDriver driver) {
		super(driver);
		HtmlElementLoader.populatePageObject(this, driver);
	}

	public boolean isCompletelyLoaded() {
		System.out.println("Inside backgroundfadepopup");
		return (ClosePopupIcon.isDisplayed() && PoweredByLink.isDisplayed() && logo.isDisplayed());
	}

}
