package project;


import static org.testng.Assert.assertEquals;

import java.io.File;
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
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {

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
		//options.noReset();  //prevents factory reset
		
		//Appium Server URL
		URL serverURL= new URI("http://localhost:4723").toURL();
		//initialize the driver object
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		
		
		
	}

	@Test
	public void addTask1() {
		//for first time launch
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"))) != null ) {
			driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		}
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.app.todolist:id/btn_skip"))) != null ) {
			driver.findElement(AppiumBy.id("com.app.todolist:id/btn_skip")).click();
		}
		
		
		//Find the add button and tap it
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.app.todolist:id/fab_new_task"))).click();
		
		//Find name field and send the activity name
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.app.todolist:id/et_new_task_name"))).sendKeys("Activity 1");
		//Find description and send the description
		driver.findElement(AppiumBy.id("com.app.todolist:id/et_new_task_description")).sendKeys("This is a testing Activity");
		//Find The priority and tap and set it to High
		driver.findElement(AppiumBy.id("com.app.todolist:id/tv_new_task_priority")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"High\"]")).click();
		//Find the save button and click it
		driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click();
		
		//Assertions
		String message = driver.findElements(AppiumBy.id
				("com.app.todolist:id/tv_exlv_task_name")).get(0).getText();
		assertEquals(message, "Activity 1");
		
	}
	
	@Test(priority = 3)
	public void addTask2() {
			
		//Find the add button and tap it
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.app.todolist:id/fab_new_task"))).click();
		
		//Find name field and send the activity name
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.app.todolist:id/et_new_task_name"))).sendKeys("Activity 2");
		//Find description and send the description
		driver.findElement(AppiumBy.id("com.app.todolist:id/et_new_task_description")).sendKeys("This is a testing Activity 2");
		//Find The priority and tap and set it to High
		driver.findElement(AppiumBy.id("com.app.todolist:id/tv_new_task_priority")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Medium\"]")).click();
		//Find the save button and click it
		driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click();
		//to find the task by name below.
		//android.widget.TextView[ @text="Activity 2"]
		//Assertions
		String message = driver.findElements(AppiumBy.id
				("com.app.todolist:id/tv_exlv_task_name")).get(1).getText();
		assertEquals(message, "Activity 2");
		
	}
	
	
	@Test(priority = 4)
	public void addTask3() {
		
		//Find the add button and tap it
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.app.todolist:id/fab_new_task"))).click();
		
		//Find name field and send the activity name
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.app.todolist:id/et_new_task_name"))).sendKeys("Activity 3");
		//Find description and send the description
		driver.findElement(AppiumBy.id("com.app.todolist:id/et_new_task_description")).sendKeys("This is a testing Activity 3");
		//Find The priority and tap and set it to High
		driver.findElement(AppiumBy.id("com.app.todolist:id/tv_new_task_priority")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Low\"]")).click();
		//Find the save button and click it
		driver.findElement(AppiumBy.id("com.app.todolist:id/bt_new_task_ok")).click();
		
		//Assertions
		String message = driver.findElements(AppiumBy.id
				("com.app.todolist:id/tv_exlv_task_name")).get(2).getText();
		assertEquals(message, "Activity 3");
		
	}
	
	
	
	@AfterClass
	public void tearDown() {
		//close the app
		driver.quit();
	}
}
