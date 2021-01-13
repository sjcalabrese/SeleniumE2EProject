package com.academy.E2EProject;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.academy.E2EProject.pageObject.LandingPage;
import com.academy.E2EProject.pageObject.LoginPage;

public class HomePage extends Base {

	@BeforeSuite
	public void logIn() throws IOException {
		driver = initializeDriver();
		LandingPage landing = new LandingPage(driver);
		driver.get(prop.getProperty("url"));
		
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click()", landing.getLogIn());

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail().sendKeys(prop.getProperty("userName"));
		loginPage.enterPassword().sendKeys(prop.getProperty("password"));
		loginPage.getloginButton().click();
	}
	

//	@Test(dataProvider = "getData")
//	public void basePageNavigation(String userName, String password) throws IOException, InterruptedException {
//
//		
//	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	
}
