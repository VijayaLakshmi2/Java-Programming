package com.bestbuy.demotests.pageobjects.results;

import org.openqa.selenium.support.FindBy;
import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.*;

/* implements a search result */
@Name("RESULT")
public class SearchResult extends HtmlElement implements Result {
			
	
	@Name("IMAGE")
    @FindBy(xpath=".//div[@class='productItemImage_1en8J']/a")

	Link image;
	
    
	@Name("TITLE")
    @FindBy(xpath=".//div[@class='productItemName_3IZ3c']")

	Link title;
	
    
	@Name("AVAILABILITY")
    @FindBy(xpath=".//div[@class='availabilityMessageSearch_23ZLw']/div/span[2]")

	HtmlElement availability;	
	
	@Override
	public Link image() {	
		return image;
	}

	@Override
	public String title() {	
		return title.getText();
	}
	
	@Override
	public void click() {
		title.click();
	}
	
	@Override
	public String availability() {
		String value = "";
		try {
			value = availability.getText();
			//System.out.println("Availability value: "+value);
		}
		catch (Exception ex) {
			value = "";
		}
		return value;
	}
		
}
