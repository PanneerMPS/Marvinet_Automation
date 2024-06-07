package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Base {
	public static Properties prop;
	public static AndroidDriver driver;

	public static AndroidDriver initializeDriver() throws IOException, Exception {
		
		prop = new Properties();

		String propPath = System.getProperty("user.dir") + "/src/main/java/resources/dataproperties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);

		   DesiredCapabilities capabilities = new DesiredCapabilities();
		   /////Physical Android Mobile/////
//	        capabilities.setCapability("platformName", "Android");
//	        capabilities.setCapability("automationName", "UiAutomator2");
//	        capabilities.setCapability("deviceName", "Galaxy A14 5G");
//	        capabilities.setCapability("platformVersion", "14");
//	        capabilities.setCapability("appPackage", "com.alarabia");
//	        capabilities.setCapability("appActivity", "com.alarabia.MainActivity");
	        
	        /////Emulator Android Mobile/////
	        capabilities.setCapability("platformName", "Android");
	        capabilities.setCapability("automationName", "UiAutomator2");
	        capabilities.setCapability("deviceName", "Pixel_emulator");
	        capabilities.setCapability("appPackage", "com.alarabia");
	        capabilities.setCapability("appActivity", "com.alarabia.MainActivity");

	        URL url = URI.create("http://127.0.0.1:4723/").toURL();

	            AndroidDriver driver = new AndroidDriver(url, capabilities);
	            System.out.println("Driver initialized successfully");
				return driver;
	}
}