package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.actions.CustomersPage;
import utilities.SeleniumDriver;
import utilities.SeleniumHelper;

public class CustomerLoginSteps {

	CustomersPage CustomersPage = new CustomersPage();

	@Given("^customer open website home page \"([^\"]*)\"$")
	public void customer_open_website_home_page(String WebsiteURL) throws Throwable {
		SeleniumDriver.openPage(WebsiteURL);
	}

	@Then("^click \\*Sign in\\* button \\(in the header\\)$")
	public void click_Sign_in_button_in_the_header() throws Throwable {
		SeleniumDriver.nav.gotoCustomerLoginPage();
	}

	@Given("^customer enter valid  email \"([^\"]*)\" and  valid password \"([^\"]*)\"$")
	public void customer_enter_valid_email_and_valid_password(String Email, String Password) throws Throwable {
		CustomersPage.enterLoginCredentials(Email, Password);
	}

	@Then("^customer click on signin button$")
	public void customer_click_on_signin_button() throws Throwable {
		CustomersPage.clickLoginBtn();
	}

	@Then("^should signin successfully and verify page URL contains \"([^\"]*)\"$")
	public void should_signin_successfully_and_verify_page_URL_contains(String ExpectedURL) throws Throwable {
		String ActualURl = SeleniumHelper.getCurrentPageURL();
		assertTrue(ActualURl.contains(ExpectedURL));

	}

	@Then("^verify welcome account name as \"([^\"]*)\"$")
	public void verify_welcome_account_name_as(String ExpectedWelcomeAccountName) throws Throwable {
		String ActualWelcomeAccountName = CustomersPage.getWelcomeAccountName();
		assertEquals(ActualWelcomeAccountName, ExpectedWelcomeAccountName);
	}

	@Then("^verify welcome text as \"([^\"]*)\"$")
	public void verify_welcome_text_as(String ExpectedWelcomeTxt) throws Throwable {
		String ActualWelcomeTxt = CustomersPage.getWelcomeTxt();
		assertTrue(ActualWelcomeTxt.contains(ExpectedWelcomeTxt));
	}

	@Then("^verify if logout button is visible$")
	public void verify_if_logout_button_is_visible() throws Throwable {
		assertTrue(SeleniumDriver.nav.checkIfLogoutBtnIsDisplayed());
	}

	@Given("^customer enter invalid  email \"([^\"]*)\" and  invalid password \"([^\"]*)\"$")
	public void customer_enter_invalid_email_and_valid_password(String Email, String Password) throws Throwable {
		CustomersPage.enterLoginCredentials(Email, Password);
	}

	@Then("^should show error with message \"([^\"]*)\"$")
	public void should_show_error_with_message(String ExpectedErrorMessageTxt) throws Throwable {
		String ActualErrorMessageTxt = CustomersPage.getUnSuccessfulLoginErrorMessage();
		assertTrue(ActualErrorMessageTxt.contains(ExpectedErrorMessageTxt));
	}

}
