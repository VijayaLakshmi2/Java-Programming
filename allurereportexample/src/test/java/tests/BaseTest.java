package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTest {
    public WebDriver driver;
    public HomePage homePage;

    public WebDriver getDriver() {
    	
		//driver=new ChromeDriver();
        return driver;
    }

    @BeforeClass
    public void classLevelSetup() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\sai.jaswanth\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void methodLevelSetup() {
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}