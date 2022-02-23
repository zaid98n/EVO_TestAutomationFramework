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
	private WebElement engbtn;
	
	@FindBy(xpath = "/html/body/div[2]/a[2]")
	private WebElement arbtn;
	
	@FindBy(xpath = "/html/body/div[2]/a[3]")
	private WebElement frbtn;
	
	@FindBy(xpath = "/html/body/app-root/app-login/div/div/div[2]/div/div/div[2]/form/div[1]/input")
	private WebElement username;
	
	@FindBy(xpath = "/html/body/app-root/app-login/div/div/div[2]/div/div/div[2]/form/div[2]/input")
	private WebElement password;
	
	
	@FindBy(xpath = "/html/body/app-root/app-login/div/div/div[2]/div/div/div[2]/form/p-button/button/span")
	private WebElement loginbtn;
	
	@FindBy(xpath = "/html/body/app-root/app-login/p-confirmdialog/div/div[3]/p-footer/button[1]")
	private WebElement alreadyloginpopup;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void checkEN() throws Exception {
		Action.fluentWait(getDriver(), engbtn, 10);
		Action.click(getDriver(), engbtn);
	}
	
	public void checkAR() throws Exception {
		Action.fluentWait(getDriver(), arbtn, 10);
		Action.click(getDriver(), arbtn);
	}
	
	public void checkFR() throws Exception {
		Action.fluentWait(getDriver(), frbtn, 10);
		Action.click(getDriver(), frbtn);
	}
	
//	public String getURL() {
//		String currenturl = getDriver().getCurrentUrl();
//		return currenturl;
//	}
	
	public DashboardPage login(String uname, String Pwd) throws InterruptedException {
		Action.fluentWait(getDriver(), engbtn, 10);
		Action.click(getDriver(), engbtn);
		Action.type(username, uname);
		Action.type(password, Pwd);
		Action.fluentWait(getDriver(), loginbtn, 10);
		Action.click(getDriver(), loginbtn);
		Thread.sleep(2000);
		try{
			Action.isDisplayed(getDriver(), alreadyloginpopup);
			Action.click(getDriver(), alreadyloginpopup);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return new DashboardPage();
	}

}
