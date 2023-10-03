package GreenCart_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TestBase.Base;
import Utilities.TestUtil;

public class Negative_ScenarioPage extends Base {
	 
	
	/*** Define web elements using the @FindBy annotation***/	
	@FindBy(xpath="//span[@ class=\"errorAlert\"]")
	WebElement warining_msg;
	
	@FindBy(xpath="//*[@class='promoCode']")
	WebElement enterPromoCode;
	
	@FindBy(xpath="//*[@class='promoBtn']")
	WebElement clickPromobtn;
	
	@FindBy(xpath="//*[@class='promoInfo']")
	WebElement warining_Promomsg;
	
	/*** Constructor for initializing page elements using PageFactory***/	
	public Negative_ScenarioPage () {
		PageFactory.initElements(driver,this); 
		} 
	
	/*** Method to get the text of the checkout warning message***/	
	public String get_checkOutWarningMsg() {
		return warining_msg.getText();
	}
	/*** Method to enter a promo code***/	
	public void EnterPromocode() {
		enterPromoCode.sendKeys(prop.getProperty("promocode"));
	}
	/*** Method to click the promo button***/	
	public void ClickPromoButton() {
		clickPromobtn.click();
	}
	/*** Method to get the text of the promo message after clicking the button***/	
	public String getPromomsg() {
		/*Using a utility method to wait for the element to be clickable*/
		return TestUtil.waitForElementToBeClickable(warining_Promomsg, 10).getText();
	
	}

}
