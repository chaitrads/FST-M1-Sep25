
package stepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertSteps extends BaseClass{

	Alert alert; 
	
	@Given("User is on the page")
	public void openAlertsPage() {
		//Open the Alerts Page
		driver.get("https://training-support.net/webelements/alerts");
		
	}
	
	@When("User clicks the Simple Alert button")
	public void simpleAlert() throws InterruptedException {
		//Find the the Simple Alert Button and Click it
		WebElement simple = driver.findElement(By.id("simple"));
		simple.click();
		Thread.sleep(1000);
	}
	@When("User clicks the Confirmation Alert button")
	public void confirmAlert() throws InterruptedException {
		//Find the the Simple Alert Button and Click it
		WebElement confirm = driver.findElement(By.id("confirmation"));
		confirm.click();
		Thread.sleep(1000);
	}
	
	@When("User clicks the Prompt Alert button")
	public void promptAlert() throws InterruptedException {
		//Find the the Simple Alert Button and Click it
		WebElement prompt = driver.findElement(By.id("prompt"));
		prompt.click();
		Thread.sleep(1000);
	}
	
	@Then("Alert opens")
	public void alertSwitch() throws InterruptedException {
		alert = driver.switchTo().alert();
		Thread.sleep(1000);
	}
	
	@And("Read the text from it and print it")
	public void readTextInsideAlert() {
		System.out.println("Alert Says: "+ alert.getText());
	}
	
	@And ("Close the alert")
	public void acceptTheAlert() throws InterruptedException {
		alert.accept();
		Thread.sleep(1000);
	}
	
	@And("Close the alert with Cancel")
	public void dismissTheAlert() throws InterruptedException {
		alert.dismiss();
		Thread.sleep(1000);
	}
	
	@And ("Read the result text")
	public void resultDisplayed() throws InterruptedException {
		String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result"))).getText(); 
		System.out.println(message);
		Thread.sleep(1000);
	}
	
	@And ("Write a custom message in it")
	public void sendInputToAlert() throws InterruptedException {
		alert.sendKeys("This is a Custom Message");
		Thread.sleep(1000);
	}
	
	
}

