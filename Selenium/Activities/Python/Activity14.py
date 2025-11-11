# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By

# Start the Driver
with webdriver.Firefox() as driver:
    # Navigate to the URL
    driver.get("https://training-support.net/webelements/tables")
    # Print the title of the page
    print("Page title is: ", driver.title)
    # Using xpaths on the table:
    # Find the number of rows and columns in the table and print them.
    # Print the number of columns
    cols = driver.find_elements(By.XPATH, "//table[contains(@class, 'table-auto')]/thead/tr/th")
    print("Number of columns: ", len(cols))
    # Print the number of rows
    rows = driver.find_elements(By.XPATH, "//table[contains(@class, 'table-auto')]/tbody/tr")
    print("Number of rows: ", len(rows))

    # Find and print the Book Name in the 5th row.
    fifthrowbook = driver.find_element(By.XPATH, "//table[contains(@class, 'table-auto')]/tbody/tr[5]/td[2]")
    print("The Fifth row Book value: ", fifthrowbook.text)
    
    # Click the header of the Price column to sort it in ascending order.
    driver.find_element(By.XPATH,"//table/thead/tr/th[5]").click()
    
    # Find and print the Book Name in the 5th row again.
    updatedfifthrowbook = driver.find_element(By.XPATH, "//table[contains(@class, 'table-auto')]/tbody/tr[5]/td[2]")
    print("The Fifth row Book value: ", updatedfifthrowbook.text)

    # Print the title of the new page
    print("New page title is: ", driver.title)
    #time.sleep(10)
    # Close the browser
    #driver.quit()
    
