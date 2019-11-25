/*
 * 
 */
package com.bestbuy.demotests.pageobjects.creditcard;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.HtmlElement;
import com.bestbuy.demo.element.TextInput;
import com.bestbuy.demo.exceptions.HtmlElementsException;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demo.utils.Driver.BrowserDriver;
import com.bestbuy.demotests.page.Page;
import com.bestbuy.demotests.testlisteners.TestListener;

/**
 * The Class CreditCardPage.
 */
public class AddCreditCardPage extends Page {

	BrowserDriver browserDriver;
	private final String mandatoryMessageError = "Mandatory message not got displayed.";

	@Name("CREDITCARD_NUMBER")
	@FindBy(id = "shownCardNumber")
	TextInput cardNumber;

	@Name("EXPIRY_MONTH")
	@FindBy(id = "expirationMonth")
	TextInput expiryMonth;

	@Name("EXPIRY_YEAR")
	@FindBy(id = "expirationYear")
	TextInput expiryYear;

	@Name("FIRST_NAME")
	@FindBy(id = "firstName")
	TextInput firstName;

	@Name("LAST_NAME")
	@FindBy(id = "lastName")
	TextInput lastName;

	@Name("ADDRESS")
	@FindBy(id = "addressLine1")
	TextInput address;

	@Name("CITY")
	@FindBy(name = "city")
	TextInput city;

	@Name("STATE")
	@FindBy(name = "regionCode")
	TextInput state;

	@Name("POSTAL_CODE")
	@FindBy(id = "postalCode")
	TextInput postalCode;

	@Name("COUNTRY_CODE")
	@FindBy(id = "countryCode")
	TextInput country;

	@Name("ADD_NEW_ADDRESS")
	@FindBy(className = "_23jGL")
	List<HtmlElement> addnewAddress;

	@Name("Address_List")
	@FindBy(className = "pcaitem")
	List<HtmlElement> addressList;

	@Name("PHONENUMBER")
	@FindBy(id = "phoneNumber")
	TextInput phoneNumber;

	@Name("SAVE_BUTTON")
	@FindBy(xpath = "//form[@class='_3dvoO']/div[4]/button")
	TextInput saveButton;

	@Name("SUCCESS_MESSAGE")
	@FindBy(xpath = "//div[@class='_3m7vW']/p")
	HtmlElement successMessage;

	@Name("FAIL_MESSAGE")
	@FindBy(xpath = "//div[@class='_2YH6O']/p")
	HtmlElement failureMessage;
	
	@Name("MANDATORY_MESSAGES")
	@FindBy(xpath = "//div[@class='input-container validation-error']/div[2]")
	List<HtmlElement> mandatoryMessages;

	@Name("CANCEL_BUTTON_IN_ADD_NEW_CARD")
	@FindBy(xpath = "//form[@class='_3dvoO']/div[4]/button[2]")
	TextInput cancelButton;

	/**
	 * Instantiates a new credit card page.
	 *
	 * @param driver the driver
	 */
	public AddCreditCardPage(WebDriver driver) {
		super(driver);
		browserDriver = (BrowserDriver) getDriver();
		HtmlElementLoader.populatePageObject(this, driver);
	}

	/**
	 * Enter credit card number in add new card.
	 *
	 * @param number the number
	 */
	public void enterCreditCardNumber(String number) {
		browserDriver.waitUntilVisible(cardNumber);
		cardNumber.click();
		TestListener.reportLog("Clicked on credit card number text box.");
		cardNumber.clear();
		cardNumber.sendKeys(number);
		TestListener.reportLog("Entered " + number + " in credit card number text box.");
	}

	/**
	 * Enter expiry month in add new card.
	 *
	 * @param month the month
	 */
	public void enterExpiryMonth(int month) {
		browserDriver.waitUntilVisible(this.expiryMonth);
		expiryMonth.click();
		TestListener.reportLog("clicked on expiry month box.");
		expiryMonth.sendKeys(String.valueOf(month));
		TestListener.reportLog("Entered " + month + " in expiry month box.");
	}

	/**
	 * Enter expiry year in add new card.
	 *
	 * @param year the year
	 */
	public void enterExpiryYear(int year) {
		browserDriver.waitUntilVisible(this.expiryYear);
		expiryYear.click();
		TestListener.reportLog("clicked on expiry year box.");
		expiryYear.sendKeys(String.valueOf(year));
		TestListener.reportLog("Entered " + year + " in expiry year box.");
	}

	/**
	 * Enter firstname in add new card.
	 *
	 * @param firstname the firstname
	 */
	public void enterFirstname(String firstname) {
		browserDriver.waitUntilVisible(this.firstName);
		firstName.click();
		TestListener.reportLog("clicked on first name text box.");
		firstName.clear();
		firstName.sendKeys(firstname);
		TestListener.reportLog("Entered " + firstname + " in first name text box.");
	}

	/**
	 * Enter lastname in add new card.
	 *
	 * @param lastname the lastname
	 */
	public void enterLastname(String lastname) {
		browserDriver.waitUntilVisible(this.lastName);
		lastName.click();
		TestListener.reportLog("clicked on last name text box.");
		lastName.clear();
		lastName.sendKeys(lastname);
		TestListener.reportLog("Entered " + lastname + " in first name text box.");
	}

	/**
	 * Enter address in add new card.
	 *
	 * @param address the address
	 * @throws InterruptedException
	 */
	public void enterAddress(String address) {
		browserDriver.waitUntilVisible(this.address);
		this.address.click();
		TestListener.reportLog("clicked on address text box.");
		this.address.clear();
		this.address.sendKeys(address);
		TestListener.reportLog("Entered " + address + " in address text box.");
	}

	/**
	 * Enter city in add new card page.
	 *
	 * @param city the city
	 */
	public void enterCity(String city) {
		browserDriver.waitUntilVisible(this.city);
		this.city.click();
		TestListener.reportLog("Clicked on City text box");
		this.city.clear();
		this.city.sendKeys(city);
		TestListener.reportLog("Entered " + city + " in city text box.");
	}

	/**
	 * Select state in add new card page.
	 *
	 * @param state the state
	 */
	public void selectState(String state) {
		browserDriver.waitUntilVisible(this.state);
		this.state.click();
		TestListener.reportLog("Clicked on State box.");
		this.state.sendKeys(state);
		TestListener.reportLog("Entered " + state + " in city text box.");
	}

	/**
	 * Enter zip code in add new card.
	 *
	 * @param postalCode the postal code
	 */
	public void enterZipCode(String postalCode) {
		browserDriver.waitUntilVisible(this.postalCode);
		this.postalCode.click();
		TestListener.reportLog("Clicked on postal text box.");
		this.postalCode.sendKeys(String.valueOf(postalCode));
		TestListener.reportLog("Entered " + postalCode + " in city text box.");
	}

	/**
	 * Select country in add new credit card page.
	 *
	 * @param country the country
	 */
	public void selectCountry(String country) {
		browserDriver.waitUntilVisible(this.country);
		this.country.click();
		TestListener.reportLog("Clicked on country box.");
		this.country.sendKeys(country);
		TestListener.reportLog("Entered " + country + " in city text box.");
	}

	/**
	 * Select address based on entered text in address text box in add new card.
	 *
	 * @param index the index
	 */
	public void selectAddress(int index) {
		addressList.get(index).click();
		TestListener.reportLog("selected address from the address list.");
	}

	/**
	 * Enter phone number.
	 *
	 * @param phonenumber the phonenumber
	 */
	public void enterPhoneNumber(String phonenumber) {
		browserDriver.waitUntilVisible(this.phoneNumber);
		this.phoneNumber.click();
		TestListener.reportLog("clicked on phone number text box.");
		this.phoneNumber.clear();
		this.phoneNumber.sendKeys(String.valueOf(phonenumber));
		TestListener.reportLog("Entered " + phonenumber + " in phonenumber text box.");
	}

	/**
	 * Click on save button in add new card.
	 */
	public void clickOnSaveButton() {
		browserDriver.waitUntilVisible(this.saveButton);
		saveButton.click();
		TestListener.reportLog("clicked on save button");
	}

	/**
	 * Verify success message after adding new card.
	 *
	 * @return true, if successful
	 */
	public boolean verifySuccessMessage() {
		System.out.println("Sucessmessage: "+successMessage.getText());
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

	/**
	 * Enter details in add new card page.
	 *
	 * @param cardNumber         the card number
	 * @param expiryMonth        the expiry month
	 * @param expiryYear         the expiry year
	 * @param firstname          the firstname
	 * @param lastName           the last name
	 * @param address            the address
	 * @param phoneNumber        the phone number
	 * @throws InterruptedException
	 */
	public void addNewCard(String cardNumber, int expiryMonth, int expiryYear, String firstName, String lastName,
			String address, String city, String state, String postalCode, String country, String phoneNumber)
			throws InterruptedException {
		enterCreditCardNumber(cardNumber);
		enterExpiryMonth(expiryMonth);
		enterExpiryYear(expiryYear);
		if (isAddNewAddressPresent() != 0) {
			clickOnAddNewAddress();
		}
		enterFirstname(firstName);
		enterLastname(lastName);
		enterAddress(address);
		enterCity(city);
		selectState(state);
		enterZipCode(postalCode);
		selectCountry(country);
		enterPhoneNumber(phoneNumber);
		clickOnSaveButton();
	}

	/**
	 * Check all mandatory fields in add new card.
	 *
	 * @param messages the messages
	 * @return true, if successful
	 */
	public boolean checkAllMandatoryFieldsInAddCard(List<String> messages) {
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
	public CreditCardPage clickOnCancelButton() {
		cancelButton.click();
		TestListener.reportLog("clicked on cancel button.");
		return new CreditCardPage(getDriver());
	}
}
