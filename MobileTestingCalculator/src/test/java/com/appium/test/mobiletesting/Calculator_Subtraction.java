package com.appium.test.mobiletesting;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.appium.test.utils.BaseTest;
import com.appium.test.utils.TestListener;
/**
 * 
 * @author Jijo
 *
 */
@Listeners(TestListener.class)
public class Calculator_Subtraction extends BaseTest{
	
	@Test
	@Parameters({"firstNumber","secondNumber"})
	public void subtractionOfTwoNumber(String firstNumber,String secondNumber) throws Exception 
	{
		MainActivityPage activityPage = new MainActivityPage();
		activityPage.sendFirstNumber(firstNumber);
		activityPage.sendSecondNumber(secondNumber);
		String actualResult = activityPage.clickOnSubtractionButton();
		activityPage.verifyResults(firstNumber,secondNumber,actualResult,"subtraction");
	}
}
