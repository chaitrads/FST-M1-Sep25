package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Initialize the driver object
		WebDriver driver = new FirefoxDriver();
		
		// open the page
		driver.get("https://training-support.net");
		
		// Page Title Verification
		System.out.println("Page Title: " + driver.getTitle());
		
		//Page interactions
		
		//FIND and click the about us button
		WebElement link= driver.findElement(By.className("svelte-4bhb3l"));
		link.click();
		System.out.println(" NEW Page Title: " + driver.getTitle());
		
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
