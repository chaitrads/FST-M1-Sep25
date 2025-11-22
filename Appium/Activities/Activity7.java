package activities;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity7 {
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
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));

		// Open Selenium page
		driver.get("https://training-support.net/webelements/lazy-loading");
	}

	@Test(priority = 1)
	public void uiScrollTest() {
		// Wait for page to load
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.className("android.widget.Image")));
		// UiScrollable object string
		String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
		
		// Find all the image elements on the page
		List<WebElement> imageElements = driver.findElements(AppiumBy.className("android.widget.Image"));
		// Print the number of images
		System.out.println("Before scroll image count is : " + imageElements.size());

		// Scroll to required element
		String imageText = driver.findElement(AppiumBy.androidUIAutomator(UiScrollable
				+ ".scrollForward(25).getChildByText(className(\"android.widget.Image\"), \"Helen\")")).getText();
		
		System.out.println("The image is  " + imageText + "Located");
		// Get image elements after scroll
		imageElements = driver.findElements(AppiumBy.className("android.widget.Image"));
		// Print the number of images after scroll
		System.out.println("After scroll image count is : " + imageElements.size());
		 
		// Assertions
		assertEquals(imageElements.size(), 2);
	}


	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}
