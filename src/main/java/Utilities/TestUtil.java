package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.Base;

public class TestUtil extends Base {
	/***Implicit wait time data***/
	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICIT_WAIT = 20;

     /***Explicit wait implementation***/
	 public static WebElement waitForElementToBeClickable(WebElement element, int seconds) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
	        return wait.until(ExpectedConditions.elementToBeClickable(element));
	    }

}
