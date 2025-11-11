# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions

# Start the Driver
with webdriver.Firefox() as driver:
    # Navigate to the URL
    driver.get("https://training-support.net/webelements/alerts")
    # Print the title of the page
    print("Page title is: ", driver.title)

    # Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)
    
    #Find the button to open a PROMPT alert and click it.
    promptalert = driver.find_element(By.ID, "prompt")
    promptalert.click() 
    
    # Switch the focus from the main window to the Alert box and get the text in it and print it.
    alert = wait.until(expected_conditions.alert_is_present())
    print("Alert message is:"+ alert.text)
    
    # Type "Awesome!" into the prompt.
    alert.send_keys("Awesome!")
    print("Alert message is:"+ alert.text)
    
    # Close the alert by clicking Ok.
    alert.accept()
    # Print the message
    print(driver.find_element(By.ID, "result").text)
    
    # Print the title of the new page
    print("New page title is: ", driver.title)
    #time.sleep(10)
    # Close the browser
    #driver.quit()
    