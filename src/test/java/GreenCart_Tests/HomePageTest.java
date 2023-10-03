package GreenCart_Tests;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import TestBase.Base;
import Utilities.LogUtil;

/***Adding a listener class to this test class***/
@Listeners(Utilities.ListnerImplementaion.class)

public class HomePageTest extends Base {
	
	
	@Test(priority=0)
	public void VerifyProductsAreDisplayedOnTheHomePage() {
		
		 /***Get a list of product names from the home page***/
		 List<WebElement> productNames = homePage.getProductNames();
		 if (productNames.size() > 0) {
			 
		 /*** Log that products are displayed***/
		 LogObj.info("******###Products are displayed on the home page.###******\n"); 
		 
		        /*** Iterate through product names and assert that each is displayed***/
	            for (WebElement productName : productNames) {
	            	Assert.assertTrue(productName.isDisplayed());
	              }
	        } else {
	        	
	        	/***Log that no products were found***/
	        	LogObj.info("******###No products found on the home page.###******\n"); 
	        }
		 /*** Log test completion***/
		 LogObj.info("******Verify Products asre Display on Home Page Successfully******\n"); 
	}

	@Test(priority=4)
	public void VerifySearchFuntioanlityOnHomePage() {
		
		    /*** Enter a search keyword, perform a search, and verify results***/
		    homePage.enterSearchKeyword(prop.getProperty("productName_3"));
	        homePage.clickSearchButton();

		        /*** Perform assertion to verify search results***/
		        String expectedProduct = prop.getProperty("productName_3");
		        Assert.assertTrue(driver.getPageSource().contains(expectedProduct));
		        
		   /*** Perform assertion to verify search results***/
		  LogObj.info("******Verify Search Functionality on Home Page Successfully******\n");      
		    }

    @Test(priority=1)
    public void VerifyProductImagePriceAndAddToCartButtonAreDisplayedForEachProduct() {
    	
    	/*** Get lists of product images, prices, and Add to Cart buttons***/
    	List<WebElement> productImages = homePage.getProductImages();
    	
    	 if (productImages.size() > 0) {
    		 
    	 /*** Log that product images are displayed***/
         LogObj.info("******###Products Images are displayed on the home page.###******\n"); 
         
         /***Iterate through product images and assert that each is displayed***/
	            for (WebElement productImage : productImages) {
	            	Assert.assertTrue(productImage.isDisplayed());
	             
	            }
	        } else {
	        	
	      /*** Log that no product images were found***/
	     LogObj.info("******###No products Images on the home page.###******\n"); 	   	
	        }
    	 LogObj.info("******Verify Product Image are displayed on Home Page Successfully******\n");   
    	 
    	 List<WebElement> productPrices = homePage.getProductPrices();
        
        if (productPrices.size() > 0) {
        /*** Log that product prices are displayed**/
        LogObj.info("******###Products Price are displayed on the home page.###******\n"); 	
        
           /***Iterate through product prices and assert that each is displayed***/
            for (WebElement productPrice : productPrices) {
            	Assert.assertTrue(productPrice.isDisplayed());
               }
            } else {
             /*** Log that no product prices were found***/
        LogObj.info("******###No products Price on the home page.###******\n"); 	   	
        }
        
        /*** Log completion for product prices***/
        LogObj.info("******Verify Product Price are displayed on Home Page Successfully******\n");  
        
        List<WebElement> addToCartButtons = homePage.getAddToCartButtons();
        if (addToCartButtons.size() > 0) {
        	
        /**Log that Add to Cart buttons are displayed**/
        LogObj.info("******###Products addToCartButtons are displayed on the home page.###******\n"); 
        
        /*** Iterate through Add to Cart buttons and assert that each is displayed***/
            for (WebElement addToCartButton : addToCartButtons) {
            	Assert.assertTrue(addToCartButton.isDisplayed());
               
            }
        } else {
        	
        /*** Log that no Add to Cart buttons were found***/
        LogObj.info("******###No addToCartButton on the home page.###******\n"); 
        }
        /*** Log completion for Add to Cart buttons***/
        LogObj.info("******Verify Product AddToCart button are displayed on Home Page Successfully******\n");  
    }

    @Test(priority=2)
    public void VerifyAddToCartFuntionality() {
    	
    	 /***Get lists of product names and Add to Cart buttons***/
    	 List<WebElement> productNames = homePage.getProductNames();
    	 List<WebElement> addToCartButtons = homePage.getAddToCartButtons();
    	 
    	/***Get the name of the first product from a properties file***/
    	 String firstPRoduct = prop.getProperty("productName_1");
    	 
    	/***Initialize a variable to store the text of the button that was clicked***/
    	 String added = "";
    	 
    	/*** Iterate through the list of product names***/
    	for (int i= 0;i<productNames.size(); i++) {
    		
    		/*** Check if the current product name matches the desired product name***/
        	if(productNames.get(i).getText().equalsIgnoreCase(firstPRoduct)) {
        		
        		/*** Click the Add to Cart button for the matching product***/
        		addToCartButtons.get(i).click();
        		
        		/*** Store the text of the clicked button***/
        		added = addToCartButtons.get(i).getText();
        	}
        	/***Exit the loop after the first match is found***/
        	break;
           }
    	
    	 /*** Assert that the text of the clicked button contains the expected text***/
    	Assert.assertTrue(added.contains(prop.getProperty("clickAddToCartText")));
    	
    	 /***Log a success message***/
    	LogObj.info("******Verify Add To Cart Functionality Successfully******\n");  
    }
    
    @Test(priority=3)
    public void VerifyProductDetailsInMiniBasket() {
    	/***Navigate to the checkout page***/
    	 homePage.checkOutPage();

        /*** Verify product details in the mini basket using assertions***/
        String productNameInBasket = homePage.getProductInBasketName().get(0).getText();
        String productPriceInBasket = homePage.getProductInBasketPrice().getText();
        
        /*** Assert that the product name and price in the mini basket match expected values***/
        Assert.assertEquals(productNameInBasket, prop.getProperty("productName_1"));
        Assert.assertEquals(productPriceInBasket, prop.getProperty("productName_1Price"));
        
        /*** Log a success message***/
        LogObj.info("******Verify Product details in Mini Basket Successfully******\n");  
    }
    
	
}

