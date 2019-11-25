import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vijay.lakshmi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//waits until the element is present
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.youtube.com/");
		driver.findElement(By.name("search_query")).click();
		driver.findElement(By.name("search_query")).sendKeys("Selenium");
		driver.findElement(By.name("search_query")).sendKeys(Keys.ENTER);
		
		//Thread.sleep(5);
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Selenium Beginner 1 - Introduction - What is Selenium | Selenium Interview basics | Step by Step")));
		driver.findElement(By.linkText("Selenium Beginner 1 - Introduction - What is Selenium | Selenium Interview basics | Step by Step")).click();
		
		
	}

}
