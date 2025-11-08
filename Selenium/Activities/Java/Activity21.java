package activities;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//Initialize the driver object
		WebDriver driver = new FirefoxDriver();
		//create a wait object
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// open the page
		driver.get("https://training-support.net/webelements/tabs");
		
		// Page Title Verification
		System.out.println("Page Title: " + driver.getTitle());
		
		//Page interactions
//		Find the button to open a new tab and click it.
		WebElement button= driver.findElement(By.cssSelector("button.bg-purple-200"));
		button.click();
		
//		Wait for the new tab to open. Once it opens, print all the handles.
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		//print current handle of current tab
		System.out.println("Current Tab handle is: "+ driver.getWindowHandle());
		
		System.out.println("All Open Tab handels: "+ driver.getWindowHandles());
		
//		Switch to the newly opened tab, print the new tab's title and message.
		for(String handle:driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		
		//print current handle of current tab
		System.out.println("Current Tab handle is: "+ driver.getWindowHandle());
		//Print the handle of the current tab
		System.out.println("Title of the new tab: "+driver.getTitle());
		System.out.println("Message on the New Tab: "+ driver.findElement(By.cssSelector("h2.text-gray-800")).getText());
				
//		Repeat the steps by clicking the button in the new tab page.
		WebElement button2= driver.findElement(By.cssSelector("button.bg-purple-200"));
		button2.click();
		
//		Wait for the new tab to open. Once it opens, print all the handles.
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		//print current handle of current tab
		System.out.println("Current Tab handle is: "+ driver.getWindowHandle());
		
		System.out.println("All Open Tab handels: "+ driver.getWindowHandles());
		
//		Switch to the newly opened tab, print the new tab's title and message.
		for(String handle:driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		
		//print current handle of current tab
		System.out.println("Current Tab handle is: "+ driver.getWindowHandle());
		//Print the handle of the current tab
		System.out.println("Title of the new tab: "+driver.getTitle());
		System.out.println("Message on the New Tab: "+ driver.findElement(By.cssSelector("h2.text-gray-800")).getText());
	
		
		// Close the browser
		//driver.quit();
		
	}

}
