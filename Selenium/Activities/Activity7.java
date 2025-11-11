package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Initialize the driver object
				WebDriver driver = new FirefoxDriver();
				
				// open the page
				driver.get("https://training-support.net/webelements/dynamic-controls");
				
				// Page Title Verification
				System.out.println("Page Title: " + driver.getTitle());
				
				//Page interactions
				
//				Find the text field.
				WebElement textbox= driver.findElement(By.name("textInput"));
//				Check if the text field is enabled and print it.
				System.out.println("THE Textbox is Selected ? " + textbox.isEnabled());
//				Click the "Enable Input" button to enable the input field.
				//driver.findElement(By.cssSelector("button.svelte-sfj3o4")).click();
				driver.findElement(By.id("textInputButton")).click();
//				Check if the text field is enabled again and print it.
				System.out.println("THE Textbox is Selected ? " + textbox.isEnabled());
				
				//type the test you want to send
				textbox.sendKeys("Test String");
				System.out.println(textbox.getDomProperty("value"));
				
			//	 Close the browser
			     driver.quit();
				
	}

}
