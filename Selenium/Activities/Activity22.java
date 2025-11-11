package activities;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//Initialize the driver object
		WebDriver driver = new FirefoxDriver();
		//create a wait object
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// open the page
		driver.get("https://training-support.net/webelements/popups");
		
		// Page Title Verification
		System.out.println("Page Title: " + driver.getTitle());
		
		//Page interactions
//		Find the button on the page and click it to launch the popup.
		WebElement button= driver.findElement(By.id("launcher"));
		button.click();
		
		
//		Wait for the popup to appear and then enter the credentials:
		WebElement name= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		WebElement password= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		WebElement submit= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.svelte-1pdjkmx")));
//			username: admin
		name.sendKeys("admin");
		
//			password: password
		password.sendKeys("password");
		
//			Click submit and print the message on the page after logging in.
		submit.click();
		WebElement message= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.mt-5")));
		System.out.println("The Message on the screen is: "+message.getText());
			
		// Close the browser
		//driver.quit();
		
	}

}
