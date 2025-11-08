import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.color import Color

with webdriver.Firefox() as driver:
    # Open the Page
    driver.get("https://training-support.net/webelements/target-practice")
    # verify Page title
    print(f"Page Title is: {driver.title}")
    
   
    # Page Interactions
    # Using xpath:
# Find the 3rd header on the page and print it's text to the console.
    thirdheader = driver.find_element(By.XPATH,"//h3[contains(@class, 'text-orange-600')]")
    print("The Third Header Text is: "+thirdheader.text)

# Find the 5th header on the page and print it's color.
    fifthheader = driver.find_element(By.XPATH,"//h5[contains(@class, 'text-purple-600')]")
    #fontcolor = fifthheader.get_css_value("color")===========================>question
    # fifthheader.get_attribute depricated
    # fifthheader.get_dom_attribute
    # fifthheader.get_property
    # fifthheader.__getattribute__
    print("The Third Header Text is: "+ fifthheader.value_of_css_property("color"))

    # Find the 5th header element on the page using XPath
    # fifth_heading_color = Color.from_string(driver.find_element(By.XPATH, "//h5[contains(text(), '#5')]").value_of_css_property("color"))
    # print("Fifth heading colour as Hexcode: ", fifth_heading_color.hex)
    # print("Fifth heading colour as RGB: ", fifth_heading_color.rgb)

# Using any other locator:
# Find the purple button and print all it's classes.
    purpleButton = driver.find_element(By.CLASS_NAME, "text-purple-900")
    print("The Classes of the Purple Button is: "+purpleButton.get_dom_attribute("class"))

# Find the slate button and print it's text.
    slateButton = driver.find_element(By.CLASS_NAME, "text-slate-900")
    print("The Classes of the Purple Button is: "+slateButton.text)
   
    
    
    # Print the title of the new page
    print("New page title is: ", driver.title)
    #time.sleep(10)
    # Close the browser
    #driver.quit()
    
