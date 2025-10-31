numbers1=input("Enter The 1st sequence of comma separated values: ").split(",")
numbers2=input("Enter The 2nd sequence of comma separated values: ").split(",")

new_list=[]

for i in numbers1:
    if (int(i)%2!=0):
        new_list.append(i)

for i in numbers2:
    if (int(i)%2==0):
        new_list.append(i)
        
print(" The new List with odd numbers from first list and even numbers from second list is "+ str(new_list))        
