package com.evo.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.evo.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This base class contains methods for
 * initialization of the test suite
 * 
 * @author Zaid Nezam
 * @version 1.0
 *  
 */

public class BaseClass {
	
	public static Properties prop;
	//public static WebDriver driver;
	
	@BeforeSuite
	public void reporting() {
		ExtentManager.setExtent();
	}
	
	@BeforeSuite
	public void loadconfig() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"\\Configuration\\config.properties");
		 
		 prop = new Properties();
		 prop.load(fis);
	}
	
	@BeforeSuite
	public void logs() {
		DOMConfigurator.configure("log4j.xml");
	}
	
	@AfterSuite
	public void reportingend() {
		ExtentManager.endReport();
	}
	
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void launchApp(String browser) {
		//WebDriverManager.chromedriver().setup();
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			driver.set(new ChromeDriver());
		}
		
		if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		}
		
		if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			//driver = new EdgeDriver();
			driver.set(new EdgeDriver());
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("ENurl"));
		getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitwait")), TimeUnit.SECONDS);
	}
	
	
}


























