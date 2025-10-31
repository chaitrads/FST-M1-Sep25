fruits={
    "apple": 220,
    "orange": 50,
    "banana": 30,
    "watermelon": 15
}
check=True
userfruit=input("Enter The Fruit Name: ").lower()
for i in fruits:
    if(i== userfruit):
        print(f"For {userfruit} The Price is {fruits[i]}")
        check=False
if(check==True):
    print(f"The {userfruit} is not available in the shop for now, please visit later")