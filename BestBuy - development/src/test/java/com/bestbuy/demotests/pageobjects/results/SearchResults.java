package com.bestbuy.demotests.pageobjects.results;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.*;
import com.bestbuy.demo.exceptions.HtmlElementsException;
import com.bestbuy.demo.utils.enumerations.*;

import static com.bestbuy.demotests.BaseTest.BaseTestClass.*;


/* implements the list of results */

@Name("SEARCH_RESULTS")
@FindBy(className ="productListingContainer_1Iyio")

public class SearchResults extends HtmlElement {
	
	@Name("RESULTS")
    @FindBy(className = "productLine_2N9kG")
	private List<SearchResult> results;
	
	private final String filteredListError = "filtered results list is empty";
			
	public SearchResult get(int index) {
		return results.get(index);				 
	}
	
	public int count() {
		return results.size();				 
	}
	
	public List<SearchResult> filterBy(Availability status) {													

		List <SearchResult> list = results.stream()
				                          .filter(condition(status))
				                          .collect(Collectors.<SearchResult>toList());
		
		if (list.size() == 0) 
			throw new HtmlElementsException(filteredListError);		
		
		return list;			
	}
	
	private Predicate<SearchResult> condition(Availability status) {		
		return p -> p.availability().equalsIgnoreCase(status.toString());
	}
}
