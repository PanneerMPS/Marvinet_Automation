package pageobjects;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import resources.Base;

public class Forgotpasswordpage extends Base {
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;

	public Forgotpasswordpage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.prop = new Properties();
		initializeWait();
		String propPath = System.getProperty("user.dir") + "/src/main/java/resources/dataproperties";
		try {
			FileInputStream fis = new FileInputStream(propPath);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

		PageFactory.initElements(driver, this);
	}

	private void initializeWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(xpath = "//android.widget.TextView[@text=\" I forgot my password\"]")
	private WebElement forgotLink;

	public void clickForgotPasswordLink() {
		wait.until(ExpectedConditions.visibilityOf(forgotLink)).click();
		System.out.println(">> User clicks on forgot password link");
	}

	@FindBy(xpath = "//android.widget.EditText")
	private WebElement emailField, invalidEmailField, enterInvalidEmail, emailfield_display;

	public void enterValidEmail() {
		wait.until(ExpectedConditions.visibilityOf(emailField)).click();
		emailField.sendKeys(prop.getProperty("Forgot_email_address"));
		System.out.println(">> User enters valid email address");
	}
	
	public void emailfield_display() {
		wait.until(ExpectedConditions.visibilityOf(emailfield_display)).isDisplayed();
		AssertJUnit.assertTrue(emailfield_display.isDisplayed());
	}
	
	public void non_technician_emailid() {
		wait.until(ExpectedConditions.visibilityOf(emailField)).click();
		emailField.sendKeys(prop.getProperty("INV_email_address2"));
		System.out.println(">> User enters the non technician email address");
	}
	
	public void emailField() {
		wait.until(ExpectedConditions.visibilityOf(emailField)).click();
	}
	public void enterInvalidEmail() {
		wait.until(ExpectedConditions.visibilityOf(invalidEmailField)).click();
		invalidEmailField.sendKeys(prop.getProperty("INV_email_address1"));
		System.out.println(">> User enters invalid email address");
	}

	public void deleteInvalidEmail() {
		wait.until(ExpectedConditions.visibilityOf(invalidEmailField)).click();
		invalidEmailField.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		System.out.println(">> User enters invalid email address and deletes it");
	}

	@FindBy(xpath = "//a[normalize-space()='English']")
	private WebElement englishLink;

	public void clickEnglishLink() {
		wait.until(ExpectedConditions.visibilityOf(englishLink)).click();
	}

	@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"card\"]/android.view.ViewGroup")
	private WebElement sendResetLink;

	public void clickSendResetLink() {
		wait.until(ExpectedConditions.elementToBeClickable(sendResetLink)).click();
		wait.until(ExpectedConditions.elementToBeClickable(sendResetLink)).click();
		System.out.println(">> User clicks on send reset link button");
	}
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text, 'Only have ')]")
	private WebElement Technician_access_error;

	public String Technician_access_error() {
		try {
			WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOf(Technician_access_error));
			String message = successMessageElement.getText().trim();
			System.out.println("Error message displayed: " + message);
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	@FindBy(xpath = "//android.widget.EditText")
	private WebElement Enter_OTP;
	
	public void Click_OTP_field() throws Exception {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(Enter_OTP)).click();
		wait.until(ExpectedConditions.visibilityOf(Click_OTPverify_text)).click();
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"OTP is required\"]")
	private WebElement OTP_required_error;
	
	public void OTP_required_error() {
		wait.until(ExpectedConditions.visibilityOf(OTP_required_error)).isDisplayed();
		String gettext = OTP_required_error.getText();
		System.out.println("Error:" + gettext);
		AssertJUnit.assertTrue(OTP_required_error.isDisplayed());
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"I want to change email address or phone number\"]")
	private WebElement Change_Mobileno_email_OTPpage;
	
	public void Change_Mobileno_email_OTPpage() {
		wait.until(ExpectedConditions.visibilityOf(Change_Mobileno_email_OTPpage)).click();
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Resend OTP\"]")
	private WebElement Resend_OTP;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"OTP Verification\"]")
	private WebElement Click_OTPverify_text;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"I remember my password\"]")
	private WebElement I_remember_password;
	
	@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"card\"]/android.view.ViewGroup")
	private WebElement Click_verifyOTP;
	
	public void Enter_OTP() throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(Enter_OTP)).click();
		Thread.sleep(20000);
		wait.until(ExpectedConditions.elementToBeClickable(Click_verifyOTP)).click();
		Click_verifyOTP.click();
		System.out.println(">> User clicks on verify OTP button");
	}
	
	public void Enter_INVOTP() throws Exception {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(Enter_OTP)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Enter_OTP)).sendKeys(prop.getProperty("INV_OTP"));
		wait.until(ExpectedConditions.elementToBeClickable(Click_verifyOTP)).click();
		Click_verifyOTP.click();
		System.out.println(">> User clicks on verify OTP button");
	}
	
	public void Enter_resendOTP() throws Exception {
		wait.until(ExpectedConditions.visibilityOf(Resend_OTP)).click();
		Thread.sleep(30000);
		wait.until(ExpectedConditions.elementToBeClickable(Click_verifyOTP)).click();
		Click_verifyOTP.click();
		System.out.println(">> User clicks on verify OTP button");
	}
	
	public void I_remember_password() throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(I_remember_password)).click();
		System.out.println(">> User clicks on remmember password link");
	}
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text, 'Verified')]")
	private WebElement OTP_verified;

	public String OTP_verified_success_popup() {
		try {
			WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOf(OTP_verified));
			String message = successMessageElement.getText().trim();
			System.out.println("Error message displayed: " + message);
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"E-mail address or phone number is required\"]")
	private WebElement requiredError;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Invalid OTP\"]")
	private WebElement InvalidOTP_error;
	
	public String InvalidOTP_error() {
		try {
			WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOf(InvalidOTP_error));
			String message = successMessageElement.getText().trim();
			System.out.println("Error message displayed: " + message);
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public void isRequiredErrorDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(requiredError)).isDisplayed();
		String gettext = requiredError.getText();
		System.out.println("Invalid email error:" + gettext);
		AssertJUnit.assertTrue(requiredError.isDisplayed());
	}

	@FindBy(xpath = "//android.widget.TextView[@text=\"Invalid E-mail address or phone number\"]")
	private WebElement invalidEmailError;

	public void isInvalidEmailErrorDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(invalidEmailError)).isDisplayed();
		String gettext = invalidEmailError.getText();
		System.out.println("Invalid email error:" + gettext);
		AssertJUnit.assertTrue(invalidEmailError.isDisplayed());
	}

	@FindBy(xpath = "//android.widget.TextView[@text='Reset Password OTP sent to tamilselvan@coducer.com mail']")
	private WebElement forgot_Success_display, login_Success_display1;

	public String checkvalid_error_display() {
		try {
			WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOf(forgot_Success_display));
			String message = successMessageElement.getText().trim();
			System.out.println("Error message displayed: " + message);
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	@FindBy(xpath = "//android.widget.TextView[@text=\"Don't remember your password? Worry not!\"]")
	private WebElement Clickforgot_text;

	public void Clickforgot_text() {
		wait.until(ExpectedConditions.visibilityOf(Clickforgot_text)).click();
	}

	@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"card\"]/android.widget.EditText[1]")
	private WebElement Reset_newpassword;
	
	public void Reset_newpassword() {
		wait.until(ExpectedConditions.visibilityOf(Reset_newpassword)).isDisplayed();
		AssertJUnit.assertTrue(Reset_newpassword.isDisplayed());
	}
	
}
