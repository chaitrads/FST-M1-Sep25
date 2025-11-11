package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//Initialize the driver object
		WebDriver driver = new FirefoxDriver();
		
		// open the page
		driver.get("https://training-support.net/webelements/selects");
		
		// Page Title Verification
		System.out.println("Page Title: " + driver.getTitle());
		
		//Page interactions
		
		// Using Xpath
		//On the Single Select:
		WebElement select= driver.findElement(By.xpath("//select[contains(@class,'h-10')]"));
		//WebElement combobox = driver.findElement(By.cssSelector("select.h-10")); 
		//create Select object
		Select dropdown = new Select(select);
		
//		Select the second option using the visible text.
		dropdown.selectByVisibleText("One");
		System.out.println("The second Option using Visible text is: "+ dropdown.getFirstSelectedOption().getText());
//		Select the third option using the index.
		dropdown.selectByIndex(2);
		System.out.println("The third Option using index is: "+ dropdown.getFirstSelectedOption().getText() );
//		Select the fourth option using the value.
		dropdown.selectByValue("three");
		System.out.println("The fourth Option using value is: "+ dropdown.getFirstSelectedOption().getText() );
//		Get all the options and print them to the console.
		System.out.println("All the Options present in the dropdown is printed below--------------");
		for (WebElement option: dropdown.getOptions()) {
			System.out.println(option.getText());
		}
		
				
		// Close the browser
		driver.quit();
		
	}

}
