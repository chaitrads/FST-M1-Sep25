package project;

import static org.testng.Assert.assertEquals;

import java.io.File;
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

import activities.ActionsBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3 {

	//Declaring the Required Objects
	AppiumDriver driver;//Parent for AndroidDriver and IOSDriver
	WebDriverWait wait;
	
	@BeforeClass //Setup Function
	public void setUp() throws MalformedURLException, URISyntaxException{
		File apkFile = new File("src/test/resources/ts-todo-list-v1.apk");   
		
		//Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("andrioid");
		options.setAutomationName("UiAutomator2");
		options.setApp(apkFile.getAbsolutePath());
		options.setAppPackage("com.app.todolist");
		options.setAppActivity(".view.SplashActivity ");
		options.noReset();  //prevents factory reset
		
		//Appium Server URL
		URL serverURL= new URI("http://localhost:4723").toURL();
		//initialize the driver object
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		
	}

	@Test
	public void addTasks() {
		
		// Get the size of the screen
		Dimension dims = driver.manage().window().getSize();
		
		//Mark the first 2 task as complete
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//android.widget.CheckBox[@resource-id=\"com.app.todolist:id/cb_task_done\"])[1]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//android.widget.CheckBox[@resource-id=\"com.app.todolist:id/cb_task_done\"])[2]"))).click();
		
		//Find the third task and edit it 
		// Set the start and end points
		Point start = new Point((int) (dims.getWidth() * .25), (int) (dims.getHeight() * .27));
				
		ActionsBase.longPress(driver, start);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Edit To-Do Task\"]"))).click();
		
		// Set the start and end points
		Point startSlide = new Point((int) (dims.getWidth() * .285), (int) (dims.getHeight() * .54));
		Point endSlide = new Point((int) (dims.getWidth() * .605), (int) (dims.getHeight() * .54));
		// Perform swipe
		ActionsBase.doSwipe(driver, startSlide, endSlide, 2000);
		//Find the save button and click it
		driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click();
		
		//Click the option icon and select “Completed tasks”.
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("More options"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.app.todolist:id/title\" and @text=\"Completed tasks\"]"))).click();
		
		//Assertions
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.TextView")));
		List<WebElement> count = driver.findElements(AppiumBy.className("android.widget.CheckBox"));
		assertEquals(count.size(), 2);
		
	}
	
	
	@AfterClass
	public void tearDown() {
		//close the app
		driver.quit();
	}
}