package steps;

import static org.testng.Assert.assertTrue;

import cucumber.api.java.en.Then;
import pages.actions.CustomerCheckoutPage;
import utilities.SeleniumDriver;
import utilities.SeleniumHelper;

public class CustomerCheckoutSteps {

	CustomerCheckoutPage  CustomerCheckoutPage = new CustomerCheckoutPage();
	
	@Then("^click \\*Women\\* button in the header$")
	public void click_Women_button_in_the_header() throws Throwable {
	   SeleniumDriver.nav.gotoWomenProductsPage();
	}

	@Then("^click the product with name \"([^\"]*)\"$")
	public void click_the_product_with_name(String ProductTitle) throws Throwable {
		CustomerCheckoutPage.selectProduct();
	}

/*	@Then("^click \\*Add to cart\\* button$")
	public void click_Add_to_card_button() throws Throwable {
	   CustomerCheckoutPage.addProductToCart();
	}*/

	@Then("^click \\*Proceed to checkout\\* button$")
	public void click_Proceed_to_checkout_button() throws Throwable {
		CustomerCheckoutPage.clickProceedToCheckout();
	}
	
	@Then("^click \\*Proceed to checkout\\* button second$")
	public void click_Proceed_to_checkout_button_second() throws Throwable {
		CustomerCheckoutPage.clickProceedToSecond();
	}
	

	@Then("^click \\*Proceed to checkout\\* button third$")
	public void click_Proceed_to_checkout_button_third() throws Throwable {
		CustomerCheckoutPage.clickProceedToThird();
	}
	

	@Then("^check by \\*Terms of service\\* to agree checkbox$")
	public void check_by_Terms_of_service_to_agree_checkbox() throws Throwable {
		CustomerCheckoutPage.clickAgreeOnTermsAndConditions();
	}
	

	@Then("^click \\*Proceed to checkout\\* button for final checkout$")
	public void click_Proceed_to_checkout_button_for_final_checkout() throws Throwable {
		CustomerCheckoutPage.clickProceedToCheckoutFinal();
	}
	

	@Then("^click by payment method \\*Pay by bank wire\\*$")
	public void click_by_payment_method_Pay_by_bank_wire() throws Throwable {
		CustomerCheckoutPage.selectPayByBankOrWire();
	}

	@Then("^click \\*I confirm my order\\*$")
	public void click_I_confirm_my_order() throws Throwable {
		CustomerCheckoutPage.clickConfirmOrderBtn();
	}

	@Then("^order confirmation page with URL \"([^\"]*)\" is opened$")
	public void order_confirmation_page_with_URL_is_opened(String ExpectedURL) throws Throwable {
		String ActualURl = SeleniumHelper.getCurrentPageURL();
		assertTrue(ActualURl.contains(ExpectedURL));
	}

	@Then("^page heading with message \"([^\"]*)\" should be present$")
	public void page_heading_with_message_should_be_present(String ExpectedHeadingTxt) throws Throwable {
		String ActualHeadingTxt = CustomerCheckoutPage.getOrderConfirmPageHeadingTxt();
		assertTrue(ActualHeadingTxt.contains(ExpectedHeadingTxt));
		
	}

	@Then("^Shipping tab should be present$")
	public void shipping_tab_should_be_present() throws Throwable {
		assertTrue(CustomerCheckoutPage.checkIfShippingTabIsDisplayed());
	}

	@Then("^Payment tab should be present$")
	public void payment_tab_should_be_present() throws Throwable {
		assertTrue(CustomerCheckoutPage.checkIfPaymentTabIsDisplayed());
	}

	@Then("^order confirmation message with text \"([^\"]*)\" should be there$")
	public void order_confirmation_message_with_text_should_be_there(String ExpectedOrderCompleteTxt) throws Throwable {
		String ActualOrderCompleteTxt = CustomerCheckoutPage.getOrderConfirmMessage();
		assertTrue(ActualOrderCompleteTxt.contains(ExpectedOrderCompleteTxt));
	}


	
}
