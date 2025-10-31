numbers1=input("Enter The 1st sequence of comma separated values: ").split(",")

numbers2=tuple(numbers1)
for i in numbers2:
    if(int(i)%5==0):
        print(i)
