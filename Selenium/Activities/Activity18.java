package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//Initialize the driver object
		WebDriver driver = new FirefoxDriver();
		
		// open the page
		driver.get("https://training-support.net/webelements/alerts");
		
		// Page Title Verification
		System.out.println("Page Title: " + driver.getTitle());
		
		//Page interactions
		
//		Find the button to open a SIMPLE alert and click it.
		WebElement l1= driver.findElement(By.id("simple"));
		l1.click();
//		Switch the focus from the main window to the Alert box and get the text in it and print it.
		Alert simpleAlert = driver.switchTo().alert();
		System.out.println(simpleAlert.getText());
		
//		Close the alert once with OK.
		simpleAlert.accept();
		System.out.println(driver.findElement(By.id("result")).getText());
		// Close the browser
		driver.quit();
		
	}

}
