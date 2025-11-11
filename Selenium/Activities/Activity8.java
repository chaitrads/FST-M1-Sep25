package activities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Initialize the driver object
		WebDriver driver = new FirefoxDriver();
		//Create the Actions object
		Actions builder = new Actions(driver);
		
		// open the page
		driver.get("https://training-support.net/webelements/mouse-events");
		
		// Page Title Verification
		System.out.println("Page Title: " + driver.getTitle());
		
		//Page interactions
		
		//FIND The buttons on the page
		List<WebElement> buttons = driver.findElements(By.cssSelector("div.svelte-hs12g9"));
//		WebElement button1 = buttons.get(0);
//		WebElement button2 = buttons.get(1);
//		WebElement button3 = buttons.get(2);
//		WebElement button4 = buttons.get(3);
		
		//Left click on the Cargo.lock button, move the cursor to the Cargo.toml button and then click it. 
		builder.click(buttons.get(0)).pause(Duration.ofSeconds(1)).click(buttons.get(1)).pause(Duration.ofSeconds(1)).build().perform();
		//Print the confirmation text at the end of the sequence.
		String message= driver.findElement(By.id("result")).getText();
		System.out.println(" Clicked Button is : " +message);
		
		//Double click on the src button. Then right click on the target button and select open. 
		builder.doubleClick(buttons.get(2)).pause(Duration.ofSeconds(2)).contextClick(buttons.get(3)).pause(Duration.ofSeconds(1)).perform();
		builder.click(driver.findElement(By.xpath("//span[text()='Open']"))).pause(Duration.ofSeconds(1)).build().perform();
		
		//Print the confirmation text at the end of the sequence.
		String message1= driver.findElement(By.id("result")).getText();
		System.out.println(" Clicked Button is : " +message1);
		
		// Close the browser
		driver.quit();
	}

}
