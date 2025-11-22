package activities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {

	//Declaring the Required Objects
	AppiumDriver driver;//Parent for AndroidDriver and IOSDriver
	WebDriverWait wait;
	
	@BeforeClass //Setup Function
	public void setUp() throws MalformedURLException, URISyntaxException{
		File apkFile = new File("src/test/resources/Calculator.apk");    //path to software to be tested .apk for android & .ipa for (ios)
		
		//Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("andrioid");
		options.setAutomationName("UiAutomator2");
		options.setApp(apkFile.getAbsolutePath());
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();  //prevents factory reset
		
		//Appium Server URL
		URL serverURL= new URI("http://localhost:4723").toURL();
		
		//initialize the driver object
		driver = new AndroidDriver(serverURL, options);
		
		// Open the page in Chrome
        driver.get("https://training-support.net");
	}

	@Test
	public void chromeTest() {
		// Find heading on the page
        String pageHeading = driver.findElement(AppiumBy.xpath(
                "//android.widget.TextView[@text='Training Support']"
        )).getText();
 
        // Print to console
        System.out.println("Heading: " + pageHeading);
 
        // Find and click the About Us link
        driver.findElement(AppiumBy.accessibilityId("About Us")).click();
 
        // Find heading of new page and print to console
        String aboutPageHeading = driver.findElement(AppiumBy.xpath(
                "//android.widget.TextView[@text='About Us']"
        )).getText();
        System.out.println(aboutPageHeading);
	}
	
	
	@AfterClass
	public void tearDown() {
		//close the app
		driver.quit();
	}
}