package pageobjects;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.Base;

public class Gmail_page extends Base {
    private final Logger LOGGER = LogManager.getLogger(Gmail_page.class);
    private final WebDriver driver;
    private WebDriverWait wait;

    public Gmail_page(WebDriver driver) throws Exception {
        this.driver = driver;
        Properties prop = new Properties();
        PageFactory.initElements(driver, this);
        String propPath = System.getProperty("user.dir") + "/src/main/java/resources/dataproperties";
        FileInputStream fis = new FileInputStream(propPath);
        prop.load(fis);
        initializeWait();
    }
    private void initializeWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    // Page Elements
//    @FindBy(id = "identifierId")
//     WebElement gmail_signin_btn;
    @FindBy(id = "identifierId")
     WebElement gmail_selvam_mailid;
    
    @FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button/div[3]")
    WebElement gmail_click_next;
    
    @FindBy(name = "Passwd")
     WebElement gmail_password;
    
    @FindBy(id = ":1n")
     WebElement gmail_firstmail;
    
    @FindBy(partialLinkText = "Address")
     WebElement gmail_confirm_account;
    
    @FindBy(id = "email")
     WebElement slug_email;
    
    @FindBy(xpath = "//tr[contains(@class,'zE')]//span[text()='Marvinet']")
    private WebElement firstUnreadMail;
    
    // Page Methods
    
    public void gmailsignin_process() throws Exception {
    	
//    	wait.until(ExpectedConditions.visibilityOf(gmail_signin_btn)).click();
    	wait.until(ExpectedConditions.visibilityOf(gmail_selvam_mailid)).click();
    	gmail_selvam_mailid.sendKeys("panneerselvam@coducer.com"+Keys.ENTER);    	
    	wait.until(ExpectedConditions.visibilityOf(gmail_password)).click();
    	gmail_password.sendKeys("Selvampanneer@123"+Keys.ENTER);
     	Thread.sleep(4000);
     	
     	List<WebElement> unreadMails =
     	        driver.findElements(By.cssSelector("tr.zA.zE"));

     	if (!unreadMails.isEmpty()) {
     	    unreadMails.get(0).click();
     	}
     	
    	Robot robot = new Robot();

       for (int i = 0; i < 3; i++) {
           robot.keyPress(KeyEvent.VK_CONTROL);
           robot.keyPress(KeyEvent.VK_SUBTRACT);
           robot.keyRelease(KeyEvent.VK_SUBTRACT);
           robot.keyRelease(KeyEvent.VK_CONTROL);
       }

       LOGGER.info("Page is zoomed out");
     	
     	Actions actions = new Actions(driver);

     	for (int i = 0; i < 5; i++) {
     	    actions.sendKeys(Keys.PAGE_DOWN).perform();
     	    Thread.sleep(500);
     	}
     	
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.visibilityOf(gmail_confirm_account)).click();
    	String currentTab = driver.getWindowHandle();

    	Set<String> allTabs = driver.getWindowHandles();

    	for (String tab : allTabs) {
    	    if (!tab.equals(currentTab)) {
    	        driver.switchTo().window(tab);
    	        break;
    	    }
    	}
    	System.out.println("Account activated successfully");
    	 LOGGER.info("Accept invitation successfully");
    } 
}