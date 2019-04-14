package com.appium.test.mobiletesting;

import java.text.DecimalFormat;

import org.testng.Assert;
import org.testng.Reporter;

import com.appium.test.utils.BaseTest;
import com.appium.test.utils.CommonUtils;
import ObjectMap.CalculatorObjectMap;


public class MainActivityPage extends BaseTest {
	
	// Function to enter the first number into the left input field
	public void sendFirstNumber(String firstNumber) 
	{
		try 
		{
			CommonUtils.findElementWhenReady(CalculatorObjectMap.CALC__LEFTINPUTFIELD_XPATH).sendKeys(firstNumber);
			Reporter.log("Entered 1st Number: "+firstNumber);
		}
		catch(Exception ex) 
		{
			Reporter.log("Failed to enter 1st Number.Exception: "+ex.getMessage());
			throw ex;
		}
	}
	
	//Function to enter the second number into the right input field
	public void sendSecondNumber(String secondNumber) 
	{
		try 
		{
			CommonUtils.findElementWhenReady(CalculatorObjectMap.CALC__RIGHTINPUTFIELD_XPATH).sendKeys(secondNumber);
			Reporter.log("Entered 2nd Number: "+secondNumber);
		}
		catch(Exception ex) 
		{
			Reporter.log("Failed to enter 2nd Number.Exception: "+ex.getMessage());
			throw ex;
		}
	}
	
	//Function to click on add button
	public String clickOnAdditionButton() throws Exception 
	{
		try 
		{
			CommonUtils.findElementWhenReady(CalculatorObjectMap.CALC__ADDITIONBUTTON_XPATH).click();
			String actualResult = CommonUtils.findElementWhenReady(CalculatorObjectMap.CALC__RESULTVIEW_XPATH).getText();
			System.out.println("Actual Result: "+actualResult);
			Reporter.log("Result: "+actualResult);
			return actualResult;
		}
		catch(Exception ex) 
		{
			Reporter.log("Exception: "+ex.getMessage());
			throw ex;
		}
	}
	
	//Function to click on subtract button
	public String clickOnSubtractionButton() throws Exception 
	{
		try 
		{
			CommonUtils.findElementWhenReady(CalculatorObjectMap.CALC__SUBTRACTIONBUTTON_XPATH).click();
			String actualResult = CommonUtils.findElementWhenReady(CalculatorObjectMap.CALC__RESULTVIEW_XPATH).getText();
			System.out.println("Actual Result: "+actualResult);
			Reporter.log("Result: "+actualResult);
			return actualResult;
		}
		catch(Exception ex) 
		{
			Reporter.log("Exception: "+ex.getMessage());
			throw ex;
		}
	}
	
	//Function to click on multiplication button
	public String clickOnMultiplicationButton() throws Exception 
	{
		try 
		{
			CommonUtils.findElementWhenReady(CalculatorObjectMap.CALC__MULTIPLICATIONBUTTON_XPATH).click();
			String actualResult = CommonUtils.findElementWhenReady(CalculatorObjectMap.CALC__RESULTVIEW_XPATH).getText();
			System.out.println("Actual Result: "+actualResult);
			Reporter.log("Result: "+actualResult);
			return actualResult;
		}
		catch(Exception ex) 
		{
			Reporter.log("Exception: "+ex.getMessage());
			throw ex;
		}
	}
	
	//Function to click on division button
	public String clickOnDivisionButton() throws Exception 
	{
		try 
		{
			CommonUtils.findElementWhenReady(CalculatorObjectMap.CALC__DIVISIONBUTTON_XPATH).click();
			String actualResult = CommonUtils.findElementWhenReady(CalculatorObjectMap.CALC__RESULTVIEW_XPATH).getText();
			System.out.println("Actual Result: "+actualResult);
			return actualResult;
		}
		catch(Exception ex) 
		{
			Reporter.log("Exception: "+ex.getMessage());
			throw ex;
		}
	}
	
	//Function to click on reset button
	public void clickOnResetButton() throws Exception {
		try {
			CommonUtils.findElementWhenReady(CalculatorObjectMap.CALC__RESETBUTTON_XPATH).click();
			Thread.sleep(2000);
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	//Function to verify firstNumber, secondNumber and actual result entered
	public void verifyResults(String firstNumber,String secondNumber,String actualResult,String action) 
	{
		String fNumber = getNumber(firstNumber);
    	String sNumber = getNumber(secondNumber);
    	if((fNumber.equals("")) || (sNumber.equals("")))
        { 
        	assertResult(actualResult,"Please, fill the input fields correctly");
        }else {
    		switch(action)  
           {
	        	case "addition":    	
	        		float sum = Float.parseFloat(fNumber)+Float.parseFloat(sNumber);
	        		String actualAdditionResults[] = actualResult.split("[+=]");
	        		assertResult(actualAdditionResults[0],fNumber);
	        		assertResult(actualAdditionResults[1],sNumber);
	        		assertResult(actualAdditionResults[2],decimalValue(sum));
	                break; 
	            case "subtraction": 
	        		float subtract = Float.parseFloat(fNumber)-Float.parseFloat(sNumber);
	        		String actualSubtractResults[] = actualResult.split("[-=]");
	        		assertResult(actualSubtractResults[0],fNumber);
	        		assertResult(actualSubtractResults[1],sNumber);
	        		assertResult(actualSubtractResults[2],decimalValue(subtract));
	                break;
	            case "multiplication": 
	            	float multiplication = Float.parseFloat(fNumber)*Float.parseFloat(sNumber);
	        		String actualMultiplicationResults[] = actualResult.split("[*=]");
	        		assertResult(actualMultiplicationResults[0],fNumber);
	        		assertResult(actualMultiplicationResults[1],sNumber);
	        		assertResult(actualMultiplicationResults[2],decimalValue(multiplication));
	                break; 
	            case "division":
	            	float division = Float.parseFloat(fNumber)/Float.parseFloat(sNumber);
	        		String actualDivisionResults[] = actualResult.split("[/=]");
	        		assertResult(actualDivisionResults[0],fNumber);
	        		assertResult(actualDivisionResults[1],sNumber);
	        		if(sNumber.equals("0.00")) {
	            		assertResult(actualDivisionResults[2],"Infinity");
	            	}else {
	            		assertResult(actualDivisionResults[2],decimalValue(division));
	            	}
		            break;
	            default: 
	                System.out.println("no match");
           }
        }
    	
	}
	
	//Function to roundoff values to nearest 2 decimal place values
	private String getNumber(String numberAsString)
	{
		String numberValue;
		if(numberAsString.equals("")) {
			numberValue = "";
		}else {
		float number = Float.parseFloat(numberAsString);
		numberValue = decimalValue(number);
		}
		System.out.println("Number Entered: "+numberAsString+" .Rounded of to 2 Decimal places format: "+numberValue);
		Reporter.log("Number Entered: "+numberAsString+" .Rounded of to 2 Decimal places format: "+numberValue);
		return numberValue;
	}
	
	//Function to convert to decimal format
	private String decimalValue(float number)
	{
		DecimalFormat df = new DecimalFormat("0.00");
		String numberValue = df.format(number);
		return numberValue;
	}
	
	//Function to Assert values
	private void assertResult(String actualValue,String expectedValue)
	{
		Assert.assertEquals(actualValue.trim(),expectedValue.trim());
		Reporter.log("Actual Result: "+actualValue.trim()+" .Expected Result: "+expectedValue.trim());
	}
}
