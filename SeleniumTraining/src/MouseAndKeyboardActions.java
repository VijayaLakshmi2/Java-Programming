import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseAndKeyboardActions {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vijay.lakshmi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		WebElement signInButton =driver.findElement(By.id("nav-link-accountList"));
		signInButton.click();
		
		WebElement userName=driver.findElement(By.id("ap_email"));
		 
		Actions builder=new Actions(driver);
		
		//Keydown is to hold the shift key
		//Keydown is to release the shift key
		Action enterUserName=builder.moveToElement(userName).click().keyDown(userName, Keys.SHIFT).sendKeys(userName, "Vijaya").keyUp(userName, Keys.SHIFT).doubleClick().build();
		
		enterUserName.perform();
		
		
	}
	
	

}
