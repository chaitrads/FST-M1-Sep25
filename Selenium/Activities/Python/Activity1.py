import time
from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
    # Open the Page
    driver.get("https://training-support.net")
    # verify Page title
    print(f"Page Title is: {driver.title}")
    
   
    # Page Interactions
    # Find the "About Us" button on the page using ID and click it
    link = driver.find_element(By.CLASS_NAME,"card")
    link.click()
    
    
    # Print the title of the new page
    print("New page title is: ", driver.title)
    #time.sleep(10)
    # Close the browser
    #driver.quit()
    
