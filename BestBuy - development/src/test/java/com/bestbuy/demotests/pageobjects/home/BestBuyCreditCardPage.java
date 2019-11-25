package com.bestbuy.demotests.pageobjects.home;

import org.openqa.selenium.support.FindBy;
import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.Button;
import com.bestbuy.demo.element.HtmlElement;
@Name("BEST_BUY_CREDIT_CARD_APPLICATION")
@FindBy(className = "main-navigation-container") 
public class BestBuyCreditCardPage extends HtmlElement {
	@Name("BEST_BUY_CREDIT_CARD")
	@FindBy(xpath = "/html/body/div[2]/div/div/div[3]/footer/div[1]/div/div[1]/div/div[1]/div[2]/ul/li[5]/a")
	private Button bestBuyCreditCard;
	@Name("APPLY_NOW")
	@FindBy(className = "content_3dXxd")
	private Button applyNowBtn;

	public void navigateAndApply() {	
		System.out.println("went to method");
		bestBuyCreditCard.click();
		applyNowBtn.click();
	}

}
