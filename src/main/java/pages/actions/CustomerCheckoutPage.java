package pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.locators.CustomerCheckoutPageLocators;
import utilities.SeleniumDriver;

public class CustomerCheckoutPage {

	CustomerCheckoutPageLocators CustomerCheckoutPageLocators =null;
	

	public CustomerCheckoutPage() {
		this.CustomerCheckoutPageLocators = new CustomerCheckoutPageLocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), CustomerCheckoutPageLocators);
	}
	
	public void selectProduct()
	{
		new WebDriverWait(SeleniumDriver.getDriver(), 180).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return (Boolean) SeleniumDriver.js.executeScript("return document.readyState").equals("complete");
			}
		});
		
		
		Actions actions = new Actions(SeleniumDriver.getDriver());
		actions.moveToElement(CustomerCheckoutPageLocators.customerProduct).perform();
		SeleniumDriver.wait.until(ExpectedConditions.elementToBeClickable(CustomerCheckoutPageLocators.customProductAddToCartBtn)).click();
		
	}
	
	public void addProductToCart() {
		CustomerCheckoutPageLocators.proceedToCheckoutFirst.click();
	}
	
	public void clickProceedToCheckout()
	{
		
		System.out.println("I am here");
		System.out.println(CustomerCheckoutPageLocators.proceedToCheckoutFirst.getText());
		SeleniumDriver.wait.until(ExpectedConditions.elementToBeClickable(CustomerCheckoutPageLocators.proceedToCheckoutFirst)).click();
		
		//CustomerCheckoutPageLocators.proceedToCheckoutFirst.click();
	}
	public void clickProceedToSecond()
	{
		CustomerCheckoutPageLocators.proceedToCheckoutSecond.click();
	}
	
	
	public void clickProceedToThird()
	{
		CustomerCheckoutPageLocators.proceedToCheckoutThird.click();
	}
	
	public void clickAgreeOnTermsAndConditions()
	{
		CustomerCheckoutPageLocators.termsAgreeCheckBox.click();
	}
	
	public void clickProceedToCheckoutFinal()
	{
		CustomerCheckoutPageLocators.proceedToCheckoutFinal.click();
	}
	
	public void selectPayByBankOrWire()
	{
		CustomerCheckoutPageLocators.payByBankWire.click();
	}
	
	public void clickConfirmOrderBtn()
	{
		CustomerCheckoutPageLocators.confirmOrderBtn.click();
	}
	
	public boolean checkIfShippingTabIsDisplayed()
	{
		return CustomerCheckoutPageLocators.shippingTab.isDisplayed();
	}
	
	public boolean checkIfPaymentTabIsDisplayed()
	{
		return CustomerCheckoutPageLocators.paymentTab.isDisplayed();
	}
	
	public String getOrderConfirmMessage()
	{
		return CustomerCheckoutPageLocators.orderCompleteMessageTxt.getText(); 
	}
	
	public String getOrderConfirmPageHeadingTxt()
	{
		return CustomerCheckoutPageLocators.orderConfirmHeadingTxt.getText(); 
	}
	
	
	
	
	
	
}
