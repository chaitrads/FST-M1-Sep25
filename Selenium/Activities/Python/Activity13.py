import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions
with webdriver.Firefox() as driver:
    # Open the Page
    driver.get("https://training-support.net/webelements/tables")
    # verify Page title
    print(f"Page Title is: {driver.title}")
    
   
    # Page Interactions
    # On the page, perform:
    # Using xpaths on the table:
    # Find the number of rows and columns in the table and print them.
    # cols = driver.find_elements(By.XPATH, "//table[contains(@class, 'table-auto')]/thead/tr/th")
    # print("Number of columns is: ", len(cols))
    
    # rows = driver.find_elements(By.XPATH, "//table[contains(@class, 'table-auto')]/tbody/tr")
    # print("Number of rows is: ",len(rows))
    
    #alternate paths
    cols = driver.find_elements(By.XPATH, "//table/thead/tr/th")
    print("Number of columns is: ", len(cols))
    
    rows = driver.find_elements(By.XPATH, "//table/tbody/tr")
    print("Number of rows is: ",len(rows))
    
    
    # Find and print all the cell values in the third row of the table.
    thirdrow = driver.find_elements(By.XPATH,"//table/tbody/tr[3]/td")
    print("Third Row values are: ============>")
    for x in thirdrow:
        print(x.text)
    
    # Find and print the cell value at the second row second column
    secondrow = driver.find_element(By.XPATH,"//table/tbody/tr[2]/td[2]")
    print("Second Row Second Column values are: ============>", secondrow.text)
   

    # Print the title of the new page
    print("New page title is: ", driver.title)
    #time.sleep(10)
    # Close the browser
    #driver.quit()
    
