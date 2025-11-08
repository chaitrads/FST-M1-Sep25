import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver import Keys, ActionChains

with webdriver.Firefox() as driver:
     # Open the Page
    driver.get("https://training-support.net/webelements/drag-drop")
    # verify Page title
    print(f"Page Title is: {driver.title}")
       
    # Set up the actions object
    actions = webdriver.ActionChains(driver)
    # Page Interactions
    # On the page, perform:
    #Find the ball and simulate a click and drag to move it into "Dropzone 1".
    ball = driver.find_element(By.ID, "ball")
    dropzone1= driver.find_element(By.ID,"dropzone1")
    dropzone2= driver.find_element(By.ID,"dropzone2")
    
    actions.click_and_hold(ball).move_to_element(dropzone1).pause(2).perform()
    # Verify that the ball has entered Dropzone 1.
    if(dropzone1.find_element(By.CLASS_NAME,"dropzone-text").text=="Dropped!"):
        print("Ball was dropped in drop zone 1")
    
    
    # Once verified, move the ball into "Dropzone 2".
    actions.move_to_element(dropzone2).pause(2).release().perform()
    
    # Verify that the ball has entered Dropzone 2.
    if(dropzone2.find_element(By.CLASS_NAME,"dropzone-text").text=="Dropped!"):
        print("Ball was dropped in drop zone 2")
    
    # Print the title of the new page
    print("New page title is: ", driver.title)
    #time.sleep(10) 
    # Close the browser
    #driver.quit()