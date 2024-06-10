package Stepdefinitions;

import static org.junit.Assert.assertEquals;

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

    @And("Click personal profile option")
    public void Click_personal_profile_option() {
    	settingspage.personal_profile_click();
    }
    
    @Then("Check the personal profile page fields")
    public void Check_the_personal_profile_page_fields() {
    	settingspage.Settings_personalinfo_namedisplay();
    }
    
    @And("Update the personal profile fields")
    public void Update_the_personal_profile_fields() {
    	settingspage.Settings_personalinfo_name();
    	settingspage.Settings_personalinfo_contact_number();
    	settingspage.Settings_personalinfo_IQAMA();
    	settingspage.Settings_personalinfo_wappnumber();
    	settingspage.Settings_personalinfo_location();
    	settingspage.Settings_personalinfo_bio();
    }
    
    @And("Click Save profile button")
    public void Click_Save_profile_button() {
    	settingspage.Settings_personalinfo_save();
    }
    
    @And("Click Yes btn in confirmation popup")
    public void Click_Yes_btn_in_confirmation_popup() {
    	settingspage.Settings_personalinfo_confirm_yes();
    }
    
    @Then("^Check the personal profile updated successfully as \"([^\"]*)\"$")
    public void Check_the_personal_profile_updated_successfully(String expectedMessage) {
    	 String actualMessage = settingspage.checkvalid_error_display();
         String normalizedExpectedMessage = normalizeWhitespace(expectedMessage);
         String normalizedActualMessage = normalizeWhitespace(actualMessage);
         System.out.println("Expected Message: " + normalizedExpectedMessage);
         System.out.println("Actual Message: " + normalizedActualMessage);  
         assertEquals(normalizedExpectedMessage, normalizedActualMessage);
    }
    private String normalizeWhitespace(String input) {
        return input.replaceAll("\\s+", " ").trim();
    }
}


