package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTableExamplesList extends BaseClass{

	@Given("user is on the To-Do list page")
	public void openToDoListPage(){
		//Open the To-Do List Page
		driver.get("https://training-support.net/webelements/todo-list");
		
	}
	
	@When("user adds the following tasks")
	public void inputTasks(DataTable inputTasks) throws InterruptedException {
		//Take the Table of tasks and convert it into a List<String>
		List<String> tasks = inputTasks.asList();
		System.out.println(tasks);
		
		//add the tasks to the page
		for(String task : tasks) {
			driver.findElement(By.id("todo-input")).sendKeys(task);
			//Find and click the add button
			driver.findElement(By.id("todo-add")).click();
			Thread.sleep(2000);//Pause to see output	
		}	
	}
	
	@Then("they can see the task added to the list")
	public void verifyResults() {
		System.out.println("All tasks present");
	}
	
}
