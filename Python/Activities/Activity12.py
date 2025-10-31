def sum(num):
    if(num<=1):
        return 1
    else:
        return num+sum(num-1)

number= int(input("Enter the Number: "))

print(f"The Sum of numbers from 1 to {number} is: "+str(sum(number)))