package amazon;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {

	WebDriver driver = null;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium dependencies\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://uatint-adjudication-kalos.mirrahealthcare.com");
	}

	@SuppressWarnings("static-access")
	@DataProvider(name = "data-provider")
	public Object[][] dataProviderMethod() {
		Excel data = null;
		Object[][] getData = null;
		try {
			getData = data.getTestData("Sheet1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getData;
	}

	@Test(dataProvider = "data-provider")
	public void login(String data) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("userId")));
		driver.findElement(By.id("userId")).clear();
		driver.findElement(By.id("userId")).sendKeys(data);
		
		driver.findElement(By.id("btnSubmit")).click();
		String errorMessage = driver.findElement(By.id("userId-error")).getText();
		//System.out.println(errorMessage);
		Assert.assertEquals(errorMessage, "The User name field is not a valid e-mail address.");

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
