import time
from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    # Open the Page
    driver.get("https://training-support.net/webelements/dynamic-controls")
    # verify Page title
    print(f"Page Title is: {driver.title}")
       
    # Page Interactions
    # On the page, perform:
    # Find the checkbox input element.
    checkbox = driver.find_element(By.ID,"checkbox")
    
    # Check if the checkbox is selected and print the result.
    print("The Checkbox is Not Selected and should display False := ", checkbox.is_selected())
    
    # Click the checkbox to select it.
    checkbox.click()
    # Check if the checkbox is selected again and print the result.
    print("The Checkbox is Selected and should display True := ", checkbox.is_selected())
    
    
    # Print the title of the new page
    print("New page title is: ", driver.title)
    #time.sleep(10)
    # Close the browser
    #driver.quit()
    
