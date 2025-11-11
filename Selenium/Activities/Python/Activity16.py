# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

# Start the Driver
with webdriver.Firefox() as driver:
    # Navigate to the URL
    driver.get("https://training-support.net/webelements/selects")
    # Print the title of the page
    print("Page title is: ", driver.title)
    # On the Single Select:
    dropdown = driver.find_element(By.CSS_SELECTOR,"select.h-10")
    # Select the second option using the visible text.
    singleselect =  Select(dropdown)
    singleselect.select_by_visible_text("One")
    print("The Selected option is: "+ singleselect.first_selected_option.text)
    # Select the third option using the index.
    singleselect.select_by_index(2)
    print("The Selected option is: "+ singleselect.first_selected_option.text)
    # Select the fourth option using the value.
    singleselect.select_by_value("three")
    print("The Selected option is: "+ singleselect.first_selected_option.text)
         
    # Get all the options and print them to the console.
    print("All the Options present in the dropdown is printed below--------------")
    alloptions = singleselect.options
    for options in alloptions:
        print(options.text)

    # Print the title of the new page
    print("New page title is: ", driver.title)
    #time.sleep(10)
    # Close the browser
    #driver.quit()
    
