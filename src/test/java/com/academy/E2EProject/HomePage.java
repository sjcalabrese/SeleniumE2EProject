package com.academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.academy.E2EProject.pageObject.LandingPage;
import com.academy.E2EProject.pageObject.LoginPage;

public class HomePage extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeSuite
	public void logIn() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized.");
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
