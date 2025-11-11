package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Initialize the driver object
		WebDriver driver = new FirefoxDriver();
		//Create the Actions object
		Actions builder = new Actions(driver);
		
		// open the page
		driver.get("https://training-support.net/webelements/keyboard-events");
		
		// Page Title Verification
		System.out.println("Page Title: " + driver.getTitle());
		
		//Page interactions
		
//		On the page, type out a string from the Selenium script to show on the page
		WebElement keystrokes= driver.findElement(By.cssSelector("h1.mt-3"));

		builder.sendKeys("Hello Welcome to Hogwarts in wonderland").sendKeys(Keys.RETURN).build().perform();;
//		Print the message to the console.
		System.out.println(keystrokes.getText());
		
		// Close the browser
		driver.quit();
	}

}
