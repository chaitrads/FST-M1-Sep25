package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Initialize the driver object
				WebDriver driver = new FirefoxDriver();
				
				// open the page
				driver.get("https://training-support.net/webelements/dynamic-controls");
				
				// Page Title Verification
				System.out.println("Page Title: " + driver.getTitle());
				
				//Page interactions
				
//				Find the checkbox input element.
				WebElement checkbox= driver.findElement(By.name("checkbox"));
//				Check if it is visible on the page.
				System.out.println("THE Checkbox is Visible ? " + checkbox.isDisplayed());
//				Click the "Remove Checkbox" button.
				//driver.findElement(By.cssSelector("button.svelte-sfj3o4")).click();
				driver.findElement(By.xpath("//button[text() ='Toggle Checkbox']")).click();
//				Check if it is visible again and print the result.
				System.out.println("THE Checkbox is Visible ? " + checkbox.isDisplayed());
				
			//	 Close the browser
			     driver.quit();
				
	}

}
