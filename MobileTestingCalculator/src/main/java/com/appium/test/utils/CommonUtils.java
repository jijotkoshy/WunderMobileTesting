package com.appium.test.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectMap.CalculatorObjectMap;

/**
 * 
 * @author Jijo
 *
 */
public class CommonUtils extends BaseTest {
	public static WebElement findElementWhenReady(CalculatorObjectMap mobileElement) {
		final String elementLocator = mobileElement.name();
		final String elementLocatorValue = mobileElement.getValue();
				WebElement element = null;
				try {
			if(elementLocator.contains("XPATH"))
				element = driver.findElement(By.xpath(elementLocatorValue));
			else if(elementLocator.contains("ID"))
				element = driver.findElement(By.id(elementLocatorValue));
					if (isElementDisplayedOrEnabled(element)) {
						return element;
					}
				} catch (Exception e) {
			}
				return null;
	}
	
	private static boolean isElementDisplayedOrEnabled(
			WebElement element) {
		boolean isElement;
		if (element.isEnabled()) {
			isElement = true;
		} else if (element.isDisplayed()) {
			isElement = true;
		} else {
			isElement = false;
		}
		return isElement;
	}
	
	public static boolean isMobileElementEnabled(WebElement mobileElement) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(mobileElement));
		boolean isElementPresent = mobileElement.isDisplayed();
		if(isElementPresent)
			return true;
		else
			return false;
				
	}
}


