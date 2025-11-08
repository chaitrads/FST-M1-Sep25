package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//Initialize the driver object
		WebDriver driver = new FirefoxDriver();
		
		// open the page
		driver.get("https://training-support.net/webelements/alerts");
		
		// Page Title Verification
		System.out.println("Page Title: " + driver.getTitle());
		
		//Page interactions
//		Find the button to open a CONFIRM alert and click it.
		WebElement confirm= driver.findElement(By.id("confirmation"));
		confirm.click();
		
//		Switch the focus from the main window to the Alert box and get the text in it and print it.
		Alert confirmationAlert = driver.switchTo().alert();
		System.out.println(confirmationAlert.getText());
		
//		Close the alert once with Ok and again with Cancel.
		confirmationAlert.accept();
		// Can also close the alert by clicking Cancel
        // confirmAlert.dismiss();
		System.out.println(driver.findElement(By.id("result")).getText());
		
		
		// Again with cancel button
		
		confirm.click();
		
//		Switch the focus from the main window to the Alert box and get the text in it and print it.
		Alert confirmationAlert1 = driver.switchTo().alert();
		System.out.println(confirmationAlert1.getText());
		
//		Close the alert once with Ok and again with Cancel.
		confirmationAlert1.dismiss();
		// Can also close the alert by clicking Cancel
		System.out.println(driver.findElement(By.id("result")).getText());
		
	
		
		// Close the browser
		driver.quit();
		
	}

}
