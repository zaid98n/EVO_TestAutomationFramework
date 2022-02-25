package com.evo.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evo.actiondriver.Action;
import com.evo.base.BaseClass;

/**
 * @author Zaid Nezam
 *  
 */

public class DashboardPage extends BaseClass {
	
	@FindBy(xpath = "/html/body/app-root/app-layout/div/section/app-dashboard/div/div/div[1]/div[3]/button[1]")
	private WebElement widgetview;
	
	@FindBy(xpath = "/html/body/app-root/app-layout/div/section/app-dashboard/div/div/div[1]/div[3]/button[2]")
	private WebElement mapview;
	
	@FindBy(xpath = "/html/body/app-root/app-layout/div/section/app-dashboard/div/div/div[1]/div[1]")
	//@FindBy(xpath = "dfdsgfdg")
	private WebElement titledashboard;
	
	@FindBy(xpath = "/html/body/app-root/app-layout/div/section/app-dashboard/div/div/div[2]/div/div/div/div[1]/div/app-widget/div/div")
	private WebElement widget1;
	
	@FindBy(xpath = "/html/body/app-root/app-layout/div/section/app-dashboard/div/div/div[2]/div/div/div/div[2]/div/app-widget/div/div")
	private WebElement widget2;
	
	@FindBy(xpath = "/html/body/app-root/app-layout/div/section/app-dashboard/div/div/div[2]/div/div/div/div[3]/div[1]/div/app-widget/div/div")
	private WebElement widget3;
	
	@FindBy(xpath = "/html/body/app-root/app-layout/div/section/app-dashboard/div/div/div[2]/div/div/div/div[3]/div[2]/div/app-widget/div/div")
	private WebElement widget4;
	
	@FindBy(xpath = "/html/body/app-root/app-layout/div/section/app-dashboard/div/div/div[2]/div/div/div/div[4]/div/app-widget/div/div")
	private WebElement widget5;
	
	public DashboardPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickWidgetview() {
		Action.fluentWait(getDriver(), widgetview, 10);
		Action.click(getDriver(), widgetview);
	}
	
	public boolean verifyWidgetview() {
		Action.fluentWait(getDriver(), titledashboard, 10);
		return Action.isDisplayed(getDriver(), titledashboard);
	}
	
	public boolean verfyFirstWidget() {
		Action.fluentWait(getDriver(), widget1, 10);
		return Action.isDisplayed(getDriver(), widget1);
	}
	
	public boolean verifySecondWidget() {
		Action.fluentWait(getDriver(), widget2, 10);
		return Action.isDisplayed(getDriver(), widget2);
	}
	
	public boolean verifyThirdWidget() {
		Action.fluentWait(getDriver(), widget3, 10);
		return Action.isDisplayed(getDriver(), widget3);
	}
	
	public boolean verifyFourthWidget() {
		Action.fluentWait(getDriver(), widget4, 10);
		return Action.isDisplayed(getDriver(), widget4);
	}
	
	public boolean verifyFifthWidget() {
		Action.fluentWait(getDriver(), widget5, 10);
		return Action.isDisplayed(getDriver(), widget5);
	}

}






















