package pageobjects;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import resources.Base;

public class Signinpage extends Base {

	private Logger LOGGER = LogManager.getLogger(Signinpage.class);
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;

	public Signinpage(WebDriver driver) throws Exception {
		this.driver = driver;
		prop = new Properties();
		PageFactory.initElements(driver, this);

		String propPath = System.getProperty("user.dir") + "/src/main/java/resources/dataproperties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);

		initializeWait();
	}

	private void initializeWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	// Page Elements
	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	private WebElement allow;

	@FindBy(xpath = "//android.widget.EditText")
	private WebElement emailField_or_phoneNo;

	@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"card\"]/android.widget.EditText[2]")
	private WebElement passwordField;

	@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"card\"]/android.view.ViewGroup[3]")
	private WebElement signinButton;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Invalid E-mail address or phone number\"]")
	private WebElement userPasswordError;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Tickets Status\"]")
	private WebElement dashboard;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Password is too short - should be 8 characters  minimum\"]")
	private WebElement passwordTooShortError;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Must Contain One Number\"]")
	private WebElement passwordNoNumberError;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Invalid E-mail address or phone number\"]")
	private WebElement invalidemailError;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Must Contain One Special Case Character\"]")
	private WebElement passwordNoSpecialCharError;

	@FindBy(xpath = "//android.widget.TextView[@text=\"Must Contain One Uppercase, One Lowercase\"]")
	private WebElement passwordNoUppercaseError;

	@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"card\"]/android.view.ViewGroup[1]/android.widget.ImageView")
	private WebElement passwordFieldEyeIcon;

	@FindBy(xpath = "//android.widget.TextView[@text=\"E-mail address or phone number is required\"]")
	private WebElement emailPhoneNoRequiredError;

	// Page Methods
	public void enterValidEmail() {
//    	 wait.until(ExpectedConditions.elementToBeClickable(allow)).click();
		wait.until(ExpectedConditions.visibilityOf(emailField_or_phoneNo)).sendKeys(prop.getProperty("email_address"));
		LOGGER.info("User enters valid email address");
	}

	public void emailField() {
		wait.until(ExpectedConditions.visibilityOf(emailField_or_phoneNo))
				.sendKeys(prop.getProperty("Supervisor_email_address"));
		LOGGER.info("Supervisor enters valid email address");
	}

	public void enterInvalidEmail() {
		wait.until(ExpectedConditions.visibilityOf(emailField_or_phoneNo))
				.sendKeys(prop.getProperty("INV_email_address"));
	}

	public void enterInvalidEmail1() {
		wait.until(ExpectedConditions.visibilityOf(emailField_or_phoneNo))
				.sendKeys(prop.getProperty("INV_email_address1"));
	}
	
	public void enterInvalidEmail2() {
		wait.until(ExpectedConditions.visibilityOf(emailField_or_phoneNo))
				.sendKeys(prop.getProperty("INV_email_address2"));
	}

	public void clickEmailField() {
		wait.until(ExpectedConditions.visibilityOf(emailField_or_phoneNo)).click();
	}

	public void enterValidPassword() {
		wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(prop.getProperty("password"));
		LOGGER.info("User enters valid password");
	}

	public void clickPasswordField() {
		wait.until(ExpectedConditions.visibilityOf(passwordField)).click();
	}

	public void enterInvalidPassword() {
		wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(prop.getProperty("INV_password"));
	}

	public void enterInvalidPasswordWithoutUpperCharacter() {
		wait.until(ExpectedConditions.visibilityOf(passwordField))
				.sendKeys(prop.getProperty("INVpassword_withoutupper_character"));
	}

	public void enterInvalidPasswordShortCharacter() {
		wait.until(ExpectedConditions.visibilityOf(passwordField))
				.sendKeys(prop.getProperty("INVpassword_short_character"));
	}

	public void enterInvalidPasswordWithoutSpecialCharacter() {
		wait.until(ExpectedConditions.visibilityOf(passwordField))
				.sendKeys(prop.getProperty("INVpassword_withoutspl_character"));
	}

	public void enterPasswordWithoutNumber() {
		wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(prop.getProperty("INV_withoutNO_password"));
	}

	public void clickSignInButton() {
		wait.until(ExpectedConditions.visibilityOf(signinButton)).click();
		LOGGER.info("User clicks on signin button");
	}

	public void checkUserPasswordErrorDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(userPasswordError));
		AssertJUnit.assertTrue(userPasswordError.isDisplayed());
		LOGGER.info("User got an invalid username and password error message");
	}

	@FindBy(xpath = "//android.widget.TextView[@text='Invalid credential']")
	private WebElement login_Success_display, login_Success_display1;

	public String checkinvalid_error_display() {
		try {
			WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOf(login_Success_display));
			String message = successMessageElement.getText().trim();
			System.out.println("Error message displayed: " + message);
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text, 'Only technician')]")
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

	public void checkDashboardDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(dashboard)).getText();
		System.out.println("Al_arabia_Dashboard:" + dashboard.getText());
		AssertJUnit.assertTrue(dashboard.isDisplayed());
		LOGGER.info("Al-Arabia user got signed in successfully");
	}

	public void checkPasswordTooShortErrorDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(passwordTooShortError)).isDisplayed();
		String gettext = passwordTooShortError.getText();
		AssertJUnit.assertTrue(passwordTooShortError.isDisplayed());
		System.out.println("Expected Message: " + gettext);
		LOGGER.info("User got a password_is_too_short_error message");
	}

	public void checkPasswordNoNumberErrorDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(passwordNoNumberError)).isDisplayed();
		String gettext = passwordNoNumberError.getText();
		AssertJUnit.assertTrue(passwordNoNumberError.isDisplayed());
		System.out.println("Expected Message: " + gettext);
		LOGGER.info("User got a must contain one number error message");
	}

	public void invalidemailError() {
		wait.until(ExpectedConditions.visibilityOf(invalidemailError)).isDisplayed();
		String gettext = invalidemailError.getText();
		AssertJUnit.assertTrue(invalidemailError.isDisplayed());
		System.out.println("Expected Message: " + gettext);
		LOGGER.info("User got a invalid email address or phone number error message");
	}

	public void checkPasswordNoSpecialCharErrorDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(passwordNoSpecialCharError)).isDisplayed();
		String gettext = passwordNoSpecialCharError.getText();
		AssertJUnit.assertTrue(passwordNoSpecialCharError.isDisplayed());
		System.out.println("Expected Message: " + gettext);
		LOGGER.info("User got a must contain one special character error message");
	}

	public void checkPasswordNoUppercaseErrorDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(passwordNoUppercaseError)).isDisplayed();
		String gettext = passwordNoUppercaseError.getText();
		AssertJUnit.assertTrue(passwordNoUppercaseError.isDisplayed());
		System.out.println("Expected Message: " + gettext);
		LOGGER.info("User got a must contain one upper case and lower case character error message");
	}

	public void clickPasswordFieldEyeIcon() {
		wait.until(ExpectedConditions.visibilityOf(passwordFieldEyeIcon)).click();
		LOGGER.info("User clicked password_field_eyeicon");
	}

	public void checkEmailPhoneNoRequiredErrorDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(emailPhoneNoRequiredError)).isDisplayed();
		String gettext = emailPhoneNoRequiredError.getText();
		AssertJUnit.assertTrue(emailPhoneNoRequiredError.isDisplayed());
		System.out.println("Expected Message: " + gettext);
		LOGGER.info("User has got the emailphoneNo_required_error");
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text=\" Sign in to your account\"]")
	private WebElement clickaccount_text;

	public void clickaccount_text() {
		wait.until(ExpectedConditions.visibilityOf(clickaccount_text)).click();
	}
}
