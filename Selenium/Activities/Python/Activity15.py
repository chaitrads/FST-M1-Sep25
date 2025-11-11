# Import webdriver from selenium
import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions
# Start the Driver
with webdriver.Firefox() as driver:
     # Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)
    # Get the title of the page and print it to the consol
    # Navigate to the URL
    driver.get("https://training-support.net/webelements/dynamic-attributes")
    # Print the title of the page
    print("Page title is: ", driver.title)
    
    
    # Find the input fields and type in the required data in the fields.
    name = driver.find_element(By.XPATH,"//input[contains(@id ,'full-name-')]")
    email = driver.find_element(By.XPATH,"//input[contains(@id ,'-email')]")
    date = driver.find_element(By.XPATH,"//input[contains(@name ,'-event-date-')]")
    details = driver.find_element(By.XPATH,"//textarea[contains(@id ,'-additional-details-')]")
    result = driver.find_element(By.XPATH,"//h3[@id='action-confirmation']") 
    submit = driver.find_element(By.CSS_SELECTOR, "button.svelte-7bqce9")
    
    name.send_keys("Mohan Kumar")
    email.send_keys("test@g.com")
    date.send_keys("2025-06-26")
    details.send_keys("This is a sample data")
    submit.click()
    # Wait for success message to appear and print it to the console.
    print("Success Message is: "+ result.text)
    # Print the title of the new page
    print("New page title is: ", driver.title)
    
    #additional wait conditions
    message = wait.until(expected_conditions.visibility_of_element_located((By.ID, "action-confirmation"))).text
    print("Success message: ", message)
    
    #time.sleep(10)
    # Close the browser
    #driver.quit()
    
