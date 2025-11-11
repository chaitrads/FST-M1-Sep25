package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Initialize the driver object
		WebDriver driver = new FirefoxDriver();
		
		// open the page
		driver.get("https://training-support.net/webelements/tables");
		
		// Page Title Verification
		System.out.println("Page Title: " + driver.getTitle());
		
		//Page interactions

//		Find the number of rows and columns in the table and print them.
		// Find the number of columns
		List<WebElement> cols= driver.findElements(By.xpath("//table/thead/tr/th"));
		//print columns
		System.out.println("Number of columns: "+ cols.size());
		
		//Find the number of rows
		List<WebElement> rows= driver.findElements(By.xpath("//table/tbody/tr"));
		//print columns
		System.out.println("Number of Rows: "+ rows.size());
		
//		Find and print all the cell values in the third row of the table.
		//By cell values
//		String thirdRow = driver.findElement(By.xpath("//table/tbody/tr[3]")).getText();
//		System.out.println(thirdRow);
		List<WebElement> thirdRow = driver.findElements(By.xpath("//table/tbody/tr[3]/td"));
		System.out.println("Third Row Values: ");
		for(WebElement cell : thirdRow) {
			System.out.println(cell.getText());
		}
		
//		Find and print the cell value at the second row second column.
		String secondRowSecondCol = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
		System.out.println("Second Row Second Value: ");
		System.out.println(secondRowSecondCol);
		
		// Close the browser
		driver.quit();
	}

}
