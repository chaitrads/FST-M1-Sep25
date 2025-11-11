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
    # Find the checkbox on the page.
    checkbox = driver.find_element(By.ID,"checkbox")
    print("The Checkbox is Visible should display True:= ",checkbox.is_displayed())
    
    # Click the "Toggle Checkbox" button to remove the checkbox.
    toggle =driver.find_element(By.CSS_SELECTOR,"button.svelte-sfj3o4")
    toggle.click()
    time.sleep(1)
    # Wait for the checkbox to disappear.
    print("The Checkbox is Not Visible should display False:= ",checkbox.is_displayed())
    toggle.click()
    time.sleep(1)
    # Toggle the checkbox again.
    print("The Checkbox is Visible should display True:= ",checkbox.is_displayed())
    
    # Wait for it appear and then select it.
    checkbox.click()
    time.sleep(1)
    print("The Checkbox is Selected should display True:= ",checkbox.is_selected())
    
    
    # Print the title of the new page
    print("New page title is: ", driver.title)
    #time.sleep(10)
    # Close the browser
    #driver.quit()
    
