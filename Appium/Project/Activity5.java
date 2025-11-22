package project;


import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity5 {
	AndroidDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();

		// Server URL
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Driver initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Open Selenium page
		driver.get("https://training-support.net/webelements");
	}

	@Test(priority = 1)
	public void successTest() {
		// Wait for page to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"WebElements\"]")));
		
		String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
		driver.findElement(AppiumBy.androidUIAutomator(UiScrollable+".scrollForward(2).scrollTextIntoView(\"Login Form\")"));//scrollForward(4) controls the speed of the scroll
		driver.findElement(AppiumBy.accessibilityId("Login Form Please sign in!")).click();

		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Form\"]")));
	
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Success!\"]")));
		
		
		// Assertions
		assertEquals(driver.findElement((AppiumBy.xpath("//android.widget.TextView[@text=\"Login Success!\"]"))).getText(), "Login Success!");
	}

	@Test(priority = 2)
	public void failureTest() {
		driver.get("https://training-support.net/webelements");
		// Wait for page to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"WebElements\"]")));
		
		String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
		driver.findElement(AppiumBy.androidUIAutomator(UiScrollable+".scrollForward(2).scrollTextIntoView(\"Login Form\")"));//scrollForward(4) controls the speed of the scroll
		driver.findElement(AppiumBy.accessibilityId("Login Form Please sign in!")).click();

		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Form\"]")));
	
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admins");
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Submit\"]")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"subheading\"]")));
		
		
		// Assertions
		assertEquals(driver.findElement((AppiumBy.xpath("//android.widget.TextView[@resource-id=\"subheading\"]"))).getText(), "Invalid credentials");
	}

	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}
