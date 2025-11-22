package project;


import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

//import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {
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
	public void listManipulation() {
		// Wait for page to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"WebElements\"]")));
		// Get the size of the screen
//		Dimension dims = driver.manage().window().getSize();
		// Set the start and end points
//		Point start = new Point((int) (dims.getWidth() * .50), (int) (dims.getHeight() * .72));
//		Point end = new Point((int) (dims.getWidth() * .67), (int) (dims.getHeight() * .72));
		// Perform swipe
		//ActionsBase.doSwipe(driver, start, end, 2000);
		
		String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
		driver.findElement(AppiumBy.androidUIAutomator(UiScrollable+".scrollForward(5).scrollTextIntoView(\"To-Do List\")"));//scrollForward(4) controls the speed of the scroll
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"To-Do List\"]")).click();
//      Another way
//		driver.findElement(AppiumBy.androidUIAutomator(UiScrollable+".flingToEnd(10)"));
//	   driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"To-Do List\"]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Todo List\"]")));
		//WebElement toDoList = driver.findElement(AppiumBy.id("todo-input"));
		WebElement toDoList = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"todo-input\"]"));
		toDoList.sendKeys("Add tasks to list");
		WebElement toAdd = driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"todo-add\"]"));
		toAdd.click();
		
		toDoList.sendKeys("Get number of tasks");
		toAdd.click();
		
		toDoList.sendKeys("Clear the list");
		toAdd.click();
		
		List<WebElement> tasks= driver.findElements(AppiumBy.className("android.widget.CheckBox"));
		
		System.out.println(tasks.size());
		
		for(int i=2; i<5; i++) {
			tasks.get(i).click();
		}
		
		
		// Assertions
		assertEquals(tasks.size(), 5);
	}


	@AfterClass
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
}
