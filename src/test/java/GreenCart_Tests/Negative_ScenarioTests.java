package GreenCart_Tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import TestBase.Base;

/***Adding a listener class to this test class***/
@Listeners(Utilities.ListnerImplementaion.class)

public class Negative_ScenarioTests extends Base {

	/***Test Case 1: Verify order cannot be placed without selecting Terms and Conditions***/
	@Test(priority=0,description="Verify order cannot be placed without selecting Tnc")
	public void VerifyOrderCannotBePlacedWithoutSelectingTermsAndConditions() {
		
		  /*** Navigate to the checkout page***/
		 homePage.negativeToCheckOut();
		 
		 /*** Click on the checkout button***/
		 checkout.clickCheckoutBtn().click();
		 
		 /*** Click the place order button***/
	     checkout.clickplaceOrderBtn();
	     
	     /*** Click the proceed button***/
	     checkout.clickProceedbtn();
	     
	   /*** Get the actual warning message about Terms and Condition***/
	   String Actual_Tnc_text = negative.get_checkOutWarningMsg();
	   
	   /*** Get the actual warning message about Terms and Condition***/
	   String expected_Tnc_text = prop.getProperty("warnMsgTnc");
	   
	   /*** Assert that the actual and expected warning messages match***/
	   Assert.assertEquals(Actual_Tnc_text, expected_Tnc_text);
	   
	  /*** Log an information message***/
	  LogObj.info("******Verify order can not be placed without Selecting Term & condition ******\n");
	}
	
	 /*** Test Case 2: Verify if PromoCode is invalid for this test***/
	@Test(priority=1,description="Verify Promocode is Invalid for this test")
	public void verifyPromoCodeIsValidOrNot() {
		
		 /*** Navigate to the checkout page***/
		homePage.negativeToCheckOut();
		
		/***Click on the checkout button***/
		checkout.clickCheckoutBtn().click();
		
		/*** Enter a PromoCode***/
		 negative.EnterPromocode();
		 
		/*** Click the PromoCode button***/
		 negative.ClickPromoButton();
		 
		/*** Click the PromoCode button***/
		String Actual_Tnc_text = negative.getPromomsg();
		
		/*** Get the expected PromoCode message from properties file***/
		String expected_Tnc_text = prop.getProperty("warnPromoCode");
		
		/*** Assert that the actual and expected PromoCode messages match***/
    	Assert.assertEquals(Actual_Tnc_text,expected_Tnc_text);
    	
    	 /*** Log an information message***/
    	 LogObj.info("******Verify PromoCode Is Invalid for the Test ******\n");
		
	}
}