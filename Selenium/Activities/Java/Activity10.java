package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Initialize the driver object
		WebDriver driver = new FirefoxDriver();
		//Create the Actions Object
		Actions builder = new Actions(driver);
		
		// open the page
		driver.get("https://training-support.net/webelements/drag-drop");
		
		// Page Title Verification
		System.out.println("Page Title: " + driver.getTitle());
		
		//Page interactions
		
		//FIND and click the Football
		WebElement football= driver.findElement(By.id("ball"));
		
		//FIND and click the Football
		WebElement dropzone1= driver.findElement(By.id("dropzone1"));
		//FIND and click the Football
		WebElement dropzone2= driver.findElement(By.id("dropzone2"));
		
//		Find the ball and simulate a click and drag to move it into "Dropzone 1".
		builder.clickAndHold(football).moveToElement(dropzone1).pause(5000).release().build().perform();
//		Verify that the ball has entered Dropzone 1.
		if(dropzone1.findElement(By.className("dropzone-text")).getText().equals("Dropped!")) {
			System.out.println(" Ball was Dropped in zone 1");
			
		}
//		Once verified, move the ball into "Dropzone 2".
		builder.dragAndDrop(football,dropzone2).pause(5000).build().perform();

//		Verify that the ball has entered Dropzone 2.
		if(dropzone2.findElement(By.className("dropzone-text")).getText().equals("Dropped!")) {
			System.out.println(" Ball was Dropped in zone 2");
			
		}

		// Close the browser
		driver.quit();
		
		
		
	}

}
