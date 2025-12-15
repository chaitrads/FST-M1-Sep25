package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {

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
		//On the Multi Select:
		WebElement multiselect= driver.findElement(By.cssSelector("select.h-80"));
		//create Select object
		Select multilist = new Select(multiselect);
		//Deselect Rust
		multilist.deselectAll();
		
//		Select the "HTML" option using the visible text.
		multilist.selectByVisibleText("HTML");
		System.out.println("The Selected Option using Visible text is: "+ multilist.getFirstSelectedOption().getText() );
		
//		Select the 4th, 5th and 6th options using the index.
//		multilist.selectByIndex(4);
//		multilist.selectByIndex(5);
//		multilist.selectByIndex(6);
		for (int i=3;i<=5; i++) {
			multilist.selectByIndex(i);
		}
		//print all selected Options
		System.out.println("All the Selected Options are: ============================>");
		for(WebElement option: multilist.getAllSelectedOptions()) {
			System.out.println(option.getText());
		}
		
//		Select the "Node" option using the value.
		multilist.selectByValue("nodejs");
		System.out.println("All the Selected Options are: ============================>");
		for(WebElement option: multilist.getAllSelectedOptions()) {
			System.out.println(option.getText());
		}

//		Deselect the 5th option using index.
		multilist.deselectByIndex(4);
		System.out.println("All the Selected Options are: ============================>");
		for(WebElement option: multilist.getAllSelectedOptions()) {
			System.out.println(option.getText());
		}

				
		// Close the browser
		driver.quit();
		
	}

}
