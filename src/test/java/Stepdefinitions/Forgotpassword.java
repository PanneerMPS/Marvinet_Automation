package Stepdefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Forgotpasswordpage;
import resources.Base;

public class Forgotpassword extends Base {
	private WebDriver driver;
	private Forgotpasswordpage forgotPasswordPage;

	public Forgotpassword(Testhooks testhooks) {
		this.driver = testhooks.getDriver();
		this.forgotPasswordPage = new Forgotpasswordpage(driver);
	}

	@When("User clicks forgot password option")
	public void user_clicks_forgot_password_option() {
		forgotPasswordPage.clickForgotPasswordLink();
	}

	@When("^User enters forgot password valid email address$")
	public void user_enters_forgot_password_valid_email_address() {
		forgotPasswordPage.enterValidEmail();
	}
	
	@When("^User enters invalid email address in forgot password page$")
	public void User_enters_invalid_email_address_in_forgot_password_page() {
		forgotPasswordPage.non_technician_emailid();
	}

	@When("User clicks Send Reset link button")
	public void user_clicks_send_reset_link_button() {
		driver.navigate().back();
		forgotPasswordPage.clickSendResetLink();
	}

	@Then("^Proper confirmation email message should receive to user mail \"([^\"]*)\"$")
	public void proper_confirmation_email_message_should_receive_to_user_mail(String expectedMessage) {
		String actualMessage = forgotPasswordPage.checkvalid_error_display();
		String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println("Expected Message: " + normalizedExpectedMessage);
		System.out.println("Actual Message: " + normalizedActualMessage);
		assertEquals(normalizedExpectedMessage, normalizedActualMessage);
	}
	
	 @Then("^User should get a technician only have access error message as \"([^\"]*)\"$")
	    public void user_should_get_a_technician_only_have_access_error_message(String expectedMessage) {
	   	 String actualMessage = forgotPasswordPage.Technician_access_error();
	     String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
	     String normalizedActualMessage = normalizeWhitespace(actualMessage);
	     System.out.println("Expected Message: " + normalizedExpectedMessage);
	     System.out.println("Actual Message: " + normalizedActualMessage);  
	     assertEquals(normalizedExpectedMessage, normalizedActualMessage);
	    }

	private String normalizeWhitespace(String input) {
		return input.replaceAll("\\s+", " ").trim();
	}

	@When("^User enters forgot password invalid email address$")
	public void user_enters_forgot_password_invalid_email_address() {
		forgotPasswordPage.enterInvalidEmail();
		forgotPasswordPage.Clickforgot_text();
	}

	@Then("User should get a email address or phone number is required error message")
	public void User_should_get_a_email_address_or_phone_number_is_required_error_message() {
		forgotPasswordPage.isRequiredErrorDisplayed();
	}

	@Then("User should get a invalid email address error message in forgotpassword page")
	public void user_should_get_a_invalid_email_address_error_message_in_forgotpassword_page() {
		forgotPasswordPage.isInvalidEmailErrorDisplayed();
	}

	@And("User enters forgot password invalid email address and delete")
	public void User_enters_forgot_password_invalid_email_address_and_delete() {
		forgotPasswordPage.emailField();
		forgotPasswordPage.Clickforgot_text();
	}
	
	@And("User enters the OTP and click verify OTP button")
	public void User_enters_the_OTP_and_click_verify_OTP_button() throws Exception {
		forgotPasswordPage.Enter_OTP();
	}
	
	@And("User enters the INVOTP and click verify OTP button")
	public void User_enters_the_INVOTP_and_click_verify_OTP_button() throws Exception {
		forgotPasswordPage.Enter_INVOTP();
	}
	
	@And("User enters the resend OTP and click verify OTP button")
	public void User_enters_the_resend_OTP_and_click_verify_OTP_button() throws Exception {
		forgotPasswordPage.Enter_resendOTP();
	}
	
	@Then("^User should get a verified OTP error message as \"([^\"]*)\"$")
	public void User_should_get_a_verified_OTP_error_message_as(String expectedMessage) {
		String actualMessage = forgotPasswordPage.OTP_verified_success_popup();
		String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println("Expected Message: " + normalizedExpectedMessage);
		System.out.println("Actual Message: " + normalizedActualMessage);
		assertEquals(normalizedExpectedMessage, normalizedActualMessage);
	}
	
	@And("Click remember my password text")
	public void Click_remember_my_password_text() throws Exception {
		forgotPasswordPage.I_remember_password();
	}
	
	@Then("Verify login page should display")
	public void Verify_login_page_should_display() throws Exception {
		forgotPasswordPage.emailfield_display();
	}
	
	@And("User clicks want to change email")
	public void User_clicks_want_to_change_email() throws Exception {
		forgotPasswordPage.Change_Mobileno_email_OTPpage();
	}
	
	@And("Click OTP field")
	public void Click_OTP_field() throws Exception {
		forgotPasswordPage.Click_OTP_field();
	}

	@Then("User should get a OTP is required error message")
	public void User_should_get_a_OTP_is_required_error_message() throws Exception {
		forgotPasswordPage.OTP_required_error();
	}
	
	@Then("Verify the reset password displayed or not")
	public void Verify_the_reset_password_displayed_or_not() throws Exception {
		forgotPasswordPage.Reset_newpassword();
	}
	
	@Then("^User should get a invalid OTP error message in OTP page as \"([^\"]*)\"$")
	public void User_should_get_a_invalid_OTP_error_message_in_OTP_page(String expectedMessage) {
		String actualMessage = forgotPasswordPage.InvalidOTP_error();
		String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
		String normalizedActualMessage = normalizeWhitespace(actualMessage);
		System.out.println("Expected Message: " + normalizedExpectedMessage);
		System.out.println("Actual Message: " + normalizedActualMessage);
		assertEquals(normalizedExpectedMessage, normalizedActualMessage);
	}
}
