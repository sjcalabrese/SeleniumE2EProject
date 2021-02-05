package com.academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.academy.E2EProject.pageObject.LandingPage;


public class ValidateNavBar extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(ValidateNavBar.class.getName());
	@BeforeTest
	public void setUp() throws IOException {
		driver = initializeDriver();
		log.info("Driver Initialized for ValidateNavBar");
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void basePageNavigation() throws IOException {
				
		LandingPage landing = new LandingPage(driver);
		
		Assert.assertTrue(landing.getNavBar().isDisplayed());
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();	
	}
	
}
