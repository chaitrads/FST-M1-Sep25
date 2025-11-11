package activities;

import java.time.Duration;

//import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Initialize the driver object
				WebDriver driver = new FirefoxDriver();
				WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
				// open the page
				driver.get("https://training-support.net/webelements/dynamic-content");
				
				// Page Title Verification
				System.out.println("Page Title: " + driver.getTitle());
				
				//Page interactions
				
//				Find and click the "Click me!" button.
				WebElement link= driver.findElement(By.id("genButton"));
				link.click();
//				Wait till the word "release" appears.
				WebElement wordElement = driver.findElement(By.id("word"));
//				Get the text and print it to console.
				wait.until(ExpectedConditions.textToBePresentInElement(wordElement,"release"));
				
				//
				// print word
				String newWord = wordElement.getText();
				System.out.println(newWord);
				//System.out.println(wordElement.getText());
		
				// Close the browser
				driver.quit();
				
	}

}
