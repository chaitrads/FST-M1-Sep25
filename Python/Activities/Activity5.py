# To take user input from Number
try:
    number = int(input("Enter a valid number: "))
    print(f"You entered: {number}")
except ValueError:
    print("Invalid input. Please enter a number.")
    
# For Multiplying
i = 0

print(f"Multiple of {number} using While loop is: ")
while(i<10):
    i+=1
    print(number, ' x ', i, ' = ', number*i)

print(f"Multiple of {number} Using For loop is :")    
# use for loop to iterate 10 times
for i in range(1,11):
   print(number, ' x ', i, ' = ', number*i)