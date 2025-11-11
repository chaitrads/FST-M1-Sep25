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
    # Find the text field.
    textbox = driver.find_element(By.ID,"textInput")
    
    # Check if the text field is enabled and print it.
    print("The Checkbox is Not Enabled and should display False := ", textbox.is_enabled())
        
    # Click the "Enable Input" button to enable the input field.
    toggle = driver.find_element(By.ID,"textInputButton")
    toggle.click()

    # Check if the text field is enabled again and print it.
    print("The Checkbox is Enabled and should display True := ", textbox.is_enabled())
        
    # Print the title of the new page
    print("New page title is: ", driver.title)
    #time.sleep(10)
    # Close the browser
    #driver.quit()