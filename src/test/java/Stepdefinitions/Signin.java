package Stepdefinitions;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageobjects.Signin_page;

public class Signin {

    Signin_page signinPage;

    public Signin(Testhooks hooks) throws Exception {

    	signinPage = new Signin_page(hooks.getDriver());
    }

    @When("User enters generated email")
    public void user_enters_generated_email() {

    	signinPage.enterLoginEmail();
    }

    @And("User enters login password")
    public void user_enters_login_password() {

    	signinPage.enterLoginPassword();
    }

    @And("User clicks login button")
    public void user_clicks_login_button() {

    	signinPage.clickLoginButton();
    }
}