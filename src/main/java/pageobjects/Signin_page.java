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

import utils.TestData;

public class Signin_page {

    private final Logger LOGGER = LogManager.getLogger(Signin_page.class);

    private WebDriver driver;
    private WebDriverWait wait;
    private Properties prop;

    public Signin_page(WebDriver driver) throws Exception {

        this.driver = driver;

        prop = new Properties();

        String propPath =
                System.getProperty("user.dir")
                        + "/src/main/java/resources/dataproperties";

        FileInputStream fis = new FileInputStream(propPath);

        prop.load(fis);

        PageFactory.initElements(driver, this);

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @FindBy(id = "email-input")
    private WebElement login_email;

    @FindBy(id = "password-input")
    private WebElement login_password;

    @FindBy(id = "Sign In")
    private WebElement login_button;

    public void enterLoginEmail() {

        wait.until(ExpectedConditions.visibilityOf(login_email));

        login_email.clear();

        login_email.sendKeys(TestData.generatedEmail);

        LOGGER.info("Login Email : " + TestData.generatedEmail);
    }

    public void enterLoginPassword() {

        wait.until(ExpectedConditions.visibilityOf(login_password));

        login_password.clear();

        login_password.sendKeys(
                prop.getProperty("signup_newpassword"));

        LOGGER.info("Password Entered");
    }

    public void clickLoginButton() {

        wait.until(ExpectedConditions.elementToBeClickable(login_button));

        login_button.click();

        LOGGER.info("Login Button Clicked");
    }
}