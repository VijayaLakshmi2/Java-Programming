import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vijay.lakshmi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		if(driver.getCurrentUrl().equalsIgnoreCase("https://www.google.com/")){
			System.out.println("Correct URL is Opened");
		}
		else
			System.out.println("Wrong URL is opened");
		
		System.out.println("Title"+" - "+driver.getCurrentUrl());
		
		System.out.println("Title Lenght"+" - "+driver.getTitle().length());
		
		driver.getPageSource();
		
		System.out.println("Page Source Length"+" - "+driver.getPageSource().length());
		
		driver.quit();

	}

}
