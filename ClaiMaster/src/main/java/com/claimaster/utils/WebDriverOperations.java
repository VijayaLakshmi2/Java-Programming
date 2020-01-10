package com.claimaster.utils;

import org.openqa.selenium.WebDriver;

public class WebDriverOperations {

	WebDriver driver = null;

	public WebDriverOperations(WebDriver driver) {
		this.driver = driver;
	}

	public void switchToFrame(int frameNumber) {
		driver.switchTo().frame(frameNumber - 1);
	}
}



