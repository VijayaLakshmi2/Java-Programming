package com.bestbuy.demotests.shopByCategory;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.HtmlElement;
import com.bestbuy.demo.exceptions.HtmlElementsException;
import com.bestbuy.demo.loader.HtmlElementLoader;
import com.bestbuy.demo.utils.Driver.BrowserDriver;
import com.bestbuy.demotests.page.Page;

import com.bestbuy.demo.utils.Property.PropertyFile;
import com.bestbuy.demo.utils.Excel;
import com.bestbuy.demotests.pageobjects.results.SearchCategoryResultsPage;
import com.bestbuy.demotests.testlisteners.TestListener;

public class CategoriesPage extends Page {
	
private WebDriver driver;
	
	private final By modalXpath = By.className("selected_18nuL");
	
	private By categoriesDiv=By.cssSelector("#root > div > div > header > div > div > div.navigationBar_3IPzN > div > div > div > div > ul > li:nth-child(1) > div > div.flyoutMenu_IfVpR.active_2JcBh.nav-item-shop > div > ul > li");
	
	private By subCategoriesDiv1=By.cssSelector("#root > div > div > header > div > div > div.navigationBar_3IPzN > div > div > div > div > ul > li:nth-child(1) > div > div.flyoutMenu_IfVpR.active_2JcBh.nav-item-shop > div > div.null.subCategoryContainer_2yeiO > div.mainCategorySection_2esFd > div");
	
	private By subCategoriesDiv=By.cssSelector("#root > div > div > header > div > div > div.navigationBar_3IPzN > div > div > div > div > ul > li:nth-child(1) > div > div.flyoutMenu_IfVpR.active_2JcBh.nav-item-shop > div > div.null.subCategoryContainer_2yeiO > div.mainCategorySection_2esFd > div > ul > li:nth-child(1) > a");
	
	private By productsDiv=By.cssSelector("#root > div > div > header > div > div > div.navigationBar_3IPzN > div > div > div > div > ul > li:nth-child(1) > div > div.flyoutMenu_IfVpR.active_2JcBh.nav-item-shop > div > div.null.subCategoryContainer_2yeiO > div.mainCategorySection_2esFd > div:nth-child(1) > ul > li:nth-child(2)");
	
	private By categoryXpath=By.xpath("//li/a");
	
	private final String modalError = "the shop modal is still displayed";
	
	public static PropertyFile propertyfile=new PropertyFile();
	
	public static Excel excel= new Excel(propertyfile.get("ExcelPathForTestData"));
	
	WebDriverWait wait=new WebDriverWait(getDriver(),200);
	
	public static Object[][] subCategories=excel.readData("Sub Categories");
	
	public CategoriesPage(WebDriver driver) {
		super(driver);
		this.driver=((BrowserDriver)driver).getWrappedDriver();
		 HtmlElementLoader.populatePageObject(this, driver);
		
	}
	
	//categories popup Xpath
	public By getModalXpath(){
		return modalXpath;
	}
	
	//Checking whether categories popup is visible
	public Boolean isVisible() {
		boolean isVisible = false;
		try {
			WebElement modalElement = driver.findElement(getModalXpath());

			wait.until(ExpectedConditions.visibilityOf(modalElement));
			isVisible=modalElement.isDisplayed();
			TestListener.reportLog("Shop ");
		}
		catch (Exception exception) {
			isVisible = false;
		}
		
		return isVisible;
	}
	
	
	@SuppressWarnings("unchecked")
	public Boolean getCategoriesList() throws IOException{
		Boolean flag=false;
		
		//Getting data from Categories sheet of Excel
		Object[][] categories=excel.readData("Categories");
		Map<String, String> map=new HashMap<String, String>();
		
		//Getting list of WebElements for Categories
		List<WebElement> categories1=driver.findElements(categoriesDiv);
		
		wait.until(ExpectedConditions.visibilityOfAllElements(categories1));
		
		int k=0;
		for(WebElement element:categories1){
			int i = 0;
			
			wait.until(ExpectedConditions.visibilityOf(element));
			for(int j=0; j<categories.length&&i==0;j++){
				// Assigning each row of category from Excel to a Map 
				map=(Map<String, String>) categories[j][0];
				if(map.get("Category").equalsIgnoreCase(element.getText())){
					
					i++;
					k++;
				}
				
			}
			// Checking whether all the 15 categories are present
			if(k==15){
				flag=true;
				TestListener.reportLog("Compared List of all the Categories");
				System.out.println("All the Categories are present");
			}
				
		}
		if(flag==false){
			TestListener.reportLog("All the Categories are not present");
			throw new HtmlElementsException("Categories are not loaded");
		}
		return flag;
	}
	
	public Boolean clickOnCategory(String categoryName){
		
		
		SearchCategoryResultsPage resultsPage = null;
		Boolean flag=false;
		//Getting list of WebElements for Categories
		List<WebElement> categories=driver.findElements(categoriesDiv);
		wait.until(ExpectedConditions.visibilityOfAllElements(categories));
		
		for(WebElement element:categories){
			wait.until(ExpectedConditions.visibilityOf(element));
			
			//Comparing text from category WebElement to category from Excel
			if(element.getText().equalsIgnoreCase(categoryName)){
				System.out.println(element.getText());
				element.click();
				TestListener.reportLog("Clicked on Category :"+ categoryName);
				System.out.println("Clicked");
				
				// Assigning the driver instance to SearchCategoryResultsPage
				resultsPage=new SearchCategoryResultsPage(getDriver());
				flag=true;
				break;
			}
		}
		
		System.out.println(resultsPage.getCategoryName());
		// Checking whether it is navigated to Search Category Results Page or not
		if(!(resultsPage.getCategoryName().equals("Home")))
			throw new RuntimeException("Search Category results page is not loaded");
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	public Boolean hoverOnCategory(String categoryName){
		
		List<WebElement> categories=driver.findElements(categoriesDiv);
		wait.until(ExpectedConditions.visibilityOfAllElements(categories));
		
		Actions actions = new Actions(driver);
		
		Boolean flag=false;
		
		for(WebElement element:categories){
			wait.until(ExpectedConditions.visibilityOf(element));
			if(element.getText().equalsIgnoreCase(categoryName)){
				
				actions.moveToElement(element).build().perform();
				//actions.moveToElement(element).keyUp(Keys.SHIFT);
				TestListener.reportLog("Hovered on Category :"+categoryName);
				List<WebElement> categories1=driver.findElements(subCategoriesDiv1);
				wait.until(ExpectedConditions.visibilityOfAllElements(categories1));
				
				if(element.isSelected()){
					flag=true;
				}
				
			}
		}
		return flag;
		
	}
	
	@SuppressWarnings("unchecked")
	public Boolean getSubCategoriesList(String categoryName) throws IOException{
		
		
		Boolean flag=false;
		
		Map<String, String> map=new HashMap<String, String>();
		hoverOnCategory(categoryName);
		
		//System.out.println(excel.getRowCount("Sub Categories"));
		List<WebElement> categories1=driver.findElements(subCategoriesDiv);
		wait.until(ExpectedConditions.visibilityOfAllElements(categories1));
		
		int k=0;
		for(WebElement element:categories1){
			wait.until(ExpectedConditions.elementToBeClickable(element));
			int i=0;
			//System.out.println(categories.length);
			for(int j=0; j<subCategories.length&&i==0;j++){
				
				map=(Map<String, String>) subCategories[j][0];
				//System.out.println(map.get(categoryName));
				if(map.get(categoryName).equalsIgnoreCase(element.getText())||map.get(categoryName).equalsIgnoreCase("")){
					System.out.println(map.get(categoryName));
					i++;
					k++;
				}
			
		}
			if(k==4){
				flag=true;
				TestListener.reportLog("Compared List of sub categories of "+ categoryName);
			}
		}
		if(flag==false){
			TestListener.reportLog("All the Sub Categories are not present");
			throw new HtmlElementsException("Sub Categories are not loaded");	
			
		}
		return flag;
	}
	
	public Boolean clickOnSubCategory(String categoryName,String subCategoryName) throws AWTException{
		
		hoverOnCategory(categoryName);
		
		Boolean flag=false;
		SearchCategoryResultsPage resultsPage = null;
		Actions actions = new Actions(driver);
		Robot robot = new Robot();
		List<WebElement> categories=driver.findElements(subCategoriesDiv);
		wait.until(ExpectedConditions.visibilityOfAllElements(categories));
		
		for(WebElement element:categories){
			wait.until(ExpectedConditions.visibilityOf(element));
			@SuppressWarnings("unused")
			String data=element.getText();
			System.out.println(data);
			if(element.getText().equalsIgnoreCase(subCategoryName)){
				System.out.println(element.getText());
				wait.until(ExpectedConditions.visibilityOf(element));
				element.click();
				TestListener.reportLog("Clicked on sub Category :"+ subCategoryName);
				//actions.moveToElement(element).build().perform();
				//actions.moveToElement(element).click().build().perform();
				System.out.println("Clicked");
				resultsPage=new SearchCategoryResultsPage(getDriver());
				flag=true;
				break;
			}
		}
		System.out.println(resultsPage.getCategoryName());
		if(!(resultsPage.getCategoryName().equals("Home")))
			throw new RuntimeException("there are no results for this Category");
		return flag;
	}
	
	public CategoriesPage getProductsList(String categoryName){
		//Boolean flag=true;
		//Object[][] categories=ReadWriteFromExcel.getTestData("Products");
		
		hoverOnCategory(categoryName);
		List<WebElement> categories1=driver.findElements(productsDiv);
		for(WebElement element:categories1){
			System.out.println(element.getText());
			
		}
		return this;
	}
}
