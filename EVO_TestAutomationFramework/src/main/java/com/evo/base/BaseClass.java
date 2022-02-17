package com.evo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.ietf.jgss.Oid;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.evo.actiondriver.Action;
import com.evo.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Zaid
 *  
 */

public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeSuite
	public void reporting() {
		ExtentManager.setExtent();
	}
	
	@AfterSuite
	public void reportingend() {
		ExtentManager.endReport();
	}
	
	@BeforeTest
	public void loadconfig() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"\\Configuration\\config.properties");
		 
		 prop = new Properties();
		 prop.load(fis);
	}
	
	public static void launchApp(String browser) {
		//WebDriverManager.chromedriver().setup();
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("ENurl"));
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitwait")), TimeUnit.SECONDS);
	}
	
	
	
}


























