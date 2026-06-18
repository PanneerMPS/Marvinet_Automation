package pageobjects;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.Base;

public class Signup_page extends Base {

    private final Logger LOGGER = LogManager.getLogger(Signup_page.class);

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private Properties prop;

    public Signup_page(WebDriver driver) throws Exception {

        this.driver = driver;
        this.js = (JavascriptExecutor) driver;

        prop = new Properties();

        String propPath = System.getProperty("user.dir")
                + "/src/main/java/resources/dataproperties";

        FileInputStream fis = new FileInputStream(propPath);
        prop.load(fis);

        PageFactory.initElements(driver, this);

        initializeWait();
    }

    private void initializeWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private String generateUniqueEmail(String baseEmail) {

        String[] emailParts = baseEmail.split("@");

        return emailParts[0]
                + System.currentTimeMillis()
                + "@"
                + emailParts[1];
    }

    // ==========================================================
    // Page Elements
    // ==========================================================

    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    private WebElement clicks_signup;

    @FindBy(id = "signup-email-input")
    private WebElement signup_email;

    @FindBy(id = "signup-mobile-number-input")
    private WebElement signup_mobilenumber;

    @FindBy(id = "signup-password-input")
    private WebElement signup_newpassword;

    @FindBy(id = "signup-confirm-password-input")
    private WebElement signup_confirmpassword;

    @FindBy(id = "accept-terms-checkbox")
    private WebElement signup_agree_checkbox;

    @FindBy(xpath = "//button[contains(.,'Join Marvinet Now')]")
    private WebElement click_join_marvinet_button;

    @FindBy(xpath = "//button[@title='Edit email address']")
    private WebElement check_signedup;

    // ==========================================================
    // Actions
    // ==========================================================

    public void clicks_signup() {

        wait.until(ExpectedConditions.visibilityOf(clicks_signup));
        wait.until(ExpectedConditions.elementToBeClickable(clicks_signup));

        try {
            clicks_signup.click();
        } catch (ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", clicks_signup);
        }

        LOGGER.info("Clicked Signup Link");
    }

    public void Enter_valid_email_address() {

        String uniqueEmail =
                generateUniqueEmail(prop.getProperty("signup_email"));

        wait.until(ExpectedConditions.visibilityOf(signup_email));
        signup_email.clear();
        signup_email.sendKeys(uniqueEmail);

        LOGGER.info("Entered Email: {}", uniqueEmail);
    }

    public void signup_mobilenumber() {

        wait.until(ExpectedConditions.visibilityOf(signup_mobilenumber));

        signup_mobilenumber.clear();
        signup_mobilenumber.sendKeys(
                prop.getProperty("signup_mobileNumber"));

        LOGGER.info("Entered Mobile Number");
    }

    public void signup_newpassword() {

        wait.until(ExpectedConditions.visibilityOf(signup_newpassword));

        signup_newpassword.clear();
        signup_newpassword.sendKeys(
                prop.getProperty("signup_newpassword"));

        LOGGER.info("Entered New Password");
    }

    public void signup_confirmpassword() {

        wait.until(ExpectedConditions.visibilityOf(signup_confirmpassword));

        signup_confirmpassword.clear();
        signup_confirmpassword.sendKeys(
                prop.getProperty("signup_confirm_password"));

        LOGGER.info("Entered Confirm Password");
    }

    public void signup_agree_checkbox() {

        wait.until(ExpectedConditions.elementToBeClickable(
                signup_agree_checkbox));

        if (!signup_agree_checkbox.isSelected()) {
            signup_agree_checkbox.click();
        }

        LOGGER.info("Clicked Agree Checkbox");
    }

    public void click_join_marvinet_button() {

        wait.until(ExpectedConditions.visibilityOf(
                click_join_marvinet_button));

        wait.until(ExpectedConditions.elementToBeClickable(
                click_join_marvinet_button));

        try {
            click_join_marvinet_button.click();
        } catch (ElementClickInterceptedException e) {
            js.executeScript(
                    "arguments[0].click();",
                    click_join_marvinet_button);
        }

        LOGGER.info("Clicked Join Marvinet Button");
    }

    public void check_signedup() {

        wait.until(ExpectedConditions.visibilityOf(check_signedup));

        if (check_signedup.isDisplayed()) {
            LOGGER.info("User Signed Up Successfully");
        }
    }
}
