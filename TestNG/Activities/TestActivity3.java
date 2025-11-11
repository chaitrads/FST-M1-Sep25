package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestActivity3 {
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
		driver.get("https://training-support.net/webelements/login-form/");
		
	}
	
	@Test
	public void pageTitleTest() {
		//get the page title
		String pageTitle = driver.getTitle();
		
		//Assertion
		Assert.assertEquals(pageTitle, "Selenium: Login Form"); 
		
	}
	
	@Test(priority = 2)
	public void testCase1() {
		//Find the login input fields - username and password
		WebElement name = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement submit = driver.findElement(By.cssSelector("button.svelte-1pdjkmx"));
		
		//Enter the credentials - admin and password - and click the "Log in" button.
		name.sendKeys("admin");
		password.sendKeys("password");
		submit.click();
		
		//Read the confirmation message and make and assertion to check if the correct message has been printed.
		String message = driver.findElement(By.cssSelector("h2.text-gray-800")).getText();
		System.out.println(message);
		Assert.assertEquals(message, "Welcome Back, Admin!");
	}
	
	//Teardown Function
	@AfterClass
	public void tearDown() {
		
		//close the Browser
		driver.quit();
	}

	
}