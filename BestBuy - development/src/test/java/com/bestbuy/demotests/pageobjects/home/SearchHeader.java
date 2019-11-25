package com.bestbuy.demotests.pageobjects.home;


import org.openqa.selenium.support.FindBy;

import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.*;
import com.bestbuy.demotests.testlisteners.TestListener;


@Name("SEARCH_HEADER")
@FindBy(className = "searchBarContainer_3c_uZ") 
public class SearchHeader extends HtmlElement{
		
	@Name("SEARCH_FIELD")
	@FindBy(className = "textField_e79SD")	
	private TextInput searchKeywordTxt;
	
	@Name("SEARCH_BUTTON")
	@FindBy(className = "searchButton_T4-BG")
	private Button searchBtn;	
	  		
	public void search(String keyword) {
		searchKeywordTxt.click();  
		TestListener.reportLog("Clicked on search textbox in home page.");
		searchKeywordTxt.clear();
		searchKeywordTxt.sendKeys(keyword);
		TestListener.reportLog("Entered "+keyword +"in search text box in home page.");
		searchBtn.click();		
	}
	
}
