package activities;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {

	//Declaring the Required Objects
	AppiumDriver driver;//Parent for AndroidDriver and IOSDriver
	WebDriverWait wait;
	
	@BeforeClass //Setup Function
	public void setUp() throws MalformedURLException, URISyntaxException, InterruptedException{
		File apkFile = new File("src/test/resources/Calculator.apk");    //path to software to be tested .apk for android & .ipa for (ios)
		
		//Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("andrioid");
		options.setAutomationName("UiAutomator2");
		options.setApp(apkFile.getAbsolutePath());
		options.setAppPackage("com.google.android.contacts");
		options.setAppActivity("com.android.contacts.activities.PeopleActivity");
		options.noReset();  //prevents factory reset
		
		//Appium Server URL
		URL serverURL= new URI("http://localhost:4723").toURL();
		
		//initialize the driver object
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	public void addContact() {
		//Find and tap the create contact button
		driver.findElement(AppiumBy.id("com.google.android.contacts:id/floating_action_button")).click();
		//Find the First name field and send first name
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@text='First name']")));
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Mohan");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']")).sendKeys("kumar");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"+1\"]")).sendKeys("900112233");
		
		//find and click the save button
		driver.findElement(AppiumBy.xpath(
		"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/"
		+ "android.view.View[2]/android.view.View/android.view.View[3]/android.widget.Button")).click();
		
		// Wait for contact to save
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("large_title")));
    
        // Assertion
        String contactName = driver.findElement(AppiumBy.id("large_title")).getText();
        Assert.assertEquals(contactName, "Mohan kumar");
	}
	
	
	@AfterClass
	public void tearDown() {
		//close the app
		driver.quit();
	}
}
