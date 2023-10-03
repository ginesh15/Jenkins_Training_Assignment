package GreenCart_Tests;

import java.util.Iterator;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import TestBase.Base;
import Utilities.LogUtil;
import Utilities.RetryAnalyzer;

/***Adding a listener class to this test class***/
@Listeners(Utilities.ListnerImplementaion.class)

public class CheckoutPageTest extends Base{
	
	/***Define a variable to specify the quantity of products***/
	int quantity=3;
	
	 @Test(priority=0)
	    public void VerifyProductDetailsInCheckoutPage() {
		 
		    /***Perform actions to navigate to the checkout page***/
		    homePage.checkOutPage();
	    	checkout.clickCheckoutBtn().click();
	    	
	    	/***Define expected product details from properties file***/
	        String expectedProductName = prop.getProperty("productName_1");
	        String expectedProductPrice = prop.getProperty("productName_1Price");

	        /***Get the actual product name and price from the Checkout Page***/
	        String actualProductName = checkout.getProductName();
	        String actualProductPrice = checkout.getProductPrice();
	        
	        /*** Verify the product details using assertions***/
	        Assert.assertEquals(actualProductName, expectedProductName);
	        Assert.assertEquals(actualProductPrice, expectedProductPrice);
	        
	        /***Log the success message***/
	        LogObj.info("******Verify Product Details In Check Out Page Successfully******\n");
	    }
	 
	 @Test(retryAnalyzer = RetryAnalyzer.class,priority=5)
	 public void VerifyUserCanNavigateToTermsAndConditionsPage() {
		 
		/***Perform actions to navigate to the Terms and Conditions page***/
		 homePage.checkOutPage();
	     checkout.clickCheckoutBtn().click();
		 driver.navigate().back();
		 checkout.clickplaceOrderBtn();
		 checkout.click_Tnclink();
		 
		/***Switch to the new window that opens***/
		 Set<String> windows = driver.getWindowHandles();
	        Iterator<String> it = windows.iterator();
	        String parentID = it.next();
	        String childID = it.next();
	        driver.switchTo().window(childID);
	        
	     /*** Define expected TnC text from properties file***/
		 String expected_Tnc_text = prop.getProperty("tNc_text");
		 String Actual_Tnc_text = checkout.displayTnC();
		 
		 /*** Verify the displayed TnC text using assertion***/
		 Assert.assertEquals(Actual_Tnc_text, expected_Tnc_text);
		 
		/*** Log the success message***/
		 LogObj.info("******Verify User can Navigate to Term & Condition Page Successfully******\n"); 
		 
	 }
	 
	/***This is a TestNG test method for verifying single-line orders.
	It has a priority of 1, meaning it will be executed before other test methods with lower priorities.***/
	 @Test(retryAnalyzer = RetryAnalyzer.class,priority =1)
	 public void VerifySingleLineOrder(){
		 
		/*** Navigate to the checkout page***/
		 homePage.checkOutPage();
		 
		/*** Click the checkout button***/
	     checkout.clickCheckoutBtn().click();
	     
	    /*** Click the place order button***/
		 checkout.clickplaceOrderBtn();
		 
		/***Click the checkbox***/
		 checkout.click_checkBox();
		 
		/*** Click the proceed button***/
		 checkout.clickProceedbtn();
		 
		/*** Verify the text message after placing the order***/
		String expected_Tnc_text = prop.getProperty("proceedMsg");
		String Actual_Tnc_text = checkout.verify_AfterplaceOrder();
		Assert.assertTrue(Actual_Tnc_text.contains(expected_Tnc_text));
		
		 /***Log a success message***/
	    LogObj.info("******Verify Single Line Order functionality Successfully******\n");
		 
	 }
	 /*** This is a TestNG test method for verifying single-line multi-quantity orders.
	    It has a priority of 2.***/
	 @Test(retryAnalyzer = RetryAnalyzer.class,priority =2)
	 public void VerifySingleLineMultiQtyOrder() {
		 
		/*** Click the "Add to Cart" button for the first product multiple times***/
		 homePage.getAddToCartButtons().get(0).click();
		 for(int i=1; i<quantity;i++) {
			 homePage.getAddToCartButtons().get(0).click();
		 }
		 /*** Open the mini basket***/
		homePage.getMiniBasket().click();
		
		/***Verify the quantity of the product in the basket***/
		 String productquantityInBasket = checkout.get_quantityOfProduct();
	 		Assert.assertEquals(productquantityInBasket, prop.getProperty("product_quantity"));
	 		
	 	/*** Check the checkout page elements***/
	 		checkout.checkOutPageElement();
	 		
	 	/*** Log a success message***/
	 	 LogObj.info("******Verify Single Line Multi-Quantity order Successfully******\n");	
	 }
	 
	 @Test(retryAnalyzer = RetryAnalyzer.class,priority=3)
	 public void VerifyMultiLIneOrder() {
		 
		 /*** Click on the first and second "Add to Cart" buttons on the home page***/
		 homePage.getAddToCartButtons().get(0).click();
		 homePage.getAddToCartButtons().get(1).click();
		 
		 /*** Click on the mini basket (shopping cart) icon***/
		 homePage.getMiniBasket().click();
		 
		/*** Get the names of products in the basket***/
		 String productNameInBasket = homePage.getProductInBasketName().get(0).getText();
		 String product_2NameInBasket = homePage.getProductInBasketName().get(1).getText();
		 
		 /*** Assert that the names of the products in the basket match the expected product names***/
	     Assert.assertEquals(productNameInBasket, prop.getProperty("productName_1"));
	     Assert.assertEquals(product_2NameInBasket, prop.getProperty("productName_2"));
	     
	     /*** Perform checkout-related actions***/
	     checkout.checkOutPageElement();
	     
	     /*** Verify and assert a text message after placing the order***/
		 String expected_Tnc_text = prop.getProperty("proceedMsg");
		 String Actual_Tnc_text = checkout.verify_AfterplaceOrder();
		 Assert.assertTrue(Actual_Tnc_text.contains(expected_Tnc_text));
		 
		 /*** Log success message***/
		 LogObj.info("******Verify Multi Line order Successfully******\n");
		 
	 
	 }
	 @Test(retryAnalyzer = RetryAnalyzer.class,priority=4)
	 public void VerifyMultiLineMultiQtyOrder() {
		 
		/*** Click on the first and second "Add to Cart" buttons on the home page***/
		 homePage.getAddToCartButtons().get(0).click();
		 homePage.getAddToCartButtons().get(1).click();
		 
		/*** Click on the "Add to Cart" buttons multiple times to increase quantity***/
		 for(int i=1; i<quantity;i++) {
			 homePage.getAddToCartButtons().get(0).click();
			 homePage.getAddToCartButtons().get(1).click();
		 }
		/*** Click on the mini basket (shopping cart) icon***/
		 homePage.getMiniBasket().click();
		 
		/*** Click on the mini basket (shopping cart) icon***/
		 String productquantityInBasket = checkout.get_quantityOfProduct();
		 
		 /*** Assert that the quantity matches the expected product quantity***/
	 		Assert.assertEquals(productquantityInBasket, prop.getProperty("product_quantity"));
	 		
	 	/*** Perform checkout-related actions***/
	 		checkout.checkOutPageElement();
	 		
	 	/*** Log success message***/
	 	 LogObj.info("******Verify Multi Line Multi-Quantity order Successfully******\n");	
		 
	 }
}
