package activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Initialize the driver object
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Create the Wait object
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Create the Actions object
		Actions builder = new Actions(driver);
				
		// open the page
		driver.get("https://training-support.net/webelements/dynamic-attributes");
		
		// Page Title Verification
		System.out.println("Page Title: " + driver.getTitle());
		
		//Page interactions	
//		Find the input fields and type in the required data in the fields.
		WebElement name= driver.findElement(By.xpath("//input[starts-with(@id, 'full-name')]")) ; 
		WebElement email= driver.findElement(By.xpath("//input[contains(@id, '-email')]"));
		WebElement event=driver.findElement(By.xpath("//input[contains(@name, '-event-date-')]"));
		WebElement details= driver.findElement(By.xpath("//textarea[contains(@id,'-additional-details-')]"));
		WebElement submit= driver.findElement(By.xpath("//button[text() ='Submit']"));
		
		//=========================================>question
		builder.sendKeys(name, "Mohan Kumar").pause(1000).sendKeys(email, "test@gmail.com").pause(1000).perform();
		// dont do====> builder.sendKeys(event, "06").sendKeys(Keys.TAB).pause(1000).sendKeys("26").sendKeys(Keys.TAB).pause(1000).sendKeys("2025").sendKeys(Keys.TAB).sendKeys(Keys.TAB).pause(1000).perform();
		builder.sendKeys(event, "2026").sendKeys(Keys.ARROW_LEFT).pause(1000).sendKeys("26").pause(1000).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).sendKeys("05").pause(1000).perform();
		builder.sendKeys(details, "This is a Sample").pause(1000).build().perform();;
		
//		name.sendKeys("Mohan Kumar");
//		email.sendKeys("Test@gmail.com");
//		event.sendKeys("2025-06-26");
//		details.sendKeys("This is a Sample Text:- ");
//		submit.click();
		
//		Wait for success message to appear and print it to the console.
		WebElement message= driver.findElement(By.id("action-confirmation"));
		System.out.println("The Success message is: "+message.getText());
		
		
		//Or other way of printing is
		// Wait for the success message and print it
//        String message1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")))
//                .getText();
//        System.out.println("Success message: " + message1);
		
		// Close the browser
		driver.quit();
	}

}
