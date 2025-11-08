# Import webdriver from selenium
import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions

# Start the Driver
with webdriver.Firefox() as driver:
    # Navigate to the URL
    driver.get("https://training-support.net/webelements/tabs")
    # Print the title of the page
    print("Page title is: ", driver.title)

    # Declare the wait variable
    wait = WebDriverWait(driver, timeout=10)
    # Store the current window/tab handle
    original_window = driver.current_window_handle
     # Print the handle of the parent window
    print("Current tab: ", driver.current_window_handle)
    #Find the button to open a new tab and click it.
    button = driver.find_element(By.CLASS_NAME, "bg-purple-200 ")
    button.click() 
    
    # Wait for the new tab to open. Once it opens, print all the handles.
    # Wait for the other window/tab to open
    wait.until(expected_conditions.number_of_windows_to_be(2))
     # Print all window handles
    print("Currently open windows: ", driver.window_handles)
    time.sleep(2)
    # Switch to the newly opened tab, print the new tab's title and message.
    # Switch to the new tab that opened
    driver.switch_to.window(driver.window_handles[1])
        # Print the handle of the current tab
    print("Current tab: ", driver.current_window_handle)
    # Print the title and heading of the new page
    print("New Page title: ", driver.title)
    print("New Page message: ", driver.find_element(By.CSS_SELECTOR, "h2.mt-5").text)


    # Repeat the steps by clicking the button in the new tab page.
    # Find and click the button on page to open another tab
    driver.find_element(By.XPATH, "//button[contains(text(), 'Another One')]").click()
    time.sleep(2)
    # Wait for new tab to open
    wait.until(expected_conditions.number_of_windows_to_be(3))
    # Switch focus
    for handle in driver.window_handles:
        driver.switch_to.window(driver.window_handles[2])
    print("New Page message: ", driver.find_element(By.CSS_SELECTOR, "h2.mt-5").text)    
    time.sleep(2)
    # Print the title of the new page
    print("New page title is: ", driver.title)
    #time.sleep(10)
    # Close the browser
    #driver.quit()
    