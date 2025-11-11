package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestActivity1 {
	//Driver Object
	WebDriver driver;
	WebDriverWait wait;
	
	//Setup function
	@BeforeClass
	public void setUp() {
		//Initialize the Driver
		driver= new FirefoxDriver();
		//Initialize The wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Open the Test Page
		driver.get("https://training-support.net");
		
	}
	
	@Test(priority = 1)
	public void pageTitleTest() {
		//get the page title
		//String pageTitle = driver.getTitle();
		
		//Assertion
		Assert.assertEquals(driver.getTitle(), "Training Support"); 
		
	}
	
	@Test(priority = 2)
	public void aboutLinkTest(){
		//Find And Click the About us link
		driver.findElement(By.linkText("About Us")).click();
		//Assertions
		wait.until(ExpectedConditions.titleContains("About"));
		Assert.assertEquals(driver.getTitle(), "About Training Support");
	}
	
	//Teardown Function
	@AfterClass
	public void tearDown() {
		
		//close the Browser
		driver.quit();
	}

	
}
