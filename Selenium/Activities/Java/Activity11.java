package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Initialize the driver object
		WebDriver driver = new FirefoxDriver();
		
		
		
		// open the page
		driver.get("https://training-support.net/webelements/dynamic-controls");

		// Page Title Verification
		System.out.println("Page Title: " + driver.getTitle());
		
		//Page interactions
		//Find the checkbox on the page.
		WebElement checkbox = driver.findElement(By.id("checkbox"));
		System.out.println("The Checkbox is currentlty Visible and should display True: "+checkbox.isDisplayed());
		System.out.println("The Checkbox is currentlty not Selected and should display False: "+checkbox.isSelected());
//		Click the "Toggle Checkbox" button to remove the checkbox.
		WebElement toggle = driver.findElement(By.cssSelector("button.svelte-sfj3o4"));
		System.out.println("Clicking the Toggle checkbox: ");
		toggle.click();
		
//		Wait for the checkbox to disappear.
		System.out.println("The Checkbox is currentlty not Visible and should display False: "+checkbox.isDisplayed());
		
//		Toggle the checkbox again.
		System.out.println("Clicking the Toggle checkbox again: ");
		toggle.click();
		System.out.println("The Checkbox is currentlty Visible and should display True: "+checkbox.isDisplayed());
//		Wait for it appear and then select it.
		checkbox.click();		
		System.out.println("The Checkbox is currentlty Selected and should display True: "+checkbox.isSelected());
		// Close the browser
		driver.quit();
		
		
		
	}

}
