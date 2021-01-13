package com.academy.E2EProject.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	By emailTextBox = By.id("user_email");
	By passwordTextBox = By.id("user_password");
	By loginButton = By.cssSelector("[type='submit']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement enterEmail() {
		return driver.findElement(emailTextBox);
	}
	public WebElement enterPassword() {
		return driver.findElement(passwordTextBox);
	}
	public WebElement getloginButton() {
		return driver.findElement(loginButton);
	}
}
