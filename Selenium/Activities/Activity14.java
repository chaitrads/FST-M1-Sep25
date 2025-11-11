package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity14 {

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
		
//		Find and print the Book Name in the 5th row.
		String fiveRowSecondCol = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]")).getText();
		System.out.println("5th Row Book Name is: ");
		System.out.println(fiveRowSecondCol);
		
//		Click the header of the Price column to sort it in ascending order.
		driver.findElement(By.xpath("//table/thead/tr/th[5]")).click();
		
//		Find and print the Book Name in the 5th row again.
		String fiveRowSecondCol1 = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]")).getText();
		System.out.println("After sorting in Ascending order of price 5th Row Book Name is: ");
		System.out.println(fiveRowSecondCol1);
			
		
		//Second approach
		driver.get("https://training-support.net/webelements/tables");
		WebElement cellValue = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[5]/td[2]"));
		System.out.println("Book Name Before Sorting: "+ cellValue.getText());
//		Click the header of the Price column to sort it in ascending order.
		driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/thead/tr/th[5]")).click();
		
//		Find and print the Book Name in the 5th row again.
		cellValue = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[5]/td[2]"));
		System.out.println("Book Name After Sorting: "+cellValue.getText());
		
		// Close the browser
		driver.quit();
	}

}
