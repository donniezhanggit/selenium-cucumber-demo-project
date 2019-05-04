package pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.locators.NavigationLocators;
import utilities.SeleniumDriver;

public class Navigation {
	
	public NavigationLocators NavigationLocators ;
	public Navigation(WebDriver driver){
		
		this.NavigationLocators = new NavigationLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.NavigationLocators);
	}
	
	public CustomersPage gotoCustomerLoginPage()
	{
		SeleniumDriver.wait.until(ExpectedConditions.visibilityOf(NavigationLocators.loginBtn)).click();
		NavigationLocators.loginBtn.click();
		return new CustomersPage();
	}
	
	
	public void gotoWomenProductsPage()
	{
	
		new WebDriverWait(SeleniumDriver.getDriver(), 180).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return (Boolean) SeleniumDriver.js.executeScript("return document.readyState").equals("complete");
			}
		});
		
		NavigationLocators.womenProductMenu.click();
		
	}
	

	
	public  boolean elementHasClass(WebElement element, String desiredClass) {
		 return element.getAttribute("class").contains(desiredClass);
	}
	
	public boolean checkIfLogoutBtnIsDisplayed()
	{
		return NavigationLocators.logout.isDisplayed();
	}
	
	
	
	
}
