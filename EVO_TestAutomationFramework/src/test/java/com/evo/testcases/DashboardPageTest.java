package com.evo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.evo.base.BaseClass;
import com.evo.pageobjects.DashboardPage;
import com.evo.pageobjects.LoginPage;
import com.evo.utility.Log;

/**
 * @author zaid.nezam_infobeans
 *
 */

public class DashboardPageTest extends BaseClass{
	
	LoginPage loginpage;
	DashboardPage dashboardpage;
	
	@Parameters("browser")
	@BeforeMethod(groups={"Smoke", "Regression"})
	public void launchBrowser(String browser) throws Exception {
		launchApp(browser);
		loginpage = new LoginPage();
		dashboardpage = new DashboardPage();
		dashboardpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod(groups={"Smoke", "Regression"})
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(priority=1, groups={"Smoke", "Regression"})
	public void clickWidgetviewTest() {
		Log.startTestCase("clickWidgetviewTest");
		dashboardpage.clickWidgetview();
		Log.info("Checking if widget view is loaded");
		boolean result = dashboardpage.verifyWidgetview();
		Assert.assertTrue(result);
		Log.info("Widget view loaded");
		Log.endTestCase("clickWidgetviewTest");
	}
	
	@Test(priority=2, groups={"Smoke", "Regression"})
	public void verfyFirstWidgetTest() {
		Log.startTestCase("verfyFirstWidgetTest");
		Log.info("Verifying if first widget is shown in the page");
		boolean result  = dashboardpage.verfyFirstWidget();
		Assert.assertTrue(result);
		Log.info("First widget is shown in the page");
		Log.endTestCase("verfyFirstWidgetTest");
	}
	
	@Test(priority=3, groups={"Smoke", "Regression"})
	public void verifySecondWidgetTest() {
		Log.startTestCase("verifySecondWidgetTest");
		Log.info("Verifying if second widget is shown in the page");
		boolean result  = dashboardpage.verifySecondWidget();
		Assert.assertTrue(result);
		Log.info("Second widget is shown in the page");
		Log.endTestCase("verifySecondWidgetTest");
	}
	
	@Test(priority=4, groups={"Smoke", "Regression"})
	public void verifyThirdWidgetTest() {
		Log.startTestCase("verifyThirdWidgetTest");
		Log.info("Verifying if third widget is shown in the page");
		boolean result  = dashboardpage.verifyThirdWidget();
		Assert.assertTrue(result);
		Log.info("Third widget is shown in the page");
		Log.endTestCase("verifyThirdWidgetTest");
	}
	
	@Test(priority=5, groups={"Smoke", "Regression"})
	public void verifyFourthWidgetTest() {
		Log.startTestCase("verifyFourthWidgetTest");
		Log.info("Verifying if fourth widget is shown in the page");
		boolean result  = dashboardpage.verifyFourthWidget();
		Assert.assertTrue(result);
		Log.info("Fourth widget is shown in the page");
		Log.endTestCase("verifyFourthWidgetTest");
	}
	
	@Test(priority=6, groups={"Smoke", "Regression"})
	public void verifyFifthWidgetTest() {
		Log.startTestCase("verifyFifthWidgetTest");
		Log.info("Verifying if fifth widget is shown in the page");
		boolean result  = dashboardpage.verifyFifthWidget();
		Assert.assertTrue(result);
		Log.info("Fifth widget is shown in the page");
		Log.endTestCase("verifyFifthWidgetTest");
	}
	

}














