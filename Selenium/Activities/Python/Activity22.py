# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions

# Start the Driver
with webdriver.Firefox() as driver:
    # Navigate to the URL
    driver.get("https://training-support.net/webelements/popups")
    # Print the title of the page
    print("Page title is: ", driver.title)

    # Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)
    
    #Find the button on the page and click it to launch the popup.
    popup = driver.find_element(By.ID, "launcher")
    popup.click() 
    
    name = driver.find_element(By.ID,"username")
    password = driver.find_element(By.ID,"password")
    button = driver.find_element(By.CSS_SELECTOR,"button.svelte-1pdjkmx")
    
    # Wait for the popup to appear and then enter the credentials:
    # username: admin
    name.send_keys("admin")
    # password: password
    password.send_keys("password")
    
    # Click submit and print the message on the page after logging in.
    button.click()
    message = driver.find_element(By.CSS_SELECTOR,"h2.mt-5") 
    print("The message is :----- "+message.text)
    
    # Print the title of the new page
    print("New page title is: ", driver.title)
    #time.sleep(10)
    # Close the browser
    #driver.quit()
    