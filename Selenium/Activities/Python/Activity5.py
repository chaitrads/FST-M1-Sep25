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
    print("The Checkbox is not selected and should display false:= ",checkbox.is_selected())
        
    # Check if it is visible on the page.
    print("The Checkbox is Visible and should display True := ", checkbox.is_displayed())
    
    # Click the "Remove Checkbox" button.
    toggle =driver.find_element(By.CSS_SELECTOR,"button.svelte-sfj3o4")
    toggle.click()

    # Check if it is visible again and print the result.
    print("The Checkbox is not Visible and should display false:= ", checkbox.is_displayed())
    
    
    # Print the title of the new page
    print("New page title is: ", driver.title)
    #time.sleep(10)
    # Close the browser
    #driver.quit()
    
