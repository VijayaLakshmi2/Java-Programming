package com.bestbuy.demotests.pageobjects.createaccount;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.Button;
import com.bestbuy.demo.element.TextBlock;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demo.utils.Driver.BrowserDriver;
import com.bestbuy.demotests.page.Page;

public class CreateAccountPage extends Page {
	
	BrowserDriver browserDriver;
	
	@Name("SUBMIT_BUTTON")
	@FindBy(xpath = "//*[@id='createAccount']/button/span")
	private Button submit;
	
	@Name("FIELD_ERROR_CLASSES")
	@FindBy(xpath = "//*[@id='createAccount']//*[@class='input-container validation-error']")
	private TextBlock fieldError;
	
	@Name("PASSWORD_CHECKS")
	@FindBy(xpath = "//*[@class='qq9Mv _2sHEv' or @class='_3LDSX _2sHEv']")
	private List<TextBlock> passwordChecks;
	
	@Name("FORM_INPUT_FIELDS")
	@FindBy(xpath = "//*[@id='createAccount']//*[@type='text' or @type='password']")
	private List<TextBlock> formInputElements;
	
	private TextBlock fieldElement = null;
	private ListIterator<TextBlock> listIterator = null;
	
	public CreateAccountPage(WebDriver driver) {
		super(driver);
		browserDriver = (BrowserDriver) getDriver();
		browserDriver.waitUntilVisible(submit);
		HtmlElementLoader.populatePageObject(this, driver);
	}
	
	/** 
	 * Action: Click on Submit
	 */
	public void submitForm() {
		submit.click();
	}
	
	/** 
	 * Fill Data to a particular field in Create Acocunt Form
	 * */
	public void fillField(TextBlock textBlock, String data) {
		textBlock.clear();
		textBlock.sendKeys(data);
	}
	
	/**
	 * Get Mandatory message getting displayed for a given field
	 *  */
	public String getRequiredMessage(String field) {
		String msg = "";
		try {
			if(fieldError.findElement(By.xpath("//label[@for='"+field+"']")).isDisplayed())
				msg = waitForElement((TextBlock) fieldError.findElement(By.xpath("//div[contains(@data-automation, '"+field+"')]"))).getText();
			} catch (Exception e) {
		}
		return msg;
	}
	
	/**
	 * Action: Returns Passes & Failed checks for an entered Password
	 * */
	public Map<String, String> getPasswordChecks() {
		
		Map<String, String> map = new HashMap<>();
		listIterator = passwordChecks.listIterator();

		while(listIterator.hasNext()) {
			fieldElement = waitForElement(listIterator.next());
			if(fieldElement.getAttribute("class").equals("qq9Mv _2sHEv")) 
				map.put(fieldElement.getText().replace(".", ""), "CheckToFail");
			if(fieldElement.getAttribute("class").equals("_3LDSX _2sHEv")) 
				map.put(fieldElement.getText().replace(".", ""), "CheckToPass");
		}
		return map;
	}
	
	/**
	 * Action: Feed data to Create Account Form
	 * */
	public boolean fillForm(Map<String, String> formInput) {

		listIterator = formInputElements.listIterator();
		Map<String, String> formOut = new HashMap<String, String>();
		boolean isDataEntered; 
		
		while(listIterator.hasNext()) {
			fieldElement = waitForElement(listIterator.next());
			fillField(fieldElement, formInput.get(fieldElement.getAttribute("id")));
			formOut.put(fieldElement.getAttribute("id"), fieldElement.getAttribute("value"));
		}
		isDataEntered = (formInput.equals(formOut)) ? true : false;
		return isDataEntered;
	}
	
	/**
	 * Action: Return WebElement/TextBlock of given Field
	 * */
	public TextBlock getTextBlock(String key) {
		listIterator = formInputElements.listIterator();
		while(listIterator.hasNext()) {
			fieldElement = waitForElement(listIterator.next());
			if(fieldElement.getAttribute("id").contains(key)) 
				break;
		}
		return fieldElement;
	}
	
	/**
	 * Action: Wait for an Element and return same if found
	 * */
	public TextBlock waitForElement(TextBlock textBlock) {
		fieldElement = textBlock;
		browserDriver.waitUntilVisible(fieldElement);
		return fieldElement;
	}
}
