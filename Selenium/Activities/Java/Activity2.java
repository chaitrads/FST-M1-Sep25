package activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

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

		WebElement link= driver.findElement(By.id("username"));
		link.sendKeys("admin");
		//		Find the password field using any locator and enter "password" into it.

		WebElement link2= driver.findElement(By.name("password"));
		link2.sendKeys("password");
		//		Find the "Log in" button using any locator and click it.
		driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
		
		// Print the success message
		String message = driver.findElement(By.cssSelector("h2.text-gray-800")).getText();
		System.out.println(message);
		
// By the cssSelector		
//		WebElement link2= driver.findElement(By.cssSelector("a.car.svelte-4bhb3l"));
//		link2.click();
//		System.out.println(" NEW Page Title: " + driver.getTitle());
		
		// Close the tab
		//driver.close(); NOT USED TYPICALLY
		// Close the browser
		driver.quit();
		
		
		
	}

}
