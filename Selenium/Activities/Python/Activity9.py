import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import Keys, ActionChains

with webdriver.Firefox() as driver:
     # Open the Page
    driver.get("https://training-support.net/webelements/keyboard-events")
    # verify Page title
    print(f"Page Title is: {driver.title}")
       
    # Set up the actions object
    actions = webdriver.ActionChains(driver)
    # Page Interactions
    # On the page, perform:
    #On the page, type out a string from the Selenium script to show on the page
    keystrokes = driver.find_elements(By.CSS_SELECTOR, "span.svelte-hs12g9")
    actions.send_keys("Hello Welcome to Hogwarts in wonderland").send_keys(Keys.RETURN).perform()
    # Print the message to the console.
    message = driver.find_element(By.CSS_SELECTOR,"h1.mt-3")
    print(message.text)
    # Print the title of the new page
    print("New page title is: ", driver.title)
    #time.sleep(10) 
    # Close the browser
    #driver.quit()