sample_list=[1,2,3,4,5,6]
sum=0
for i in sample_list:
    sum+=i

print(sum)    

numbers=input("Enter a sequence of comma separated values: ").split(",")

sum=0
for i in numbers:
    sum+=int(i)
    
print(sum)    