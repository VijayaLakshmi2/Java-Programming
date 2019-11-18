package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage extends BasePage {

    /**Constructor*/
    public HomePage(WebDriver driver) {
        super(driver);
       // System.setProperty("webdriver.chrome.driver", "C:\\Users\\vijay.lakshmi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		// this.driver=new ChromeDriver();
    }

    /**Variables*/
    String baseURL = "https://www.n11.com/";

    /**Web Elements*/
    By signInButtonClass = By.className("btnSignIn");

    /**Page Methods*/
    //Go to Homepage
    @Step("Open N11 Step...")
    public HomePage goToN11() {
        driver.get(baseURL);
        return this;
    }

    //Go to LoginPage
    @Step("Go to Login Page Step...")
    public LoginPage goToLoginPage() {
        click(signInButtonClass);
        return new LoginPage(driver);
    }
}