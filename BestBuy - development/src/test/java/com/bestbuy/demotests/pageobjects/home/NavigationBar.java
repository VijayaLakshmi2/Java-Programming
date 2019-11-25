package com.bestbuy.demotests.pageobjects.home;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.HtmlElement;

@Name("NAVIGATION_BAR")
@FindBy(className = "linkList_3Rt5z")
public class NavigationBar extends HtmlElement{
	
	@Name("NAVIGATION_ELEMENTS")
	@FindBy(xpath = "//li/div/button/span")	
	private List<HtmlElement> navigationButton;

	
		  		
		public void clickOnNavigationHeader(String name) {
			
			for(HtmlElement element:navigationButton){
				if(element.getText().equalsIgnoreCase(name))
					element.click();
				
			}
		}


}
