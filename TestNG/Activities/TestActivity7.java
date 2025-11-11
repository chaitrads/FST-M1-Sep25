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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestActivity7 {
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
		driver.get("https://training-support.net/webelements/login-form");
		
	}
	
	@DataProvider(name = "Credentials")
	public Object[][] creds(){
		return new Object[][] {
			{"admin","wrongPassword"},
			{"wrongAdmin","password"},
			{"$_$","DELETE TABLE users"}
		};
	}
	
	@Test
	public void pageTitleTest() {
		//get the page title
		String pageTitle = driver.getTitle();
		//Assertion
		Assert.assertEquals(pageTitle, "Selenium: Login Form"); 
		
	}
	
	@Test(dependsOnMethods = { "pageTitleTest" },priority = 2, dataProvider = "Credentials")
	public void invalidLoginTest(String username, String password) throws InterruptedException {
		//Find the login input fields - username and password
		WebElement name = driver.findElement(By.id("username"));
		WebElement passwordField = driver.findElement(By.name("password"));
		WebElement submit = driver.findElement(By.cssSelector("button.svelte-1pdjkmx"));
		
		//Clear the Input Fields
		name.clear();
		passwordField.clear();
		//Enter the credentials - admin and password - and click the "Log in" button.
		name.sendKeys(username);
		passwordField.sendKeys(password);
		submit.click();
		Thread.sleep(2000);
		//Assertions
		String invalidMessage = driver.findElement(By.id("subheading")).getText();
		Assert.assertEquals("Invalid credentials", invalidMessage);
				
		
	}
	
	//Teardown Function
	@AfterClass
	public void tearDown() {
		
		//close the Browser
		driver.quit();
	}

	
}
