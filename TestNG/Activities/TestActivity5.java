package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestActivity5 {
	//Driver Object
	WebDriver driver;
	
	
	//Setup function
	@BeforeClass(alwaysRun = true)
	public void setUp() {
		//Initialize the Driver
		driver= new FirefoxDriver();
		//Open the Test Page
		driver.get("https://training-support.net/webelements/target-practice");
		
	}
	
	@Test(groups = {"Headers","Buttons"}, alwaysRun = true)
	public void pageTitleTest() {
		//get the page title
		String pageTitle = driver.getTitle();
		
		//Assertion
		Assert.assertEquals(pageTitle, "Selenium: Target Practice"); 
		
	}
	
	@Test(groups = {"Headers"})
	public void headerTest1() {
		//Find the third header and assert the text in the h3 tag.
		WebElement thirdHeader = driver.findElement(By.cssSelector("h3.text-orange-600"));
		Assert.assertEquals(thirdHeader.getText(),"Heading #3");
	}
	
	@Test(groups = {"Headers"})
	public void headerTest2() {
		//Find and assert the colour of the fifth header tag element.
		Color header5 = Color.fromString(driver.findElement(By.cssSelector("h5.text-purple-600")).getCssValue("color"));
		Assert.assertEquals(header5.asHex(), "#9333ea");
	}
	
	@Test(groups = {"Buttons"})
	 public void buttonTest1() {
		//Find the button with the class emerald and assert it text.
        WebElement button1 = driver.findElement(By.xpath("//button[contains(@class, 'emerald')]"));
        Assert.assertEquals(button1.getText(), "Emerald");
	    }
	@Test(groups = {"Buttons"})
	public void buttonTest2() {
		//Find and assert the colour of the first button in the third row.
		Color button2Color = Color.fromString(driver.findElement(By.xpath("//button[contains(@class, 'purple')]")).getCssValue("color"));
        Assert.assertEquals(button2Color.asHex(), "#581c87");
	}
	
	//Teardown Function
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		
		//close the Browser
		driver.quit();
	}

	
}
