package activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//Initialize the driver object
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// open the page
		driver.get("https://training-support.net/webelements/login-form/");
		
		// Page Title Verification
		System.out.println("Page Title: " + driver.getTitle());
		
		//Page interactions
		
		//Find the username field using any locator and enter "admin" into it.

		WebElement link= driver.findElement(By.xpath("//input[@id='username']"));
		link.sendKeys("admin");
		//		Find the password field using any locator and enter "password" into it.

		WebElement link2= driver.findElement(By.xpath("//*[@id=\"password\"]"));
		link2.sendKeys("password");
		//		Find the "Log in" button using any locator and click it.
		driver.findElement(By.xpath("//button[@class='svelte-1pdjkmx']")).click();
		

		// Print the success message
		String message = driver.findElement(By.xpath("//h1[contains(text(), 'Success')]")).getText();
		System.out.println(message);
		
		// Close the browser
		//driver.quit();
		
	}

}
