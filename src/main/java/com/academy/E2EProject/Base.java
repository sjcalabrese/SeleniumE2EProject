package com.academy.E2EProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

public class Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	public Properties prop = new Properties();
	
	public WebDriver initializeDriver() throws IOException {
		//chrome
		//firefox
		
		FileInputStream fis = new FileInputStream("/home/sal/Documents/workspace-spring-tool-suite-4-4.9.0.RELEASE/SeleniumE2EProject/src/main/java/com/academy/E2EProject/resources/data.properties");
		
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome") ) {
			System.setProperty("webdriver.chrome.driver", 
					"/home/sal/Documents/Selenium Training/chromedriver_linux64/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", 
					"/home/sal/Documents/Selenium Training/geckodriver_linux64/geckodriver");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
		}
		else if(browserName == "ie") {
			
		}
		else {
			System.out.println("No browser selected");
		}
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
	}	
	
	public void getScreenShotPath(String testCaseName) throws IOException {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver; 
		File source = takeScreenShot.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
	}
}
