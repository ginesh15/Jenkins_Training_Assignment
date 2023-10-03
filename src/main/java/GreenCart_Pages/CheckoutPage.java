package GreenCart_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TestBase.Base;

public class CheckoutPage extends Base {
	
	/*** Define WebElements using @FindBy annotation***/
	@FindBy(xpath="//td//p[@class='product-name']")
	WebElement productNameLocator;
	
	@FindBy(xpath="//tbody/tr[1]/td[4]/p[1]")
	WebElement productPriceLocator;

	@FindBy(xpath="//button[contains(text(),'PROCEED TO CHECKOUT')]")
	WebElement checkoutbtn;
	
	@FindBy(xpath="//button[contains(text(),'Place Order')]")
	WebElement placedorderBtn;
	
	@FindBy(xpath="//a[contains(text(),'Terms & Conditions')]")
	WebElement clickterm_Condition;
	
	@FindBy(xpath="//div[@class='products']/div[1]")
	WebElement visible_tnCText;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement click_checkbox;
	
	@FindBy(xpath="//button[contains(text(),\"Proceed\")]")
	WebElement click_proceedBtn;
	
	@FindBy(css="div.wrapperTwo")
	WebElement get_text_Afterproceed;
	
	@FindBy(xpath="//p[@class =\"quantity\"]")
	WebElement get_quantity;
    
	/*** Constructor to initialize elements using PageFactory***/
	public CheckoutPage () {
	PageFactory.initElements(driver,this); 
	} 
	
	/*** Method to return the 'checkout' button WebElement***/
	public WebElement clickCheckoutBtn() {
	return checkoutbtn;
	}
	/*** Method to get the product name from the 'productNameLocator' WebElement***/
	 public String getProductName() {
	 WebElement productNameElement = productNameLocator;
	 return productNameElement.getText();
	    }
	 /*** Method to get the product price from the 'productPriceLocator' WebElement***/
	 public String getProductPrice() {
	 WebElement productPriceElement =productPriceLocator;
	 return productPriceElement.getText();
	    }
	 /*** Method to click the 'Place Order' button***/
	 public void clickplaceOrderBtn() {
		 placedorderBtn.click();
	 }
	 /*** Method to click the 'Terms & Conditions' link***/		
	 public void click_Tnclink() {
		 clickterm_Condition.click();
	 }
	 /*** Method to get the visible text of 'Terms & Conditions' section***/	
	 public String displayTnC() {
		 return visible_tnCText.getText();
	 }
	 /*** Method to click the checkbox***/	
	 public void click_checkBox()  {
		 click_checkbox.click();
	 }
	 /*** Method to click the 'Proceed' button***/	
	 public void clickProceedbtn() {
		 click_proceedBtn.click();
	 }
	 /*** Method to verify the text after placing the order***/	
	 public String verify_AfterplaceOrder() {
		 return get_text_Afterproceed.getText();
	 }
	 /*** Method to get the quantity of the product***/	
	 public String get_quantityOfProduct() {
		 return get_quantity.getText();
	 }
	 /*** Method to perform a sequence of actions on the checkout page***/	
	 public void checkOutPageElement() {
		    clickCheckoutBtn().click();
	    	clickplaceOrderBtn();
			click_checkBox();
			clickProceedbtn();
	 }
	 
}
