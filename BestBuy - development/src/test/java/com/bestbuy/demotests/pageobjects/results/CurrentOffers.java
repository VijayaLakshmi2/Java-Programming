package com.bestbuy.demotests.pageobjects.results;

import java.util.List;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.support.FindBy;

import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.HtmlElement;
import com.bestbuy.demo.exceptions.HtmlElementsException;

import static com.bestbuy.demotests.BaseTest.BaseTestClass.*;

@Name("CURRENT_OFFERS")
@FindBy(xpath = "//ul[contains(@class,'materialOverride_17Qey')][2]/div/div/div") 
public class CurrentOffers extends HtmlElement{	
	
	@Name("OFFER_ELEMENTS")
	@FindBy(xpath = "//li[contains(@class,'materialOverride_3wPsb')]")
	private List<Offer> offers;		
		
	public Offer offer(String offerName) {
		System.out.println(offers.get(6).getText());
		System.out.println("offers count:"+offers.size());
		for(Offer offer: offers) 
			if (offer.name().contains(offerName))
				return offer;
			
		throw new HtmlElementsException(offerName + " offer not found");			
	}	
	
}
