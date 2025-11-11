package stepDefinitions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseClass{

	@Given("the user is on the login page")
	public void openLoginPage() {
		driver.get(" https://training-support.net/webelements/login-form");
		//Assertions
		Assertions.assertEquals("Selenium: Login Form",driver.getTitle());
	}
	
	@When("the user enters username and password")
	public void enterCredentials() {
		//Locate the usaername field and entre the Valid username
		WebElement name = driver.findElement(By.id("username"));
		name.sendKeys("admin");
		//Locate the password fields and enter the valid password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("password");
		
		//Assertion
		Assertions.assertEquals("admin", name.getDomProperty("value"));
		Assertions.assertEquals("password", password.getDomProperty("value"));
		
	}
	
	@And("clicks the submit button")
	public void clickSubmit(){
		//Locate and Click the Submit Button
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}
	
	@Then("get the confirmation message and verify it")
	public void verifyMessage() {
		//Wait for the next page to load and then get the login message
		String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.text-gray-800"))).getText();
		Assertions.assertEquals("Welcome Back, Admin!",message);
		
	}
	
	@When("the user enters {string} and {string}")
	public void enterCredentials(String username, String password) {
		//Locate the usaername field and entre the Valid username
		WebElement nameField = driver.findElement(By.id("username"));
		nameField.sendKeys(username);
		//Locate the password fields and enter the valid password
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys(password);
		
		//Assertion
		Assertions.assertEquals(username, nameField.getDomProperty("value"));
		Assertions.assertEquals(password, passwordField.getDomProperty("value"));
	}
	
	@Then("verify message as {string}")
	public void verifyMessage(String message) {
		//Wait for the next page to load and then get the login message
		String messageField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.text-gray-800"))).getText();
		Assertions.assertEquals(message,messageField);
		
	}
	@Then("verify error message as {string}")
	public void verifyErrorMessage(String errorMessage) {
		String messageField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subheading"))).getText();
		Assertions.assertEquals(errorMessage,messageField);
	}
	
	
	
}
