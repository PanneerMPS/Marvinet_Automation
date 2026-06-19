package pageobjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.Key;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.Enter;
import utils.TestData;

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
    
    private String generateUniqueVatNumber() {

        Random random = new Random();

        long vat = 1000000000L + (long)(random.nextDouble() * 9000000000L);

        return String.valueOf(vat);
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
        
        TestData.generatedEmail = uniqueEmail;

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
    
    public void openMail() throws IOException {
        LOGGER.info("Opening Gmail page");
        driver.get(prop.getProperty("Gmail_URL"));
        LOGGER.info("Navigated to Gmail login page");
    }
    
    
    // ==========================================================
    // 2FA Page
    // ==========================================================
    @FindBy(id = "Enable Two-Factor Authentication")
    private WebElement TwoFA_page;
    
    @FindBy(partialLinkText = "Skip")
    private WebElement TwoFA_skip;
    
    
    public void TwoFA_page_Open() throws IOException {

        wait.until(ExpectedConditions.visibilityOf(TwoFA_page));

        if (TwoFA_page.isDisplayed()) {
            LOGGER.info("2FA page displaying successfully");
        }
    }
    
    public void TwoFA_skip() {

        wait.until(ExpectedConditions.visibilityOf(
        		TwoFA_skip));

        wait.until(ExpectedConditions.elementToBeClickable(
        		TwoFA_skip));

        try {
        	TwoFA_skip.click();
        } catch (ElementClickInterceptedException e) {
            js.executeScript(
                    "arguments[0].click();",
                    TwoFA_skip);
        }

        LOGGER.info("Clicked skip button in 2FA page");
    }
    
    // ==========================================================
    // Complete Your Profile
    // ==========================================================
  
    @FindBy(id = "firstName")
    private WebElement CP_FN;
    
    @FindBy(id = "lastName")
    private WebElement CP_LN;
    
    @FindBy(id = "companyContactPhoneNo")
    private WebElement CP_PN;
    
    @FindBy(id = "companyContactMailId")
    private WebElement CP_Mail;
    
    @FindBy(xpath = "//div[@role='combobox']")
    private WebElement CP_Country;
    
    @FindBy(xpath = "//input[@placeholder='Search...']")
    private WebElement CP_Country_search;
    
    @FindBy(id = "taxNumber")
    private WebElement CP_VAT;
    
    @FindBy(id = "companyName")
    private WebElement CP_CN;
    
    @FindBy(id = "website")
    private WebElement CP_Website;
    
    @FindBy(id = "companyAddress")
    private WebElement CP_CA;
    
    @FindBy(id = "region")
    private WebElement CP_Region;
    
    @FindBy(id = "city")
    private WebElement CP_City;
    
    @FindBy(id = "zipCode")
    private WebElement CP_Zipcode;
    
    @FindBy(id = "Continue")
    private WebElement CP_Continue;
    
    
    public void CP_FN() {

        wait.until(ExpectedConditions.visibilityOf(CP_FN));

        CP_FN.clear();
        CP_FN.sendKeys(
                prop.getProperty("FirstName"));

        LOGGER.info("Entered FirstName");
    }
    
    public void CP_LN() {

        wait.until(ExpectedConditions.visibilityOf(CP_LN));

        CP_LN.clear();
        CP_LN.sendKeys(
                prop.getProperty("LastName"));

        LOGGER.info("Entered LastName");
    }
    
    public void CP_PN() {

        wait.until(ExpectedConditions.visibilityOf(CP_PN));

        CP_PN.clear();
        CP_PN.sendKeys(
                prop.getProperty("PhoneNo"));

        LOGGER.info("Entered PhoneNo");
    }
    
    public void CP_Mail() {

        wait.until(ExpectedConditions.visibilityOf(CP_Mail));

        CP_Mail.clear();

        CP_Mail.sendKeys(TestData.generatedEmail);

        LOGGER.info("Company Email : " + TestData.generatedEmail);
    }
    
    public void CP_Country() {

        wait.until(ExpectedConditions.visibilityOf(CP_Country));

        CP_Country.click();
        CP_Country_search.click();
        String searchTerm = prop.getProperty("Country");
		wait.until(ExpectedConditions.visibilityOf(CP_Country_search)).sendKeys(searchTerm + Keys.ARROW_DOWN + Keys.ENTER);
        LOGGER.info("Entered Country");
    }
    
    public void CP_VAT() {

    	String uniqueVat = generateUniqueVatNumber();

    	CP_VAT.clear();
    	CP_VAT.sendKeys(uniqueVat);

    	System.out.println("Generated VAT Number: " + uniqueVat);
        LOGGER.info("Entered VAT: {}", uniqueVat);
    }

    public void CP_CN() {

        wait.until(ExpectedConditions.visibilityOf(CP_CN));

        CP_CN.clear();
        CP_CN.sendKeys(
                prop.getProperty("CompanyName"));

        LOGGER.info("Entered CompanyName");
    }
    
    public void CP_Website() {

        wait.until(ExpectedConditions.visibilityOf(CP_Website));

        CP_Website.clear();
        CP_Website.sendKeys(
                prop.getProperty("Website"));

        LOGGER.info("Entered Website");
    }
    
    public void CP_CA() throws InterruptedException {
 
        wait.until(ExpectedConditions.visibilityOf(CP_CA));

        CP_CA.clear();
        CP_CA.sendKeys(
                prop.getProperty("Company_Address"));

        LOGGER.info("Entered Company_Address");
    }
    
    public void CP_Region() {

        wait.until(ExpectedConditions.visibilityOf(CP_Region));

        CP_Region.clear();
        CP_Region.sendKeys(
                prop.getProperty("Region"));

        LOGGER.info("Entered Region");
    }
    
    public void CP_City() {

        wait.until(ExpectedConditions.visibilityOf(CP_City));

        CP_City.clear();
        CP_City.sendKeys(
                prop.getProperty("City"));

        LOGGER.info("Entered City");
    }
    
    public void CP_Zipcode() {

        wait.until(ExpectedConditions.visibilityOf(CP_Zipcode));

        CP_Zipcode.clear();
        CP_Zipcode.sendKeys(
                prop.getProperty("Zipcode"));

        LOGGER.info("Entered Zipcode");
    }
    
    public void CP_Continue() {

        wait.until(ExpectedConditions.visibilityOf(
        		CP_Continue));

        wait.until(ExpectedConditions.elementToBeClickable(
        		CP_Continue));

        try {
        	CP_Continue.click();
        } catch (ElementClickInterceptedException e) {
            js.executeScript(
                    "arguments[0].click();",
                    CP_Continue);
        }

        LOGGER.info("Clicked Continue in Complete Profile 1st page");
    }
    
    // ==========================================================
    // Complete Your Profile - Verify OTP
    // ==========================================================
  
    @FindBy(xpath = "//h2[normalize-space()='Verify Your Contact Number']")
    private WebElement CP_OTP_Title;
    
    @FindBy(id = "Verify & Proceed")
    private WebElement CP_OTP_Proceed;
    
    public void CP_OTP_Title() throws IOException {

        wait.until(ExpectedConditions.visibilityOf(CP_OTP_Title));

        if (CP_OTP_Title.isDisplayed()) {
            LOGGER.info("Verify OTP page displaying successfully");
        }
    }
    
    public void CP_OTP_Proceed() {

        wait.until(ExpectedConditions.visibilityOf(
        		CP_OTP_Proceed));

        wait.until(ExpectedConditions.elementToBeClickable(
        		CP_OTP_Proceed));

        try {
        	CP_OTP_Proceed.click();
        } catch (ElementClickInterceptedException e) {
            js.executeScript(
                    "arguments[0].click();",
                    CP_OTP_Proceed);
        }

        LOGGER.info("OTP Verified Successfully");
    }
    
    // ==========================================================
    // Complete Your Profile - Verify KYC
    // ==========================================================
  
    @FindBy(xpath = "//h2[normalize-space()='Verify Your Identity']")
    private WebElement CP_Verify_KYC_Title;
    
    @FindBy(id = "Verify KYC")
    private WebElement CP_Verify_KYC_button;
    
    public void CP_Verify_KYC_Title() throws IOException {

        wait.until(ExpectedConditions.visibilityOf(CP_Verify_KYC_Title));

        if (CP_Verify_KYC_Title.isDisplayed()) {
            LOGGER.info("Verify KYC page displaying successfully");
        }
    }
    
    public void CP_Verify_KYC_button() {

        wait.until(ExpectedConditions.visibilityOf(
        		CP_Verify_KYC_button));

        wait.until(ExpectedConditions.elementToBeClickable(
        		CP_Verify_KYC_button));

        try {
        	CP_Verify_KYC_button.click();
        } catch (ElementClickInterceptedException e) {
            js.executeScript(
                    "arguments[0].click();",
                    CP_Verify_KYC_button);
        }

        LOGGER.info("KYC Verified Successfully");
    }
}

