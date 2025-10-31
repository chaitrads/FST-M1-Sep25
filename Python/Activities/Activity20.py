# Import pandas
import pandas

# Read data from Excel sheet
input_file = pandas.read_excel('./sample.xlsx')

# Print the dataframe
print(input_file)

# Print the number of rows and columns
print("Rows: ", input_file.shape[0], " Columns: ", input_file.shape[1])
print("Number of rows and columns:", input_file.shape)

# Print the data in the emails column only

print("Emails:")
print(input_file['Email'])

# Sort the data based on FirstName in ascending order and print the data

print("Sorted data:")
print(input_file.sort_values('FirstName'))