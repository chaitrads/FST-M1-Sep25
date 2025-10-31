
# To take user input from Number
try:
    number = int(input("Enter a valid number: "))
    print(f"You entered: {number}")
except ValueError:
    print("Invalid input. Please enter a number.")
    

#For printing    

i=number
j=1

while(j<=i):
    k=1
    while(k<=j):
        print(j, end="")
        k+=1
    print()
    j+=1


for i in range(10):
    print(str(i) * i)

