import time
from selenium import webdriver
from selenium.webdriver.common.by import By

with webdriver.Firefox() as driver:
     # Open the Page
    driver.get("https://training-support.net/webelements/mouse-events")
    # verify Page title
    print(f"Page Title is: {driver.title}")
       
    # Set up the actions object
    actions = webdriver.ActionChains(driver)
    # Page Interactions
    # On the page, perform:
    buttons = driver.find_elements(By.CSS_SELECTOR, "div.svelte-hs12g9")
    
    # Left click on the Cargo.lock button, move the cursor to the Cargo.toml button and then click it. Print the confirmation text at the end of the sequence.
    actions.click(buttons[0]).pause(2).click(buttons[1]).pause(2).perform()
    message = driver.find_element(By.ID, "result").text
    print(message)
    # Double click on the src button. Then right click on the target button and select open. Print the confirmation text at the end of the sequence.
    actions.double_click(buttons[2]).pause(2).context_click(buttons[3]).pause(1).perform()
    actions.click(driver.find_element(By.XPATH,"//span[text()='Open']")).pause(1).perform()
    message1 = driver.find_element(By.ID, "result").text
    print(message1)
    
    # Print the title of the new page
    print("New page title is: ", driver.title)
    #time.sleep(10)
    # Close the browser
    #driver.quit()