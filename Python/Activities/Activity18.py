# Import pandas
import pandas as pd

# Read the CSV file and store it into a DataFrame
input_file = pd.read_csv("sample.csv")

# Print the full data
print("Full Data: ")
print(input_file)

# Print the values in the Usernames column only

print("Usernames:")
print(input_file["usernames"])

# Print the username and password of the second row
print("Second Row Values: ")
print("Username: ", input_file["usernames"][1], " | ", "Password: ", input_file["passwords"][1])

#Sort the Usernames column in ascending order

print("Data sorted in ascending Usernames:")
print(input_file.sort_values("usernames"))

#Sort the Passwords column in descending order

print("Data sorted in descending Passwords:")
print(input_file.sort_values("passwords", ascending=False))