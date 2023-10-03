package GreenCart_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.Base;
import Utilities.TestUtil;

public class HomePage extends Base{
	
	/*** Define web elements using the @FindBy annotation***/	
	@FindBy(xpath="//h4[@class='product-name']")
	List<WebElement> productNames;
	
	@FindBy(css="input.search-keyword")
	WebElement searchBox ;
	
	@FindBy(css="button.search-button")
	WebElement searchButton;
	
	@FindBy(xpath="//div[@class='product']//img")
	List<WebElement> productImages;
	
	@FindBy(xpath="//p[@class='product-price']")
	List<WebElement> productPrices;
	
	@FindBy(xpath="//div[@class='product-action']")
	List<WebElement> addToCartButtons;

	@FindBy(css="a.cart-icon")
	WebElement miniBasket;
	
	@FindBy(css="p.product-name")
	List<WebElement> productInBasketName;
	
	@FindBy(css="p.product-price")
	WebElement productInBasketPrice;
	
	/*PageFactory*/
	public HomePage () {
	/*** Initialize page elements using PageFactory***/		
	PageFactory.initElements(driver,this); 
	} 
	/*** Getter method for product names***/	
	public List<WebElement> getProductNames() {
	return productNames;
	    }
	/*** Method to enter a search keyword***/		 
	public void enterSearchKeyword(String keyword) {
	searchBox.sendKeys(keyword);
		    }
	/*** Method to click the search button***/	
	public void clickSearchButton() {
	searchButton.click();
		    }
		    
	/*** Getter method for product images***/	
	public List<WebElement> getProductImages() {
	return productImages;
		    }

	/*** Getter method for product prices***/	
	public List<WebElement> getProductPrices() {
	return productPrices;
		    }

	/*** Getter method for "Add to Cart" buttons***/	
	public List<WebElement> getAddToCartButtons() {
	return addToCartButtons;
	
		    }
	/*** Getter method for the mini basket icon***/		 
	public WebElement getMiniBasket() {
	return miniBasket;
		    }
	/*** Getter method for product names in the basket***/	
	public List<WebElement> getProductInBasketName() {
	return productInBasketName;
		    }
	/*** Getter method for the product price in the basket***/		    
	public WebElement getProductInBasketPrice() {
	return productInBasketPrice;
	}
	/*** Method to navigate to the checkout page***/		    
	public void negativeToCheckOut() {
		/*Enter a search keyword from property file*/
		 enterSearchKeyword(prop.getProperty("productName_1"));
		 /*Click the search button*/
	     clickSearchButton();
	     /*Click the "Add to Cart" button for the first product*/
	     getAddToCartButtons().get(0).click();
	     /*Click the mini basket icon*/
	     getMiniBasket().click();

	}
	/*** Method to navigate to the checkout page (repeated code, consider refactoring)***/	
	public void checkOutPage() {
		enterSearchKeyword(prop.getProperty("productName_1"));
	    clickSearchButton();
		getAddToCartButtons().get(0).click();
	    getMiniBasket().click();
	}
	
  		   
}
