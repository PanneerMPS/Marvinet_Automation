package Hooks;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.AfterStep;
//import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageobjects.Signup_page;
import resources.Base;
import utils.NetworkInterceptor;

public class Testhooks extends Base {

    @Getter
    public WebDriver driver;

    public WebDriverWait wait;
    public Signup_page signuppage;

    private static final Logger LOGGER = LogManager.getLogger(Testhooks.class);

    public void initializeWait() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Before
    public void setup(Scenario scenario) throws Exception {

        LOGGER.info("Execution Started");

        driver = initializeDriver();

        LOGGER.info("Browser launched successfully");

//        if (driver instanceof ChromeDriver) {
//            devTools = ((ChromeDriver) driver).getDevTools();
//            devTools.createSession();
//            
//            networkInterceptor = new NetworkInterceptor(devTools);
//            networkInterceptor.startIntercepting();
//        } else {
//            throw new IllegalStateException("WebDriver is not an instance of ChromeDriver");
//        }

        signuppage = new Signup_page(driver);

        driver.get(prop.getProperty("Marvinet_Userflow_URL"));

        initializeWait();

        LOGGER.info("Navigated to URL");

        Robot robot = new Robot();

        for (int i = 0; i < 3; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        LOGGER.info("Page is zoomed out");

        System.out.println(
                "** Execution started for scenario -" + scenario.getName());

        Thread.sleep(1000);
	
//		String bearerToken = networkInterceptor.getBearerToken();
//        if (bearerToken != null) {
//            LOGGER.info("Captured Bearer Token: " + bearerToken);
//        } else {
//            LOGGER.warn("Bearer Token not found!");
//        }
    }
//	@After
//	public void tearDown(Scenario scenario) throws Exception {
//
//		if (driver != null) {
//			driver.quit();
//			LOGGER.info("Browser got closed");
//			System.out.println("-- Browser got closed --");
//			System.out.println(
//					"** Execution ended for scenario -" + scenario.getName());
//		}
//	}

//    @AfterStep
//    public void addScreenshot(Scenario scenario) {
//
//        final byte[] screenshot =
//                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//
//        scenario.attach(screenshot, "image/png", scenario.getName());
//
//        if (scenario.isFailed()) {
//            LOGGER.info("Failed scenario screenshot captured");
//        } else {
//            LOGGER.info("Passed scenario screenshot captured");
//        }
//    }

    public WebDriver getDriver() {
        return driver;
    }
}
