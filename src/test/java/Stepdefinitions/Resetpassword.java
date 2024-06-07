package Stepdefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.Resetpasswordpage;
import resources.Base;

public class Resetpassword extends Base {
	private WebDriver driver;
	private Resetpasswordpage resetPasswordPage;

	public Resetpassword(Testhooks testhooks) {
		this.driver = testhooks.getDriver();
		this.resetPasswordPage = new Resetpasswordpage(driver);
	}

	@And("User enters the valid new password and confirm password")
	public void User_enters_the_valid_new_password_and_confirm_password() {
		resetPasswordPage.ValidEnter_newpassword();
		resetPasswordPage.ValidReset_confirmpassword();
		resetPasswordPage.Reset_reset_btn();
	}

	@Then("^User should get a password updated error message as \"([^\"]*)\"$")
	public void User_should_get_a_password_updated_error_message_as(String expectedMessage) {
		String actualMessage = resetPasswordPage.Resetpassword_success();
		String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println("Expected Message: " + normalizedExpectedMessage);
		System.out.println("Actual Message: " + normalizedActualMessage);
		assertEquals(normalizedExpectedMessage, normalizedActualMessage);
	}

	private String normalizeWhitespace(String input) {
		return input.replaceAll("\\s+", " ").trim();
	}

	@And("User enters the invalid new password and confirm password")
	public void User_enters_the_invalid_new_password_and_confirm_password() {
		resetPasswordPage.ValidEnter_newpassword();
		resetPasswordPage.INVValidReset_confirmpassword_notmatch();
		resetPasswordPage.Reset_click_sample_text();
	}

	@Then("^User should get a confirm password does not match error message in resetpassword page$")
	public void User_should_get_a_confirm_password_does_not_match_error_message_in_resetpassword_page() {
		resetPasswordPage.Reset_passwordnot_match();
	}

	@And("User Clicks the both new and confirm password fields")
	public void User_Clicks_the_both_new_and_confirm_password_fields() {
		resetPasswordPage.Reset_newpassword_click();
		resetPasswordPage.Reset_click_sample_text();
	}

	@Then("^User should get a passsword is required error message in resetpassword page$")
	public void User_should_get_a_passsword_is_required_error_message_in_resetpassword_page() {
		resetPasswordPage.password_required();
	}
}
