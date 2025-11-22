package project;


import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
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

public class Activity2 {

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
	public void addTask1() {
		
		// Get the size of the screen
		Dimension dims = driver.manage().window().getSize();
		// Set the start and end points
		Point start = new Point((int) (dims.getWidth() * .25), (int) (dims.getHeight() * .11));
		
		//Long press the first task in the list to edit its details.
		ActionsBase.longPress(driver, start);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Edit To-Do Task\"]"))).click();
		
		//Find date field and edit it
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.app.todolist:id/tv_todo_list_deadline"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("22 November 2025"))).click();
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.app.todolist:id/bt_deadline_ok\"]")).click();
		//Find the save button and click it
		driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click();
		
		//Assertions
		String message = driver.findElement(AppiumBy.xpath
				("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_deadline\" and @text=\"Deadline: 22.11.2025\"]")).getText();
		assertEquals(message, "Deadline: 22.11.2025");
		
	}
	
	@Test
	public void addTask2() {
		
		// Get the size of the screen
		Dimension dims = driver.manage().window().getSize();
		// Set the start and end points
		Point start = new Point((int) (dims.getWidth() * .25), (int) (dims.getHeight() * .20));
		
		//Long press the first task in the list to edit its details.
		ActionsBase.longPress(driver, start);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Edit To-Do Task\"]"))).click();
		
		//Find date field and edit it
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.app.todolist:id/tv_todo_list_deadline"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("22 November 2025"))).click();
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.app.todolist:id/bt_deadline_ok\"]")).click();
		//Find the save button and click it
		driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click();
		
		//Assertions
		String message = driver.findElement(AppiumBy.xpath
				("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_deadline\" and @text=\"Deadline: 22.11.2025\"]")).getText();
		assertEquals(message, "Deadline: 22.11.2025");
		
	}
	
	@Test
	public void addTask3() {
		
		// Get the size of the screen
		Dimension dims = driver.manage().window().getSize();
		// Set the start and end points
		Point start = new Point((int) (dims.getWidth() * .25), (int) (dims.getHeight() * .27));
		
		//Long press the first task in the list to edit its details.
		ActionsBase.longPress(driver, start);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Edit To-Do Task\"]"))).click();
		
		//Find date field and edit it
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.app.todolist:id/tv_todo_list_deadline"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("22 November 2025"))).click();
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.app.todolist:id/bt_deadline_ok\"]")).click();
		//Find the save button and click it
		driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click();
		
		//Assertions
		String message = driver.findElement(AppiumBy.xpath
				("//android.widget.TextView[@resource-id=\"com.app.todolist:id/tv_exlv_task_deadline\" and @text=\"Deadline: 22.11.2025\"]")).getText();
		assertEquals(message, "Deadline: 22.11.2025");
		
	}
	
	@AfterClass
	public void tearDown() {
		//close the app
		driver.quit();
	}
}
