package activities;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class Activity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//Initialize the driver object
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// open the page
		driver.get("https://training-support.net/webelements/target-practice");
		
		// Page Title Verification
		System.out.println("Page Title: " + driver.getTitle());
		
		//Page interactions
		
		// Using Xpath
		//Find the 3rd header on the page and print it's text to the console.
		WebElement header3= driver.findElement(By.xpath("//h3[contains(@class,'text-orange-600')]"));
		System.out.println("The Third Hearder Text is: " + header3.getText());
		
		//Find the 5th header on the page and print it's color.
		WebElement header5= driver.findElement(By.xpath("//h5[contains(@class,'text-purple-600')]"));
		System.out.println("The Third Hearder Text is: " + header5.getCssValue("color"));
		
//		 Color fifthHeaderColor = Color.fromString(driver.findElement(By.xpath("//h5[contains(text(), '#5')]")).getCssValue("color"));
//	     System.out.println("Color as RGB: " + fifthHeaderColor.asRgb());
//	     System.out.println("Color as hexcode: " + fifthHeaderColor.asHex());
		
		//using other selectors
		//Find the purple button and print all it's classes.
		WebElement purpleButton= driver.findElement(By.className("text-purple-900"));
		System.out.println("The purple Button classes is: " + purpleButton.getAttribute("class"));
		
		//Find the slate button and print it's text.
		WebElement slateButton= driver.findElement(By.cssSelector("button.text-slate-900"));
		System.out.println("The Slate Button Text is: " + slateButton.getText());
				
		// Close the browser
		driver.quit();
		
	}

}
