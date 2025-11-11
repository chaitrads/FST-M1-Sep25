package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestActivity2 {
	//Driver Object
	WebDriver driver;
	WebDriverWait wait;
	
	//Setup function
	@BeforeClass
	public void setUp() {
		//Initialize the Driver
		driver= new FirefoxDriver();
		//Initialize The wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//Open the Test Page
		driver.get("https://training-support.net/webelements/target-practice/");
		
	}
	
	@Test(priority = 1)
	public void testCase1() {
		//get the page title
		String pageTitle = driver.getTitle();
		
		//Assertion
		Assert.assertEquals(pageTitle, "Selenium: Target Practice"); 
		
	}
	
	@Test(priority = 2)
	public void testCase2(){
		WebElement bButton = driver.findElement(By.cssSelector("button.black"));
		 Assert.assertTrue(bButton.isDisplayed());
	     Assert.assertEquals(bButton.getText(), "black");
	}
	
	@Test(priority = 3, enabled = false)
    public void testCase3() {
        // This test case will be skipped
		WebElement bButton = driver.findElement(By.cssSelector("button.black"));
		 Assert.assertTrue(bButton.isDisplayed());
	     Assert.assertEquals(bButton.getText(), "black");
		
    }
	
	@Test (priority = 4)
	public void testCase4() {
		throw new SkipException("Skipping - This is not ready for testing ");
	}
	
	
	//Teardown Function
	@AfterClass
	public void tearDown() {
		
		//close the Browser
		driver.quit();
	}

	
}
