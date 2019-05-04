package steps;

import static org.testng.Assert.assertTrue;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.actions.CustomersPage;
import utilities.SeleniumHelper;

public class CustomerSignupSteps {

	CustomersPage CustomersPage = new CustomersPage();

	@Given("^customer enter valid email address \"([^\"]*)\"$")
	public void customer_enter_valid_email_address(String Email) throws Throwable {
		CustomersPage.enterEmailForRegisterAccount(Email);
	}

	@Then("^click on Create An Account button$")
	public void click_on_Create_An_Account_button() throws Throwable {
			CustomersPage.clickSubmitBtnForCreateAccount();
	}

	@Then("^enter valid account details as$")
	public void enter_valid_account_details_as(DataTable CustomerData) throws Throwable {
			CustomersPage.enterCustomerDetailsForCreateAccount(CustomerData);
	}

	@Then("^customer click on register button$")
	public void customer_click_on_register_button() throws Throwable {
		CustomersPage.clickOnRegisterBtnToCreateAccount();
	}

	@Then("^should registered successfully and verify page URL contains \"([^\"]*)\"$")
	public void should_registered_successfully_and_verify_page_URL_contains(String ExpectedURL) throws Throwable {
		String ActualURl = SeleniumHelper.getCurrentPageURL();
		assertTrue(ActualURl.contains(ExpectedURL));

	}

}
