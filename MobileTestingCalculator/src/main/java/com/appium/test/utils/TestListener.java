package com.appium.test.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener extends BaseTest implements ITestListener{

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		screenShotName = new File(System.getProperty("user.dir")+"/Screenshots/"+timeStamp+".png");
		try {
			FileHandler.copy(scrFile, screenShotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		String filePath = screenShotName.toString();
		//String path = "<a href='"+ screenShotName + "'> <img src='"+ filePath + "' height='100' width='100'/> </a>";
		String path = "<img src=\"file://" + filePath + "\" alt=\"\"/>";
		System.out.println(path);
		Reporter.log(path);
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		screenShotName = new File(System.getProperty("user.dir")+"/Screenshots/"+timeStamp+".png");
		
			try {
				FileHandler.copy(scrFile, screenShotName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		String filePath = screenShotName.toString();
		//String path = "<a href='"+ screenShotName + "'> <img src='"+ filePath + "' height='100' width='100'/> </a>";
		String path = "<img src=\"file://" + filePath + "\" alt=\"\"/>";
		System.out.println(path);
		Reporter.log(path);
		
	}
	
	

}
