package pageobjects;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import resources.Base;

public class Settingspage extends Base {

	private Logger LOGGER = LogManager.getLogger(Settingspage.class);
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties prop;

	public Settingspage(WebDriver driver) throws Exception {
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

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[5]")
	private WebElement Settings_option;

	public void Click_settings() {
		wait.until(ExpectedConditions.visibilityOf(Settings_option)).click();
		LOGGER.info("User clicks the settings option");
	}

	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement Settings_permission;

	public void Click_while_usingapp_permission() {
		wait.until(ExpectedConditions.visibilityOf(Settings_permission)).click();
		LOGGER.info("User select the settings permissions");
	}

	@FindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"card\"])[1]/android.view.ViewGroup")
	private WebElement Settings_personal_profile, Settings_personal_profile_display;

	public void personal_profile_display() {
		wait.until(ExpectedConditions.visibilityOf(Settings_personal_profile_display)).isDisplayed();
		AssertJUnit.assertTrue(Settings_personal_profile_display.isDisplayed());
	}

	public void personal_profile_click() {
		wait.until(ExpectedConditions.visibilityOf(Settings_personal_profile)).click();
	}

	@FindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"card-container\"])[2]")
	private WebElement Settings_company_profile;

	public void company_profile_click() {
		wait.until(ExpectedConditions.visibilityOf(Settings_company_profile)).click();
	}

	@FindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"card\"])[3]/android.view.ViewGroup")
	private WebElement Settings_vehicleinfo_profile;

	public void Settings_vehicleinfo_profile_click() {
		wait.until(ExpectedConditions.visibilityOf(Settings_vehicleinfo_profile)).click();
	}

	@FindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"card\"])[4]/android.view.ViewGroup")
	private WebElement Settings_changepassword_profile;

	public void Settings_changepassword_profile_click() {
		wait.until(ExpectedConditions.visibilityOf(Settings_changepassword_profile)).click();
	}

	@FindBy(xpath = "//android.widget.TextView[@text=\"\"]")
	private WebElement Settings_edit_profile;

	public void Settings_edit_profile_click() {
		wait.until(ExpectedConditions.visibilityOf(Settings_edit_profile)).click();
	}

	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]")
	private WebElement Settings_profileicon;

	public void Settings_profileicon_click() {
		wait.until(ExpectedConditions.visibilityOf(Settings_profileicon)).click();
	}

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup")
	private WebElement Settings_edit_gallery;

	public void Settings_edit_gallery_click() {
		wait.until(ExpectedConditions.visibilityOf(Settings_edit_gallery)).click();
	}

	@FindBy(xpath = "//android.widget.TextView[@text=\"\"]")
	private WebElement Settings_edit_camera;

	public void Settings_edit_camera_click() {
		wait.until(ExpectedConditions.visibilityOf(Settings_edit_camera)).click();
	}

	@FindBy(xpath = "//android.widget.TextView[@text=\"\"]")
	private WebElement Settings_edit_closepopup;

	public void Settings_edit_closepopup_click() {
		wait.until(ExpectedConditions.visibilityOf(Settings_edit_closepopup)).click();
	}

	@FindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"card\"])[3]/android.view.ViewGroup")
	private WebElement Settings_notification;

	public void Settings_notification_click() {
		wait.until(ExpectedConditions.visibilityOf(Settings_notification)).click();
	}

	@FindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"card\"])[4]/android.view.ViewGroup")
	private WebElement Settings_timesheet;

	public void Settings_timesheet_click() {
		wait.until(ExpectedConditions.visibilityOf(Settings_timesheet)).click();
	}

	@FindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"card\"])[5]/android.view.ViewGroup")
	private WebElement Settings_helpcenter;

	public void Settings_helpcenter_click() {
		wait.until(ExpectedConditions.visibilityOf(Settings_helpcenter)).click();
	}

	@FindBy(xpath = "//android.widget.TextView[@text=\"العربية\"]")
	private WebElement Settings_arab_language_switch;

	public void Settings_arab_language_switch_click() {
		wait.until(ExpectedConditions.visibilityOf(Settings_arab_language_switch)).click();
	}

	@FindBy(xpath = "//android.widget.TextView[@text=\"English\"]")
	private WebElement Settings_eng_language_switch;

	public void Settings_eng_language_switch_click() {
		wait.until(ExpectedConditions.visibilityOf(Settings_eng_language_switch)).click();
	}

	@FindBy(xpath = "//android.widget.TextView[@text=\" Logout\"]")
	private WebElement Settings_logout;

	public void Settings_logout_click() {
		wait.until(ExpectedConditions.visibilityOf(Settings_logout)).click();
	}

	@FindBy(xpath = "//android.widget.EditText[@text=\"Tamil\"]")
	private WebElement Settings_personalinfo_name, Settings_personalinfo_namedisplay;

	public void Settings_personalinfo_name() {
		wait.until(ExpectedConditions.visibilityOf(Settings_personalinfo_name)).sendKeys(Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(Settings_personalinfo_name_emt)).sendKeys(prop.getProperty("name"));
	}
	
	public void Settings_personalinfo_namedisplay() {
		wait.until(ExpectedConditions.visibilityOf(Settings_personalinfo_namedisplay)).isDisplayed();
		AssertJUnit.assertTrue(Settings_personalinfo_namedisplay.isDisplayed());
	}

	@FindBy(xpath = "//android.widget.EditText[@text=\"+917708183591\"]")
	private WebElement Settings_personalinfo_contact_number;

	public void Settings_personalinfo_contact_number() {
		wait.until(ExpectedConditions.visibilityOf(Settings_personalinfo_contact_number))
		.sendKeys(Keys.CLEAR);
		wait.until(ExpectedConditions.visibilityOf(Settings_personalinfo_contact_emt))
		.sendKeys(prop.getProperty("Contact_number"));
	}
	
	private static String generateUniqueIQMANumber(String baseIQMANumber) {
		Random rand = new Random();
		return baseIQMANumber + rand.nextInt(10000); 
	}
	@FindBy(xpath = "//android.widget.EditText[@text=\"Enter IQAMA ID\"]")
	private WebElement Settings_personalinfo_IQAMA;

	public void Settings_personalinfo_IQAMA() {
		wait.until(ExpectedConditions.visibilityOf(Settings_personalinfo_IQAMA))
		.sendKeys(Keys.CLEAR);
		String uniqueIQMANumber = generateUniqueIQMANumber(prop.getProperty("IQAMA_number"));
		wait.until(ExpectedConditions.visibilityOf(Settings_personalinfo_IQAMA))
				.sendKeys(uniqueIQMANumber);
	}

	@FindBy(xpath = "//android.widget.EditText[@text=\"Enter alternate number (Optional)\"]")
	private WebElement Settings_personalinfo_altnumber;

	public void Settings_personalinfo_altnumber() {
		wait.until(ExpectedConditions.visibilityOf(Settings_personalinfo_altnumber))
				.sendKeys(prop.getProperty("Contact_number"));
	}

	@FindBy(xpath = "//android.widget.EditText[@text=\"+918808008801\"]")
	private WebElement Settings_personalinfo_wappnumber;

	public void Settings_personalinfo_wappnumber() {
		wait.until(ExpectedConditions.visibilityOf(Settings_personalinfo_wappnumber))
		.sendKeys(Keys.CLEAR);
		wait.until(ExpectedConditions.visibilityOf(Settings_personalinfo_wappnumber))
				.sendKeys(prop.getProperty("Whatsapp_number"));
	}

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup")
	private WebElement Settings_personalinfo_save;

	public void Settings_personalinfo_save() {
		wait.until(ExpectedConditions.elementToBeClickable(Settings_personalinfo_save)).click();
	}

	@FindBy(xpath = "//android.widget.EditText[@text=\"Enter whatsapp number\"]")
	private WebElement Settings_personalinfo_wtp_empty;

	public void Settings_personalinfo_wtp_empty() {
		wait.until(ExpectedConditions.visibilityOf(Settings_personalinfo_wtp_empty))
				.sendKeys(prop.getProperty("Whatsapp_number"));
	}

	@FindBy(xpath = "//android.widget.EditText[@text=\"Chennai, Tamil Nadu, India\"]")
	private WebElement Settings_personalinfo_location;

	public void Settings_personalinfo_location() {
		wait.until(ExpectedConditions.visibilityOf(Settings_personalinfo_location))
		.sendKeys(Keys.CLEAR);
		wait.until(ExpectedConditions.visibilityOf(Settings_personalinfo_location))
				.sendKeys(prop.getProperty("Location"+Keys.ARROW_DOWN +Keys.ENTER));
	}

	@FindBy(xpath = "//android.widget.EditText[@text=\"Enter biography\"]")
	private WebElement Settings_personalinfo_bio;

	public void Settings_personalinfo_bio() {
		wait.until(ExpectedConditions.visibilityOf(Settings_personalinfo_bio))
		.sendKeys(Keys.CLEAR);
		wait.until(ExpectedConditions.visibilityOf(Settings_personalinfo_bio)).sendKeys(prop.getProperty("Biography"));
	}

	@FindBy(xpath = "//android.widget.EditText")
	private WebElement Settings_personalinfo_name_emt;

	public void Settings_personalinfo_name_emt() {
		wait.until(ExpectedConditions.visibilityOf(Settings_personalinfo_name_emt)).sendKeys(prop.getProperty("name"));
	}

	@FindBy(xpath = "//android.widget.EditText[@text=\"\"]")
	private WebElement Settings_personalinfo_contact_emt;

	public void Settings_personalinfo_contact_emt() {
		wait.until(ExpectedConditions.visibilityOf(Settings_personalinfo_contact_emt))
				.sendKeys(prop.getProperty("Contact_number"));
	}
	
	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")
	private WebElement Settings_personalinfo_confirm_yes;

	public void Settings_personalinfo_confirm_yes() {
		wait.until(ExpectedConditions.visibilityOf(Settings_personalinfo_confirm_yes)).click();
	}
	
	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]")
	private WebElement Settings_personalinfo_confirm_no;

	public void Settings_personalinfo_confirm_no() {
		wait.until(ExpectedConditions.visibilityOf(Settings_personalinfo_confirm_no)).click();
	}

	@FindBy(xpath = "//android.widget.TextView[@text='Personal']")
	private WebElement personalprofile_Success_display;

	public String checkvalid_error_display() {
		try {
			WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOf(personalprofile_Success_display));
			String message = successMessageElement.getText().trim();
			System.out.println("Error message displayed: " + message);
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}

