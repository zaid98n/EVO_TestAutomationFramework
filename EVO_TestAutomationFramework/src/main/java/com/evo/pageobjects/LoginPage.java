package com.evo.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evo.actiondriver.Action;
import com.evo.base.BaseClass;

/**
 * This LoginPage class contains locators
 * and methods for test case implementation
 * 
 * @author Zaid Nezam
 * @version 1.0
 *  
 */

public class LoginPage extends BaseClass{
	
	@FindBy(xpath = "/html/body/div[2]/a[1]")
	WebElement engbtn;
	
	@FindBy(xpath = "/html/body/div[2]/a[2]")
	WebElement arbtn;
	
	@FindBy(xpath = "/html/body/div[2]/a[3]")
	WebElement frbtn;
	
	@FindBy(xpath = "/html/body/app-root/app-login/div/div/div[2]/div/div/div[2]/form/div[1]/input")
	WebElement username;
	
	@FindBy(xpath = "/html/body/app-root/app-login/div/div/div[2]/div/div/div[2]/form/div[2]/input")
	WebElement password;
	
	
	@FindBy(xpath = "/html/body/app-root/app-login/div/div/div[2]/div/div/div[2]/form/p-button/button/span")
	WebElement loginbtn;
	
	@FindBy(xpath = "/html/body/app-root/app-login/p-confirmdialog/div/div[3]/p-footer/button[1]")
	WebElement alreadyloginpopup;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void checkEN() throws Exception {
		Action.fluentWait(driver, engbtn, 10);
		Action.click(driver, engbtn);
	}
	
	public void checkAR() throws Exception {
		Action.fluentWait(driver, arbtn, 10);
		Action.click(driver, arbtn);
	}
	
	public void checkFR() throws Exception {
		Action.fluentWait(driver, frbtn, 10);
		Action.click(driver, frbtn);
	}
	
	public String getURL() {
		String currenturl = driver.getCurrentUrl();
		return currenturl;
	}
	
	public DashboardPage login(String uname, String Pwd) throws InterruptedException {
		Action.fluentWait(driver, engbtn, 10);
		Action.click(driver, engbtn);
		Action.type(username, uname);
		Action.type(password, Pwd);
		Action.click(driver, loginbtn);
		Thread.sleep(2000);
		try{
			Action.isDisplayed(driver, alreadyloginpopup);
			Action.click(driver, alreadyloginpopup);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return new DashboardPage();
	}

}
