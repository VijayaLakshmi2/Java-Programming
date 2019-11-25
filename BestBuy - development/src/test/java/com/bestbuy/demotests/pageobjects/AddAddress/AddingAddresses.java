package com.bestbuy.demotests.pageobjects.AddAddress;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.Button;
import com.bestbuy.demo.element.HtmlElement;
import com.bestbuy.demo.element.Link;
import com.bestbuy.demo.element.Select;
import com.bestbuy.demo.element.TextInput;
import com.bestbuy.demo.exceptions.HtmlElementsException;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demo.utils.SystemInfo;
import com.bestbuy.demo.utils.Driver.BrowserDriver;
import com.bestbuy.demotests.page.Page;
import com.bestbuy.demotests.pageobjects.creditcard.CreditCardPage;
import com.bestbuy.demotests.pageobjects.home.HomePage;
import com.bestbuy.demotests.testlisteners.TestListener;

@Name("ADDADDRESS_HEADER")
@FindBy(className = "_2QCpT")
public class AddingAddresses extends Page {
	BrowserDriver browserDriver;
	private final String mandatoryMessageError = "Mandatory message not got displayed.";

	public AddingAddresses(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		HtmlElementLoader.populatePageObject(this, driver);
	}

	/**
	 * List of elements available in the add address page.
	 */
	@Name("Firstname")
	@FindBy(id = "firstName")
	private TextInput firstName;

	@Name("Lastname")
	@FindBy(id = "lastName")
	private TextInput lastName;

	@Name("Address")
	@FindBy(id = "addressLine1")
	private Button addressLine1;

	@Name("City")
	@FindBy(id = "city")
	private TextInput city;

	@Name("Province")
	@FindBy(id = "regionCode")
	private Select province;

	@Name("Zip")
	@FindBy(id = "postalCode")
	private TextInput zip;

	@Name("Phone")
	@FindBy(id = "phoneNumber")
	private TextInput phone;
	@Name("ADD_NEW_ADDRESS")
	@FindBy(className = "_23jGL")
	List<HtmlElement> addnewAddress;

	@Name("Address_List")
	@FindBy(className = "pcaitem")
	List<HtmlElement> addressList;

	@Name("Save")
	@FindBy(xpath = "//div[@class='_3UHBq']/button")
	private Button save;
	@Name("cancel")
	@FindBy(xpath = "//div[@class='_3UHBq']/button[2]")
	private Button cancel;
	@Name("SUCCESS_MESSAGE")
	@FindBy(xpath = "//div[@class='_3m7vW']/p")
	HtmlElement successMessage;

	@Name("FAIL_MESSAGE")
	@FindBy(xpath = "//div[@class='_2YH6O']/p")
	HtmlElement failureMessage;

	@Name("MANDATORY_MESSAGES")
	@FindBy(xpath = "//div[@class='input-container validation-error']/div[2]")
	List<HtmlElement> mandatoryMessages;

	/**
	 * Adding valid address to the fields available in the add address page.
	 */

	public AddressPage validAddress() {

		firstName.sendKeys("Kelvin");
		lastName.sendKeys("James");
		addressLine1.sendKeys("kattokaran house");
		city.sendKeys("Thrissur");
		TestListener.reportLog("City got Added");
		province.selectByIndex(2);
		zip.sendKeys("T2S 3E9");
		zip.sendKeys(Keys.ENTER);
		TestListener.reportLog("Zip Code got added");
		phone.sendKeys("7736234502");
		save.click();
		TestListener.reportLog("clicked on save Button.");
		/**
		 * generating report for Performance
		 */
		SystemInfo.getMemoryInfo();
		return new AddressPage(getDriver());
	}

	/**
	 * Adding Invalid address to the fields available in the add address page.
	 */

	public AddingAddresses inValidAddress() {
		firstName.sendKeys("Kelvin");
		lastName.sendKeys("James");
		addressLine1.sendKeys("kattokaran house");
		city.sendKeys("Thrissur");
		TestListener.reportLog("City got Added");
		province.getFirstSelectedOption();
		zip.sendKeys("T2S 3E9");
		zip.sendKeys(Keys.ENTER);
		TestListener.reportLog("Zip Code got added");
		phone.sendKeys("7736234502");
		save.click();
		TestListener.reportLog("clicked on save Button.");
		/**
		 * generating report for Performance
		 */
		SystemInfo.getMemoryInfo();
		return new AddingAddresses(getDriver());
	}

	/**
	 * Adding blank address to the fields available in the add address page.
	 */

	public AddingAddresses blankAddress() {
		firstName.sendKeys("");
		lastName.sendKeys("");
		addressLine1.sendKeys("");
		city.sendKeys("");
		TestListener.reportLog("City not got added");
		province.getFirstSelectedOption();
		zip.sendKeys("");
		zip.sendKeys(Keys.ENTER);
		TestListener.reportLog("Zip Code not got added");
		phone.sendKeys("");
		save.click();
		TestListener.reportLog("clicked on save Button. and not redirected");
		/**
		 * generating report for Performance
		 */
		SystemInfo.getMemoryInfo();
		return new AddingAddresses(getDriver());
	}

	/**
	 * Adding blank address to the Mandatory fields available in the add address
	 * page.
	 */
	public AddingAddresses MandatorylessAddress() {
		firstName.sendKeys("");
		lastName.sendKeys("");
		addressLine1.sendKeys("");
		city.sendKeys("");
		TestListener.reportLog("City Not Got Added");
		province.getFirstSelectedOption();
		zip.sendKeys("");
		zip.sendKeys(Keys.ENTER);
		TestListener.reportLog("Zip Not Got Added");
		phone.sendKeys("");
		save.click();
		TestListener.reportLog("clicked on save Button.");

		/**
		 * generating report for Performance
		 */

		SystemInfo.getMemoryInfo();
		return new AddingAddresses(getDriver());
	}

	public boolean verifySuccessMessage() {
		System.out.println("Sucessmessage: " + successMessage.getText());
		boolean result = false;
		if (successMessage.getText().contains("added")) {
			result = true;
			TestListener.reportLog("verified success message.");
		}
		return result;
	}

	/**
	 * Verify failure message after adding duplicate card
	 *
	 * @return true, if successful
	 */
	public boolean verifyFailureMessage() {
		boolean result = false;
		if (failureMessage.getText().contains("Sorry")) {
			result = true;
			TestListener.reportLog("verified failure message.");
		}
		return result;
	}

	/**
	 * Checks if add new address button is exists or not
	 *
	 * @return the int
	 */
	public int isAddNewAddressPresent() {
		return addnewAddress.size();
	}

	/**
	 * Click on add new address button in add new card.
	 */
	public void clickOnAddNewAddress() {
		addnewAddress.get(0).click();
		TestListener.reportLog("clicked on add new address button.");
	}

	public boolean checkAllMandatoryFieldsInAddAddress(List<String> messages) {
		int check = 0;
		boolean result = false;
		browserDriver.waitUntilVisible(mandatoryMessages.get(0));
		for (int i = 0; i < mandatoryMessages.size(); i++) {
			for (int j = 0; j < messages.size(); j++) {
				if (mandatoryMessages.get(i).getText().equals(messages.get(j))) {
					check++;
					TestListener.reportLog("Checking mandatory message: '" + mandatoryMessages.get(i).getText() + " '");
					break;
				}
			}
		}
		if (check > 0) {
			result = true;
		} else {
			TestListener.reportLog(mandatoryMessageError);
			throw new HtmlElementsException(mandatoryMessageError);
		}
		return result;
	}

	/**
	 * Click on cancel button.
	 */
	public AddressPage clickOnCancelButton() {
		cancel.click();
		TestListener.reportLog("clicked on cancel button.");
		return new AddressPage(getDriver());
	}
}
