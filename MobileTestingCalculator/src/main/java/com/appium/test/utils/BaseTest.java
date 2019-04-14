package com.appium.test.utils;
/**
 * 
 * @author Jijo
 * 
 */
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.appium.test.mobiletesting.MainActivityPage;

import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
	protected static AndroidDriver driver;
	
	@BeforeSuite
	@Parameters({"udidNumber","serverURL"})
	public void setUp(String udidNumber, String serverURL) throws InterruptedException, MalformedURLException {
	   //Capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("udid", udidNumber);
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("deviceName","Android");
		capabilities.setCapability("app", System.getProperty("user.dir")+"\\resources\\app\\android-sample-app.apk");
		capabilities.setCapability("launchActivity ", "com.vbanthia.androidsampleapp.MainActivity");
		capabilities.setCapability("appPackage", "com.vbanthia.androidsampleapp");
	  //Initialize Android driver
	   driver = new AndroidDriver (new URL(serverURL), capabilities);
	  // Implicit Wait
	   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   System.out.println("The app has been launched");
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
	
	@AfterTest
	public void resetCalculator() {
		MainActivityPage activityPage = new MainActivityPage();
		try {
			activityPage.clickOnResetButton();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}