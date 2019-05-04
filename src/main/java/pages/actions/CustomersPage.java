package pages.actions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import pages.locators.CustomersPageLocators;
import utilities.SeleniumDriver;

public class CustomersPage {

	CustomersPageLocators CustomersPageLocators = null;

	public CustomersPage() {
		this.CustomersPageLocators = new CustomersPageLocators();
		PageFactory.initElements(SeleniumDriver.getDriver(), CustomersPageLocators);
	}

	public void enterLoginCredentials(String Email, String Password) {
		
		new WebDriverWait(SeleniumDriver.getDriver(), 180).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return (Boolean) SeleniumDriver.js.executeScript("return document.readyState").equals("complete");
			}
		});
		
		CustomersPageLocators.email.sendKeys(Email);
		CustomersPageLocators.passwd.sendKeys(Password);
	}

	public void clickLoginBtn() {
		CustomersPageLocators.SubmitLogin.click();
	}

	public String getWelcomeTxt() {
		return CustomersPageLocators.acocuntWelcomeTxt.getText();
	}

	public String getWelcomeAccountName() {
		return CustomersPageLocators.acocuntTxt.getText();
	}

	public String getUnSuccessfulLoginErrorMessage() {
		new WebDriverWait(SeleniumDriver.getDriver(), 180).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return (Boolean) SeleniumDriver.js.executeScript("return document.readyState").equals("complete");
			}
		});

		return SeleniumDriver.wait.until(ExpectedConditions.visibilityOf(CustomersPageLocators.loginErrorMsg))
				.getText();

	}
	
	public void enterEmailForRegisterAccount(String Email)
	{
		CustomersPageLocators.emailAddress.sendKeys(Email);
	}
	
	public void clickSubmitBtnForCreateAccount()
	{
		CustomersPageLocators.submitCreateBtn.click();
	}
	
	public void enterCustomerDetailsForCreateAccount(DataTable CustomerData)
	{
		List<Map<String,String>> data = CustomerData.asMaps(String.class, String.class);
		String Title = data.get(0).get("Title");
		if(Title.equalsIgnoreCase("Mr"))
		{
			CustomersPageLocators.mr.click();
		}else
		{
			CustomersPageLocators.miss.click();
		}
			
		CustomersPageLocators.firstName.sendKeys(data.get(0).get("FirstName"));
		CustomersPageLocators.lastName.sendKeys(data.get(0).get("LastName"));
		CustomersPageLocators.accountPasswd.sendKeys(data.get(0).get("Password"));
		String [] DOB = data.get(0).get("DOB").split("-");
		Select Days = new Select(CustomersPageLocators.days);
		Days.selectByValue(DOB[0]);
		Select Months = new Select(CustomersPageLocators.months);
		Months.selectByValue(DOB[1]);
		Select Year = new Select(CustomersPageLocators.years);
		Year.selectByValue(DOB[2]);
		
		CustomersPageLocators.company.sendKeys(data.get(0).get("Company"));
		CustomersPageLocators.address1.sendKeys(data.get(0).get("Address1"));
		CustomersPageLocators.address2.sendKeys(data.get(0).get("Address2"));
		CustomersPageLocators.city.sendKeys(data.get(0).get("City"));
		Select State = new Select(CustomersPageLocators.state);
		State.selectByVisibleText(data.get(0).get("State"));
		CustomersPageLocators.postcode.sendKeys(data.get(0).get("ZipCode"));
		CustomersPageLocators.other.sendKeys(data.get(0).get("AdditionatInfo"));
		CustomersPageLocators.phone.sendKeys(data.get(0).get("HomePhone"));
		CustomersPageLocators.mobileNumber.sendKeys(data.get(0).get("MobilePhone"));
		CustomersPageLocators.alias.clear();
		CustomersPageLocators.alias.sendKeys(data.get(0).get("AssignAddress_Alis"));
		
	}
	
	public void clickOnRegisterBtnToCreateAccount()
	{
		CustomersPageLocators.registerAccountBtn.click();
	}

	/*
	 * public Hashtable<String, String> getAccountDetails() { Hashtable<String,
	 * String> ReturnValues = new Hashtable<String, String>(); String AccountHeading
	 * = SeleniumDriver.wait
	 * .until(ExpectedConditions.visibilityOf(CustomersPageLocators.accountHeading))
	 * .getText(); String AccountName = CustomersPageLocators.acocuntTxt.getText();
	 * String WelcomeText = CustomersPageLocators.acocuntWelcomeTxt.getText();
	 * 
	 * ReturnValues.put("AccountHeading", AccountHeading);
	 * ReturnValues.put("AccountName", AccountName); ReturnValues.put("WelcomeText",
	 * WelcomeText);
	 * 
	 * return ReturnValues; }
	 */

}
