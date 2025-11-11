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
    # On the Multi Select:
    multidrop = driver.find_element(By.CSS_SELECTOR,"select.h-80")
    multiselect =  Select(multidrop)
    multiselect.deselect_all()
    # Select the "HTML" option using the visible text.
    multiselect.select_by_visible_text("HTML")
    
    # Get all the options and print them to the console.
    print("All the Options present in the dropdown is printed below--------------")
    alloptions = multiselect.all_selected_options
    for options in alloptions:
        print(options.text)
    
    
    # # Select the 4th, 5th and 6th options using the index.
    # multiselect.select_by_index(4)
    # multiselect.select_by_index(5)
    # multiselect.select_by_index(6)
    
    # # Get all the options and print them to the console.
    # print("All the Options present in the dropdown is printed below--------------")
    # alloptions = multiselect.all_selected_options
    # for options in alloptions:
    #     print(options.text)
    
    # alternate option
    for j in range(3,6):
        multiselect.select_by_index(j)
    
    # Get all the options and print them to the console.
    print("All the Options present in the dropdown is printed below--------------")
    alloptions = multiselect.all_selected_options
    for options in alloptions:
        print(options.text)
        
    # Select the "Node" option using the value.
    multiselect.select_by_value("nodejs")
    
    # Get all the options and print them to the console.
    print("All the Options present in the dropdown is printed below--------------")
    alloptions = multiselect.all_selected_options
    for options in alloptions:
        print(options.text)
    
    # Deselect the 5th option using index.
    multiselect.deselect_by_index(5)
    # Get all the options and print them to the console.
    print("All the Options present in the dropdown is printed below--------------")
    alloptions = multiselect.all_selected_options
    for options in alloptions:
        print(options.text)

    # Print the title of the new page
    print("New page title is: ", driver.title)
    #time.sleep(10)
    # Close the browser
    #driver.quit()
    
