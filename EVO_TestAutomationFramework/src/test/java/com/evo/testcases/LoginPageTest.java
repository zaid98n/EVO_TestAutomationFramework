package com.evo.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.evo.base.BaseClass;
import com.evo.pageobjects.LoginPage;

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
		driver.quit();
	}
	
	@Test(priority = 1)
	public void verifyENpage() throws Exception {
		loginpage.checkEN();
		String currenturl = loginpage.getURL();
		Assert.assertEquals(currenturl, prop.getProperty("ENurl"));
				
	}
	
	@Test(priority = 2)
	public void verifyARpage() throws Exception {
		loginpage.checkAR();
		String currenturl = loginpage.getURL();
		Assert.assertEquals(currenturl, prop.getProperty("ARurl"));
				
	}
	
	@Test(priority = 3)
	public void verifyFRpage() throws Exception {
		loginpage.checkFR();
		String currenturl = loginpage.getURL();
		Assert.assertEquals(currenturl, prop.getProperty("FRurl"));
				
	}
	
	@Test(priority = 4)
	public void loginCheck() throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
	}

}
