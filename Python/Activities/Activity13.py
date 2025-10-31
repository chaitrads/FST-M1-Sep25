def sum(list):
    sum=0
    for i in list:
        sum+=int(i)
    return sum

numbers= input("Enter The 1st sequence of comma separated values: ").split(",")
print("The Sum of the items ins the List is "+str(sum(numbers)))