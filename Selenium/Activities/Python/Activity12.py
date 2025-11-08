import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions
with webdriver.Firefox() as driver:
    # Open the Page
    driver.get("https://training-support.net/webelements/dynamic-content")
    # verify Page title
    print(f"Page Title is: {driver.title}")
    
   
    # Page Interactions
    # On the page, perform:
    # Find and click the "Click me!" button.
    button = driver.find_element(By.ID,"genButton")
    button.click()
    
    # Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)
    # Wait till the word "release" appears.
    
    
    # Get the text and print it to console.
    if wait.until(expected_conditions.text_to_be_present_in_element((By.ID,"word"),"release")):
        # Print the text to console
        print("Word found: ", driver.find_element(By.ID, "word").text)

    # Print the title of the new page
    print("New page title is: ", driver.title)
    #time.sleep(10)
    # Close the browser
    #driver.quit()
    
