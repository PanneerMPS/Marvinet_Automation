package Stepdefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Gmail_page;
import pageobjects.Signup_page;
import resources.Base;

public class Signup extends Base {

    private Logger LOGGER = LogManager.getLogger(Signup.class);
    private final Signup_page signup_page;
	private Gmail_page Gmail_page;
    

    public Signup(Testhooks testhooks) throws Exception {

        WebDriver driver = testhooks.getDriver();

        this.signup_page = new Signup_page(driver);
		this.Gmail_page = new Gmail_page(driver);

        LOGGER = LogManager.getLogger(Signup.class.getName());
    }

    @Given("User navigates to Login page")
    public void user_navigates_to_login_page() {
        LOGGER.info("User navigates to login page");
    }

    @When("Users Clicks Signup link")
    public void Users_Clicks_Signup_link() throws Exception {
        signup_page.clicks_signup();
    }

    @And("User enters valid email address")
    public void user_enters_valid_email_address() {
        signup_page.Enter_valid_email_address();
    }

    @And("Enter valid mobile number")
    public void Enter_valid_mobile_number() {
        signup_page.signup_mobilenumber();
    }

    @And("Enter New Password")
    public void Enter_New_Password() {
        signup_page.signup_newpassword();
    }

    @And("Enter Confirm Password")
    public void Enter_Confirm_Password() {
        signup_page.signup_confirmpassword();
    }

    @And("Click I Agree Checkbox")
    public void Click_I_Agree_Checkbox() {
        signup_page.signup_agree_checkbox();
    }

    @And("Click Join Marvinet Button")
    public void Click_Join_Marvinet_Button() {
        signup_page.click_join_marvinet_button();
    }

    @Then("Check Signed Up Successfully")
    public void Check_Signed_Up_Successfully() {
        signup_page.check_signedup();
    }
    
    @And("Go to mail signin page")
	public void Go_to_mail_signin_page() throws Exception {
    	signup_page.openMail();
	}

	@And("Gmail confirm account process")
	public void Gmail_confirm_account_process() throws Exception {
		Gmail_page.gmailsignin_process();
	}
	
	@Then("Check confirm account got success")
	public void Check_confirm_account_got_success() {
		System.out.println("Confirm account got success");
	}
	
	@Then("Check 2FA page showing successfully")
	public void Check_2FA_page_showing_successfully() throws IOException {
		signup_page.TwoFA_page_Open();
	}
	
	@Then("Click Skip in 2FA page")
	public void Click_Skip_in_2FA_page() {
		signup_page.TwoFA_skip();
	}
	
	@Then("Check Complete Profile page showing successfully")
	public void Check_Complete_Profile_page_showing_successfully() throws IOException {
		signup_page.CP_FN();
	}
	
	@Then("Complete the Complete profile")
	public void Complete_the_Complete_profile() throws IOException, InterruptedException {
		signup_page.CP_FN();
		signup_page.CP_LN();
		signup_page.CP_PN();
		signup_page.CP_Mail();
		signup_page.CP_Country();
		signup_page.CP_VAT();
		signup_page.CP_CN();
		signup_page.CP_Website();
		signup_page.CP_CA();
		signup_page.CP_Region();
		signup_page.CP_City();
		signup_page.CP_Zipcode();
		signup_page.CP_Continue();
	}
	
	@Then("Check Verify OTP page showing successfully")
	public void Check_Verify_OTP_page_showing_successfully() throws IOException {
		signup_page.CP_OTP_Title();
	}
	
	@And("Click Veriy and Proceed button")
	public void Click_Veriy_and_Proceed_button() throws IOException {
		signup_page.CP_OTP_Proceed();
	}
	
	@Then("Check Verify KYC page showing successfully")
	public void Check_Verify_KYC_page_showing_successfully() throws IOException {
		signup_page.CP_Verify_KYC_Title();
	}
	
	@And("Click Veriy KYC button")
	public void Click_Veriy_KYC_button() throws IOException {
		signup_page.CP_Verify_KYC_button();
	}
	
	
	
	
	
	
	
	
	

}