package pageobjects;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import resources.Base;

public class Resetpasswordpage extends Base {
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;

	public Resetpasswordpage(WebDriver driver) {
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

	@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"card\"]/android.widget.EditText[1]")
	private WebElement Reset_newpassword, Enter_newpassword, Reset_newpasswordclick;

	public void Reset_newpassword() {
		wait.until(ExpectedConditions.visibilityOf(Reset_newpassword)).isDisplayed();
		AssertJUnit.assertTrue(Reset_newpassword.isDisplayed());
	}
	
	public void Reset_newpassword_click() {
		wait.until(ExpectedConditions.visibilityOf(Reset_newpasswordclick)).click();
		wait.until(ExpectedConditions.visibilityOf(Reset_confirmpassword)).click();
	}

	public void ValidEnter_newpassword() {
		wait.until(ExpectedConditions.visibilityOf(Enter_newpassword)).click();
		wait.until(ExpectedConditions.visibilityOf(Enter_newpassword)).sendKeys(prop.getProperty("Newpassword"));
	}

	@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"card\"]/android.widget.EditText[2]")
	private WebElement Reset_confirmpassword;

	public void ValidReset_confirmpassword() {
		wait.until(ExpectedConditions.visibilityOf(Reset_confirmpassword)).click();
		wait.until(ExpectedConditions.visibilityOf(Reset_confirmpassword))
				.sendKeys(prop.getProperty("Confirmpassword"));
	}

	public void INVValidReset_confirmpassword_notmatch() {
		wait.until(ExpectedConditions.visibilityOf(Reset_confirmpassword)).click();
		wait.until(ExpectedConditions.visibilityOf(Reset_confirmpassword))
				.sendKeys(prop.getProperty("INV_confirmpassword"));
	}

	public void INVValidReset_confirmpassword() {
		wait.until(ExpectedConditions.visibilityOf(Reset_confirmpassword)).click();
		wait.until(ExpectedConditions.visibilityOf(Reset_confirmpassword))
				.sendKeys(prop.getProperty("INV_confirmpassword"));
	}

	@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"card\"]/android.view.ViewGroup[3]")
	private WebElement Reset_reset_btn;

	public void Reset_reset_btn() {
		driver.navigate().back();
		wait.until(ExpectedConditions.elementToBeClickable(Reset_reset_btn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Reset_reset_btn)).click();
	}

	@FindBy(xpath = "//android.widget.TextView[contains(@text, 'Password updated')]")
	private WebElement Resetpassword_success;

	public String Resetpassword_success() {
		try {
			WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOf(Resetpassword_success));
			String message = successMessageElement.getText().trim();
			System.out.println("Error message displayed: " + message);
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	@FindBy(xpath = "//android.widget.TextView[@text=\"Enter your new password,kindly note it down :)\"]")
	private WebElement Reset_sample_text;

	public void Reset_click_sample_text() {
		driver.navigate().back();
		wait.until(ExpectedConditions.elementToBeClickable(Reset_sample_text)).click();
	}

	@FindBy(xpath = "//android.widget.TextView[@text=\"I remember my password\"]")
	private WebElement Reset_remember;
	
	public void Reset_remember() {
		wait.until(ExpectedConditions.visibilityOf(Reset_remember)).click();
	}

	@FindBy(xpath = "//android.widget.TextView[@text=\"Password is required\"]")
	private WebElement Reset_required_error;

	public void password_required() {
		wait.until(ExpectedConditions.visibilityOf(Reset_required_error)).isDisplayed();
		AssertJUnit.assertTrue(Reset_required_error.isDisplayed());
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Passwords does not match\"]")
	private WebElement Reset_passwordnot_match;

	public void Reset_passwordnot_match() {
		wait.until(ExpectedConditions.visibilityOf(Reset_passwordnot_match)).isDisplayed();
		String gettext = Reset_passwordnot_match.getText();
		System.out.println("error:" + gettext);
		AssertJUnit.assertTrue(Reset_passwordnot_match.isDisplayed());
	}

	@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"card\"]/android.view.ViewGroup[1]/android.widget.ImageView")
	private WebElement Reset_new_eyeicon;

	@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"card\"]/android.view.ViewGroup[2]/android.widget.ImageView")
	private WebElement Reset_confirm_eyeicon;

}
