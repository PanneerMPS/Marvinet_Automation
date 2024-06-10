package Stepdefinitions;

import org.openqa.selenium.WebDriver;

import Hooks.Testhooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.Settingspage;
import resources.Base;

public class Settings extends Base {

    private WebDriver driver;
    private Settingspage settingspage;

    public Settings(Testhooks testhooks) throws Exception {
        this.driver = testhooks.getDriver();
        this.settingspage = new Settingspage(driver);
    }

    @And("Go to settings feature")
    public void Go_to_settings_feature() {
    	settingspage.Click_settings();
    	settingspage.Click_while_usingapp_permission();
    }

    @Then("Check personal info option is displayed")
    public void Check_personal_info_option_is_displayed() {
    	settingspage.personal_profile_display();
    }

}


