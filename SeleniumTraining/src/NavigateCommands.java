import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateCommands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vijay.lakshmi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		/*driver.navigate().to("https://www.amazon.in/");
		
		driver.findElement(By.id("nav-link-accountList")).click();
		
		List<WebElement> buttons=driver.findElements(By.tagName("input"));
		
		for (WebElement button: buttons){
			if(button.getAttribute("name").contains("name"))
				button.click();
		}
		
		//driver.findElement(By.name("email")).sendKeys("1234567890");;
		
		System.out.println(driver.findElement(By.className("a-button-input")).getTagName());
		System.out.println(driver.findElement(By.className("a-button-input")).getCssValue("color"));
		System.out.println(driver.findElement(By.className("a-button-input")).getSize());
		System.out.println(driver.findElement(By.className("a-button-input")).getLocation());
		*/
		//driver.findElements(By.tagName("input")).get(1).click();
 
//		        driver.get("https://www.amazon.com");
//		        driver.findElement(By.partialLinkText("Account & List")).click();
//		        driver.findElement(By.linkText("Privacy Notice")).click();
//		        driver.findElement(By.xpath("//*[@id=\"nav-orders\"]/span[2]")).click();
//		        
		        
		        //WebElement SearchBox= driver.findElement(By.name("q"));
		        //driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("a");
		        //driver.findElement(By.cssSelector("input[class='gLFyf gsfi']")).sendKeys("a");
		        //driver.findElement(By.cssSelector."gLFyf gsfi").sendKeys("a");
		        //SearchBox.clear();
		        //SearchBox.sendKeys("Selenium");
		        //driver.findElement(By.partialLinkText("Sign")).click();;
		        
//		        driver.navigate().to("https://www.amazon.com/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_signin&switch_account=");
//		        
//		        driver.findElement(By.id("ap_email")).sendKeys("8885638718");;
//		        driver.findElement(By.name("email"));
		////
//		        driver.findElement(By.id("continue")).click();
//		        driver.findElement(By.name("password"));
		        //driver.findElement(By.id("ap_password"));
		        
		    //    driver.findElement(By.className("a-input-text a-span12 auth-autofocus auth-required-field"));
		    //    driver.findElement(By.className("a-button-input")).click();;
		        
		        

		 

		        // open the website
//		        
//		        driver.get("https://www.amazon.in/");
//		        driver.navigate().to("https://www.amazon.com/ap/register?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_newcust");
//		        driver.navigate().back();
//		        driver.navigate().forward();
//		        driver.navigate().to("https://www.amazon.in/");
//		        driver.navigate().refresh();
//		        
		//
//		        // title of the page
//		        System.out.println(driver.getTitle());
//		        
		//
//		        // Title Length
//		        System.out.println(driver.getTitle().length());
		//
//		        // get the url and check whether correct url is opened or not
//		        String url = driver.getCurrentUrl();
//		        System.out.println(url);
		//
//		        if (url == urlValue) {
//		            System.out.println("Correct Url");
//		        } else {
//		            System.out.println("Incorrect Url");
//		        }
		//
//		        // page source length
//		        System.out.println(driver.getPageSource().length());
		//
//		        // close the tab
		        //driver.close();
		
//		driver.get("https://haltersweb.github.io/Accessibility/submit-disabling.html");
//      WebElement submit= driver.findElement(By.className("btn"));
//      System.out.println(submit.isEnabled());
//      driver.findElement(By.id("firstName")).sendKeys("Lavanya");
//      driver.findElement(By.id("lastName")).sendKeys("Jami");
//      System.out.println(submit.isEnabled());
//      WebElement catName= driver.findElement(By.id("catName"));
//     
//       System.out.println("Cat's name check box is "+catName.isEnabled());
// 
//       driver.findElement(By.id("cat")).click();
// 
//       System.out.println("Cat's name check box is " +catName.isEnabled());
//     
     
//      driver.get("https://www.dyn-web.com/tutorials/forms/examples/pizza.php");
//      WebElement mediumSize=driver.findElement(By.xpath("//*[@id=\"pizzaForm\"]/fieldset/p[1]/label[2]/input"));
//      System.out.println("Medium check box is "+ mediumSize.isSelected() );
//      driver.findElement(By.xpath("//*[@id=\"pizzaForm\"]/fieldset/p[1]/label[1]/input")).click();
//      driver.findElement(By.xpath("//*[@id=\"pizza_toppings\"]/label[1]/input")).click();
//      driver.findElement(By.xpath("//*[@id=\"pizza_toppings\"]/label[5]/input")).click();
//      System.out.println(driver.findElement(By.xpath("//*[@id=\"pizzaForm\"]/fieldset/p[3]/label/input")).getAttribute("value"));
//             
//      List <WebElement> radioButtons= driver.findElements(By.name("size"));
//      for(WebElement radioButton: radioButtons) {
//          System.out.println("Value of Size is"+ radioButton.getAttribute("value"));
//          if(radioButton.isSelected()) {
//              System.out.println("Value" + radioButton.getAttribute("value") +" is selected");
//          }
//          //System.out.println(radioButton.getCssValue(arg0));
//      }
		
		
		driver.get("https://www.dyn-web.com/tutorials/forms/examples/pizza.php");
		//System.out.println(driver.findElement(By.tagName("label")).getText());
		List<WebElement> elements=driver.findElements(By.tagName("label"));
		//System.out.println(elements.size());
		for(WebElement element1:elements){
			WebElement element=element1.findElement(By.tagName("input"));
			if(element.getAttribute("type").contains("radio")&&element.getAttribute("name").contains("size"))
				System.out.println(element1.getText());
		}
		System.out.println();
	}

}
