package com.bestbuy.demotests.Login;

import org.openqa.selenium.support.FindBy;

import com.bestbuy.demo.annotations.Name;
import com.bestbuy.demo.element.Button;
import com.bestbuy.demo.element.HtmlElement;
import com.bestbuy.demo.element.TextInput;

@Name("LOGIN_HEADER")
@FindBy(className = "_2lBc-")
public class Login extends HtmlElement {

	@Name("Username")
	@FindBy(id = "email")
	private TextInput username;

	@Name("Password")
	@FindBy(id = "password")
	private TextInput password;

	@Name("SignIn")
	@FindBy(xpath = "//*[@id=\"signIn\"]/div/button/span/span")
	private Button signInapp;


	public void Login(String Username, String Password) {
		username.click();
		username.sendKeys(Username);
		password.click();
		password.sendKeys(Password);
		signInapp.click();
	}

}