# Import pandas
import pandas as pd

# Create a Data Set
test = {
  "usernames": ["admin", "Charles", "Deku"],
  "passwords": ["password", "Charl13", "AllMight"]
}

# convert Data into a DataFrame
df = pd.DataFrame(test)

# Print the DataFrame
print(df)


 # Write the DataFrame to a CSV file

df.to_csv("./sample.csv", index=False)