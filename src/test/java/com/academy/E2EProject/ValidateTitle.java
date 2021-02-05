package com.academy.E2EProject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.academy.E2EProject.pageObject.LandingPage;
import com.academy.E2EProject.pageObject.LoginPage;


public class ValidateTitle extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void setUp() throws IOException {
		driver = initializeDriver();
		log.info("Initialized Driver for Validate Title");
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void basePageNavigation() throws IOException {
				
		LandingPage landing = new LandingPage(driver);
		
		Assert.assertEquals(landing.getTitle().getText(), "FEATURED COURSES");
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();	
	}
}
