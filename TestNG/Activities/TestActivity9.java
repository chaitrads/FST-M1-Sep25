package activities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestActivity9 {
	//Driver Object
	WebDriver driver;
	WebDriverWait wait;
	
	//Setup function
	@BeforeClass
	public void setUp() {
		//Initialize the Driver
		driver= new FirefoxDriver();
		// Initialize Wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Reporter.log("Starting Test |");
		//Open the Test Page
		driver.get("https://training-support.net/webelements/alerts");
		
		Reporter.log("Opened Browser |");
		
		// Print title of page
        Reporter.log("Page title is " + driver.getTitle() + " |");
	}
	
	@BeforeMethod
    public void beforeMethod() {
        Reporter.log("Test Case Setup started |");
        driver.switchTo().defaultContent();
    }
	
	@Test
	public void pageTitleTest() {
		//get the page title
		String pageTitle = driver.getTitle();
		//Assertion
		Assert.assertEquals(pageTitle, "Selenium: Alerts"); 
		
	}
	
	
	@Test(priority = 2)
	public void simpleAlertTestCase() {
		Reporter.log("simpleAlertTestCase() started |");
        // Click the button to open a simple alert
        driver.findElement(By.id("simple")).click();
        Reporter.log("Simple Alert opened |");
        // Switch to alert window
        Alert simpleAlert = driver.switchTo().alert();
        Reporter.log("Switched foucs to alert |");
 
        // Get text in the alert box and print it
        String alertText = simpleAlert.getText();
        Reporter.log("Alert text is: " + alertText + " |");
 
        // Assertion
        Assert.assertEquals("You've just triggered a simple alert!", alertText);
 
        simpleAlert.accept();
        Reporter.log("Alert closed");
 
        Reporter.log("Test case ended |");
	}
	
	
	@Test(priority = 3)
	public void confirmAlertTestCase() throws InterruptedException {
		Reporter.log("confirmAlertTestCase() started |");
        // Click the button to open a simple alert
        driver.findElement(By.id("confirmation")).click();
        Reporter.log("Confirm Alert opened |");
        // Switch to alert window
        Alert confirmAlert = driver.switchTo().alert();
        Reporter.log("Switched foucs to alert |");
 
        // Get text in the alert box and print it
        String alertText = confirmAlert.getText();
        Reporter.log("Alert text is: " + alertText + " |");
 
        // Assertion
        Assert.assertEquals("You've just triggered a confirmation alert!", alertText);
 
        confirmAlert.accept();
        Reporter.log("Alert closed with accept");
        Thread.sleep(1000);
        Reporter.log("confirmAlertTestCase() Restarted |");
        // Click the button to open a simple alert
        driver.findElement(By.id("confirmation")).click();
        Reporter.log("Confirm Alert opened |");
        // Switch to alert window
        Alert confirmAlert1 = driver.switchTo().alert();
        Reporter.log("Switched foucs to alert |");
 
        // Get text in the alert box and print it
        String alertText1 = confirmAlert1.getText();
        Reporter.log("Alert text is: " + alertText1 + " |");
 
        // Assertion
        Assert.assertEquals("You've just triggered a confirmation alert!", alertText1);
 
        confirmAlert.dismiss();
        Reporter.log("Alert closed with dismiss");
        
        
        Reporter.log("Test case ended |");
		
	}
	
	
	@Test(priority = 4)
	public void promptAlertTestCase() {
		Reporter.log("promptAlertTestCase() started |");
        // Click the button to open a simple alert
        driver.findElement(By.id("prompt")).click();
        Reporter.log("Prompt Alert opened |");
        // Switch to alert window
        Alert promptAlert = driver.switchTo().alert();
        Reporter.log("Switched foucs to alert |");
 
        // Get text in the alert box and print it
        String alertText = promptAlert.getText();
        Reporter.log("Alert text is: " + alertText + " |");
        //send keys to prompt
        promptAlert.sendKeys("This is a sample Prompt test");
        Reporter.log("a sample text has been entred to the prompt |");
        // Assertion
        Assert.assertEquals("I'm a Prompt! Type something into me!", alertText);
 
        promptAlert.accept();
        Reporter.log("Alert closed");
	}
	
	
	//Teardown Function
	@AfterClass
	public void tearDown() {
		
		//close the Browser
		driver.quit();
	}

	
}

