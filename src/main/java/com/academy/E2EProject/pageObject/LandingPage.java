package com.academy.E2EProject.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By signIn = By.cssSelector("a[href*='sign_in']");
	By landingPageTitle = By.xpath("/html/body/section[1]/div/div/h2");
	By navBar = By.xpath("//*[@id=\"homepage\"]/header/div[2]/div/nav/ul");
	
		
	public WebElement getLogIn() {
		return driver.findElement(signIn);
	}

	public WebElement getTitle() {
		return driver.findElement(landingPageTitle);
	}

	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}

}
