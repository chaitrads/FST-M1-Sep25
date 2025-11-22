package activities;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedCondition;
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

public class Activity5 {

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
		options.setAppPackage("com.google.android.apps.messaging");
		options.setAppActivity(".ui.ConversationListActivity");
	//options.noReset();  //prevents factory reset
		
		//Appium Server URL
		URL serverURL= new URI("http://localhost:4723").toURL();
		
		//initialize the driver object
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
	}

	@Test
	public void startMessaging() {
		//Find and tap the create contact button
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Start chat"))).click();
		//Find the First name field and send first name
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"ContactSearchField\"]")));
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"ContactSearchField\"]")).sendKeys("7619364269");
		driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"ContactSuggestionList\"]/android.view.View")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.messaging:id/compose_message_text\"]"))).click();
		
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.apps.messaging:id/compose_message_text\"]")).sendKeys("Hello from Appium");
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@resource-id=\"Compose:Draft:Send\"]/android.widget.Button"))).click();
		
				
		
    
        // Assertion
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[contains(@content-desc,'Hello from Appium')]"))).getText();
        System.out.println(message);
        //        Assert.assertEquals(contactName, "Mohan kumar");
	}
	
	
	@AfterClass
	public void tearDown() {
		//close the app
		driver.quit();
	}
}
