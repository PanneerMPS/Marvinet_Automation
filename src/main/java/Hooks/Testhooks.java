package Hooks;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageobjects.Signinpage;
import resources.Base;

public class Testhooks extends Base {
	public WebDriver driver;
	public WebDriverWait wait;
	public Signinpage signinpage;

	private static Logger LOGGER = LogManager.getLogger(Testhooks.class);

	public void initializeWait() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@Before
	public void setup(Scenario scenario) throws Exception {
		LOGGER = LogManager.getLogger(Testhooks.class.getName());
		LOGGER.info("Execution Started");
		driver = initializeDriver();
		LOGGER.info("Application got launched");
		signinpage = new Signinpage(driver);
		initializeWait();
		LOGGER.info("Navigated to application");
		System.out.println("Login page opened");

		System.out.println("** Execution started for scenario -" + scenario.getName());
		Thread.sleep(1000);
	}

	@After
	public void tearDown(Scenario scenario) throws Exception {
		if (driver != null) {
			driver.quit();
			LOGGER.info("Application got closed");
			System.out.println("-- Application got closed --");
			System.out.println("** Execution ended for scenario -" + scenario.getName());
		}
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		if (scenario.isFailed()) {
			scenario.attach(screenshot, "image/png", scenario.getName());
			LOGGER.info("Failed scenario screenshot got captured" + scenario.getName());
		} else {
//            scenario.attach(screenshot, "image/png", "Passed scenario: " + scenario.getName());
//            LOGGER.info("Passed scenario screenshot captured: " + scenario.getName());
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

}
