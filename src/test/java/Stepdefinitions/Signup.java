package Stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.Signup_page;
import resources.Base;

public class Signup extends Base {

    private Logger LOGGER = LogManager.getLogger(Signup.class);
    private final Signup_page signup_page;

    public Signup(Testhooks testhooks) throws Exception {

        WebDriver driver = testhooks.getDriver();

        this.signup_page = new Signup_page(driver);

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
}