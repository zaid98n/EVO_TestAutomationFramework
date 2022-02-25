package com.evo.utility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.evo.actiondriver.Action;
import com.evo.base.BaseClass;

/**
 * This ListenerClass class contains methods for
 * Implementation for extent report logs
 * 
 * @author Zaid Nezam
 * @version 1.0
 *  
 */

@SuppressWarnings("unused")
public class ListenerClass extends ExtentManager implements ITestListener {

	//Action action= new Action();
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case " + result.getName() + " has Passed");
			//test.log(Status.PASS, MarkupHelper.createLabel("Test Case " + result.getName() + " has Passed", ExtentColor.GREEN));
		}
	}

	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				test.log(Status.FAIL,
						MarkupHelper.createLabel("Test Case " + result.getName() + " has Failed", ExtentColor.RED));
				test.log(Status.FAIL,
						MarkupHelper.createLabel("Test Case " + result.getThrowable() + " has Failed", ExtentColor.RED));
				String imgPath = Action.screenShot(BaseClass.getDriver(), result.getName());
			
				test.fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, 
					MarkupHelper.createLabel("Skipped Test case is: " + result.getName(), ExtentColor.YELLOW));
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}
}