package com.evo.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.evo.base.BaseClass;
import com.evo.pageobjects.LoginPage;
import com.evo.utility.Log;

/**
 * This LoginPageTest class contains
 * testcases of login page
 * Testcases are independent of each other
 * 
 * @author Zaid Nezam
 * @version 1.0
 *  
 */

public class LoginPageTest extends BaseClass{
	
	LoginPage loginpage;
	
	@Parameters("browser")
	@BeforeMethod
	public void launchBrowser(String browser) throws IOException {
		launchApp(browser);
		loginpage = new LoginPage();
	}
	
	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(priority = 1)
	public void verifyENpage() throws Exception {
		Log.startTestCase("VerifyENpage");
		loginpage.checkEN();
		String currenturl = loginpage.getURL();
		Log.info("Checking if EN page is loading");
		Assert.assertEquals(currenturl, prop.getProperty("ENurl"));
		Log.info("EN page successfully loaded");
		Log.endTestCase("verifyENpage");
	}
	
	@Test(priority = 2)
	public void verifyARpage() throws Exception {
		Log.startTestCase("verifyARpage");
		loginpage.checkAR();
		String currenturl = loginpage.getURL();
		Log.info("Checking if AR page is loading");
		Assert.assertEquals(currenturl, prop.getProperty("ARurl"));
		Log.info("AR page successfully loaded");
		Log.endTestCase("verifyARpage");
				
	}
	
	@Test(priority = 3)
	public void verifyFRpage() throws Exception {
		Log.startTestCase("verifyFRpage");
		loginpage.checkFR();
		String currenturl = loginpage.getURL();
		Log.info("Checking if FR page is loading");
		Assert.assertEquals(currenturl, prop.getProperty("FRurl"));
		Log.info("FR page successfully loaded");
		Log.endTestCase("verifyFRpage");
				
	}
	
	@Test(priority = 4)
	public void verifyLogin() throws Exception {
		Log.startTestCase("verifyLogin");
		Log.info("Entering username and password and clicking on login button also clicking on yes button if popup already-loggedin appears");
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		Log.info("verifying if login is success");
		String currenturl = loginpage.getURL();
		Thread.sleep(1000);
		String expectedurl = "https://ewsqa.enova-me.com/enova.cossp.app/en/dashboard";
		Assert.assertEquals(currenturl, expectedurl);
		Log.info("Login Success");
		Log.endTestCase("verifyLogin");
	}

}
