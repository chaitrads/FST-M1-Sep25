# Import webdriver from selenium
import time
from selenium import webdriver
from selenium.webdriver.common.by import By

# Start the Driver
with webdriver.Firefox() as driver:
    # Navigate to the URL
    driver.get("https://training-support.net/webelements/login-form/")

    # Print the title of the page
    print("Page title is: ", driver.title)

 # Find the username field
    username = driver.find_element(By.XPATH, "//input[@id='username']")
    # Find the password field
    password = driver.find_element(By.XPATH, "//input[@name='password']")

    # Enter the given credentials
    # Enter username
    username.send_keys("admin")
    # Enter password
    password.send_keys("password")

    # Find the login button
    login = driver.find_element(By.XPATH, "//button[text()='Submit']")
    login.click()

    time.sleep(1)
    # Print the login message
    message = driver.find_element(By.XPATH, "//h2[@class='mt-5 text-center text-4xl font-semibold text-gray-800']")
    print("Login message: ", message.text)

    # Print the title of the new page
    print("New page title is: ", driver.title)
    #time.sleep(10)