package com.academy.E2EProject;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.academy.E2EProject.pageObject.LandingPage;
import com.academy.E2EProject.pageObject.LoginPage;


public class ValidateNavBar extends Base {

	@BeforeTest
	public void setUp() throws IOException {
		driver = initializeDriver();
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
