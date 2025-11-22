package activities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {

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
//		options.setAppPackage("com.google.android.calculator");
//		options.setAppActivity("com.android.calculator2.calculator");
		options.noReset();  //prevents factory reset
		
		//Appium Server URL
		URL serverURL= new URI("http://localhost:4723").toURL();
		
		//initialize the driver object
		driver = new AndroidDriver(serverURL, options);
		
	}

	@Test
	public void multiplyTest() {
		//Find and tap the number 7
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_7")).click();
		//Find and tap the multiply button
		driver.findElement(AppiumBy.accessibilityId("multiply")).click();
		//Find and tap the Number 9
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_9")).click();
		//Find and tap the equals button
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		//Find the result and display it
		
		String result = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();
		Assert.assertEquals(result, "63");
	}
	
	
	@AfterClass
	public void tearDown() {
		//close the app
		driver.quit();
	}
}
