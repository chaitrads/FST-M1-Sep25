# Normal Method
def fibo(num):
    perv_number=0
    present_number=1
    counter=0
    sum=0
    while(counter<int(num)):
        print(str(perv_number), end=" ")
        sum=perv_number+present_number
        perv_number=present_number
        present_number=sum
        counter+=1
        

numbers= input("Enter The Number till which you want the Fibonacci sequence to be generated: ")

if int(numbers) <= 0:
    print("Please enter a positive number")
else:
    print("Fibonacci Sequence: ")
fibo(numbers)

# End of program using Normal method

# using recursion

def fibonum(number1):
    if number1 <= 1:
        return number1
    else:
        return(fibonum(number1-1) + fibonum(number1-2))
    

number= int(input("Enter The Number till which you want the Fibonacci sequence to be generated: "))

if number<= 0:
    print("Please enter a positive number")
else:
    print("Fibonacci Sequence: ")
    for i in range(number):
        print(fibonum(i), end=" ")


